package com.praktyka.repository;

import com.praktyka.model.CaseType;
import com.praktyka.model.Color;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CaseTypeDAO extends CrudRepository<CaseType, String> {
        List<CaseType> findAll();
    }
