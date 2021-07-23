package com.praktyka.controller;


import com.praktyka.dto.DocumentDTO;
import com.praktyka.model.Document;
import com.praktyka.service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@RestController
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public DocumentController(DocumentService theDocumentService){
        documentService = theDocumentService;
    }

    @GetMapping("/infoDocument")
    public String infoDocument(@RequestParam String path){
        return documentService.info(path);
    }

    @GetMapping("/infoDocumentDate")
    public List<String> infoDocument(@RequestParam String path, @RequestParam String dateFrom, @RequestParam String dateTo){
        File[] files = documentService.info(path, dateFrom, dateTo);
        List<String> infos = new ArrayList<String>();
        for (File file : files) {
            infos.add(documentService.info(file.getAbsolutePath()));
        }
        return infos;
    }
    @GetMapping("/readDocument")
    public String readDocument(@RequestParam String path){
        return documentService.readDocument(path);
    }

    @PostMapping("/createDocument")
    public DocumentDTO createDocument(@RequestBody DocumentDTO documentDTO, @RequestParam String text){
        Document documentRequest = modelMapper.map(documentDTO, Document.class);
        Document document = documentService.createDocument(documentRequest, text);
        DocumentDTO documentResponse = modelMapper.map(document, DocumentDTO.class);
        return documentResponse;
    }


}
