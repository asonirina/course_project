package by.bsu.project.mvc;

import by.bsu.project.entity.ProgramFilesEntity;
import by.bsu.project.entity.UserInfoEntity;
import by.bsu.project.paging.Paging;
import by.bsu.project.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alina Glumova
 */

@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    private static List<ProgramFilesEntity> programFilesEntityList = new ArrayList<>();

    @RequestMapping(value = "/e-Testing/ChangePassword")
    public ModelAndView changePassword(@RequestParam(value = "oldPassword", required = false) String oldPassword,
                                       @RequestParam(value = "password1", required = false) String password1,
                                       @RequestParam(value = "password2", required = false) String password2,
                                       HttpServletRequest request) {
        String login = request.getRemoteUser();
        UserInfoEntity user = userInfoService.findStudentByLogin(login);
        if (oldPassword != null && oldPassword.equals(user.getPassword()) && password1.equals(password2)) {
            user.setPassword(password1);
            userInfoService.save(user);
        }
        return new ModelAndView("ChangePassword");
    }

    @RequestMapping(value = "/e-Testing/StudentList")
    public ModelAndView displayStudentsList(@RequestParam(value = "page", required = false) Integer page,
                                            Model model) {

        Paging paging1 = new Paging(userInfoService.studentsCountList().intValue());
        model.addAttribute("studentList", userInfoService.studentsList(userInfoService.setPage(page, paging1, model)));

        return new ModelAndView("StudentList");
    }

    @RequestMapping(value = "/e-Testing/SaveStudent", method = RequestMethod.POST)
    public String save(@ModelAttribute("EditStudent") UserInfoEntity userInfoEntity) {
        userInfoEntity.setProgramFiles(programFilesEntityList);
        userInfoService.save(userInfoEntity);

        return "redirect:/e-Testing/ViewStudent.html?id=" + userInfoEntity.getId();
    }

    @RequestMapping(value = "/e-Testing/EditStudent")
    public ModelAndView displayStudent(@RequestParam(value = "id", required = false) Long id,
                                       UserInfoEntity userInfoEntity) {
        if (null != id) {
            userInfoEntity = userInfoService.getStudentById(id);
        } else {
            userInfoEntity = new UserInfoEntity();
        }
        programFilesEntityList = userInfoEntity.getProgramFiles();

        return new ModelAndView("EditStudent", "student", userInfoEntity);
    }

    @RequestMapping("/e-Testing/ViewStudent")
    public ModelAndView newsView(@RequestParam(value = "id", required = false) Long id,
                                 @RequestParam(value = "page", required = false) Integer page,
                                 UserInfoEntity userInfoEntity,
                                 Model model) {

        userInfoEntity = userInfoService.getStudentById(id);
        model.addAttribute("student", userInfoEntity);
        Paging paging1 = new Paging(userInfoEntity.getProgramFiles().size());
        model.addAttribute("programList", userInfoService.programsList(
                userInfoService.setPage(page, paging1, model), id));

        return new ModelAndView("ViewStudent");
    }

    @RequestMapping("/e-Testing/DeleteStudent")
    public ModelAndView deleteNews(@RequestParam(value = "id", required = false) Long id) {
        userInfoService.deleteStudentById(id);

        return new ModelAndView("redirect:/e-Testing/StudentList.html");
    }

    @RequestMapping("/e-Testing/Download")
    public String download(@RequestParam(value = "programId", required = false) Long programId,
                           HttpServletResponse response,
                           ProgramFilesEntity programFilesEntity) throws Exception {

        programFilesEntity = userInfoService.getFileById(programId);
        response.setHeader("Content-Disposition", "inline;filename=\"" + programFilesEntity.getFileName() + "\"");
        response.setContentType(programFilesEntity.getContentType());
        response.setContentLength(programFilesEntity.getFile().length);
        FileCopyUtils.copy(programFilesEntity.getFile(), response.getOutputStream());

        return null;
    }

    @RequestMapping(value = "/e-Testing/MainAdminPage")
    public ModelAndView displayMainAdminPage() {
        return new ModelAndView("MainAdminPage");
    }

    @RequestMapping(value = "/e-Testing/MainStudentPage")
    public ModelAndView displayMainStudentPage(@RequestParam(value = "id", required = false) Long id) {
        System.out.println(id);
        return new ModelAndView("MainStudentPage");
    }
}
