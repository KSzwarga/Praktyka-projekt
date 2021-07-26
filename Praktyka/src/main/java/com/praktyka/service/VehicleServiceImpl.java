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

    @Override
    public List<String> distinctColors() {
        return vehicleDAO.distinctColors();
    }

    @Override
    public List<String> distinctBrands() {
        return vehicleDAO.distinctBrands();
    }

    @Override
    public List<String> distinctModels() {
        return  vehicleDAO.distinctModels();
    }

    @Override
    public List<String> distinctYears() {
        return vehicleDAO.distinctYears();
    }

    @Override
    public List<CountQueryResultDTO> caseTypeForColor(String color) {
       return vehicleDAO.caseTypeForColor(color);
    }

    @Override
    public List<CountQueryResultDTO> caseTypeForBrand(String brand) {
        return vehicleDAO.caseTypeForBrand(brand);
    }

    @Override
    public List<CountQueryResultDTO> caseTypeForModel(String model) {
        return vehicleDAO.caseTypeForModel(model);
    }

    @Override
    public List<CountQueryResultDTO> caseTypeForYear(String year) {
        return vehicleDAO.caseTypeForYear(year);
    }

    @Override
    public List<CountQueryResultDTO> statisticsByYearByColor(String year, String color) {
        return vehicleDAO.statisticsByYearByColor(year, color);
    }

    @Override
    public List<CountQueryResultDTO> statisticsByYearByBrand(String year, String brand){
        return vehicleDAO.statisticsByYearByBrand(year, brand);
    }

    @Override
    public List<CountQueryResultDTO> statisticsByYearByModel(String year, String model){
        return vehicleDAO.statisticsByYearByModel(year, model);
    }
}
