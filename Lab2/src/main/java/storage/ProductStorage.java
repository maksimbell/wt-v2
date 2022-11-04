package storage;

import entity.*;
import java.util.List;

public interface ProductStorage {
    List<Product> findAll();
}