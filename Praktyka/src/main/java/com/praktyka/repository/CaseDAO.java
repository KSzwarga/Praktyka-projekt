package com.praktyka.repository;

import com.praktyka.model.Case;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CaseDAO extends CrudRepository<Case, String> {
    Case findCaseByCaseNumber(int caseNumber);
    List<Case> findAll();
}
