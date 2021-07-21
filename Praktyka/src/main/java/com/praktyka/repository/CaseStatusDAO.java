package com.praktyka.repository;

import com.praktyka.model.CaseStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CaseStatusDAO extends CrudRepository<CaseStatus, String> {
    List<CaseStatus> findAll();
}
