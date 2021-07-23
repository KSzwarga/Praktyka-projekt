package com.praktyka.repository;

import com.praktyka.model.CaseType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseTypeDAO extends CrudRepository<CaseType, String> {
        List<CaseType> findAll();
    }
