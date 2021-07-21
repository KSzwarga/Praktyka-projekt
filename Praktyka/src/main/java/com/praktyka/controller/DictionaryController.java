package com.praktyka.controller;


import com.praktyka.dto.DictionaryDTO;
import com.praktyka.model.*;
import com.praktyka.repository.BrandModelDAO;
import com.praktyka.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DictionaryController {

    private final ColorService colorService;
    private final CaseStatusService caseStatusService;
    private final CaseTypeService caseTypeService;
    private final DocumentTypeService documentTypeService;
    private final IncomingCorrespondanceTypeService incomingCorrespondanceTypeService;
    private final OutgoingCorrespondanceTypeService outgoingCorrespondanceTypeService;
    private final BrandModelService brandModelService;

    @Autowired
    public DictionaryController(ColorService theColorService, CaseStatusService theCaseStatusService,
                                CaseTypeService theCaseTypeService, DocumentTypeService theDocumentTypeService,
                                IncomingCorrespondanceTypeService theIncomingCorrespondanceTypeService,
                                OutgoingCorrespondanceTypeService theOutgoingCorrespondanceTypeService,
                                BrandModelService theBrandModelService){
        colorService = theColorService;
        caseStatusService = theCaseStatusService;
        caseTypeService = theCaseTypeService;
        documentTypeService = theDocumentTypeService;
        incomingCorrespondanceTypeService = theIncomingCorrespondanceTypeService;
        outgoingCorrespondanceTypeService = theOutgoingCorrespondanceTypeService;
        brandModelService = theBrandModelService;

    }

    @GetMapping(value = "/getAllColors")
    public List<DictionaryDTO> getAllColors() {
        List<Color> colors = colorService.findAll();
        List<DictionaryDTO> colorsDTO = new ArrayList<>();
        for (Color color : colors) {
            DictionaryDTO colorDTO = new DictionaryDTO();
            colorDTO.setCode(color.getColorCode());
            colorDTO.setDescription(color.getColorDescription());
            colorsDTO.add(colorDTO);
        }
        return colorsDTO;
    }
    @GetMapping(value = "/getAllCaseStatuses")
    public List<DictionaryDTO> getAllCaseStatuses() {
        List<CaseStatus> caseStatuses = caseStatusService.findAll();
        List<DictionaryDTO> caseStatusesDTO = new ArrayList<>();
        for (CaseStatus status : caseStatuses) {
            DictionaryDTO caseStatusDTO = new DictionaryDTO();
            caseStatusDTO.setCode(status.getCaseStatusCode());
            caseStatusDTO.setDescription(status.getCaseStatusDescription());
            caseStatusesDTO.add(caseStatusDTO);
        }
        return caseStatusesDTO;
    }
    @GetMapping(value = "/getAllCaseTypes")
    public List<DictionaryDTO> getAllCaseTypes() {
        List<CaseType> caseTypes = caseTypeService.findAll();
        List<DictionaryDTO> caseTypesDTO = new ArrayList<>();
        for (CaseType type : caseTypes) {
            DictionaryDTO caseTypeDTO = new DictionaryDTO();
            caseTypeDTO.setCode(type.getCaseTypeCode());
            caseTypeDTO.setDescription(type.getCaseTypeDescription());
            caseTypesDTO.add(caseTypeDTO);
        }
        return caseTypesDTO;
    }
    @GetMapping(value = "/getAllDocumentTypes")
    public List<DictionaryDTO> getAllDocumentTypes() {
        List<DocumentType> documentTypes = documentTypeService.findAll();
        List<DictionaryDTO> documentTypesDTO = new ArrayList<>();
        for (DocumentType documentType : documentTypes) {
            DictionaryDTO documentTypeDTO = new DictionaryDTO();
            documentTypeDTO.setCode(documentType.getDocumentTypeCode());
            documentTypeDTO.setDescription(documentType.getDocumentTypeDescription());
            documentTypesDTO.add(documentTypeDTO);
        }
        return documentTypesDTO;
    }
    @GetMapping(value = "/getAllIncomingCorrespondanceTypes")
    public List<DictionaryDTO> getAllIncomingCorrespondanceTypes() {
        List<IncomingCorrespondanceType> incomingCorrespondanceTypes = incomingCorrespondanceTypeService.findAll();
        List<DictionaryDTO> incomingCorrespondanceTypesDTO = new ArrayList<>();
        for (IncomingCorrespondanceType incomingCorrespondanceType : incomingCorrespondanceTypes) {
            DictionaryDTO incomingCorrespondanceTypeDTO = new DictionaryDTO();
            incomingCorrespondanceTypeDTO.setCode(incomingCorrespondanceType.getIncomingCorrespondanceTypeCode());
            incomingCorrespondanceTypeDTO.setDescription(incomingCorrespondanceType.getIncomingCorrespondanceTypeDescription());
            incomingCorrespondanceTypesDTO.add(incomingCorrespondanceTypeDTO);
        }
        return incomingCorrespondanceTypesDTO;
    }
    @GetMapping(value = "/getAllOutgoingCorrespondanceTypes")
    public List<DictionaryDTO> getAllOutgoingCorrespondanceTypes() {
        List<OutgoingCorrespondanceType> outgoingCorrespondanceTypes = outgoingCorrespondanceTypeService.findAll();
        List<DictionaryDTO> outgoingCorrespondanceTypesDTO = new ArrayList<>();
        for (OutgoingCorrespondanceType outgoingCorrespondanceType : outgoingCorrespondanceTypes) {
            DictionaryDTO outgoingCorrespondanceTypeDTO = new DictionaryDTO();
            outgoingCorrespondanceTypeDTO.setCode(outgoingCorrespondanceType.getOutgoingCorrespondanceTypeCode());
            outgoingCorrespondanceTypeDTO.setDescription(outgoingCorrespondanceType.getOutgoingCorrespondanceTypeDescription());
            outgoingCorrespondanceTypesDTO.add(outgoingCorrespondanceTypeDTO);
        }
        return outgoingCorrespondanceTypesDTO;
    }
    @GetMapping(value = "/getAllBrandsAndModels")
    public List<DictionaryDTO> getAllBrandsAndModels() {
        List<BrandModel> brandsAndModels = brandModelService.findAll();
        List<DictionaryDTO> brandsAndModelsDTO = new ArrayList<>();
        for (BrandModel brandModel : brandsAndModels) {
            DictionaryDTO brandModelDTO = new DictionaryDTO();
            brandModelDTO.setCode(brandModel.getBrand() + " " + brandModel.getModel());
            brandModelDTO.setDescription(null);
            brandsAndModelsDTO.add(brandModelDTO);
        }
        return brandsAndModelsDTO;
    }
}
