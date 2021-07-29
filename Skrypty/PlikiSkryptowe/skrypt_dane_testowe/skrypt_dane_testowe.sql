INSERT INTO cases.vehicle (vin, registration_number, dmc, brand, model, color_code)
VALUES ('TESTTESTTESTTEST1', 'ABC 1234', '3500 kg', 'Nissan', 'Quashqai', 'ZI'), 
('TESTTESTTESTTEST2','DEF 4567', '1655 kg', 'Fiat', 'Tipo', 'CZ'),
('TESTTESTTESTTEST3', 'SBI 1234', '2065 kg', 'Opel','Astra Hatchback', 'SR');

INSERT INTO cases.sys_case (filing_date, punishment_date, case_type_code, case_status_code, vehicle_id)
VALUES ('06.05.2021', '22.05.2021', 'PPR', 'ZK', 1), ('10.05.2021', NULL , 'PCZ', 'WM', 2),
('01.06.2021',NULL, 'NPPRZ', 'PDW', 3), ('13.06.2021', NULL , 'KPW', 'WTUS', NULL);

INSERT INTO cases.sys_document (case_number, reference_number, document_date, document_type_code, file_path)
VALUES (1, 'ABC-A.123.77.3.2021.JW.', '06.05.2021', 'PW' , NULL), 
(2, 'AF000P00.382.12.2.2021', '10.05.2021', 'PW' , 'C:\TEST'),
(3, 'AB123P00.111.22.3.2021', '01.06.2021', 'PP' , NULL),
(4, 'ABCDEFGH.462.12.2.2021', '13.06.2021', 'PP' , 'C:\TEST2');

INSERT INTO cases.correspondent (first_name, surname, company_name , address_city, address_street, address_home_number, address_postal_code)
VALUES ('Andrzej', 'Kowalski', 'Firma testowa', 'miasto1', 'ulica1', '6', '12-345'),
('Janusz', 'Nowak', 'Firma testowa2', 'miasto2', 'ulica2', '12', '23-456'),
('Maria', 'Wiśniewska', 'Firma testowa3', 'miasto3', 'ulica3', '2', '34-567');

INSERT INTO cases.correspondence_outgoing (document_id, createdby, creation_date , delivery_date, outgoing_correspondence_type_code, correspondent_id)
VALUES (1,'test.test', '07.05.2021','17.05.2021', 'WDZ', 1),
(2,'test.test', '10.05.2021','19.05.2021', 'M', 2);

INSERT INTO cases.correspondence_incoming (document_id, receipt_date, incoming_correspondence_type_code, correspondent_id)
VALUES (3, '08.06.2021', 'W', 2),
(4, '20.06.2021', 'O', 3);

