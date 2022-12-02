package com.wt.dao;

import com.wt.repository.Criteria;
import com.wt.dao.DAOException;
import com.wt.entity.User;
import java.util.List;

public interface UserDAO {
    List<User> find(Criteria criteria) throws DAOException;
}
