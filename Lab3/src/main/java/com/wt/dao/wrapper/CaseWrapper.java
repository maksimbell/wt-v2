package com.wt.dao.wrapper;

import com.wt.entity.Case;
import java.util.ArrayList;
import java.util.List;

public class CaseWrapper {
    private List<Case> cases;

    public CaseWrapper() {
        this.cases = new ArrayList<>();
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    public CaseWrapper(List<Case> cases) {
        this.cases = cases;
    }

    public void add(Case d) {
        cases.add(d);
    }
}
