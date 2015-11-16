package by.bsu.project.dao;

import by.bsu.project.general.model.*;

import java.util.List;

/**
 * @author Alina Glumova
 */
public interface UserInfoDAO {
    public void save(UserInfoEntity userInfoEntity);
    public void save(Task task);
    public void save(UserTask userTask);
    public boolean isExist(Class c, Long id);
    public UserInfoEntity getStudentById(Long id);
    public Task getTaskById(Long id);
    public ProgramFilesEntity getFileById(Long id);
    public void deleteStudentById(Long id);
    public void deleteTaskById(Long id);
    public List studentsList(int pageNumber);
    public List studentsList();
    public Long studentsCountList();
    public Long taskCountList(String form);
    public UserInfoEntity findStudentByLogin(String login);
    public List<ProgramFilesEntity> programsList(int pageNumber, Long id);
    public List<UserInfoEntity> studentListByForm(int pageNumber, String form);
    public List<UserInfoEntity> studentListByForm(String form);
    public List<Task> taskListByForm(Integer pageNumber, String form);
    public Long studentsByFormCountList(String form);
    public List<ProgramFilesEntity> getProgramsByName(String name, Long userId);
    public List<ProgramFilesEntity> getProgramsByRunStatus(int runStatus);
    public Task getTask(String form, String programName);
    public UserTask getUserTask(Long userId, Long taskId);
    public AttributeCounting getAC(Long acId);
}
