package com.praktyka.controller;

import com.praktyka.dto.CaseRequest;
import com.praktyka.dto.CaseResponse;
import com.praktyka.model.Case;
import com.praktyka.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
public class CaseController {

    private final CaseService caseService;

    @Autowired
    public CaseController(CaseService theCaseService){
        caseService = theCaseService;
    }

    @PostMapping(value = "/createCase", consumes={"application/json"})
    public CaseResponse createCase(@RequestBody CaseRequest inputPayload) {
        CaseResponse response = new CaseResponse();
        response.setCaseNumber(inputPayload.getCaseNumber());
        response.getVehicleId(inputPayload.getVehicleId());
        response.getCreationDate(inputPayload.getCreationDate());
        response.getPunishmentDate(inputPayload.getPunishmentDate());
        response.getCaseType(inputPayload.getCaseType());
        response.getCaseStatus(inputPayload.getCaseStatus());
        return response;
    }

    @GetMapping("/getCase")
    @ResponseBody
    public Case getCaseNumber(@RequestParam int caseNumber) {
        return caseService.findCaseByCaseNumber(caseNumber);
    }

    @GetMapping("/getAllCases")
    @ResponseBody
    public List<Case> getAllCases() {
        return caseService.findAll();
    }


    @PostMapping("/saveCase")
    public Case saveCase(@RequestBody Case theCase){
        return (caseService.save(theCase));
    }



}
