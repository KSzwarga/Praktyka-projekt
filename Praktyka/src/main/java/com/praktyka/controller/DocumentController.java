package com.praktyka.controller;

import com.praktyka.dto.DocumentDTO;
import com.praktyka.model.Document;
import com.praktyka.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService theDocumentService){
        documentService = theDocumentService;
    }

    @PostMapping("/createDocument")
    public Document createDocument(@RequestBody DocumentDTO theDocumentDTO, @RequestParam String text){
        return (documentService.createDocument(theDocumentDTO, text));
    }


}
