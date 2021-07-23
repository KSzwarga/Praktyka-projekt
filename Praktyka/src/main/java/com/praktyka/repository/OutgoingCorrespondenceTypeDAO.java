package com.praktyka.repository;

import com.praktyka.model.OutgoingCorrespondenceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutgoingCorrespondenceTypeDAO extends CrudRepository<OutgoingCorrespondenceType, String> {
    List<OutgoingCorrespondenceType> findAll();
}
