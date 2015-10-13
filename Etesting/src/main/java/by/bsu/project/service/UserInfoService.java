package by.bsu.project.service;

import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.Task;
import by.bsu.project.general.model.UserInfoEntity;
import by.bsu.project.paging.Paging;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author Alina Glumova
 */
public interface UserInfoService {
    public void save(UserInfoEntity userInfoEntity);
    public void save(Task task);
    public UserInfoEntity getStudentById(Long id);
    public Task getTaskById(Long id);
    public void deleteStudentById(Long id);
    public ProgramFilesEntity getFileById(Long id);
    public List<UserInfoEntity> studentsList(int pageNumber);
    public List<UserInfoEntity> studentsList();
    public Long studentsCountList ();
    public UserInfoEntity findStudentByLogin(String login);
    public List<ProgramFilesEntity> programsList(int pageNumber, Long id);
    public int setPage(Integer page, Paging paging1, Model model);
    public List<UserInfoEntity> studentListByForm(int pageNumber, String form);
    public List<Task> taskListByForm(int pageNumber, String form);
    public List<Task> taskListByForm(String form);
    public Long studentsByFormCountList(String form);
    public Long taskCountList();
    public List<ProgramFilesEntity> getProgramsByName (ProgramFilesEntity entity);
    public List<ProgramFilesEntity> getUploadedProgramFiles();
    public List<ProgramFilesEntity> getTestedProgramFiles();
    public List<ProgramFilesEntity> getReadyProgramFiles();
    public Task getTask(ProgramFilesEntity entity);
}
