package storage;

import entity.*;
import java.util.List;

public interface KettleStorage {
    List<Kettle> findAll();

    List<Kettle> findAllByColor(String color);
}