package com.praktyka.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "correspondence_incoming", schema = "cases")
public class IncomingCorrespondence {
    @Id
    @Column(name="document_id")
    private Integer documentId;
    @Column(name="receipt_date")
    private LocalDate receiptDate;
    @Column(name="incoming_correspondence_type_code")
    private String incomingCorrespondenceTypeCode;
    @OneToOne()
    @JoinColumn(name = "correspondent_id")
    private Correspondent correspondentId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "document_id")
    private Document document;

    protected IncomingCorrespondence() {}

    public IncomingCorrespondence(Integer documentId, LocalDate receiptDate, String incomingCorrespondenceTypeCode, Correspondent correspondentId) {
        this.documentId = documentId;
        this.receiptDate = receiptDate;
        this.incomingCorrespondenceTypeCode = incomingCorrespondenceTypeCode;
        this.correspondentId = correspondentId;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDate receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getIncomingCorrespondenceTypeCode() {
        return incomingCorrespondenceTypeCode;
    }

    public void setIncomingCorrespondenceTypeCode(String incomingCorrespondenceTypeCode) {
        this.incomingCorrespondenceTypeCode = incomingCorrespondenceTypeCode;
    }

    public Correspondent getCorrespondentId() {
        return correspondentId;
    }

    public void setCorrespondentId(Correspondent correspondentId) {
        this.correspondentId = correspondentId;
    }
}
