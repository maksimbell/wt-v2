package com.wt.service;

import com.wt.entity.Case;
import java.util.List;

public interface CaseService {

    List<Case> findAll();

    void add(Case userCase);

    void update(Case userCase);
}
