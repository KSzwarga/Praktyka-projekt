package com.praktyka.service;

import com.praktyka.dto.CountQueryResultDTO;
import com.praktyka.model.Vehicle;


import java.util.List;

public interface VehicleService {
    List<Vehicle> findByColorCode(String colorCode);
    List<CountQueryResultDTO> colorForCaseType(String caseType);
    List<CountQueryResultDTO> brandForCaseType(String caseType);
    List<CountQueryResultDTO> modelForCaseType(String caseType);
    List<CountQueryResultDTO> yearForCaseType(String caseType);


}
