package com.praktyka.service;


import com.praktyka.model.Document;
import java.io.File;


public interface DocumentService {
    Document createDocument(Document theDocument, String text);
    String info(String path);
    File[] info(String path, String dateFrom, String dateTo);
    String readDocument(String path);
}
