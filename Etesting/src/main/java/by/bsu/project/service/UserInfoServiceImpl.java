package by.bsu.project.service;

import by.bsu.project.general.dao.*;
import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.model.*;
import by.bsu.project.paging.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author Alina Glumova
 */

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final static int PAGE_SIZE = 3;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserTaskRepository userTaskRepository;

    @Autowired
    private AttributeCountingRepository attributeCountingRepository;

    @Autowired
    private ProgramFileInfoRepository programFileInfoRepository;

    @Transactional
    public void save(UserInfoEntity userInfoEntity) {
        userInfoRepository.save(userInfoEntity);
    }

    @Transactional
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Transactional
    public void save(UserTask userTask) {
        userTaskRepository.save(userTask);
    }

    @Transactional
    public ProgramFilesEntity getFileById(Long id) {
        return programFileInfoRepository.findOne(id);
    }

    @Transactional
    public UserInfoEntity getStudentById(Long id) {
        return userInfoRepository.findOne(id);
    }

    @Transactional
    public Task getTaskById(Long id) {
        return taskRepository.findOne(id);
    }

    @Transactional
    public void deleteStudentById(Long id) {
        userInfoRepository.delete(id);
    }

    @Transactional
    public void deleteTaskById(Long id) {
        taskRepository.delete(id);
    }

    @Transactional
    public List<UserInfoEntity> studentsList(int pageNumber) {
        return userInfoRepository.findByFormNot("admin", new PageRequest(pageNumber, PAGE_SIZE));
    }

    @Transactional
    public List<UserInfoEntity> studentsList() {
        return userInfoRepository.findByFormNot("admin");
    }


    @Transactional
    public List<ProgramFilesEntity> programsList(int pageNumber, Long id) {
        return programFileInfoRepository.findByUserId(id, new PageRequest(pageNumber, PAGE_SIZE));
    }

    @Transactional
    public Long studentsCountList() {
        return userInfoRepository.countByFormNot("admin");
    }

    @Transactional
    public UserInfoEntity findStudentByLogin(String login) {
        return userInfoRepository.findOneByLogin(login);
    }

    @Transactional
    public List<UserInfoEntity> studentListByForm(int pageNumber, String form) {
        return userInfoRepository.findByForm(form, new PageRequest(pageNumber, PAGE_SIZE));
    }

    @Transactional
    public List<UserInfoEntity> studentListByForm(String form) {
        return userInfoRepository.findByForm(form);
    }

    @Transactional
    public List<Task> taskListByForm(int pageNumber, String form) {
        if(form.equals("admin")) {
            form = "11";
        }
        return taskRepository.findByForm(form, new PageRequest(pageNumber, PAGE_SIZE));
    }

    @Transactional
    public List<Task> taskListByForm(String form) {
        if (form.equals("admin")) {
            form = "11";
        }
        return taskRepository.findByForm(form);
    }

    @Transactional
    public Long studentsByFormCountList(String form) {
        return userInfoRepository.countByForm(form);
    }

    @Transactional
    @Override
    public Long taskCountList(String form) {
        return taskRepository.countByForm(form);
    }

    @Transactional
    @Override
    public List<ProgramFilesEntity> getProgramsByName(ProgramFilesEntity entity) {
        return programFileInfoRepository.findByProgramNameAndUserIdNot(entity.getProgramName(), entity.getUser().getId());
    }

    @Transactional
    @Override
    public List<ProgramFilesEntity> getUploadedProgramFiles() {
        return programFileInfoRepository.findByRunStatus(ETestingConstants.UPLOADED_FILE);
    }

    @Transactional
    @Override
    public List<ProgramFilesEntity> getTestedProgramFiles() {
        return programFileInfoRepository.findByRunStatus(ETestingConstants.TESTED_FILE);
    }

    @Transactional
    @Override
    public List<ProgramFilesEntity> getReadyProgramFiles() {
        return programFileInfoRepository.findByRunStatus(ETestingConstants.READY_FILE);
    }

    @Transactional
    @Override
    public List<ProgramFilesEntity> getCompletedProgramFiles() {
        return programFileInfoRepository.findByRunStatus(ETestingConstants.COMPLETE_FILE);
    }

    @Transactional
    @Override
    public Task getTask(ProgramFilesEntity entity) {
        return taskRepository.findOneByFormAndProgramName(entity.getUser().getForm(), entity.getProgramName());
    }

    @Transactional
    @Override
    public UserTask getUserTask(UserInfoEntity user, Task task) {
        return userTaskRepository.findByUserIdAndTaskId(user.getId(), task.getId());
    }

    @Transactional
    @Override
    public UserTask getUserTask(Long userId, Long taskId) {
        return userTaskRepository.findByUserIdAndTaskId(userId, taskId);
    }

    @Transactional
    @Override
    public AttributeCounting getAC(Long acId) {
        return attributeCountingRepository.findOne(acId);
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

}
