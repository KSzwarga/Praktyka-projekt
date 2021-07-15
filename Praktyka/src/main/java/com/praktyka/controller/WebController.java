package com.praktyka.controller;

import com.praktyka.DTO.PostRequest;
import com.praktyka.DTO.PostResponse;
import com.praktyka.model.Case;
import com.praktyka.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {

    private CaseService caseService;

    @Autowired
    public WebController(CaseService thecaseService){
        caseService = thecaseService;
    }

    @RequestMapping(value = "/createCase", method =  RequestMethod.POST, consumes={"application/json"})
    public PostResponse createCase(@RequestBody PostRequest inputPayload) {
        PostResponse response = new PostResponse();
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

}
