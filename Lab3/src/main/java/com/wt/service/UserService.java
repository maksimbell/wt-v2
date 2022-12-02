package com.wt.service;

import com.wt.entity.User;

public interface UserService {

    User signIn(String login, String password);
}
