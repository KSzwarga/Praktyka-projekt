package com.praktyka;
import org.apache.commons.lang3.*;

public class Main {

    public static void main(String[] args) {
        Files dataBase = new Files("C:\\Users\\kacper.szwarga\\Desktop\\BazaDanych");
        dataBase.createFile("Test.txt","Some content");
        dataBase.exists("Test.txt");
        dataBase.info("Test.txt");
        dataBase.readFile("Test.txt");
        dataBase.info("07/06/2021","10/07/2021");
    }
}
