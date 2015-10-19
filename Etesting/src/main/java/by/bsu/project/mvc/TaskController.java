package by.bsu.project.mvc;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.constants.PageTitles;
import by.bsu.project.general.model.Task;
import by.bsu.project.general.model.UserInfoEntity;
import by.bsu.project.general.model.UserTask;
import by.bsu.project.paging.Paging;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class TaskController extends BaseController {
    private List<UserTask> userTasks = new ArrayList<>();

    @RequestMapping(value = "/e-Testing/admin/TaskList")
    public ModelAndView displayTaskList(@RequestParam(value = "page", required = false) Integer page,
                                        @RequestParam(value = "form", required = false, defaultValue = "11") String form,
                                        Model model) {
        try {
            Paging paging1 = new Paging(userInfoService.taskCountList(form).intValue());
            model.addAttribute(ETestingConstants.MODEL_TASK_LIST,
                    userInfoService.taskListByForm(userInfoService.setPage(page, paging1, model), form));
            model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.TASK_LIST);
            model.addAttribute(ETestingConstants.CURRENT_FORM, form);
            return new ModelAndView("TaskList");
        } catch (Exception ex) {
            logger.error("Unable to display tasks list " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/student/StudentTasks")
    public ModelAndView displayStudentTasks(@RequestParam(value = "page", required = false) Integer page,
                                        Model model) {
        try {
            String form = userInfoService.getStudentById(getUser().getId()).getForm();
            Paging paging1 = new Paging(userInfoService.taskCountList(form).intValue());
            model.addAttribute(ETestingConstants.MODEL_TASK_LIST,
                    userInfoService.taskListByForm(userInfoService.setPage(page, paging1, model), form));
            model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.TASK_LIST);
            return new ModelAndView("StudentTasks");
        } catch (Exception ex) {
            logger.error("Unable to display tasks list " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/admin/SaveTask", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("EditTask") Task task, Model model) {

        try {
            task.setUserTasks(userTasks);
            userInfoService.save(task);
            model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.VIEW_STUDENT);
            return new ModelAndView("redirect:/e-Testing/admin/ViewTask.html?id=" + task.getId());

        } catch (Exception ex) {
            logger.error("Unable to save student " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/admin/EditTask")
    public ModelAndView displayTask(@RequestParam(value = "id", required = false) Long id,
                                    Task task, Model model) {
        try {
            if (null != id) {
                task = userInfoService.getTaskById(id);
                userTasks = task.getUserTasks();
                model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.EDIT_TASK);
            } else {
                task = new Task();
                model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.ADD_TASK);
            }
            model.addAttribute(ETestingConstants.MODEL_TASK, task);
            return new ModelAndView("EditTask");

        } catch (Exception ex) {
            logger.error("Unable to edit task " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping("/e-Testing/admin/ViewTask")
    public ModelAndView taskView(@RequestParam(value = "id", required = false) Long id,
                                 @RequestParam(value = "page", required = false) Integer page,
                                 Task task,
                                 Model model) {
        try {
            task = userInfoService.getTaskById(id);
            model.addAttribute(ETestingConstants.MODEL_TASK, task);
            model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.VIEW_TASK);
            return new ModelAndView("ViewTask");

        } catch (Exception ex) {
            logger.error("Unable to display task " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping("/e-Testing/admin/DeleteTask")
    public ModelAndView deleteTask(@RequestParam(value = "id", required = false) Long id,
                                   @RequestParam(value = "form", required = false) String form) {
        try {
            userInfoService.deleteTaskById(id);
            Map<String, Object> params = new HashMap<>();
            params.put(ETestingConstants.MODEL_TITLE, PageTitles.STUDENT_LIST);
            params.put(ETestingConstants.TABLE_FIELD_FORM, form);
            return new ModelAndView("redirect:/e-Testing/TaskList.html", params);

        } catch (Exception ex) {
            logger.error("Unable to delete task " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/admin/Assignments")
    public ModelAndView displayAssignTable(@RequestParam(value = "form", required = false, defaultValue = "11") String form,
                                        Model model) {
        try {
            List<UserInfoEntity> users = userInfoService.studentListByForm(form);
            List<Task> tasks = userInfoService.taskListByForm(form);
            model.addAttribute(ETestingConstants.MODEL_STUDENT_LIST, users);
            model.addAttribute(ETestingConstants.MODEL_TASKS, tasks);
            model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.TASK_LIST);
            model.addAttribute(ETestingConstants.CURRENT_FORM, form);
            return new ModelAndView("Assignments");
        } catch (Exception ex) {
            logger.error("Unable to display tasks list " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/admin/AssignTask", method = RequestMethod.POST)
    public
    @ResponseBody
    String assignTask(@RequestParam(value = "userId", required = true) Long userId,
                      @RequestParam(value = "taskId", required = true) Long taskId) throws Exception {

        UserInfoEntity user = userInfoService.getStudentById(userId);
        Task task = userInfoService.getTaskById(taskId);

        UserTask userTask = new UserTask();
        userTask.setUser(user);
        userTask.setTask(task);
        user.getUserTasks().add(userTask);
        task.getUserTasks().add(userTask);
        userInfoService.save(user);
        userInfoService.save(task);
        return "";
    }
}
