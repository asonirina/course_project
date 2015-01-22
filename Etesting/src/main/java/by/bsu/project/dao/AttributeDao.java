package by.bsu.project.dao;

import by.bsu.project.entity.AttributeCounting;

import java.util.List;

/**
 * User: iason
 * Date: 04.05.14
 */
public interface AttributeDao {
    public void save(AttributeCounting ac);
    public List<AttributeCounting> getACByProgramName(String programMame);

}
