package by.bsu.project.mvc;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.constants.ErrorsMessages;
import by.bsu.project.general.constants.PageTitles;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.entity.UserInfoEntity;
import by.bsu.project.general.huffman.Huffman;
import by.bsu.project.model.SpringUser;
import by.bsu.project.paging.Paging;
import by.bsu.project.general.model.AttributeCounting;
import by.bsu.project.antlr.tree.TreeParser;
import by.bsu.project.antlr.model.TreeNode;
import by.bsu.project.antlr.util.AttributeCountingUtil;
import by.bsu.project.antlr.util.TreeCompareUtil;
import by.bsu.project.service.AttributeService;
import by.bsu.project.service.UserInfoService;
import by.bsu.project.utils.ProgramFilesUtil;
import by.bsu.project.validator.Validator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alina Glumova
 */

@Controller
public class ProgramUploadController {

    private static final Logger logger = Logger.getLogger(ProgramUploadController.class);

    private Long currentFileId;
    private ProgramFilesUtil programFilesUtil;

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private AttributeService attributeService;
    private SpringUser user;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Convert multipart object to byte[]
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }

    @RequestMapping(value = "/e-Testing/UploadProgram")
    public ModelAndView displayUploadFile(
            UserInfoEntity userInfoEntity,
            ProgramFilesEntity programFilesEntity,
            Model model) {
        try {
            user = getUser();
            userInfoEntity = userInfoService.getStudentById(user.getId());
            programFilesEntity = new ProgramFilesEntity();

            File dir = new File(System.getProperty("java.io.tmpdir") + "/tasks/" + userInfoEntity.getForm());
            List<String> tasks = Arrays.asList(dir.list());
            model.addAttribute(ETestingConstants.MODEL_STUDENT, userInfoEntity);
            Map<String, Object> params = new HashMap<>();
            params.put(ETestingConstants.MODEL_PROGRAM, programFilesEntity);
            params.put(ETestingConstants.MODEL_TASKS, tasks);
            params.put(ETestingConstants.MODEL_TITLE, PageTitles.UPLOAD_PROGRAM);
            return new ModelAndView("UploadProgram", params);

        } catch (Exception ex) {
            logger.error("Unable to display upload file page " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html");
        }
    }

    @RequestMapping(value = "/e-Testing/SaveProgram")
    public ModelAndView processUploadPreview(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "studentId", required = false) Long studentId,
            @ModelAttribute("UploadProgram") ProgramFilesEntity programFilesEntity,
            Model model) throws Exception{

//        try {
            UserInfoEntity userInfoEntity = userInfoService.getStudentById(studentId);
            List<String> errors = Validator.validateFile(file, programFilesEntity.getProgramName());

            if (errors.size() != 0) {
                model.addAttribute(ETestingConstants.MODEL_ERRORS, errors);
                model.addAttribute(ETestingConstants.MODEL_STUDENT, userInfoEntity);
                return new ModelAndView("UploadProgram", ETestingConstants.MODEL_PROGRAM, programFilesEntity);
            }

            programFilesUtil = new ProgramFilesUtil(file, userInfoEntity, programFilesEntity.getProgramName());
            String programStatus;

            if (programFilesUtil.checkFile()) {
                programStatus = ETestingConstants.PASSED_STATUS;
            } else {
                programStatus = ETestingConstants.FAILED_STATUS;
            }

//            programStatus = ETestingConstants.PASSED_STATUS;

            programFilesEntity.setFile(Huffman.compress(file.getBytes()));
            programFilesEntity.setFileName(file.getOriginalFilename());
            programFilesEntity.setContentType(file.getContentType());
            programFilesEntity.setUploadProgramTime(new Date(System.currentTimeMillis()));
            programFilesEntity.setStatus(programStatus);
            programFilesEntity.setTestResults(programFilesUtil.getTestResults());
            programFilesEntity.setUserId(getUser().getId());

            TreeParser parser = new TreeParser(programFilesEntity.getProgramName(), programFilesEntity.getLang());
            List<TreeNode>nodes = parser.getTree(Huffman.expand(programFilesEntity.getFile()));
            AttributeCounting ac = parser.getAc();
            ac.setProgrName(programFilesEntity.getProgramName());

            int plagiat1 = AttributeCountingUtil.checkAC(attributeService.getByProgrName(ac), ac);
            if (plagiat1 <= 30) {
                attributeService.save(ac);
            }

            int plagiat2 = TreeCompareUtil.checkTrees(userInfoService.getProgramsByName(programFilesEntity), nodes);

            programFilesEntity.setPlagiat1(plagiat1);
            programFilesEntity.setPlagiat2(plagiat2);
            programFilesEntity.setTreeContent(Huffman.compress(TreeNode.getBytes(nodes)));
            userInfoEntity.getProgramFiles().add(programFilesEntity);
            userInfoService.save(userInfoEntity);
            currentFileId = programFilesEntity.getId();
            return new ModelAndView("redirect:/e-Testing/UploadProgramStatus.html");

//        } catch (Exception ex) {
//            logger.error("Unable to save entity " + ex.getMessage());
//            return new ModelAndView("redirect:/e-Testing/error503.html");
//        }
    }

    @RequestMapping(value = "/e-Testing/UploadProgramStatus")
    public ModelAndView processUploadPreview(Model model) {
        model.addAttribute(ETestingConstants.MODEL_PROGRAM, userInfoService.getFileById(currentFileId));
        model.addAttribute(ETestingConstants.MODEL_MESSAGES, programFilesUtil.getMessages());
        model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.PROGRAM_STATUS);
        return new ModelAndView("UploadProgramStatus");
    }

    @RequestMapping(value = "/e-Testing/UploadProgramsHistory")
    public ModelAndView processHistoryPreview(
            @RequestParam(value = "page", required = false) Integer page,
            UserInfoEntity userInfoEntity,
            Model model) {

        try {
            user = getUser();
            userInfoEntity = userInfoService.getStudentById(user.getId());
            Paging paging1 = new Paging(userInfoEntity.getProgramFiles().size());
            model.addAttribute(ETestingConstants.MODEL_PROGRAM_LIST, userInfoService.programsList(
                    userInfoService.setPage(page, paging1, model), user.getId()));
            model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.PROGRAM_HISTORY);

            return new ModelAndView("UploadProgramsHistory");

        } catch (Exception ex) {
            logger.error("Unable to display upload file history page " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }


    @RequestMapping(value = "/e-Testing/viewTree")
    public ModelAndView viewTree(@RequestParam(value = "programId", required = false) Long programId,
                                 Model model) {
        try {
            byte[] content = Huffman.expand(userInfoService.getFileById(programId).getTreeContent());
            List<TreeNode> nodes = TreeNode.getTree(content);
            model.addAttribute(ETestingConstants.TREE_NODES, nodes);
            model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.VIEW_TREE);
            return new ModelAndView("tree/viewTree2");
        } catch (Exception ex) {
            return new ModelAndView("errors/error503", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/error503")
    public ModelAndView errorPage() {
        return new ModelAndView("errors/error503", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
    }

    @RequestMapping(value = "/e-Testing/Run")
    public ModelAndView script(
            @RequestParam(value = "command", required = false) String command
    ) throws Exception {
        // 755
        //  (rwxr-xr-x) The file's owner may read, write, and execute the file. All others may read and execute the file.
        // This setting is common for programs that are used by all users.

        //unzip file.zip -d destination_folder
//        Process  process = Runtime.getRuntime().exec("chmod -R 755 /opt/tomcat/temp/compilers/fpc", null);
//
//        int result  = process.waitFor();
//
        //find /opt/lampp/htdocs -type f -exec chmod 644 {} \;
        if (command != null) {
            Process process = Runtime.getRuntime().exec(command, null);

            int result = process.waitFor();

            return new ModelAndView("RunShell", ETestingConstants.MODEL_MESSAGE, String.valueOf(result));
        }
        return new ModelAndView("RunShell");
    }

    private SpringUser getUser() {
        return (SpringUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
