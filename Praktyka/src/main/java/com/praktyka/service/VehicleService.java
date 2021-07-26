package com.praktyka.service;

import com.praktyka.dto.CountQueryResultDTO;
import com.praktyka.model.Vehicle;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface VehicleService {
    List<Vehicle> findByColorCode(String colorCode);
    List<CountQueryResultDTO> colorForCaseType(String caseType);
    List<CountQueryResultDTO> brandForCaseType(String caseType);
    List<CountQueryResultDTO> modelForCaseType(String caseType);
    List<CountQueryResultDTO> yearForCaseType(String caseType);
    List<String> distinctColors();
    List<String> distinctBrands();
    List<String> distinctModels();
    List<String> distinctYears();
    List<CountQueryResultDTO> caseTypeForColor(String color);
    List<CountQueryResultDTO> caseTypeForBrand(String brand);
    List<CountQueryResultDTO> caseTypeForModel(String model);
    List<CountQueryResultDTO> caseTypeForYear(String year);
    List<CountQueryResultDTO> statisticsByYearByColor(String year, String color);
    List<CountQueryResultDTO> statisticsByYearByBrand(String year, String brand);
    List<CountQueryResultDTO> statisticsByYearByModel(String year, String model);


}
