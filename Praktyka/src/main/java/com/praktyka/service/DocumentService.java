package com.praktyka.service;

import com.praktyka.dto.DocumentDTO;
import com.praktyka.model.Document;



public interface DocumentService {
    Document createDocument(DocumentDTO theDocumentDTO, String text);
}
