package com.praktyka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "outgoing_Correspondence_type", schema = "cases")
public class OutgoingCorrespondenceType {
    @Id
    @Column(name="outgoing_Correspondence_type_code")
    private String outgoingCorrespondenceTypeCode;
    @Column(name="description")
    private String outgoingCorrespondenceTypeDescription;

    protected OutgoingCorrespondenceType() {}

    public OutgoingCorrespondenceType(String outgoingCorrespondenceTypeCode, String outgoingCorrespondenceTypeDescription) {
        this.outgoingCorrespondenceTypeCode = outgoingCorrespondenceTypeCode;
        this.outgoingCorrespondenceTypeDescription = outgoingCorrespondenceTypeDescription;
    }



    public String getOutgoingCorrespondenceTypeCode() {
        return outgoingCorrespondenceTypeCode;
    }

    public void setOutgoingCorrespondenceTypeCode(String outgoingCorrespondenceTypeCode) {
        this.outgoingCorrespondenceTypeCode = outgoingCorrespondenceTypeCode;
    }

    public String getOutgoingCorrespondenceTypeDescription() {
        return outgoingCorrespondenceTypeDescription;
    }

    public void setOutgoingCorrespondenceTypeDescription(String outgoingCorrespondenceTypeDescription) {
        this.outgoingCorrespondenceTypeDescription = outgoingCorrespondenceTypeDescription;
    }
}
