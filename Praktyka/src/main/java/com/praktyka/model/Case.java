package com.praktyka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "sys_case", schema = "cases")
public class Case {
    @Id
    @Column(name="case_number")
    private int caseNumber;
    @Column(name="vehicle_id")
    private int vehicleId;
    @Column(name="filing_date")
    private LocalDate creationDate;
    @Column(name="punishment_date")
    private LocalDate punishmentDate;
    @Column(name="case_type_code")
    private String caseType;
    @Column(name="status_code")
    private String caseStatus;

    protected Case() {}

    public Case(int caseNumber, int vehicleId, LocalDate creationDate, String caseType, String caseStatus) {
        this.caseNumber = caseNumber;
        this.vehicleId = vehicleId;
        this.creationDate = creationDate;
        this.caseType = caseType;
        this.caseStatus = caseStatus;
    }


    public int getCaseNumber() {
        return caseNumber;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
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

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
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
                ", vehicleId=" + vehicleId +
                ", creationDate=" + creationDate +
                ", caseType='" + caseType + '\'' +
                ", caseStatus='" + caseStatus + '\'' +
                '}';
    }
}
