package com.praktyka.repository;

import com.praktyka.model.Case;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CaseDAO extends CrudRepository<Case, String>{
    Case findCaseByCaseNumber(int caseNumber);
    List<Case> findAll();

}
