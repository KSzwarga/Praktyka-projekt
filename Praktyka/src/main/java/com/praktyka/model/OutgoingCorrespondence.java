package com.praktyka.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "correspondence_outgoing", schema = "cases")
public class OutgoingCorrespondence {
    @Id
    @Column(name="document_id")
    private Integer documentId;
    @Column(name="createdby")
    private String createdBy;
    @Column(name="creation_date")
    private LocalDate creationDate;
    @Column(name="delivery_date")
    private LocalDate deliveryDate;
    @Column(name="outgoing_correspondence_type_code")
    private String outgoingCorrespondenceTypeCode;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "correspondent_id")
    private Correspondent correspondentId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "document_id")
    private Document document;

    protected OutgoingCorrespondence() {}

    public OutgoingCorrespondence(Integer documentId, String createdBy, LocalDate creationDate,
                                  LocalDate deliveryDate, String outgoingCorrespondenceTypeCode ,
                                  Correspondent correspondentId) {
        this.documentId = documentId;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.deliveryDate = deliveryDate;
        this.outgoingCorrespondenceTypeCode = outgoingCorrespondenceTypeCode;
        this.correspondentId = correspondentId;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }


    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getOutgoingCorrespondenceTypeCode() {
        return outgoingCorrespondenceTypeCode;
    }

    public void setOutgoingCorrespondenceTypeCode(String outgoingCorrespondenceTypeCode) {
        this.outgoingCorrespondenceTypeCode = outgoingCorrespondenceTypeCode;
    }

    public Correspondent getCorrespondentId() {
        return correspondentId;
    }

    public void setCorrespondentId(Correspondent correspondentId) {
        this.correspondentId = correspondentId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
