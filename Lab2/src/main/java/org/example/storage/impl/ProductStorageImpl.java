package org.example.storage.impl;

import org.example.dao.ProductDAO;
import org.example.dao.exception.DAOException;
import org.example.entity.Product;
import org.example.entity.criteria.Criteria;
import org.example.storage.ProductStorage;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.storage.ProductStorage;

@RequiredArgsConstructor
public class ProductStorageImpl implements ProductStorage {

    private final ProductDAO productDAO;

    @Override
    public List<Product> findAll() {
        try {
            return productDAO.find(new Criteria(""));
        } catch (DAOException e) {
            return Collections.emptyList();
        }
    }
}

