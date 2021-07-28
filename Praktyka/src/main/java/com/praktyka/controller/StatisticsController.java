package com.praktyka.controller;

import com.praktyka.dto.CountQueryResultDTO;
import com.praktyka.dto.StatisticQueryResultDTO;
import com.praktyka.dto.StatisticQueryResultYearDTO;
import com.praktyka.model.Vehicle;
import com.praktyka.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/statistics")
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
    public List<CountQueryResultDTO> colorForCaseType(@RequestParam String caseType) {
        return vehicleService.colorForCaseType(caseType);
    }

    @GetMapping("/brandForCaseType")
    public List<CountQueryResultDTO> brandForCaseType(@RequestParam String caseType) {
        return vehicleService.brandForCaseType(caseType);
    }

    @GetMapping("/modelForCaseType")
    public List<CountQueryResultDTO> modelForCaseType(@RequestParam String caseType) {
        return vehicleService.modelForCaseType(caseType);
    }

    @GetMapping("/yearForCaseType")
    public List<CountQueryResultDTO> yearForCaseType(@RequestParam String caseType) {
        return vehicleService.yearForCaseType(caseType);
    }

    @GetMapping("/statisticsByColor")
    public List<StatisticQueryResultDTO> statisticsByColor() {

        List<StatisticQueryResultDTO> result = new ArrayList<>();
        List<String> colors = vehicleService.distinctColors();
        for (String color: colors){
            result.add(new StatisticQueryResultDTO(color, vehicleService.caseTypeForColor(color)));
        }
        return result;
    }
    @GetMapping("/statisticsByBrand")
    public List<StatisticQueryResultDTO> statisticsByBrand() {
        List<StatisticQueryResultDTO> result = new ArrayList<>();
        List<String> brands = vehicleService.distinctBrands();
        for (String brand: brands){
            result.add(new StatisticQueryResultDTO(brand, vehicleService.caseTypeForBrand(brand)));
        }
        return result;
    }

    @GetMapping("/statisticsByModel")
    public List<StatisticQueryResultDTO> statisticsByModel() {
        List<StatisticQueryResultDTO> result = new ArrayList<>();
        List<String> models = vehicleService.distinctModels();
        for (String model: models){
            result.add(new StatisticQueryResultDTO(model, vehicleService.caseTypeForModel(model)));
        }
        return result;

    }

    @GetMapping("/statisticsByYear")
    public List<StatisticQueryResultDTO> statisticsByYear() {
        List<StatisticQueryResultDTO> result = new ArrayList<>();
        List<String> years = vehicleService.distinctYears();
        for (String year: years){
            result.add(new StatisticQueryResultDTO(year, vehicleService.caseTypeForYear(year)));
        }
        return result;
    }

    @GetMapping("/statisticsByYearByColor")
    public List<StatisticQueryResultYearDTO> statisticsByYearByColor() {
        List<StatisticQueryResultYearDTO> yearsResult = new ArrayList<>();

        List<String> years = vehicleService.distinctYears();
        List<String> colors = vehicleService.distinctColors();

        for (String year: years){
            List<StatisticQueryResultDTO> colorResult = new ArrayList<>();
            for (String color: colors){
                List<CountQueryResultDTO> queryResult = vehicleService.statisticsByYearByColor(year, color);
                if (!queryResult.isEmpty()){
                    colorResult.add(new StatisticQueryResultDTO(color, queryResult));
                }
            }
            yearsResult.add(new StatisticQueryResultYearDTO(year,colorResult));
        }
        return yearsResult;
    }

    @GetMapping("/statisticsByYearByBrand")
    public List<StatisticQueryResultYearDTO> statisticsByYearByBrand() {
        List<StatisticQueryResultYearDTO> yearsResult = new ArrayList<>();

        List<String> years = vehicleService.distinctYears();
        List<String> brands = vehicleService.distinctBrands();

        for (String year: years){
            List<StatisticQueryResultDTO> brandResult = new ArrayList<>();
            for (String brand: brands){
                List<CountQueryResultDTO> queryResult = vehicleService.statisticsByYearByBrand(year, brand);
                if (!queryResult.isEmpty()) {
                    brandResult.add(new StatisticQueryResultDTO(brand, queryResult));
                }
            }
            yearsResult.add(new StatisticQueryResultYearDTO(year,brandResult));
        }
        return yearsResult;
    }

    @GetMapping("/statisticsByYearByModel")
    public List<StatisticQueryResultYearDTO> statisticsByYearByModel() {
        List<StatisticQueryResultYearDTO> yearsResult = new ArrayList<>();

        List<String> years = vehicleService.distinctYears();
        List<String> models = vehicleService.distinctModels();

        for (String year: years){
            List<StatisticQueryResultDTO> modelResult = new ArrayList<>();
            for (String model: models){
                List<CountQueryResultDTO> queryResult = vehicleService.statisticsByYearByModel(year, model);
                if (!queryResult.isEmpty()){
                    modelResult.add(new StatisticQueryResultDTO(model, queryResult));
                }
            }
            yearsResult.add(new StatisticQueryResultYearDTO(year,modelResult));
        }
        return yearsResult;
    }
}
