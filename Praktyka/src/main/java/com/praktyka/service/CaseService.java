package com.praktyka.service;


import com.praktyka.model.Case;

import java.util.List;

public interface CaseService {
    public List<Case> findAllCases();
    public Case findCaseByCaseNumber(int caseNumber);
}