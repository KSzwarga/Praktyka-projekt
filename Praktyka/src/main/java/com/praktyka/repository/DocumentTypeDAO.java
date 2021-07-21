package com.praktyka.repository;


import com.praktyka.model.DocumentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentTypeDAO extends CrudRepository<DocumentType, String> {
    List<DocumentType> findAll();
}
