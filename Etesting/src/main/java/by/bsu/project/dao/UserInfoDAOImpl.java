package by.bsu.project.dao;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.Task;
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

    @Override
    public List<UserInfoEntity> studentsList() {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserInfoEntity where form != 'admin'  order by secondName");
        return query.list();
    }

    @Override
    public List<ProgramFilesEntity> programsList(int pageNumber, Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from ProgramFilesEntity where user_id = :id order by uploadProgramTime desc").
                setParameter(ETestingConstants.TABLE_FIELD_ID, id);
        return getSubList(query, pageNumber);
    }

    @Override
    public List<ProgramFilesEntity> getProgramsByName(String name, Long userId) {
        Query query = sessionFactory.getCurrentSession().
                createQuery("from ProgramFilesEntity where programName = :progrName and runStatus <> 5 and user_id <> :userId").
                setParameter(ETestingConstants.PROGRAM_NAME, name).
                setParameter(ETestingConstants.USER_ID, userId);
        return query.list();

    }

    @Override
    public List<ProgramFilesEntity> getProgramsByRunStatus(int runStatus) {
        Query query = sessionFactory.getCurrentSession().createQuery("from ProgramFilesEntity where runStatus = :run_status order by uploadProgramTime desc").
                setParameter(ETestingConstants.TABLE_FIELD_RUN_STATUS, runStatus);
        return query.list();
    }

    @Override
    public Task getTask(String form, String programName) {
        return (Task) sessionFactory.getCurrentSession().createQuery("from Task where programName = :program_name and form = :form").
                setParameter(ETestingConstants.TABLE_FIELD_PROGRAM_NAME, programName).
                setParameter(ETestingConstants.TABLE_FIELD_FORM, form).uniqueResult();
    }

    @Override
    public Long studentsCountList() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from UserInfoEntity where form != 'admin'").uniqueResult();
    }

    @Override
    public Long taskCountList(String form) {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from Task where form= :form")
                .setParameter(ETestingConstants.TABLE_FIELD_FORM, form).uniqueResult();
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

    public void save(Task task) {
        if (isExist(task.getId())) {
            sessionFactory.getCurrentSession().update(task);
        } else {
            sessionFactory.getCurrentSession().save(task);
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
    public Task getTaskById(Long id) {
        return (Task) sessionFactory.getCurrentSession().createQuery("from Task where id = :id").
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

    public List<Task> taskListByForm(Integer pageNumber, String form) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Task where form = :form order by id").
                setParameter(ETestingConstants.TABLE_FIELD_FORM, form);
        return (pageNumber != null) ? getSubList(query, pageNumber) : query.list();
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
