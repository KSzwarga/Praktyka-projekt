package com.praktyka.service;


import com.praktyka.model.Case;


import java.util.List;

public interface CaseService {
    Case findCaseByCaseNumber(int caseNumber);
    List<Case> findAll();
    Case save(Case theCase);
    Case updateStatus(int caseNumber, String caseStatus);
    List<Case> findAllByCaseNumber(String surname);
}