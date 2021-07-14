package com.praktyka;

import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {

    @RequestMapping(value = "/createCase", method =  RequestMethod.POST, consumes={"application/json"})
    public PostResponse CreateCase(@RequestBody PostRequest inputPayload) {
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
    public String getCaseNumber(@RequestParam String caseNumber) {
        return "caseNumber : " + caseNumber;
    }


}
