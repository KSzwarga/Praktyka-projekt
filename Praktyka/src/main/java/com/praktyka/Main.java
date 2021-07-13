package com.praktyka;


public class Main {

    public static void main(String[] args) {
        FilesManagement dataBase = new FilesManagement("C:\\Users\\kacper.szwarga\\Desktop\\Skrypty");
        dataBase.createFile("Test.txt","Some content");
        dataBase.exists("Test.txt");
        dataBase.info("Test.txt");
        dataBase.readFile("Test.txt");
        dataBase.info("10/10/2021","07/07/2021");
    }
}
