package com.praktyka.repository;

import com.praktyka.model.Case;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CaseDAO extends CrudRepository<Case, String>{
    Case findCaseByCaseNumber(int caseNumber);
    List<Case> findAll();

    @Transactional
    @Modifying
    @Query("UPDATE Case u SET u.caseStatus = :caseStatus WHERE u.caseNumber = :caseNumber")
    void updateStatus( @Param("caseNumber") int caseNumber, @Param("caseStatus") String caseStatus);
}
