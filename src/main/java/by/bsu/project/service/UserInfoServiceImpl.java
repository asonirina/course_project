package by.bsu.project.service;

import by.bsu.project.dao.UserInfoDAO;
import by.bsu.project.entity.ProgramFilesEntity;
import by.bsu.project.entity.UserInfoEntity;
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
