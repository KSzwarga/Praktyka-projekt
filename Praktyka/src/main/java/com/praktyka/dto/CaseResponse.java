package com.praktyka.dto;

import java.time.LocalDate;

public class CaseResponse {
    private String caseNumber;
    private int vehicleId;
    private LocalDate creationDate;
    private LocalDate punishmentDate;
    private String caseType;
    private String caseStatus;


    public String getCaseNumber() {
        return caseNumber;
    }

    public int getVehicleId(int vehicleId) {
        return this.vehicleId;
    }

    public LocalDate getCreationDate(LocalDate creationDate) {
        return this.creationDate;
    }

    public LocalDate getPunishmentDate(LocalDate punishmentDate) {
        return this.punishmentDate;
    }

    public String getCaseType(String caseType) {
        return this.caseType;
    }

    public String getCaseStatus(String caseStatus) {
        return this.caseStatus;
    }

    public void setCaseNumber(String caseNumber) {
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
}