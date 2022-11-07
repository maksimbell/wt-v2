package org.example.storage;

import org.example.entity.Product;
import java.util.List;

public interface ProductStorage {
    List<Product> findAll();
}
