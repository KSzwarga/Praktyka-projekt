package com.praktyka.service;

import com.praktyka.model.Color;
import com.praktyka.repository.ColorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ColorServiceImpl implements ColorService {

    private final ColorDAO colorDAO;

    @Autowired
    public ColorServiceImpl(ColorDAO theColorDAO) {
        colorDAO = theColorDAO;
    }

    @Override
    public List<Color> findAll() {
        return colorDAO.findAll();
    }
}

