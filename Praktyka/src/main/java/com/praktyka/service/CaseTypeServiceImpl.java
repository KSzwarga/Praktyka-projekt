package com.praktyka.service;

import com.praktyka.model.CaseType;
import com.praktyka.repository.CaseTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CaseTypeServiceImpl implements CaseTypeService{
    private final CaseTypeDAO caseTypeDAO;

    @Autowired
    public CaseTypeServiceImpl(CaseTypeDAO theCaseTypeDAO) {
        caseTypeDAO = theCaseTypeDAO;
    }

    @Override
    public List<CaseType> findAll() {
        return caseTypeDAO.findAll();
    }
}
