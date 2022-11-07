package org.example.storage;

import org.example.entity.Kettle;

import java.util.List;

public interface KettleStorage {
    List<Kettle> findAll();

    List<Kettle> findAllByColor(String color);
}