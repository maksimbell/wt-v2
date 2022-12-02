package com.wt.repository;

import com.wt.entity.Case;
import java.util.List;

public interface CaseRepository {

    List<Case> findAll();

    Case findByCardNum(String cardNum);

    void save(Case userCase);

    void update(Case userCase);
}
