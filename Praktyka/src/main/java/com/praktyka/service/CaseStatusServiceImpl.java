package com.praktyka.service;

import com.praktyka.model.CaseStatus;
import com.praktyka.repository.CaseStatusDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseStatusServiceImpl implements CaseStatusService{
    private final CaseStatusDAO caseStatusDAO;

    @Autowired
    public CaseStatusServiceImpl(CaseStatusDAO theCaseStatusDAO) {
        caseStatusDAO = theCaseStatusDAO;
    }

    @Override
    public List<CaseStatus> findAll() {
        return caseStatusDAO.findAll();
    }
}
