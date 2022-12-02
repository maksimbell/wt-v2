package com.wt.dao;

import com.wt.repository.Criteria;
import com.wt.entity.Case;
import java.util.List;

public interface CaseDAO {
    List<Case> find(Criteria criteria) throws DAOException;

    void save(Case userCase) throws DAOException;

    void update(Case userCase) throws DAOException;
}
