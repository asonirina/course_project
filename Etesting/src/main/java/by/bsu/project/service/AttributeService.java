package by.bsu.project.service;

import by.bsu.project.entity.AttributeCounting;

import java.util.List;

/**
 * User: iason
 * Date: 04.05.14
 */
public interface AttributeService {
    public void save(AttributeCounting ac);
    public List<AttributeCounting> getByProgrName(AttributeCounting ac);
}
