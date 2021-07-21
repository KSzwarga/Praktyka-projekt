package com.praktyka.model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(BrandModelId.class)
@Table(name = "brand_model", schema = "cases")
public class BrandModel implements Serializable {
    @Id
    @Column(name="brand")
    private String brand;
    @Id
    @Column(name="model")
    private String model;

    protected BrandModel() {}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
