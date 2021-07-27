package com.praktyka.repository;

import com.praktyka.model.Correspondent;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CorrespondentDAO extends CrudRepository<Correspondent, String> {
}

