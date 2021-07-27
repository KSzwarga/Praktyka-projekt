package com.praktyka.service;


import com.praktyka.model.Case;
import com.praktyka.model.Document;
import com.praktyka.model.IncomingCorrespondence;
import com.praktyka.repository.CaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

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

    private Specification<Case> caseNumberLike(String surname){
        return (root, query, criteriaBuilder) -> {
            Join<Case, Document> caseDoc = root.join("documents");
            Predicate p1 = criteriaBuilder.like(caseDoc.get("outgoingCorrespondence").get("correspondentId").get("surname"), surname);
            Predicate p2 = criteriaBuilder.like(caseDoc.get("incomingCorrespondence").get("correspondentId").get("surname"), surname);
            return criteriaBuilder.or(p1,p2);
        };
    }

    @Override
    public List<Case> findAllByCaseNumber(String surname) {
        return caseDAO.findAll(where(caseNumberLike(surname)));
    }

}

