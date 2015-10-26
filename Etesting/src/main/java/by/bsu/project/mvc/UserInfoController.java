package by.bsu.project.mvc;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.constants.PageTitles;
import by.bsu.project.general.model.NeuralNode;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.UserInfoEntity;
import by.bsu.project.general.model.UserTask;
import by.bsu.project.model.News;
import by.bsu.project.paging.Paging;
import by.bsu.project.utils.NewsHelper;
import by.bsu.project.validator.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alina Glumova
 */

@Controller
public class UserInfoController extends BaseController {

    private List<ProgramFilesEntity> programFilesEntityList = new ArrayList<>();
    private List<UserTask> userTasks = new ArrayList<>();

    @RequestMapping(value = "/e-Testing/admin/StudentList")
    public ModelAndView displayStudentsList(@RequestParam(value = "page", required = false) Integer page,
                                            @RequestParam(value = "form", required = false) String form,
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
                model.addAttribute("currentForm", form);
                model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.STUDENT_LIST);
            }
            return new ModelAndView("StudentList");
        } catch (Exception ex) {
            logger.error("Unable to display students list " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/admin/SaveStudent", method = RequestMethod.POST)
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
            userInfoEntity.setUserTasks(userTasks);

            if (errors != null && errors.size() != 0) {
                model.addAttribute(ETestingConstants.MODEL_ERRORS, errors);
                model.addAttribute(ETestingConstants.MODEL_STUDENT, userInfoEntity);
                model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.EDIT_STUDENT);
                return new ModelAndView("EditStudent");
            }
            userInfoService.save(userInfoEntity);
            model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.VIEW_STUDENT);
            return new ModelAndView("redirect:/e-Testing/admin/ViewStudent.html?id=" + userInfoEntity.getId());

        } catch (Exception ex) {
            logger.error("Unable to save student " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/admin/EditStudent")
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
            userTasks = userInfoEntity.getUserTasks();
            model.addAttribute(ETestingConstants.MODEL_STUDENT, userInfoEntity);
            return new ModelAndView("EditStudent");

        } catch (Exception ex) {
            logger.error("Unable to edit student " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping("/e-Testing/admin/ViewStudent")
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

    @RequestMapping("/e-Testing/admin/DeleteStudent")
    public ModelAndView deleteStudent(@RequestParam(value = "id", required = false) Long id) {
        try {
            userInfoService.deleteStudentById(id);
            return new ModelAndView("redirect:/e-Testing/admin/StudentList.html", ETestingConstants.MODEL_TITLE, PageTitles.STUDENT_LIST);
        } catch (Exception ex) {
            logger.error("Unable to delete student " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping("/e-Testing/admin/Download")
    public ModelAndView download(@RequestParam(value = "programId", required = false) Long programId,
                           Model model) {
        try {
            ProgramFilesEntity programFilesEntity = userInfoService.getFileById(programId);
            String file  = new String(programFilesEntity.getFile());
            model.addAttribute(ETestingConstants.MODEL_FILE, file);
            model.addAttribute(ETestingConstants.MODEL_LANG, programFilesEntity.getLang().lang());
            model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.SOURCE_CODE);
            return new ModelAndView("DownloadCode", ETestingConstants.MODEL_FILE, file);
        } catch (Exception ex) {
            logger.error("Unable to download program file " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/{admin|student}/MainPage")
    public ModelAndView displayMainPage() {
        UserInfoEntity entity = userInfoService.getStudentById(getUser().getId());
        return newsPage("MainPage");
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
}
