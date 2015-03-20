package by.bsu.project.dao;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.UserInfoEntity;
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

    private final static int PAGE_SIZE = 3;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<UserInfoEntity> studentsList(int pageNumber) {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserInfoEntity where form != 'admin'  order by secondName");
        return getSubList(query, pageNumber);
    }

    public List<ProgramFilesEntity> programsList(int pageNumber, Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from ProgramFilesEntity where user_id = :id order by uploadProgramTime desc").
                setParameter(ETestingConstants.TABLE_FIELD_ID, id);
        return getSubList(query, pageNumber);

    }

    @Override
    public List<ProgramFilesEntity> getProgramsByName(String name, Long userId) {
        Query query = sessionFactory.getCurrentSession().
                createQuery("from ProgramFilesEntity where programName = :progrName and user_id <> :userId").
                setParameter(ETestingConstants.PROGRAM_NAME, name).
                setParameter(ETestingConstants.USER_ID, userId);
        return query.list();

    }

    @Override
    public Long studentsCountList() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from UserInfoEntity where form != 'admin'").uniqueResult();
    }

    @Override
    public Long studentsByFormCountList(String form) {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from UserInfoEntity where form =:form").
                setParameter(ETestingConstants.TABLE_FIELD_FORM, form).uniqueResult();
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
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(UserInfoEntity.class, id));
    }

    @Override
    public UserInfoEntity getStudentById(Long id) {
        return (UserInfoEntity) sessionFactory.getCurrentSession().createQuery("from UserInfoEntity where id = :id").
                setParameter(ETestingConstants.TABLE_FIELD_ID, id).uniqueResult();
    }

    @Override
    public ProgramFilesEntity getFileById(Long id) {
        return (ProgramFilesEntity) sessionFactory.getCurrentSession().createQuery("from ProgramFilesEntity where id = :id").
                setParameter(ETestingConstants.TABLE_FIELD_ID, id).uniqueResult();
    }

    @Override
    public boolean isExist(Long id) {
        return id != null && null != (UserInfoEntity) sessionFactory.getCurrentSession().load(UserInfoEntity.class, id);
    }

    @Override
    public UserInfoEntity findStudentByLogin(String login) {
        return (UserInfoEntity) sessionFactory.getCurrentSession().createQuery("from UserInfoEntity where login = :login").
                setParameter(ETestingConstants.TABLE_FIELD_LOGIN, login).uniqueResult();
    }

    public List<UserInfoEntity> studentListByForm(int pageNumber, String form) {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserInfoEntity where form = :form order by secondName").
                setParameter(ETestingConstants.TABLE_FIELD_FORM, form);
        return getSubList(query, pageNumber);
    }

    private List getSubList(Query query, int pageNumber) {
        query.setFirstResult(PAGE_SIZE * (pageNumber));
        query.setMaxResults(PAGE_SIZE);
        return query.list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
