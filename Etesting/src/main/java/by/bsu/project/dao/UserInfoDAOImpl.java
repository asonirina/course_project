package by.bsu.project.dao;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.constants.FieldToLoad;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.Task;
import by.bsu.project.general.model.UserInfoEntity;
import by.bsu.project.general.model.UserTask;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;


/**
 * @author Alina Glumova
 */

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

    private static final String ID = "id";
    private static final String FORM = "form";
    private static final String PROGRAM_NAME = "programName";
    private static final String SECOND_NAME = "secondName";

    private final static int PAGE_SIZE = 3;

    public static enum Op {
        EQ(" = "), NOT_EQ(" != ");

        private String op;

        private Op(String op) {
            this.op = op;
        }

        public String getOp() {
            return op;
        }
    }

    private static class Param {
        private String op;
        private String col;

        public static Param of(String col, Op op) {
            Param param = new Param();
            param.setOp(op.getOp());
            param.setCol(col);
            return param;
        }

        public String getOp() {
            return op;
        }

        public void setOp(String op) {
            this.op = op;
        }

        public String getCol() {
            return col;
        }

        public void setCol(String col) {
            this.col = col;
        }

        @Override
        public String toString() {
            return "." + col + op + ":" + col;
        }
    }

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<UserInfoEntity> studentsList(int pageNumber) {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserInfoEntity where form != 'admin'  order by secondName");
        return getSubList(query, pageNumber);
    }

    @Override
    public List<UserInfoEntity> studentsList(FieldToLoad... fields) {
        String query1 = generateQuery(UserInfoEntity.class, new Param[]{Param.of(FORM, Op.NOT_EQ)}, SECOND_NAME, fields);
        return sessionFactory.getCurrentSession().createQuery(query1).setParameter(FORM, "admin").list();
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
                createQuery("from ProgramFilesEntity where programName = :progrName and runStatus <> 5 and user_id <> :user_id").
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
    public Task getTask(String form, String programName, FieldToLoad... fields) {
        String query = generateQuery(Task.class, new Param[]{Param.of(FORM, Op.EQ), Param.of(PROGRAM_NAME, Op.EQ)}, fields);
        return (Task) sessionFactory.getCurrentSession().createQuery(query).
                setParameter(PROGRAM_NAME, programName).setParameter(FORM, form).uniqueResult();
    }

    @Override
    public UserTask getUserTask(Long userId, Long taskId) {
        return (UserTask) sessionFactory.getCurrentSession().createQuery("from UserTask where user_id = :user_id and task_id = :task_id").
                setParameter(ETestingConstants.USER_ID, userId).
                setParameter(ETestingConstants.TASK_ID, taskId).uniqueResult();
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

    @Override
    public void save(UserInfoEntity userInfoEntity) {
        if (isExist(UserInfoEntity.class, userInfoEntity.getId())) {
            sessionFactory.getCurrentSession().update(userInfoEntity);
        } else {
            sessionFactory.getCurrentSession().save(userInfoEntity);
        }
    }

    @Override
    public void save(Task task) {
        if (isExist(Task.class, task.getId())) {
            sessionFactory.getCurrentSession().update(task);
        } else {
            sessionFactory.getCurrentSession().save(task);
        }
    }

    @Override
    public void save(UserTask userTask) {
        if (isExist(Task.class, userTask.getId())) {
            sessionFactory.getCurrentSession().update(userTask);
        } else {
            sessionFactory.getCurrentSession().save(userTask);
        }
    }

    @Override
    public void deleteStudentById(Long id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(UserInfoEntity.class, id));
    }


    @Override
    public void deleteTaskById(Long id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(Task.class, id));
    }

    @Override
    public UserInfoEntity getStudentById(Long id) {
        return (UserInfoEntity) sessionFactory.getCurrentSession().get(UserInfoEntity.class, id);
    }

    @Override
    public Task getTaskById(Long id, FieldToLoad... fields) {
        String query = generateQuery(Task.class, new Param[]{Param.of(ID, Op.EQ)}, fields);
        return (Task) sessionFactory.getCurrentSession().createQuery(query).setParameter(ID, id).uniqueResult();
    }

    @Override
    public ProgramFilesEntity getFileById(Long id) {
        return (ProgramFilesEntity) sessionFactory.getCurrentSession().get(ProgramFilesEntity.class, id);
    }

    @Override
    public boolean isExist(Class c, Long id) {
        return id != null && null != sessionFactory.getCurrentSession().load(c, id);
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

    public List<UserInfoEntity> studentListByForm(String form) {
        return sessionFactory.getCurrentSession().createQuery("from UserInfoEntity where form = :form order by secondName").
                setParameter(ETestingConstants.TABLE_FIELD_FORM, form).list();
    }

    public List<Task> taskListByForm(Integer pageNumber, String form) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Task where form = :form order by id").
                setParameter(FORM, form);
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

    private static String generateQuery(Class c, Param params[], FieldToLoad... fields) {
        return generateQuery(c, params, null, fields);
    }

    private static String generateQuery(Class c, Param params[], String orderBy, FieldToLoad... fields) {
        String uqId = RandomStringUtils.randomAlphabetic(5);
        StringBuilder builder = new StringBuilder("FROM " + c.getSimpleName() + " " + uqId);
        for (FieldToLoad f : fields) {
            builder.append(String.format(" LEFT JOIN FETCH %s.%s ", uqId, f.getName()));
        }
        if (params.length > 0) {
            builder.append(" WHERE ");
        }
        List<String> list = new ArrayList<>();
        for (Param p : params) {
            list.add(uqId + p.toString());
        }
        builder.append(StringUtils.join(list, " AND "));
        if (orderBy != null) {
            builder.append(" ORDER BY " + uqId + "." + orderBy);
        }
        return builder.toString();
    }
}
