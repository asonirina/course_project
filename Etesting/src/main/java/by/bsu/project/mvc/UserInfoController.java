package by.bsu.project.mvc;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.constants.ErrorsMessages;
import by.bsu.project.general.constants.PageTitles;
import by.bsu.project.general.model.NeuralNode;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.UserInfoEntity;
import by.bsu.project.model.News;
import by.bsu.project.paging.Paging;
import by.bsu.project.service.UserInfoService;
import by.bsu.project.utils.LinkGenerator;
import by.bsu.project.utils.NewsHelper;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alina Glumova
 */

@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    private String form = null;
    private static List<ProgramFilesEntity> programFilesEntityList = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(UserInfoController.class);

    @RequestMapping(value = "/e-Testing/ChangePassword")
    public ModelAndView changePassword(@RequestParam(value = "oldPassword", required = false) String oldPassword,
                                       @RequestParam(value = "password1", required = false) String password1,
                                       @RequestParam(value = "password2", required = false) String password2,
                                       HttpServletRequest request) {
        return changeUserPassword(oldPassword, password1, password2, request);
    }

    @RequestMapping(value = "/e-Testing/ChangeStudentPassword")
    public ModelAndView changeStudentPassword(@RequestParam(value = "oldPassword", required = false) String oldPassword,
                                              @RequestParam(value = "password1", required = false) String password1,
                                              @RequestParam(value = "password2", required = false) String password2,
                                              HttpServletRequest request) {
        return changeUserPassword(oldPassword, password1, password2, request);
    }

    @RequestMapping(value = "/e-Testing/StudentList")
    public ModelAndView displayStudentsList(@RequestParam(value = "page", required = false) Integer page,
                                            Model model) {

        try {
            if (form == null || form.isEmpty()) {
                Paging paging1 = new Paging(userInfoService.studentsCountList().intValue());
                model.addAttribute(ETestingConstants.MODEL_STUDENT_LIST,
                        userInfoService.studentsList(userInfoService.setPage(page, paging1, model)));
                model.addAttribute("students", new UserInfoEntity());
                model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.STUDENT_LIST);
            } else {
                Paging paging1 = new Paging(userInfoService.studentsByFormCountList(form).intValue());
                model.addAttribute(ETestingConstants.MODEL_STUDENT_LIST,
                        userInfoService.studentListByForm(userInfoService.setPage(page, paging1, model), form));
                model.addAttribute("students", new UserInfoEntity());
                model.addAttribute("currentForm", form);
                model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.STUDENT_LIST);
            }
            return new ModelAndView("StudentList");
        } catch (Exception ex) {
            logger.error("Unable to display students list " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/GetStudentListByForm")
    public ModelAndView getStudentListById(@ModelAttribute("StudentList") UserInfoEntity userInfoEntity) {
        form = userInfoEntity.getForm();
        return new ModelAndView("redirect:/e-Testing/StudentList.html", ETestingConstants.MODEL_TITLE, PageTitles.STUDENT_LIST);
    }

    @RequestMapping(value = "/e-Testing/vklogin")
    public ModelAndView vklogin(@ModelAttribute("StudentList") UserInfoEntity userInfoEntity) {
        return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
    }

    @RequestMapping(value = "/e-Testing/SaveStudent", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("EditStudent") UserInfoEntity userInfoEntity, Model model) {

        try {
            List<String> errors = null;
            if (userInfoEntity.getId() == null) {
                errors = Validator.validateLogin(userInfoEntity.getLogin(), userInfoService);
                NeuralNode node = NeuralNode.createRandom();
                userInfoEntity.setNeuralNode(node);
                node.setEntity(userInfoEntity);
            }
            userInfoEntity.setProgramFiles(programFilesEntityList);

            if (errors != null && errors.size() != 0) {
                model.addAttribute(ETestingConstants.MODEL_ERRORS, errors);
                model.addAttribute(ETestingConstants.MODEL_STUDENT, userInfoEntity);
                model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.EDIT_STUDENT);
                return new ModelAndView("EditStudent");
            }
            userInfoService.save(userInfoEntity);
            model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.VIEW_STUDENT);
            return new ModelAndView("redirect:/e-Testing/ViewStudent.html?id=" + userInfoEntity.getId());

        } catch (Exception ex) {
            logger.error("Unable to save student " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/EditStudent")
    public ModelAndView displayStudent(@RequestParam(value = "id", required = false) Long id,
                                       UserInfoEntity userInfoEntity, Model model) {
        try {
            if (null != id) {
                userInfoEntity = userInfoService.getStudentById(id);
                model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.EDIT_STUDENT);
            } else {
                userInfoEntity = new UserInfoEntity();
                model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.ADD_STUDENT);
            }
            programFilesEntityList = userInfoEntity.getProgramFiles();
            model.addAttribute(ETestingConstants.MODEL_STUDENT, userInfoEntity);
            return new ModelAndView("EditStudent");

        } catch (Exception ex) {
            logger.error("Unable to edit student " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
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
            model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.VIEW_STUDENT);
            return new ModelAndView("ViewStudent");

        } catch (Exception ex) {
            logger.error("Unable to display student " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping("/e-Testing/DeleteStudent")
    public ModelAndView deleteStudent(@RequestParam(value = "id", required = false) Long id) {
        try {
            userInfoService.deleteStudentById(id);

            return new ModelAndView("redirect:/e-Testing/StudentList.html", ETestingConstants.MODEL_TITLE, PageTitles.STUDENT_LIST);

        } catch (Exception ex) {
            logger.error("Unable to delete student " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
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

            byte[] file = programFilesEntity.getFile();
            response.setContentLength(file.length);

            FileCopyUtils.copy(file, response.getOutputStream());

            return null;

        } catch (Exception ex) {
            logger.error("Unable to download program file " + ex.getMessage());
            return "redirect:/e-Testing/error503.html";
        }
    }

    @RequestMapping("/e-Testing/DownloadResults")
    public String downloadResults(@RequestParam(value = "programId", required = false) Long programId,
                                  HttpServletResponse response,
                                  ProgramFilesEntity programFilesEntity) {
        try {
            programFilesEntity = userInfoService.getFileById(programId);
            response.setHeader("Content-Disposition", "inline;filename=\"" + ETestingConstants.MODEL_TEST_RESULTS + ".txt\"");
            response.setContentType(programFilesEntity.getContentType());

            byte[] file = programFilesEntity.getTestResults().getBytes();
            response.setContentLength(file.length);

            FileCopyUtils.copy(file, response.getOutputStream());
            return null;

        } catch (Exception ex) {
            logger.error("Unable to download test results file " + ex.getMessage());
            return "redirect:/e-Testing/error503.html";
        }
    }

    @RequestMapping(value = "/e-Testing/MainAdminPage")
    public ModelAndView displayMainAdminPage() {
        return newsPage("MainAdminPage");
    }

    @RequestMapping(value = "/e-Testing/MainStudentPage")
    public ModelAndView displayMainStudentPage() {
        return newsPage("MainStudentPage");
    }

    private ModelAndView newsPage(String base) {
        List<News> news = new ArrayList<>();
        try{
            news = NewsHelper.getRandomNews();
        } catch (Exception ex) {
            logger.info("News are not loaded");
        }
        Map<String, Object> params = new HashMap<>();
        params.put(ETestingConstants.MODEL_NEWS, news);
        params.put(ETestingConstants.MODEL_TITLE, PageTitles.HOME_PAGE);
        return new ModelAndView(base, params);
    }

    private ModelAndView changeUserPassword(String oldPassword,
                                            String password1,
                                            String password2,
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
            return new ModelAndView("ChangePassword", ETestingConstants.MODEL_TITLE, PageTitles.CHANGE_PASSWORD);

        } catch (Exception ex) {
            logger.error("Unable to change password " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/ResetPassword")
    public ModelAndView resetPassword(
            @RequestParam(value = "hash", required = true) String hash,
            @RequestParam(value = "password1", required = false) String password1,
            @RequestParam(value = "password2", required = false) String password2,
            @RequestParam(value = "email", required = false) String email,
            Model model
    ) throws Exception {
        if (!LinkGenerator.checkHash(hash)) {
            return new ModelAndView("redirect:/e-Testing/error404.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }

        try {
            if (password1 != null) {
                UserInfoEntity user = userInfoService.findStudentByLogin(email);
                if (password1.equals(password2)) {
                    user.setPassword(password1);
                    userInfoService.save(user);
                    model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.LOGIN_PAGE);
                    return new ModelAndView("redirect:/e-Testing/Login.html");
                }
                model.addAttribute(ETestingConstants.MODEL_MESSAGE, ErrorsMessages.WRONG_PASSWORD);
                return new ModelAndView("ResetPassword", ETestingConstants.MODEL_TITLE, PageTitles.CHANGE_PASSWORD );
            }
            return new ModelAndView("ResetPassword", ETestingConstants.MODEL_TITLE, PageTitles.CHANGE_PASSWORD);

        } catch (Exception ex) {
            logger.error("Unable to change password " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }
}
