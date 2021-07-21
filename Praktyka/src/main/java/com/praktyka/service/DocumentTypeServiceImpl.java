package com.praktyka.service;


import com.praktyka.model.DocumentType;
import com.praktyka.repository.DocumentTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {
    private final DocumentTypeDAO documentTypeDAO;

    @Autowired
    public DocumentTypeServiceImpl(DocumentTypeDAO theDocumentTypeDAO) {
        documentTypeDAO = theDocumentTypeDAO;
    }

    @Override
    public List<DocumentType> findAll() {
        return documentTypeDAO.findAll();
    }
}
