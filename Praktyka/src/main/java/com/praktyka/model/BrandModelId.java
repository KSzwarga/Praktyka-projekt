package com.praktyka.model;


import java.io.Serializable;

public class BrandModelId implements Serializable {
    private String brand;
    private String model;

    protected BrandModelId() {}

    public BrandModelId(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

}

