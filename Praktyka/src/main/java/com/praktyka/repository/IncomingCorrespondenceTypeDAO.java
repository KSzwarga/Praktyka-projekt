package com.praktyka.repository;

import com.praktyka.model.IncomingCorrespondenceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomingCorrespondenceTypeDAO extends CrudRepository<IncomingCorrespondenceType, String> {
    List<IncomingCorrespondenceType> findAll();
}
