package by.bsu.project.mvc;

import by.bsu.project.constants.ETestingConstants;
import by.bsu.project.entity.ProgramFilesEntity;
import by.bsu.project.entity.UserInfoEntity;
import by.bsu.project.huffman.Huffman;
import by.bsu.project.model.SpringUser;
import by.bsu.project.paging.Paging;
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

import java.util.Date;
import java.util.List;

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
            model.addAttribute(ETestingConstants.MODEL_STUDENT, userInfoEntity);
            return new ModelAndView("UploadProgram", ETestingConstants.MODEL_PROGRAM, programFilesEntity);

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
            Model model) {

        try {
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

            programFilesEntity.setFile(Huffman.compress(file.getBytes()));
            programFilesEntity.setFileName(file.getOriginalFilename());
            programFilesEntity.setContentType(file.getContentType());
            programFilesEntity.setUploadProgramTime(new Date(System.currentTimeMillis()));
            programFilesEntity.setStatus(programStatus);
            programFilesEntity.setTestResults(programFilesUtil.getTestResults());
            userInfoEntity.getProgramFiles().add(programFilesEntity);

            userInfoService.save(userInfoEntity);
            currentFileId = programFilesEntity.getId();
            return new ModelAndView("redirect:/e-Testing/UploadProgramStatus.html");

        } catch (Exception ex) {
            logger.error("Unable to save entity " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html");
        }
    }

    @RequestMapping(value = "/e-Testing/UploadProgramStatus")
    public ModelAndView processUploadPreview(Model model) {
        model.addAttribute(ETestingConstants.MODEL_PROGRAM, userInfoService.getFileById(currentFileId));
        model.addAttribute(ETestingConstants.MODEL_MESSAGES, programFilesUtil.getMessages());
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

            return new ModelAndView("UploadProgramsHistory");

        } catch (Exception ex) {
            logger.error("Unable to display upload file history page " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html");
        }
    }

    @RequestMapping(value = "/e-Testing/error503")
    public ModelAndView errorPage() {
        return new ModelAndView("errors/error503");
    }

    private SpringUser getUser() {
        return (SpringUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
