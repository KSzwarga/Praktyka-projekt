package com.praktyka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "outgoing_correspondance_type", schema = "cases")
public class OutgoingCorrespondanceType {
    @Id
    @Column(name="outgoing_correspondance_type_code")
    private String outgoingCorrespondanceTypeCode;
    @Column(name="description")
    private String outgoingCorrespondanceTypeDescription;

    protected OutgoingCorrespondanceType() {}

    public OutgoingCorrespondanceType(String outgoingCorrespondanceTypeCode, String outgoingCorrespondanceTypeDescription) {
        this.outgoingCorrespondanceTypeCode = outgoingCorrespondanceTypeCode;
        this.outgoingCorrespondanceTypeDescription = outgoingCorrespondanceTypeDescription;
    }



    public String getOutgoingCorrespondanceTypeCode() {
        return outgoingCorrespondanceTypeCode;
    }

    public void setOutgoingCorrespondanceTypeCode(String outgoingCorrespondanceTypeCode) {
        this.outgoingCorrespondanceTypeCode = outgoingCorrespondanceTypeCode;
    }

    public String getOutgoingCorrespondanceTypeDescription() {
        return outgoingCorrespondanceTypeDescription;
    }

    public void setOutgoingCorrespondanceTypeDescription(String outgoingCorrespondanceTypeDescription) {
        this.outgoingCorrespondanceTypeDescription = outgoingCorrespondanceTypeDescription;
    }
}
