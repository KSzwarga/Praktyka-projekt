package com.praktyka.repository;

import com.praktyka.model.DocumentType;
import com.praktyka.model.IncomingCorrespondanceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomingCorrespondanceTypeDAO  extends CrudRepository<IncomingCorrespondanceType, String> {
    List<IncomingCorrespondanceType> findAll();
}
