package storage;

import dao.ProductDAO;
import entity.*;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductStorageImpl implements ProductStorage {

    private final ProductDAO productDAO;

    @Override
    public List<Product> findAll() {
        try {
            return productDAO.find(new Criteria(""));
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}