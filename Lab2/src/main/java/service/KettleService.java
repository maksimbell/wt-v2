package service;

import entity.*;
import java.util.List;

public interface KettleService {
    List<Kettle> getAll();

    List<Kettle> getAllByColor(String color);
}