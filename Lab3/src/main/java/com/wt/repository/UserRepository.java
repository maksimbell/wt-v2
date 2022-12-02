package com.wt.repository;

import com.wt.entity.User;

public interface UserRepository {
    User findByLogin(String login);
}
