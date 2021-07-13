package com.praktyka;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FilesManagement {

    public String dir;

    public FilesManagement(String directory){
        dir =  directory + "\\";
    }

    public boolean exists(String path){
        if (new File(dir + path).isFile()) {
            System.out.println("File:" + path + " - exists");
            return true;
        }
        else {
            System.out.println("File:" + path + " - does not exist");
            return false;
        }
    }

    public boolean info(String path) {
        File file = new File(dir + path);
        if (file.isFile()){
            System.out.println("File name:" + file.getName());
            System.out.println("File path:" + file.getAbsolutePath());
            System.out.println("File size:" + file.length() +" bytes");
            System.out.println("File last time modified:" + new Date(file.lastModified())+"\n");
            return true;
        }
        else {
            System.out.println("File doesnt exist.");
            return false;
        }
    }

    public boolean info(String dateFrom, String dateTo) {
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateFrom);
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(dateTo);

            if (date2.before(date1)) {
                Date temp;
                temp = date1;
                date1 = date2;
                date2 = temp;
            }

            Date finalDate = date1;
            Date finalDate2 = date2;

            FileFilter fileFilter = file -> {
                if (!file.isFile()) return false;
                Date lastModified = new Date(file.lastModified());
                return lastModified.after(finalDate) && lastModified.before(finalDate2);
            };

            File directory = new File(dir);
            File[] files = directory.listFiles(fileFilter);
            if (files != null) {
                for (File file : files) {
                    try {
                        System.out.println("File name:" + file.getName());
                        System.out.println("File path:" + file.getAbsolutePath());
                        System.out.println("File size:" + file.length() + " bytes");
                        System.out.println("File last time modified:" + new Date(file.lastModified()) + "\n");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void createFile(String path, String Content) {
        try {
            File newFile = new File(dir + path);
            if (newFile.createNewFile()) {
                System.out.println("File created.");
                PrintWriter printWriter = new PrintWriter(dir + path, StandardCharsets.UTF_8);
                printWriter.write(Content);
                printWriter.close();
            } else {
                System.out.println("File already exists.");
            }

        }
         catch (IOException e) {
             System.out.println("An error occurred while creating or writing to a file.");
             e.printStackTrace();
        }


    }

    public String readFile(String path) {
        try {
            String content = Files.readString(Paths.get(dir + path));
            System.out.println(content + "\n");
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
