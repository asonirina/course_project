package by.bsu.project.mvc;

import by.bsu.project.antlr.lang.LangFactory;
import by.bsu.project.antlr.model.TreeNode;
import by.bsu.project.antlr.rted.RTED;
import by.bsu.project.antlr.tree.BaseParser;
import by.bsu.project.antlr.util.OrderComparator;
import by.bsu.project.antlr.util.TreeEditDistance;
import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.constants.PageTitles;
import by.bsu.project.general.model.AttributeCounting;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.UserInfoEntity;
import by.bsu.project.general.model.UserTask;
import by.bsu.project.general.view.ACInfo;
import by.bsu.project.general.view.ProgramFileInfo;
import by.bsu.project.neural.Node;
import by.bsu.project.utils.CodeDiffUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * User: iason
 * Date: 29.10.15
 */
@Controller
public class TestController extends BaseController {


    @RequestMapping(value = "/e-Testing/student/UploadTest")
    public ModelAndView displayUploadTest(Model model) {
        try {
            return new ModelAndView("UploadTest", ETestingConstants.MODEL_TITLE, PageTitles.UPLOAD_TEST);
        } catch (Exception ex) {
            logger.error("Unable to display upload file page " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/admin/Canvas")
    public ModelAndView displayCanvas(Model model) {
        try {
            List<ProgramFilesEntity> programs = userInfoService.getCompletedProgramFiles();
            List<UserInfoEntity> users = userInfoService.studentsList();
            List<Node> nodes = new ArrayList<>();
            for (ProgramFilesEntity entity : programs) {
                nodes.add(new Node(entity.getAc()));
            }
            for (UserInfoEntity entity : users) {
                if (entity.getNeuralNode() != null) {
                    nodes.add(new Node(entity.getNeuralNode(), true, 500));
                }
            }
            model.addAttribute("nodes", nodes);
            return new ModelAndView("graph/Canvas", ETestingConstants.MODEL_TITLE, PageTitles.UPLOAD_TEST);
        } catch (Exception ex) {
            logger.error("Unable to display upload file page " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }


    @RequestMapping(value = "/e-Testing/student/CheckMatches")
    public ModelAndView checkManually(
            @RequestParam(value = "file1", required = true) MultipartFile file1,
            @RequestParam(value = "file2", required = true) MultipartFile file2,
            Model model) throws Exception {
        ProgramFilesEntity e1 = new ProgramFilesEntity();
        e1.setFileName(file1.getOriginalFilename());
        ProgramFilesEntity e2 = new ProgramFilesEntity();
        e2.setFileName(file2.getOriginalFilename());

        e1.setFile(file1.getBytes());
        e2.setFile(file2.getBytes());

        BaseParser parser1 = LangFactory.createParser(e1.getLang());
        List<TreeNode> nodes1 = parser1.getTree(e1.getFile());

        BaseParser parser2 = LangFactory.createParser(e2.getLang());
        List<TreeNode> nodes2 = parser2.getTree(e2.getFile());

        TreeEditDistance.numerateTree(nodes1.get(0));
        TreeEditDistance.numerateTree(nodes2.get(0));
        Collections.sort(nodes1, new OrderComparator());
        Collections.sort(nodes2, new OrderComparator());

        RTED c = new RTED();
        c.nonNormalizedTreeDist(nodes1, nodes2);
        List<int[]> byteMap = c.computeEditMapping();

        String[] files = CodeDiffUtil.getHighlights(e1, e2, byteMap);

        int height = Math.max(StringUtils.countMatches(files[0], "\n"), StringUtils.countMatches(files[1], "\n")) * 23;

        model.addAttribute(ETestingConstants.MODEL_FILE1, files[0]);
        model.addAttribute(ETestingConstants.MODEL_FILE2, files[1]);
        model.addAttribute(ETestingConstants.MODEL_HEIGHT, height);
        model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.SOURCE_CODE);

        return new ModelAndView("DiffCode");
    }

    @RequestMapping(value = "/e-Testing/admin/GetACInfo", method = RequestMethod.GET)
    public
    @ResponseBody
    ACInfo getUserTask(@RequestParam(value = "acId", required = true) Long acId) throws Exception {
        AttributeCounting ac = userInfoService.getAC(acId);
        return new ACInfo(ac);
    }
}
