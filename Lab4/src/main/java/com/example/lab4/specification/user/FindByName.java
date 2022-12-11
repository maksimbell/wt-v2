package com.example.lab4.specification.user;


import com.example.lab4.specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindByName implements Specification {

    private final String username;

    public FindByName(String username) {
        this.username = username;
    }

    @Override
    public String toSql() {
        return "WHERE username=?";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.singletonList(username);
    }
}
