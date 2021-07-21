package com.praktyka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "incoming_correspondance_type", schema = "cases")
public class IncomingCorrespondanceType {
    @Id
    @Column(name="incoming_correspondance_type_code")
    private String incomingCorrespondanceTypeCode;
    @Column(name="description")
    private String incomingCorrespondanceTypeDescription;

    protected IncomingCorrespondanceType() {}

    public IncomingCorrespondanceType(String incomingCorrespondanceTypeCode, String incomingCorrespondanceTypeDescription) {
        this.incomingCorrespondanceTypeCode = incomingCorrespondanceTypeCode;
        this.incomingCorrespondanceTypeDescription = incomingCorrespondanceTypeDescription;
    }


    public String getIncomingCorrespondanceTypeCode() {
        return incomingCorrespondanceTypeCode;
    }

    public void setIncomingCorrespondanceTypeCode(String incomingCorrespondanceTypeCode) {
        this.incomingCorrespondanceTypeCode = incomingCorrespondanceTypeCode;
    }

    public String getIncomingCorrespondanceTypeDescription() {
        return incomingCorrespondanceTypeDescription;
    }

    public void setIncomingCorrespondanceTypeDescription(String incomingCorrespondanceTypeDescription) {
        this.incomingCorrespondanceTypeDescription = incomingCorrespondanceTypeDescription;
    }
}
