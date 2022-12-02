package com.wt.repository.impl;

import com.wt.repository.Criteria;
import com.wt.dao.CaseDAO;
import com.wt.dao.DAOException;
import com.wt.entity.Case;
import com.wt.repository.CaseRepository;
import java.util.List;

public class CaseRepositoryImpl implements CaseRepository {
    private final CaseDAO caseDAO;

    public CaseRepositoryImpl(CaseDAO caseDAO) {
        this.caseDAO = caseDAO;
    }

    @Override
    public List<Case> findAll() {
        try {
            return caseDAO.find(new Criteria());
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Case findByCardNum(String cardNum) {
        var criteria = new Criteria();
        criteria.add("cardNum", cardNum);
        try {
            return caseDAO.find(criteria).get(0);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Case userCase) {
        try {
            caseDAO.save(userCase);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Case userCase) {
        try {
            caseDAO.update(userCase);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }
}
