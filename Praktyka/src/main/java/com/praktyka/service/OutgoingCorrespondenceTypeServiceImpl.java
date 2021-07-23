package com.praktyka.service;

import com.praktyka.model.OutgoingCorrespondenceType;
import com.praktyka.repository.OutgoingCorrespondenceTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OutgoingCorrespondenceTypeServiceImpl implements OutgoingCorrespondenceTypeService {

    private final OutgoingCorrespondenceTypeDAO outgoingCorrespondenceTypeDAO;

    @Autowired
    public OutgoingCorrespondenceTypeServiceImpl(OutgoingCorrespondenceTypeDAO theOutgoingCorrespondenceTypeDAO) {
        outgoingCorrespondenceTypeDAO = theOutgoingCorrespondenceTypeDAO;
    }

    @Override
    public List<OutgoingCorrespondenceType> findAll() {
        return outgoingCorrespondenceTypeDAO.findAll();
    }
}

