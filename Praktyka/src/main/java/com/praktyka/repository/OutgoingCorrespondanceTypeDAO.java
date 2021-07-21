package com.praktyka.repository;

import com.praktyka.model.IncomingCorrespondanceType;
import com.praktyka.model.OutgoingCorrespondanceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutgoingCorrespondanceTypeDAO  extends CrudRepository<OutgoingCorrespondanceType, String> {
    List<OutgoingCorrespondanceType> findAll();
}
