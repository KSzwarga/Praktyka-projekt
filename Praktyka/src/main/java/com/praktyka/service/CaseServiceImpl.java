package com.praktyka.service;


import com.praktyka.model.Case;
import com.praktyka.repository.CaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}

