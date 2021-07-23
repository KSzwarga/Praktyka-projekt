package com.praktyka.repository;

import com.praktyka.model.CaseStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseStatusDAO extends CrudRepository<CaseStatus, String> {
    List<CaseStatus> findAll();
}
