package com.praktyka.service;


import com.praktyka.model.Case;
import com.praktyka.repository.CaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CaseServiceImpl implements CaseService{

    CaseDAO caseDAO;
    @Autowired
    public CaseServiceImpl(CaseDAO theCaseDAO){
        caseDAO = theCaseDAO;
    }

    @Override
    @Transactional
    public List<Case> findAllCases() {
        return caseDAO.findAll();
    }

    @Override
    public Case findCaseByCaseNumber(int caseNumber) {
        Case theCase = caseDAO.findCaseByCaseNumber(caseNumber);
        return theCase;
    }
}

