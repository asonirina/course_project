package by.bsu.project.dao;

import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.Task;
import by.bsu.project.general.model.UserInfoEntity;

import java.util.List;

/**
 * @author Alina Glumova
 */
public interface UserInfoDAO {
    public void save(UserInfoEntity userInfoEntity);
    public void save(Task task);
    public boolean isExist(Long id);
    public UserInfoEntity getStudentById(Long id);
    public Task getTaskById(Long id);
    public ProgramFilesEntity getFileById(Long id);
    public void deleteStudentById(Long id);
    public List studentsList(int pageNumber);
    public List studentsList();
    public Long studentsCountList();
    public Long taskCountList();
    public UserInfoEntity findStudentByLogin(String login);
    public List<ProgramFilesEntity> programsList(int pageNumber, Long id);
    public List<UserInfoEntity> studentListByForm(int pageNumber, String form);
    public List<Task> taskListByForm(Integer pageNumber, String form);
    public Long studentsByFormCountList(String form);
    public List<ProgramFilesEntity> getProgramsByName(String name, Long userId);
    public List<ProgramFilesEntity> getProgramsByRunStatus(int runStatus);
    public Task getTask(String form, String programName);
}
