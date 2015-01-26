package by.bsu.project.dao;

import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.entity.UserInfoEntity;

import java.util.List;

/**
 * @author Alina Glumova
 */
public interface UserInfoDAO {
    public void save(UserInfoEntity userInfoEntity);
    public boolean isExist(Long id);
    public UserInfoEntity getStudentById(Long id);
    public ProgramFilesEntity getFileById(Long id);
    public void deleteStudentById(Long id);
    public List studentsList(int pageNumber);
    public Long studentsCountList();
    public UserInfoEntity findStudentByLogin(String login);
    public List<ProgramFilesEntity> programsList(int pageNumber, Long id);
    public List<UserInfoEntity> studentListByForm(int pageNumber, String form);
    public Long studentsByFormCountList(String form);
    public List<ProgramFilesEntity> getProgramsByName(String name);
}
