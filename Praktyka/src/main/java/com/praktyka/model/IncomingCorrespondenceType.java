package com.praktyka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "incoming_Correspondence_type", schema = "cases")
public class IncomingCorrespondenceType {
    @Id
    @Column(name="incoming_Correspondence_type_code")
    private String incomingCorrespondenceTypeCode;
    @Column(name="description")
    private String incomingCorrespondenceTypeDescription;

    protected IncomingCorrespondenceType() {}

    public IncomingCorrespondenceType(String incomingCorrespondenceTypeCode, String incomingCorrespondenceTypeDescription) {
        this.incomingCorrespondenceTypeCode = incomingCorrespondenceTypeCode;
        this.incomingCorrespondenceTypeDescription = incomingCorrespondenceTypeDescription;
    }


    public String getIncomingCorrespondenceTypeCode() {
        return incomingCorrespondenceTypeCode;
    }

    public void setIncomingCorrespondenceTypeCode(String incomingCorrespondenceTypeCode) {
        this.incomingCorrespondenceTypeCode = incomingCorrespondenceTypeCode;
    }

    public String getIncomingCorrespondenceTypeDescription() {
        return incomingCorrespondenceTypeDescription;
    }

    public void setIncomingCorrespondenceTypeDescription(String incomingCorrespondenceTypeDescription) {
        this.incomingCorrespondenceTypeDescription = incomingCorrespondenceTypeDescription;
    }
}
