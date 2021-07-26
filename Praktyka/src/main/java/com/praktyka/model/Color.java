package com.praktyka.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "color", schema = "cases")
public class Color {
    @Id
    @Column(name="color_code")
    private String colorCode;
    @Column(name="description")
    private String colorDescription;

    @OneToMany(mappedBy = "colorCode")
    private List<Vehicle> vehicles = new ArrayList<>();

    protected Color() {}

    public  Color(String colorCode, String colorDescription) {
        this.colorCode = colorCode;
        this.colorDescription = colorDescription;
    }

    public String getColorCode() {
        return colorCode;
    }

    public String getColorDescription() {
        return colorDescription;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public void setColorDescription(String colorDescription) {
        this.colorDescription = colorDescription;
    }


}
