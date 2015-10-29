package by.bsu.project.mvc;

import by.bsu.project.antlr.model.TreeNode;
import by.bsu.project.antlr.rted.RTED;
import by.bsu.project.antlr.tree.TreeParser;
import by.bsu.project.general.model.ProgramFilesEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * User: iason
 * Date: 29.10.15
 */
@Controller
public class TestController extends BaseController{

    @RequestMapping(value = "/e-Testing/admin/CheckMatches")
    public ModelAndView checkManually(
            @RequestParam(value = "file1", required = false) MultipartFile file1,
            @RequestParam(value = "file2", required = false) MultipartFile file2,
            Model model) throws Exception{
        ProgramFilesEntity e1  = new ProgramFilesEntity();
        e1.setFileName(file1.getOriginalFilename());
        ProgramFilesEntity e2  = new ProgramFilesEntity();
        e2.setFileName(file2.getOriginalFilename());

        e1.setFile(file1.getBytes());
        e2.setFile(file1.getBytes());

        TreeParser parser1 = new TreeParser(e1.getLang());
        List<TreeNode> nodes1 = parser1.getTree(e1.getFile());

        TreeParser parser2 = new TreeParser(e2.getLang());
        List<TreeNode> nodes2 = parser1.getTree(e2.getFile());


        RTED c = new RTED();
        c.nonNormalizedTreeDist(nodes1, nodes2);
        List<int[]> map = c.computeEditMapping();

        return new ModelAndView("DiffCode");
    }
}
