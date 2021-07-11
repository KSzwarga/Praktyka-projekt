package com.praktyka;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Files {

    String dir;

    public Files(String directory){
        dir =  directory + "\\";
    }

    public boolean exists(String path){
        if (new File(dir + path).isFile()) {
            System.out.println("File:" + path + " exists");
            return true;
        }
        else {
            System.out.println("File:" + path + "does not exist");
            return false;
        }
    }

    public void info(String path) {
        File file = new File(dir + path);
        if (file.isFile()){
            System.out.println("File name:" + file.getName());
            System.out.println("File path:" + file.getAbsolutePath());
            System.out.println("File size:" + file.length() +" bytes");
            System.out.println("File last time modified:" + new Date(file.lastModified())+"\n");
        }
        else {
            System.out.println("File doesnt exist.");
        }
    }

    public void info(String dateFrom, String dateTo) {
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateFrom);
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(dateTo);

            FileFilter fileFilter = file -> {
                if (!file.isFile()) return false;
                Date lastModified = new Date(file.lastModified());
                return lastModified.after(date1) && lastModified.before(date2);
            };

            File directory = new File(dir);
            File[] files = directory.listFiles(fileFilter);
            assert files != null;
            for (File file : files) {
                try{
                    System.out.println("File name:" + file.getName());
                    System.out.println("File path:" + file.getAbsolutePath());
                    System.out.println("File size:" + file.length() +" bytes");
                    System.out.println("File last time modified:" + new Date(file.lastModified()) +"\n");
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
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

    public void readFile(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(dir + path));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        }
        catch (IOException e){
            System.out.println("Error occured while trying to read a file");
            e.printStackTrace();
        }
    }

}
