package com.praktyka.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "sys_case", schema = "cases")
public class Case {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="case_number")
    private int caseNumber;

    @ManyToOne()
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicleId;

    @Column(name="filing_date")
    private LocalDate filingDate;
    @Column(name="punishment_date")
    private LocalDate punishmentDate;

    @ManyToOne()
    @JoinColumn(name = "case_type_code")
    private CaseType caseTypeCode;

    @Column(name="case_status_code")
    public String caseStatus;

    @OneToMany(mappedBy="caseNumber")
    private Set<Document> documents;


    protected Case() {}

    public Case(int caseNumber, Vehicle vehicleId, LocalDate filingDate, LocalDate punishmentDate, CaseType caseTypeCode, String caseStatus) {
        this.caseNumber = caseNumber;
        this.vehicleId = vehicleId;
        this.filingDate = filingDate;
        this.punishmentDate = punishmentDate;
        this.caseTypeCode = caseTypeCode;
        this.caseStatus = caseStatus;
    }


    public int getCaseNumber() {
        return caseNumber;
    }

    public Vehicle getVehicleId() {
        return vehicleId;
    }

    public LocalDate getFilingDate() {
        return filingDate;
    }

    public LocalDate getPunishmentDate() {
        return punishmentDate;
    }

    public CaseType getCaseTypeCode() {
        return caseTypeCode;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseNumber(int caseNumber) {
        this.caseNumber = caseNumber;
    }

    public void setVehicleId(Vehicle vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setFilingDate(LocalDate creationDate) {
        this.filingDate = creationDate;
    }

    public void setPunishmentDate(LocalDate punishmentDate) {
        this.punishmentDate = punishmentDate;
    }

    public void setCaseTypeCode(CaseType caseType) {
        this.caseTypeCode = caseType;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    @Override
    public String toString() {
        return "Case{" +
                "caseNumber='" + caseNumber + '\'' +
                ", vehicleId=" + vehicleId + '\'' +
                ", filingDate=" + filingDate + '\'' +
                ", punishmentDate=" + punishmentDate + '\'' +
                ", caseTypeCode='" + caseTypeCode + '\'' +
                ", caseStatus='" + caseStatus + '\'' +
                '}';
    }
}
