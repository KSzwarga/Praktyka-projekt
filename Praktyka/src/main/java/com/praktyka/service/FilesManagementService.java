package com.praktyka.service;

import java.io.File;


public interface FilesManagementService {
    boolean exists(String path);
    String info(String path);
    File[] info(String path, String dateFrom, String dateTo);
    void createFile(String path, String content);
    String readFile(String path);
}
