package com.wt.service.impl;

import com.wt.entity.Case;
import com.wt.repository.CaseRepository;
import com.wt.service.CaseService;
import java.util.List;

public class CaseServiceImpl implements CaseService {
    private final CaseRepository caseRepository;

    public CaseServiceImpl(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    @Override
    public List<Case> findAll() {
        return caseRepository.findAll();
    }

    @Override
    public void add(Case userCase) {
        caseRepository.save(userCase);
    }

    @Override
    public void update(Case userCase) {
        caseRepository.update(userCase);
    }
}
