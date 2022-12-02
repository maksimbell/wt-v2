package com.wt.repository.impl;

import com.wt.repository.Criteria;
import com.wt.dao.UserDAO;
import com.wt.dao.DAOException;
import com.wt.entity.User;
import com.wt.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    private final UserDAO userDAO;

    public UserRepositoryImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User findByLogin(String login) {
        var criteria = new Criteria();
        criteria.add("name", login);
        try {
            return userDAO.find(criteria).get(0);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }
}
