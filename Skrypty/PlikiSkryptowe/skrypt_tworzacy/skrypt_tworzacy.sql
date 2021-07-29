CREATE DATABASE praktyka
  WITH OWNER "postgres"
  ENCODING "UTF-8";
\c praktyka

CREATE SCHEMA cases;

CREATE TABLE cases.case_type 
(
	case_type_code character varying(10) PRIMARY KEY,
    description character varying(255) NOT NULL UNIQUE
);

CREATE TABLE cases.document_type 
(
	document_type_code character varying(10) PRIMARY KEY,
    description character varying(255) NOT NULL UNIQUE
);


CREATE TABLE cases.case_status 
(
	case_status_code character varying(10) PRIMARY KEY,
    description character varying(255) NOT NULL UNIQUE
);

CREATE TABLE cases.color 
(
    color_code character varying(10) PRIMARY KEY ,
	description character varying(255) NOT NULL UNIQUE
);

CREATE TABLE cases.brand_model 
(
    brand character varying(25),
    model character varying(25),
	PRIMARY KEY (brand, model)
);

CREATE TABLE cases.outgoing_correspondence_type
(
	outgoing_correspondence_type_code character varying(10) PRIMARY KEY,
	description character varying(255) NOT NULL UNIQUE
);

CREATE TABLE cases.incoming_correspondence_type
(
	incoming_correspondence_type_code character varying(10) PRIMARY KEY,
	description character varying(255) NOT NULL UNIQUE
);


CREATE TABLE cases.vehicle 
(
    vehicle_id bigserial PRIMARY KEY ,
    vin character varying(20) NOT NULL,
    registration_number character varying(20) NOT NULL,
    dmc character varying(10),
    brand character varying(255),
    model character varying(255),
	color_code character varying(10) REFERENCES  cases.color (color_code),
	CONSTRAINT Foreign_key_vehicle FOREIGN KEY (brand,model) REFERENCES  cases.brand_model (brand,model)
);

CREATE TABLE cases.sys_case
(
    case_number bigserial PRIMARY KEY,
    filing_date date NOT NULL,
    punishment_date date,
    case_type_code character varying(10) NOT NULL REFERENCES  cases.case_type (case_type_code),
    case_status_code character varying(10) NOT NULL REFERENCES  cases.case_status (case_status_code),
    vehicle_id bigint REFERENCES  cases.vehicle (vehicle_id)
	CONSTRAINT check_filing_date 
   		CHECK (punishment_date > filing_date)
);

CREATE TABLE cases.sys_document 
(
    document_id bigserial PRIMARY KEY,
    case_number bigint NOT NULL REFERENCES  cases.sys_case (case_number),
	reference_number character varying(25) NOT NULL,
	document_date date NOT NULL,
	document_type_code character varying(10) NOT NULL REFERENCES  cases.document_type (document_type_code),
	file_path character varying(512)
);

CREATE TABLE cases.correspondent 
(
    correspondent_id bigserial PRIMARY KEY,
	first_name character varying(50) NOT NULL,
	surname character varying(50) NOT NULL,
	company_name  character varying(512),
	address_city character varying(50) NOT NULL,
	address_street character varying(50) NOT NULL,
	address_home_number character varying(50),
	address_postal_code character varying(10) NOT NULL,
	CONSTRAINT Unique_Correspondent UNIQUE (first_name, surname, company_name, address_city, address_street, address_home_number, address_postal_code)
);

CREATE TABLE cases.correspondence_outgoing 
(
    document_id bigserial PRIMARY KEY,
	createdby character varying(255) NOT NULL,
	creation_date date NOT NULL,
	delivery_date date,
	outgoing_correspondence_type_code character varying(5) NOT NULL REFERENCES  cases.outgoing_correspondence_type (outgoing_correspondence_type_code),
	correspondent_id bigint NOT NULL REFERENCES  cases.correspondent (correspondent_id)
	CONSTRAINT check_delivery_date 
   		CHECK (delivery_date  > creation_date)
);


CREATE TABLE cases.correspondence_incoming 
(
    document_id bigserial PRIMARY KEY,
	receipt_date date NOT NULL,
	incoming_correspondence_type_code character varying(5) NOT NULL REFERENCES  cases.incoming_correspondence_type (incoming_correspondence_type_code),
	correspondent_id bigint NOT NULL REFERENCES  cases.correspondent (correspondent_id)
);