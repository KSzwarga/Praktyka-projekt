package com.praktyka.controller;


import com.praktyka.dto.CaseDTO;
import com.praktyka.model.Case;
import com.praktyka.service.CaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;


@RestController()
@RequestMapping("/case")
public class CaseController {

    private final CaseService caseService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public CaseController(CaseService theCaseService){
        caseService = theCaseService;
    }

    @GetMapping("/getCase")
    public CaseDTO getCaseNumber(@RequestParam int caseNumber) {
        Case theCase = caseService.findCaseByCaseNumber(caseNumber);
        return modelMapper.map(theCase, CaseDTO.class);
    }

    @GetMapping("/getAllCases")
    public List<CaseDTO> getAllCases() {
        return caseService.findAll().stream().map(theCase -> modelMapper.map(theCase, CaseDTO.class))
                .collect(Collectors.toList());
    }


    @PostMapping("/saveCase")
    public CaseDTO saveCase(@RequestBody CaseDTO caseDTO){
        Case caseRequest = modelMapper.map(caseDTO, Case.class);
        Case theCase = caseService.save(caseRequest);
        return modelMapper.map(theCase, CaseDTO.class);
    }

    @PutMapping ("/updateCaseStatus")
    public CaseDTO updateCaseStatus(@RequestParam int caseNumber, @RequestParam String caseStatus){
        Case theCase = caseService.updateStatus(caseNumber, caseStatus);
        return modelMapper.map(theCase, CaseDTO.class);
    }

    @GetMapping ("/findByName")
    public List<CaseDTO> findAllByCaseNumber(@RequestParam String surname){
        return caseService.findAllByCaseNumber(surname).stream().map(theCase -> modelMapper.map(theCase, CaseDTO.class))
                .collect(Collectors.toList());
    }




}
