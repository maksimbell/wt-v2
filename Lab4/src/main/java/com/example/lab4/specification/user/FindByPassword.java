package com.example.lab4.specification.user;


import com.example.lab4.specification.Specification;

import java.util.Arrays;
import java.util.List;

public class FindByPassword implements Specification {

    private final String username;
    private final String password;

    public FindByPassword(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toSql() {
        return "where username = ? AND password = ?";
    }

    @Override
    public List<Object> getParameters() {
        return Arrays.asList(username, password);
    }

}
