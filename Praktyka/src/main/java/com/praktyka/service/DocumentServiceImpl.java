package com.praktyka.service;

import com.praktyka.FilesManagement;
import com.praktyka.dto.DocumentDTO;
import com.praktyka.model.Document;
import com.praktyka.repository.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DocumentServiceImpl implements DocumentService {
    private final DocumentDAO documentDAO;

    @Autowired
    public DocumentServiceImpl(DocumentDAO theDocumentDAO) {
        documentDAO = theDocumentDAO;
}

    @Override
    public Document createDocument(DocumentDTO theDocumentDTO, String text) {
        Document theDocument = new Document();
        theDocument.setDocumentId(theDocumentDTO.getDocumentId());
        theDocument.setCaseNumber(theDocumentDTO.getCaseNumber());
        theDocument.setReferenceNumber(theDocumentDTO.getReferenceNumber());
        theDocument.setDocumentDate(theDocumentDTO.getDocumentDate());
        theDocument.setDocumentTypeCode(theDocumentDTO.getDocumentTypeCode());
        theDocument.setFilePath(theDocumentDTO.getFilePath());
        FilesManagement fm = new FilesManagement();
        fm.createFile(theDocument.getFilePath(),text);
        return documentDAO.save(theDocument);
    }

}
