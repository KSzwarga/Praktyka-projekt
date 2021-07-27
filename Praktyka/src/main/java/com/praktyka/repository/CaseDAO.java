package com.praktyka.repository;

import com.praktyka.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CaseDAO extends JpaRepository<Case, String>, JpaSpecificationExecutor<Case> {
    Case findCaseByCaseNumber(int caseNumber);
    List<Case> findAll();
    List<Case> findAllByCaseNumber(String surname);


}
