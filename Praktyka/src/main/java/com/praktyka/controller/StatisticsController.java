package com.praktyka.controller;

import com.praktyka.dto.CountQueryResultDTO;
import com.praktyka.model.Vehicle;
import com.praktyka.service.DocumentService;
import com.praktyka.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticsController {
    private final VehicleService vehicleService;

    @Autowired
    public StatisticsController(VehicleService theVehicleService){
        vehicleService = theVehicleService;
    }

    @GetMapping("/findVehicleByColor")
    public List<Vehicle> findByColor(@RequestParam String color){
        return vehicleService.findByColorCode(color);
    }

    @GetMapping("/colorForCaseType")
    public List<CountQueryResultDTO> colorForCaseType(@RequestParam String caseType) {return vehicleService.colorForCaseType(caseType);}

    @GetMapping("/brandForCaseType")
    public List<CountQueryResultDTO> brandForCaseType(@RequestParam String caseType) {return vehicleService.brandForCaseType(caseType);}

    @GetMapping("/modelForCaseType")
    public List<CountQueryResultDTO> modelForCaseType(@RequestParam String caseType) {return vehicleService.modelForCaseType(caseType);}

    @GetMapping("/yearForCaseType")
    public List<CountQueryResultDTO> yearForCaseType(@RequestParam String caseType) {return vehicleService.yearForCaseType(caseType);}
}
