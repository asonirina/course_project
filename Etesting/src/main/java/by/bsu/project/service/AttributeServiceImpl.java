package by.bsu.project.service;

import by.bsu.project.dao.AttributeDao;
import by.bsu.project.general.model.AttributeCounting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: iason
 * Date: 04.05.14
 */
@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeDao attributeDao;

    @Transactional
    @Override
    public void save(AttributeCounting ac) {
        attributeDao.save(ac);
    }

    @Transactional
    @Override
    public List<AttributeCounting> getByProgrName(AttributeCounting ac) {
        return attributeDao.getACByProgramName(ac.getProgrName());
    }
}
