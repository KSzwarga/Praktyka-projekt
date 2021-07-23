package com.praktyka.service;


import com.praktyka.dto.DocumentDTO;
import com.praktyka.model.Document;
import com.praktyka.repository.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;


@Service
public class DocumentServiceImpl implements DocumentService {
    private final DocumentDAO documentDAO;
    private final FilesManagementService filesManagementService;

    @Autowired
    public DocumentServiceImpl(DocumentDAO theDocumentDAO, FilesManagementService theFilesManagementService) {
        documentDAO = theDocumentDAO;
        filesManagementService = theFilesManagementService;
    }

    @Override
    public String info(String path) {
        return filesManagementService.info(path);
    }

    @Override
    public File[] info(String path, String dateFrom, String dateTo) {
        return filesManagementService.info(path, dateFrom, dateTo);
    }

    @Override
    public Document createDocument(Document theDocument, String text) {
        filesManagementService.createFile(theDocument.getFilePath(),text);
        return documentDAO.save(theDocument);
    }

    @Override
    public String readDocument(String path) {
        return filesManagementService.readFile(path);
    }
}
