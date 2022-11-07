package org.example.dao;

import org.example.dao.exception.DAOException;
import org.example.entity.Product;
import org.example.entity.criteria.Criteria;
import java.util.List;

public interface ProductDAO {
    List<Product> find(Criteria criteria) throws DAOException;
    void create(Product product) throws DAOException;
}
