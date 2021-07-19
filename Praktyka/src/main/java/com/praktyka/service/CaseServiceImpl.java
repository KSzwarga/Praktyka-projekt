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
    public Case save(Case d) {
        return caseDAO.save(d);
    }

    @Override
    public void updateStatus(int caseNumber, String caseStatus) {
        caseDAO.updateStatus(caseNumber, caseStatus);
    }

}

