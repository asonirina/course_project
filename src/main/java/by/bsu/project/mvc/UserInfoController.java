package by.bsu.project.mvc;

import by.bsu.project.compressing.Compresser;
import by.bsu.project.constants.ETestingConstants;
import by.bsu.project.constants.ErrorsMessages;
import by.bsu.project.entity.ProgramFilesEntity;
import by.bsu.project.entity.UserInfoEntity;
import by.bsu.project.paging.Paging;
import by.bsu.project.service.UserInfoService;
import by.bsu.project.validator.Validator;
import org.apache.log4j.Logger;
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
    private static final Logger logger = Logger.getLogger(UserInfoController.class);

    @RequestMapping(value = "/e-Testing/ChangePassword")
    public ModelAndView changePassword(@RequestParam(value = "oldPassword", required = false) String oldPassword,
                                       @RequestParam(value = "password1", required = false) String password1,
                                       @RequestParam(value = "password2", required = false) String password2,
                                       HttpServletRequest request) {
        try {
            if (oldPassword != null) {
                String login = request.getRemoteUser();
                UserInfoEntity user = userInfoService.findStudentByLogin(login);
                if (oldPassword.equals(user.getPassword()) && password1.equals(password2)) {
                    user.setPassword(password1);
                    userInfoService.save(user);
                    if (user.getForm().equals(ETestingConstants.ADMIN_ROLE)) {
                        return new ModelAndView("redirect:/e-Testing/MainAdminPage.html");
                    } else return new ModelAndView("redirect:/e-Testing/MainStudentPage.html");
                }
                return new ModelAndView("ChangePassword", ETestingConstants.MODEL_MESSAGE, ErrorsMessages.WRONG_PASSWORD);
            }
            return new ModelAndView("ChangePassword");

        } catch (Exception ex) {
            logger.error("Unable to change password " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html");
        }
    }

    @RequestMapping(value = "/e-Testing/StudentList")
    public ModelAndView displayStudentsList(@RequestParam(value = "page", required = false) Integer page,
                                            Model model) {

        try {
            Paging paging1 = new Paging(userInfoService.studentsCountList().intValue());
            model.addAttribute(ETestingConstants.MODEL_STUDENT_LIST,
                    userInfoService.studentsList(userInfoService.setPage(page, paging1, model)));

            return new ModelAndView("StudentList");
        } catch (Exception ex) {
            logger.error("Unable to display students list " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html");
        }
    }

    @RequestMapping(value = "/e-Testing/SaveStudent", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("EditStudent") UserInfoEntity userInfoEntity, Model model) {

        try {
            List<String> errors = Validator.validateLogin(userInfoEntity.getLogin(), userInfoService);
            userInfoEntity.setProgramFiles(programFilesEntityList);

            if (errors.size() != 0) {
                model.addAttribute(ETestingConstants.MODEL_ERRORS, errors);
                model.addAttribute(ETestingConstants.MODEL_STUDENT, userInfoEntity);
                return new ModelAndView("EditStudent");
            }

            userInfoService.save(userInfoEntity);

            return new ModelAndView("redirect:/e-Testing/ViewStudent.html?id=" + userInfoEntity.getId());

        } catch (Exception ex) {
            logger.error("Unable to save student " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html");
        }
    }

    @RequestMapping(value = "/e-Testing/EditStudent")
    public ModelAndView displayStudent(@RequestParam(value = "id", required = false) Long id,
                                       UserInfoEntity userInfoEntity) {
        try {
            if (null != id) {
                userInfoEntity = userInfoService.getStudentById(id);
            } else {
                userInfoEntity = new UserInfoEntity();
            }
            programFilesEntityList = userInfoEntity.getProgramFiles();

            return new ModelAndView("EditStudent", ETestingConstants.MODEL_STUDENT, userInfoEntity);

        } catch (Exception ex) {
            logger.error("Unable to edit student " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html");
        }
    }

    @RequestMapping("/e-Testing/ViewStudent")
    public ModelAndView studentView(@RequestParam(value = "id", required = false) Long id,
                                    @RequestParam(value = "page", required = false) Integer page,
                                    UserInfoEntity userInfoEntity,
                                    Model model) {
        try {
            userInfoEntity = userInfoService.getStudentById(id);
            model.addAttribute(ETestingConstants.MODEL_STUDENT, userInfoEntity);
            Paging paging1 = new Paging(userInfoEntity.getProgramFiles().size());
            model.addAttribute(ETestingConstants.MODEL_PROGRAM_LIST, userInfoService.programsList(
                    userInfoService.setPage(page, paging1, model), id));

            return new ModelAndView("ViewStudent");

        } catch (Exception ex) {
            logger.error("Unable to display student " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html");
        }
    }

    @RequestMapping("/e-Testing/DeleteStudent")
    public ModelAndView deleteStudent(@RequestParam(value = "id", required = false) Long id) {
        try {
            userInfoService.deleteStudentById(id);

            return new ModelAndView("redirect:/e-Testing/StudentList.html");

        } catch (Exception ex) {
            logger.error("Unable to delete student " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html");
        }
    }

    @RequestMapping("/e-Testing/Download")
    public String download(@RequestParam(value = "programId", required = false) Long programId,
                           HttpServletResponse response,
                           ProgramFilesEntity programFilesEntity) {
        try {
            programFilesEntity = userInfoService.getFileById(programId);
            response.setHeader("Content-Disposition", "inline;filename=\"" + programFilesEntity.getFileName() + "\"");
            response.setContentType(programFilesEntity.getContentType());
            response.setContentLength(programFilesEntity.getFile().length);

            System.out.println(programFilesEntity.getFile());
            byte[] file = Compresser.decompress(programFilesEntity.getFile());
            FileCopyUtils.copy(file, response.getOutputStream());

            return null;

        } catch (Exception ex) {
            logger.error("Unable to download file " + ex.getMessage());
            return "redirect:/e-Testing/error503.html";
        }
    }

    @RequestMapping(value = "/e-Testing/MainAdminPage")
    public ModelAndView displayMainAdminPage() {
        return new ModelAndView("MainAdminPage");
    }

    @RequestMapping(value = "/e-Testing/MainStudentPage")
    public ModelAndView displayMainStudentPage() {
        return new ModelAndView("MainStudentPage");
    }
}
