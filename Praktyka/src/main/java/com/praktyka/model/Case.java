package com.praktyka.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sys_case", schema = "cases")
public class Case {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="case_number")
    private int caseNumber;
    @Column(name="vehicle_id")
    private Integer vehicleId;
    @Column(name="filing_date")
    private LocalDate filingDate;
    @Column(name="punishment_date")
    private LocalDate punishmentDate;
    @Column(name="case_type_code")
    private String caseType;
    @Column(name="status_code")
    private String caseStatus;

    protected Case() {}

    public Case(int caseNumber, Integer vehicleId, LocalDate creationDate, LocalDate punishmentDate, String caseType, String caseStatus) {
        this.caseNumber = caseNumber;
        this.vehicleId = vehicleId;
        this.filingDate = creationDate;
        this.punishmentDate = punishmentDate;
        this.caseType = caseType;
        this.caseStatus = caseStatus;
    }


    public int getCaseNumber() {
        return caseNumber;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public LocalDate getFilingDate() {
        return filingDate;
    }

    public LocalDate getPunishmentDate() {
        return punishmentDate;
    }

    public String getCaseType() {
        return caseType;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseNumber(int caseNumber) {
        this.caseNumber = caseNumber;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setFilingDate(LocalDate creationDate) {
        this.filingDate = creationDate;
    }

    public void setPunishmentDate(LocalDate punishmentDate) {
        this.punishmentDate = punishmentDate;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    @Override
    public String toString() {
        return "Case{" +
                "caseNumber='" + caseNumber + '\'' +
                ", vehicleId=" + vehicleId + '\'' +
                ", creationDate=" + filingDate + '\'' +
                ", punishmentDate=" + punishmentDate + '\'' +
                ", caseType='" + caseType + '\'' +
                ", caseStatus='" + caseStatus + '\'' +
                '}';
    }
}
