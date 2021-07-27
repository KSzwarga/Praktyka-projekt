package com.praktyka.model;

import javax.persistence.*;


@Entity
@Table(name = "correspondent", schema = "cases")
public class Correspondent {
    @Id
    @Column(name="correspondent_id")
    private Integer correspondentId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="surname")
    private String surname;
    @Column(name="company_name")
    private String companyName;
    @Column(name="address_city")
    private String addressCity;
    @Column(name="address_street")
    private String addressStreet;
    @Column(name="address_home_number")
    private String addressHomeNumber;
    @Column(name="address_postal_code")
    private String addressPostalCode;

    @OneToOne(mappedBy = "correspondentId", fetch = FetchType.LAZY)
    private IncomingCorrespondence incomingCorrespondence;
    @OneToOne(mappedBy = "correspondentId", fetch = FetchType.LAZY)
    private OutgoingCorrespondence outgoingCorrespondence;

    protected Correspondent() {}

    public Correspondent(Integer correspondentId, String firstName, String surname, String companyName,
                         String addressCity, String addressStreet , String addressHomeNumber,
                         String addressPostalCode) {
        this.correspondentId = correspondentId;
        this.firstName = firstName;
        this.surname = surname;
        this.companyName = companyName;
        this.addressCity = addressCity;
        this.addressStreet = addressStreet;
        this.addressHomeNumber = addressHomeNumber;
        this.addressPostalCode = addressPostalCode;
    }
    public Integer getCorrespondentId() {
        return correspondentId;
    }

    public void setCorrespondentId(Integer correspondentId) {
        this.correspondentId = correspondentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressHomeNumber() {
        return addressHomeNumber;
    }

    public void setAddressHomeNumber(String addressHomeNumber) {
        this.addressHomeNumber = addressHomeNumber;
    }

    public String getAddressPostalCode() {
        return addressPostalCode;
    }

    public void setAddressPostalCode(String addressPostalCode) {
        this.addressPostalCode = addressPostalCode;
    }
}
