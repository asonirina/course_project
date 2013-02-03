package by.bsu.project.dao;

import by.bsu.project.entity.ProgramFilesEntity;
import by.bsu.project.entity.UserInfoEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alina Glumova
 */

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<UserInfoEntity> studentsList(int pageNumber) {
        Query criteria = sessionFactory.getCurrentSession().createQuery("from UserInfoEntity order by id asc ");
        criteria.setFirstResult(3 * (pageNumber));
        criteria.setMaxResults(3);
        return criteria.list();
    }

    @Override
    public Long studentsCountList() {
        return (Long)sessionFactory.getCurrentSession().createQuery("select count(*) from UserInfoEntity").uniqueResult();
    }

    public void save(UserInfoEntity userInfoEntity) {
        if (isExist(userInfoEntity.getId())) {
            sessionFactory.getCurrentSession().update(userInfoEntity);
        } else {
            sessionFactory.getCurrentSession().save(userInfoEntity);
        }
    }

    @Override
    public void deleteStudentById(Long id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(UserInfoEntity.class,id));
    }

    @Override
    public UserInfoEntity getStudentById(Long id) {
        return (UserInfoEntity) sessionFactory.getCurrentSession().createQuery("from UserInfoEntity where id = :id").
                setParameter("id", id).uniqueResult();
    }

    @Override
    public ProgramFilesEntity getFileById(Long id) {
        return (ProgramFilesEntity) sessionFactory.getCurrentSession().createQuery("from ProgramFilesEntity where id = :id").
                setParameter("id", id).uniqueResult();
    }

    @Override
    public boolean isExist(Long id) {
        return id == null ? false : null != (UserInfoEntity) sessionFactory.getCurrentSession().load(UserInfoEntity.class, id);
    }
}
