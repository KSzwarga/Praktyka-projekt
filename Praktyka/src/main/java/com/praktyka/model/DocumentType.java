package com.praktyka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "document_type", schema = "cases")
public class DocumentType {
    @Id
    @Column(name="document_type_code")
    private String documentTypeCode;
    @Column(name="description")
    private String documentTypeDescription;

    protected DocumentType() {}

    public DocumentType(String documentTypeCode, String documentTypeDescription) {
        this.documentTypeCode = documentTypeCode;
        this.documentTypeDescription = documentTypeDescription;
    }

    public String getDocumentTypeDescription() {
        return documentTypeDescription;
    }

    public void setDocumentTypeDescription(String documentTypeDescription) {
        this.documentTypeDescription = documentTypeDescription;
    }

    public String getDocumentTypeCode() {
        return documentTypeCode;
    }

    public void setDocumentTypeCode(String documentTypeCode) {
        this.documentTypeCode = documentTypeCode;
    }
}
