package by.bsu.project.dao;

import by.bsu.project.constants.ETestingConstants;
import by.bsu.project.general.model.AttributeCounting;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: iason
 * Date: 04.05.14
 */
@Repository
public class AttributeDaoImpl implements AttributeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(AttributeCounting ac) {
        if (isExist(ac.getId())) {
            sessionFactory.getCurrentSession().update(ac);
        } else {
            sessionFactory.getCurrentSession().save(ac);
        }
    }

    public boolean isExist(Long id) {
        return id != null && null != sessionFactory.getCurrentSession().load(AttributeCounting.class, id);
    }

    public List<AttributeCounting> getACByProgramName(String programMame) {
        Query query = sessionFactory.getCurrentSession().createQuery("from AttributeCounting where progrName=:progrName").
                setParameter(ETestingConstants.PROGRAM_NAME, programMame);
        return query.list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
