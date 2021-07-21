package com.praktyka.repository;

import com.praktyka.model.Color;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorDAO extends CrudRepository<Color, String> {
    List<Color> findAll();
}
