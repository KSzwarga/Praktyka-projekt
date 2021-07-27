package com.praktyka.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicle", schema = "cases")
public class Vehicle {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="vehicle_id")
    private Integer vehicleId;
    @Column(name="vin")
    private String vin;
    @Column(name="registration_number")
    private String registrationNumber;
    @Column(name="dmc")
    private String dmc;
    @Column(name="brand")
    private String brand;
    @Column(name="model")
    private String model;

    @ManyToOne()
    @JoinColumn(name = "color_code")
    private Color colorCode;

    @OneToMany(mappedBy = "vehicleId")
    private List<Case> cases = new ArrayList<>();

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getDmc() {
        return dmc;
    }

    public void setDmc(String dmc) {
        this.dmc = dmc;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColorCode() {
        return colorCode;
    }

    public void setColorCode(Color colorCode) {
        this.colorCode = colorCode;
    }
}
