package com.example.lab4.specification;


import java.util.List;

public interface Specification {
    String toSql();

    List<Object> getParameters();
}
