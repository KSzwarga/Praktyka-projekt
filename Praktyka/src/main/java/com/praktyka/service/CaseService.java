package com.praktyka.service;


import com.praktyka.model.Case;

import java.util.List;

public interface CaseService {
    Case findCaseByCaseNumber(int caseNumber);
    List<Case> findAll();
    Case save(Case d);
    void updateStatus(int caseNumber, String caseStatus);
}