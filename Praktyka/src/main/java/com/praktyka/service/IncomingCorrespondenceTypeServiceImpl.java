package com.praktyka.service;

import com.praktyka.model.IncomingCorrespondenceType;
import com.praktyka.repository.IncomingCorrespondenceTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomingCorrespondenceTypeServiceImpl implements IncomingCorrespondenceTypeService {
    private final IncomingCorrespondenceTypeDAO incomingCorrespondenceTypeDAO;

    @Autowired
    public IncomingCorrespondenceTypeServiceImpl(IncomingCorrespondenceTypeDAO theIncomingCorrespondenceTypeDAO) {
        incomingCorrespondenceTypeDAO = theIncomingCorrespondenceTypeDAO;
    }

    @Override
    public List<IncomingCorrespondenceType> findAll() {
        return incomingCorrespondenceTypeDAO.findAll();
    }
}
