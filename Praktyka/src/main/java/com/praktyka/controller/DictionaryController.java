package com.praktyka.controller;


import com.praktyka.dto.DictionaryDTO;
import com.praktyka.model.*;
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
    private final IncomingCorrespondenceTypeService incomingCorrespondenceTypeService;
    private final OutgoingCorrespondenceTypeService outgoingCorrespondenceTypeService;
    private final BrandModelService brandModelService;

    @Autowired
    public DictionaryController(ColorService theColorService, CaseStatusService theCaseStatusService,
                                CaseTypeService theCaseTypeService, DocumentTypeService theDocumentTypeService,
                                IncomingCorrespondenceTypeService theIncomingCorrespondenceTypeService,
                                OutgoingCorrespondenceTypeService theOutgoingCorrespondenceTypeService,
                                BrandModelService theBrandModelService){
        colorService = theColorService;
        caseStatusService = theCaseStatusService;
        caseTypeService = theCaseTypeService;
        documentTypeService = theDocumentTypeService;
        incomingCorrespondenceTypeService = theIncomingCorrespondenceTypeService;
        outgoingCorrespondenceTypeService = theOutgoingCorrespondenceTypeService;
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
    @GetMapping(value = "/getAllIncomingCorrespondenceTypes")
    public List<DictionaryDTO> getAllIncomingCorrespondenceTypes() {
        List<IncomingCorrespondenceType> incomingCorrespondenceTypes = incomingCorrespondenceTypeService.findAll();
        List<DictionaryDTO> incomingCorrespondenceTypesDTO = new ArrayList<>();
        for (IncomingCorrespondenceType incomingCorrespondenceType : incomingCorrespondenceTypes) {
            DictionaryDTO incomingCorrespondenceTypeDTO = new DictionaryDTO();
            incomingCorrespondenceTypeDTO.setCode(incomingCorrespondenceType.getIncomingCorrespondenceTypeCode());
            incomingCorrespondenceTypeDTO.setDescription(incomingCorrespondenceType.getIncomingCorrespondenceTypeDescription());
            incomingCorrespondenceTypesDTO.add(incomingCorrespondenceTypeDTO);
        }
        return incomingCorrespondenceTypesDTO;
    }
    @GetMapping(value = "/getAllOutgoingCorrespondenceTypes")
    public List<DictionaryDTO> getAllOutgoingCorrespondenceTypes() {
        List<OutgoingCorrespondenceType> outgoingCorrespondenceTypes = outgoingCorrespondenceTypeService.findAll();
        List<DictionaryDTO> outgoingCorrespondenceTypesDTO = new ArrayList<>();
        for (OutgoingCorrespondenceType outgoingCorrespondenceType : outgoingCorrespondenceTypes) {
            DictionaryDTO outgoingCorrespondenceTypeDTO = new DictionaryDTO();
            outgoingCorrespondenceTypeDTO.setCode(outgoingCorrespondenceType.getOutgoingCorrespondenceTypeCode());
            outgoingCorrespondenceTypeDTO.setDescription(outgoingCorrespondenceType.getOutgoingCorrespondenceTypeDescription());
            outgoingCorrespondenceTypesDTO.add(outgoingCorrespondenceTypeDTO);
        }
        return outgoingCorrespondenceTypesDTO;
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
