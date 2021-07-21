package com.praktyka.service;

import com.praktyka.model.IncomingCorrespondanceType;
import com.praktyka.repository.IncomingCorrespondanceTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomingCorrespondanceTypeServiceImpl implements IncomingCorrespondanceTypeService {
    private final IncomingCorrespondanceTypeDAO incomingCorrespondanceTypeDAO;

    @Autowired
    public IncomingCorrespondanceTypeServiceImpl(IncomingCorrespondanceTypeDAO theIncomingCorrespondanceTypeDAO) {
        incomingCorrespondanceTypeDAO = theIncomingCorrespondanceTypeDAO;
    }

    @Override
    public List<IncomingCorrespondanceType> findAll() {
        return incomingCorrespondanceTypeDAO.findAll();
    }
}
