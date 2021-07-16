package com.praktyka.dto;

import java.time.LocalDate;

public class CaseRequest {
    private String caseNumber;
    private int vehicleId;
    private LocalDate creationDate;
    private LocalDate punishmentDate;
    private String caseType;
    private String caseStatus;


    public String getCaseNumber() {
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
