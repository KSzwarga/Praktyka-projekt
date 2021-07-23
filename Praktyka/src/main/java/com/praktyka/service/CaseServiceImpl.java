package com.praktyka.service;


import com.praktyka.model.Case;
import com.praktyka.repository.CaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseServiceImpl implements CaseService{

    private final CaseDAO caseDAO;
    @Autowired
    public CaseServiceImpl(CaseDAO theCaseDAO){
        caseDAO = theCaseDAO;
    }
    @Override
    public Case findCaseByCaseNumber(int caseNumber) {
        return caseDAO.findCaseByCaseNumber(caseNumber);
    }
    @Override
    public List<Case> findAll() {
        return caseDAO.findAll();
    }
    @Override
    public Case save(Case theCase) {
        return caseDAO.save(theCase);
    }

    @Override
    public Case updateStatus(int caseNumber, String caseStatus) {
        Case theCase = caseDAO.findCaseByCaseNumber(caseNumber);
        theCase.setCaseStatus(caseStatus);
        return caseDAO.save(theCase);
    }

}

