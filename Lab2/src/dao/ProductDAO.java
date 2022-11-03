package dao;

import entity.*;

public interface ProductDAO {
    List<Product> find(Criteria criteria);
    void create(Product product);
}
