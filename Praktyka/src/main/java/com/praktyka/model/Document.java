package com.praktyka.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sys_document", schema = "cases")
public class Document {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="document_id")
    private Integer documentId;
    @ManyToOne
    @JoinColumn(name="case_number", nullable=false)
    private Case caseNumber;
    @Column(name="reference_number")
    private String referenceNumber;
    @Column(name="document_date")
    private LocalDate documentDate;
    @Column(name="document_type_code")
    private String documentTypeCode;
    @Column(name="file_path")
    private String filePath;

    @OneToOne(mappedBy = "document")
    @PrimaryKeyJoinColumn
    private OutgoingCorrespondence outgoingCorrespondence;

    @OneToOne(mappedBy = "document")
    @PrimaryKeyJoinColumn
    private IncomingCorrespondence incomingCorrespondence;


    public Document() {}

    public Document(Integer documentId, Case caseNumber, String referenceNumber, LocalDate documentDate, String documentTypeCode, String filePath) {
        this.documentId = documentId;
        this.caseNumber = caseNumber;
        this.referenceNumber = referenceNumber;
        this.documentDate = documentDate;
        this.documentTypeCode = documentTypeCode;
        this.filePath = filePath;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public Case getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(Case caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public LocalDate getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(LocalDate documentDate) {
        this.documentDate = documentDate;
    }

    public String getDocumentTypeCode() {
        return documentTypeCode;
    }

    public void setDocumentTypeCode(String documentTypeCode) {
        this.documentTypeCode = documentTypeCode;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
