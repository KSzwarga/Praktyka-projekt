package com.praktyka.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "case_type", schema = "cases")
public class CaseType {
    @Id
    @Column(name="case_type_code")
    private String caseTypeCode;
    @Column(name="description")
    private String caseTypeDescription;

    @OneToMany(mappedBy = "caseTypeCode")
    private List<Case> cases = new ArrayList<>();

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


