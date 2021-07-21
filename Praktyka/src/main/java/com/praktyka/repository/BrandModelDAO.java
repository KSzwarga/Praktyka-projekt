package com.praktyka.repository;

import com.praktyka.model.BrandModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BrandModelDAO extends CrudRepository<BrandModel, String> {
    List<BrandModel> findAll();
}
