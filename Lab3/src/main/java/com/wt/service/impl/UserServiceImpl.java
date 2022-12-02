package com.wt.service.impl;

import com.wt.entity.User;
import com.wt.repository.UserRepository;
import com.wt.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signIn(String login, String password) {
        try {
            var user = userRepository.findByLogin(login);
            return user.getPassword().equals(password) ? user : null;
        } catch (Exception e) {
            return null;
        }
    }
}
