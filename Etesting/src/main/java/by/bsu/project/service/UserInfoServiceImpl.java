package by.bsu.project.service;

import by.bsu.project.dao.UserInfoDAO;
import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.model.Task;
import by.bsu.project.general.model.UserInfoEntity;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.UserTask;
import by.bsu.project.paging.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author Alina Glumova
 */

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Transactional
    public void save(UserInfoEntity userInfoEntity) {
        userInfoDAO.save(userInfoEntity);
    }

    @Transactional
    public void save(Task task) {
        userInfoDAO.save(task);
    }

    @Transactional
    public void save(UserTask userTask) {
        userInfoDAO.save(userTask);
    }

    @Transactional
    public ProgramFilesEntity getFileById(Long id) {
        return userInfoDAO.getFileById(id);
    }

    @Transactional
    public UserInfoEntity getStudentById(Long id) {
        return userInfoDAO.getStudentById(id);
    }

    @Transactional
    public Task getTaskById(Long id) {
        return userInfoDAO.getTaskById(id);
    }

    @Transactional
    public void deleteStudentById(Long id) {
        userInfoDAO.deleteStudentById(id);
    }

    @Transactional
    public void deleteTaskById(Long id) {
        userInfoDAO.deleteTaskById(id);
    }

    @Transactional
    public List<UserInfoEntity> studentsList(int pageNumber) {
        return userInfoDAO.studentsList(pageNumber);
    }

    @Transactional
    public List<UserInfoEntity> studentsList() {
        return userInfoDAO.studentsList();
    }


    @Transactional
    public List<ProgramFilesEntity> programsList(int pageNumber, Long id) {
        return userInfoDAO.programsList(pageNumber, id);
    }

    @Transactional
    public Long studentsCountList() {
        return userInfoDAO.studentsCountList();
    }

    @Transactional
    public UserInfoEntity findStudentByLogin(String login) {
        return userInfoDAO.findStudentByLogin(login);
    }

    @Transactional
    public List<UserInfoEntity> studentListByForm(int pageNumber, String form) {
        return userInfoDAO.studentListByForm(pageNumber, form);
    }

    @Transactional
    public List<UserInfoEntity> studentListByForm(String form) {
        return userInfoDAO.studentListByForm(form);
    }
    @Transactional
    public List<Task> taskListByForm(int pageNumber, String form) {
        if(form.equals("admin")) {
            form = "11";
        }
        return userInfoDAO.taskListByForm(pageNumber, form);
    }

    @Transactional
    public List<Task> taskListByForm(String form) {
        if (form.equals("admin")) {
            form = "11";
        }
        return userInfoDAO.taskListByForm(null, form);
    }

    @Transactional
    public Long studentsByFormCountList(String form) {
        return userInfoDAO.studentsByFormCountList(form);
    }

    @Transactional
    @Override
    public Long taskCountList(String form) {
        return userInfoDAO.taskCountList(form);
    }

    @Transactional
    @Override
    public List<ProgramFilesEntity> getProgramsByName(ProgramFilesEntity entity) {
        return userInfoDAO.getProgramsByName(entity.getProgramName(), entity.getUser().getId());
    }

    @Transactional
    @Override
    public List<ProgramFilesEntity> getUploadedProgramFiles() {
        return userInfoDAO.getProgramsByRunStatus(ETestingConstants.UPLOADED_FILE);
    }

    @Transactional
    @Override
    public List<ProgramFilesEntity> getTestedProgramFiles() {
        return userInfoDAO.getProgramsByRunStatus(ETestingConstants.TESTED_FILE);
    }

    @Transactional
    @Override
    public List<ProgramFilesEntity> getReadyProgramFiles() {
        return userInfoDAO.getProgramsByRunStatus(ETestingConstants.READY_FILE);
    }

    @Transactional
    @Override
    public Task getTask(ProgramFilesEntity entity) {
        return userInfoDAO.getTask(entity.getUser().getForm(), entity.getProgramName());
    }

    @Transactional
    @Override
    public UserTask getUserTask(UserInfoEntity user, Task task) {
        return userInfoDAO.getUserTask(user.getId(), task.getId());
    }

    @Transactional
    @Override
    public UserTask getUserTask(Long userId, Long taskId) {
        return userInfoDAO.getUserTask(userId, taskId);
    }

    public int setPage(Integer page, Paging paging1, Model model) {
        int pageNumber = 0;
        if (null != page) {
            if (page > paging1.getPageCount() - 1 || page < 0) {
                setFirstPage(model, paging1, 0);

                return 0;
            }
            setFirstPage(model, paging1, page);
            pageNumber = page;
        } else {
            setFirstPage(model, paging1, 0);
        }

        return pageNumber;
    }

    private void setFirstPage(Model model, Paging paging1, Integer page) {
        model.addAttribute("page", page);
        paging1.setPage(page);
        model.addAttribute("paging1", paging1);
    }

    public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
        this.userInfoDAO = userInfoDAO;
    }
}
