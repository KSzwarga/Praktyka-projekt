package com.praktyka.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "case_type", schema = "cases")
public class CaseType {
    @Id
    @Column(name="case_type_code")
    private String caseTypeCode;
    @Column(name="description")
    private String caseTypeDescription;

    protected CaseType() {}

    public  CaseType(String caseTypeCode, String caseTypeDescription) {
        this.caseTypeCode = caseTypeCode;
        this.caseTypeDescription = caseTypeDescription;
    }

    public String getCaseTypeCode() {
        return caseTypeCode;
    }

    public void setCaseTypeCode(String caseTypeCode) {
        this.caseTypeCode = caseTypeCode;
    }


    public String getCaseTypeDescription() {
        return caseTypeDescription;
    }

    public void setCaseTypeDescription(String caseTypeDescription) {
        this.caseTypeDescription = caseTypeDescription;
    }
}


