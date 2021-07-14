package com.praktyka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        /*
        FilesManagement dataBase = new FilesManagement("C:\\Users\\kacper.szwarga\\Desktop\\Skrypty");
        String testFile = "Test.txt";
        dataBase.createFile(testFile,"Some content");
        dataBase.exists(testFile);
        dataBase.info(testFile);
        dataBase.readFile(testFile);
        dataBase.info("10/10/2021","07/07/2021");
        */
    }
}
