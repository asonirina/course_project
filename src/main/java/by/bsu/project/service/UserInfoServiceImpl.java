package by.bsu.project.service;

import by.bsu.project.dao.UserInfoDAO;
import by.bsu.project.entity.ProgramFilesEntity;
import by.bsu.project.entity.UserInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public ProgramFilesEntity getFileById(Long id) {
        return userInfoDAO.getFileById(id);
    }

    @Transactional
    public UserInfoEntity getStudentById(Long id) {
        return userInfoDAO.getStudentById(id);
    }

    @Transactional
    public void deleteStudentById(Long id) {
        userInfoDAO.deleteStudentById(id);
    }

    @Transactional
    public List<UserInfoEntity> studentsList(int pageNumber) {
        return userInfoDAO.studentsList(pageNumber);
    }

    @Transactional
    public Long studentsCountList() {
        return userInfoDAO.studentsCountList();
    }

    @Transactional
    public UserInfoEntity findStudentByLogin(String login) {
        return userInfoDAO.findStudentByLogin(login);
    }
}
