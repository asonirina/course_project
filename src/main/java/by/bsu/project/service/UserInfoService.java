package by.bsu.project.service;

import by.bsu.project.entity.ProgramFilesEntity;
import by.bsu.project.entity.UserInfoEntity;

import java.util.List;

/**
 * @author Alina Glumova
 */
public interface UserInfoService {
    public void save(UserInfoEntity userInfoEntity);
    public UserInfoEntity getStudentById(Long id);
    public void deleteStudentById(Long id);
    public ProgramFilesEntity getFileById(Long id);
    public List<UserInfoEntity> studentsList(int pageNumber);
    public Long studentsCountList ();
    public UserInfoEntity findStudentByLogin(String login);
}
