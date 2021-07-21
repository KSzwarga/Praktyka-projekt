package com.praktyka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "case_status", schema = "cases")
public class CaseStatus {
    @Id
    @Column(name="case_status_code")
    private String caseStatusCode;
    @Column(name="description")
    private String caseStatusDescription;

    protected CaseStatus() {}

    public  CaseStatus(String caseStatusCode, String caseStatusDescription) {
        this.caseStatusCode = caseStatusCode;
        this.caseStatusDescription = caseStatusDescription;
    }

    public String getCaseStatusCode() {
        return caseStatusCode;
    }

    public void setCaseStatusCode(String caseStatusCode) {
        this.caseStatusCode = caseStatusCode;
    }


    public String getCaseStatusDescription() {
        return caseStatusDescription;
    }

    public void setCaseStatusDescription(String caseStatusDescription) {
        this.caseStatusDescription = caseStatusDescription;
    }
}



