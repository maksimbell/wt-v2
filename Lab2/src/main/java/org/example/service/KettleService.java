package org.example.service;

import org.example.entity.Kettle;
import java.util.List;

public interface KettleService {
    List<Kettle> getAll();

    List<Kettle> getAllByColor(String color);
}
