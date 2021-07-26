package com.praktyka.service;

import com.praktyka.dto.CountQueryResultDTO;
import com.praktyka.model.OutgoingCorrespondenceType;
import com.praktyka.model.Vehicle;
import com.praktyka.repository.OutgoingCorrespondenceTypeDAO;
import com.praktyka.repository.VehicleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements  VehicleService{
    private final VehicleDAO vehicleDAO;

    @Autowired
    public VehicleServiceImpl(VehicleDAO theVehicleDAO) {
        vehicleDAO = theVehicleDAO;
    }

    @Override
    public List<Vehicle> findByColorCode(String colorCode) {
        return vehicleDAO.findByColorCode(colorCode);
    }

    @Override
    public List<CountQueryResultDTO> colorForCaseType(String caseType) {
        return vehicleDAO.colorForCaseType(caseType);
    }

    public List<CountQueryResultDTO> brandForCaseType(String caseType){
        return vehicleDAO.brandForCaseType(caseType);
    }

    public List<CountQueryResultDTO> modelForCaseType(String caseType){
        return vehicleDAO.modelForCaseType(caseType);
    }

    public List<CountQueryResultDTO> yearForCaseType(String caseType){
        return vehicleDAO.yearForCaseType(caseType);
    }


}
