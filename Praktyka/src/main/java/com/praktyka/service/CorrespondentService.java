package com.praktyka.service;

import com.praktyka.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CorrespondentService {
    List<Case> findAllByNameLike(String name);
}
