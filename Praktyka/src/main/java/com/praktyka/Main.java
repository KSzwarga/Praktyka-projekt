package com.praktyka;


import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        FilesManagement dataBase = new FilesManagement("C:\\Users\\kacper.szwarga\\Desktop\\Skrypty");
        String testFile = "Test.txt";
        dataBase.createFile(testFile,"Some content");
        dataBase.exists(testFile);
        dataBase.info(testFile);
        dataBase.readFile(testFile);
        dataBase.info("10/10/2021","07/07/2021");
    }
}
