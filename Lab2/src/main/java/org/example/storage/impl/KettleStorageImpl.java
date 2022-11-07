package org.example.storage.impl;

import org.example.dao.ProductDAO;
import org.example.dao.exception.DAOException;
import org.example.entity.Kettle;
import org.example.entity.criteria.Criteria;
import org.example.storage.KettleStorage;
import java.util.Collections;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class KettleStorageImpl implements KettleStorage {
    private final ProductDAO productDAO;

    @Override
    public List<Kettle> findAll() {
        var kettleCriteria = new Criteria(Kettle.class.getSimpleName());
        try {
            return productDAO.find(kettleCriteria).stream().map(Kettle.class::cast).toList();
        } catch (DAOException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Kettle> findAllByColor(String color) {
        var kettleCriteria = new Criteria(Kettle.class.getSimpleName());
        kettleCriteria.add("color", color);
        try {
            return productDAO.find(kettleCriteria).stream().map(Kettle.class::cast).toList();
        } catch (DAOException e) {
            return Collections.emptyList();
        }
    }
}
