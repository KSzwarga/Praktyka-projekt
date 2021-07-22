package com.praktyka.repository;

import com.praktyka.model.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DocumentDAO extends CrudRepository<Document, String> {

}
