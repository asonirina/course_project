package by.bsu.project.service;

import by.bsu.project.general.model.*;
import by.bsu.project.paging.Paging;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author Alina Glumova
 */
public interface UserInfoService {
    public void save(UserInfoEntity userInfoEntity);
    public void save(Task task);
    public void save(UserTask userTask);
    public UserInfoEntity getStudentById(Long id);
    public Task getTaskById(Long id);
    public void deleteStudentById(Long id);
    public void deleteTaskById(Long id);
    public ProgramFilesEntity getFileById(Long id);
    public List<UserInfoEntity> studentsList(int pageNumber);
    public List<UserInfoEntity> studentsList();
    public Long studentsCountList();
    public UserInfoEntity findStudentByLogin(String login);
    public List<ProgramFilesEntity> programsList(int pageNumber, Long id);
    public int setPage(Integer page, Paging paging1, Model model);
    public List<UserInfoEntity> studentListByForm(int pageNumber, String form);
    public List<UserInfoEntity> studentListByForm(String form);
    public List<Task> taskListByForm(int pageNumber, String form);
    public List<Task> taskListByForm(String form);
    public Long studentsByFormCountList(String form);
    public Long taskCountList(String form);
    public List<ProgramFilesEntity> getProgramsByName (ProgramFilesEntity entity);
    public List<ProgramFilesEntity> getUploadedProgramFiles();
    public List<ProgramFilesEntity> getTestedProgramFiles();
    public List<ProgramFilesEntity> getReadyProgramFiles();
    public List<ProgramFilesEntity> getCompletedProgramFiles();
    public Task getTask(ProgramFilesEntity entity);
    public UserTask getUserTask(UserInfoEntity user, Task task);
    public UserTask getUserTask(Long userId, Long taskId);
    public AttributeCounting getAC(Long acId);
}
