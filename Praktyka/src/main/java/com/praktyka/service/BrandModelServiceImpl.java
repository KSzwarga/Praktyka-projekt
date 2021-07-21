package com.praktyka.service;

import com.praktyka.model.BrandModel;
import com.praktyka.repository.BrandModelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandModelServiceImpl implements BrandModelService{
    private final BrandModelDAO brandModelDAO;

    @Autowired
    public BrandModelServiceImpl(BrandModelDAO theBrandModelDAO) {
        brandModelDAO = theBrandModelDAO;
    }

    @Override
    public List<BrandModel> findAll() {
        return brandModelDAO.findAll();
    }
}
