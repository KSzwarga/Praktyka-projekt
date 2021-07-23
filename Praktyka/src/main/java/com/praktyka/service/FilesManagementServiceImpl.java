package com.praktyka.service;


import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FilesManagementServiceImpl implements FilesManagementService {
    private static final Logger LOGGER = Logger.getLogger( FilesManagementServiceImpl.class.getName() );

    public boolean exists(String path){
        if (new File(path).isFile()) {
            LOGGER.log(Level.INFO, "{0} - exists.", path);
            return true;
        } else {
            LOGGER.log(Level.INFO, "{0} - does not exist.", path);
            return false;
        }
    }
    public static String showInfo(File file) {
        LOGGER.log(Level.INFO, "File name: {0} ", file.getName());
        LOGGER.log(Level.INFO, "File path: {0} ", file.getAbsolutePath());
        LOGGER.log(Level.INFO, "File size: {0} bytes ", file.length());
        LocalDate localdate = Instant.ofEpochMilli(file.lastModified())
                .atZone(ZoneId.systemDefault()).toLocalDate();
        LOGGER.log(Level.INFO, "File last time modified: {0} ", localdate);
        return
                "File name=" + file.getName() + "  " +
                "File path=" + file.getAbsolutePath() + "  " +
                "File size=" + file.length() + " bytes" + "  " +
                "File last time modified=" + localdate + "  " ;

    }

    public String info(String path) {
        File file = new File(path);
        if (file.exists()){
            return showInfo(file);
        } else {
            LOGGER.log(Level.INFO, "file does not exist.");
            return null;
        }
    }

    public File[] info(String path, String dateFrom, String dateTo) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(dateFrom, dtf);
        LocalDate date2 = LocalDate.parse(dateTo, dtf);

        if (date2.isBefore(date1)) {
            LocalDate temp;
            temp = date1;
            date1 = date2;
            date2 = temp;
        }

        LocalDate finalDate = date1;
        LocalDate finalDate2 = date2;

        FileFilter fileFilter = (File file) -> {
            if (!file.exists()) {
                return false;
            }
            LocalDate localdate = Instant.ofEpochMilli(file.lastModified())
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            return localdate.isAfter(finalDate) && localdate.isBefore(finalDate2);
        };

        File directory = new File(path);
        File[] files = directory.listFiles(fileFilter);
        if (files != null) {
            for (File file : files) {
                showInfo(file);
            }
            return files;
        }
        return new File[0];
    }

    public void createFile(String path, String content) {
        try {
            File newFile = new File(path);
            if (newFile.createNewFile()) {
                LOGGER.log(Level.INFO, "File created.");
                PrintWriter printWriter = new PrintWriter(path, StandardCharsets.UTF_8);
                printWriter.write(content);
                printWriter.close();
            } else {
                LOGGER.log(Level.INFO, "File already exists.");
            }

        } catch (IOException e) {
            LOGGER.log( Level.SEVERE, e.toString(), e );
        }
    }

    public String readFile(String path) {
        try {
            String content = Files.readString(Paths.get(path));
            LOGGER.log( Level.INFO, content);
            return content;
        } catch (IOException e) {
            LOGGER.log( Level.SEVERE, e.toString(), e );
            return null;
        }
    }

}
