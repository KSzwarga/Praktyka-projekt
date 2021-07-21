package com.praktyka.service;

import com.praktyka.model.OutgoingCorrespondanceType;
import com.praktyka.repository.OutgoingCorrespondanceTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OutgoingCorrespondanceTypeServiceImpl implements OutgoingCorrespondanceTypeService{

    private final OutgoingCorrespondanceTypeDAO outgoingCorrespondanceTypeDAO;

    @Autowired
    public OutgoingCorrespondanceTypeServiceImpl(OutgoingCorrespondanceTypeDAO theOutgoingCorrespondanceTypeDAO) {
        outgoingCorrespondanceTypeDAO = theOutgoingCorrespondanceTypeDAO;
    }

    @Override
    public List<OutgoingCorrespondanceType> findAll() {
        return outgoingCorrespondanceTypeDAO.findAll();
    }
}

