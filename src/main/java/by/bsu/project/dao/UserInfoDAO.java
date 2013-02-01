package by.bsu.project.dao;

import by.bsu.project.entity.UserInfoEntity;

import java.util.List;

/**
 * @author Alina Glumova
 */
public interface UserInfoDAO {
    public void save(UserInfoEntity userInfoEntity);
    public boolean isExist(Long id);
    public UserInfoEntity getStudentById(Long id);
    public void deleteStudentById(Long id);
    public List<UserInfoEntity> studentsList(int pageNumber);
    public Long studentsCountList();
}
