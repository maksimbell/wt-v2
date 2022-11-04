package dao;

import entity.*;
import java.util.List;

public interface ProductDAO {
    List<Product> find(Criteria criteria);
    void create(Product product);
}
