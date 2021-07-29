INSERT INTO cases.case_type (case_type_code, description)
VALUES ('PPR','Przekroczenie prędkosci'), ('NPR','Nieprawidłowe parkowanie'), ('PCZ','Przejazd na czerwonym świetle'),
('NPPRZ','Nieustąpienie pierwszeństwa przejazdu'), ('NPPIE', 'Nieustąpienie pierwszeństwa pieszemu'),
('KPW','Kierowanie pod wpływem alkoholu lub środka odurzającego'), ('NPO','Nieudzielenie pomocy ofiarom wypadku'),
('ST','Sprawa testowa');

INSERT INTO cases.case_status (case_status_code, description) 
VALUES ('PZ','Przyjęcie zapisu'), ('WTUS','W trakcie ustalania sprawcy'), ('US','Ustalono Sprawcę'), ('PDW','Przyznanie do winy'),
('WW','Wysłano wezwanie do stawienia się'), ('PS','Postępowanie sądowe'), ('WM','Wysłano mandat'), ('WN','Windykacja'), ('ZK','Zakończona');


INSERT INTO cases.outgoing_correspondence_type (outgoing_correspondence_type_code, description)
VALUES ('WDPW','Wezwanie do pisemnego wyjaśnienia'), ('WDSW','Wezwanie do stawienienia osobistego'), ('M','Mandat'), 
('WDZ','Wezwanie do zapłaty (ponaglenie)'), ('IPS','Informacja o przekazaniu sprawy do postępowania sądowego'),
('IZP','Informacja o zakończeniu postępowania');

INSERT INTO cases.incoming_correspondence_type (incoming_correspondence_type_code, description)
VALUES ('W','Wyjaśnienie'), ('WS','Wskazanie sprawcy'), ('OM','Odmowa mandatu'), ('O','Odwołanie'),  ('N','Niestandardowe');

INSERT INTO cases.document_type (document_type_code, description)
VALUES ('PW','pismo_wychodzące'), ('PP','pismo_przychodzące');

INSERT INTO cases.color (color_code, description)
VALUES ('ZI','zielony'), ('CZ','czerwony'), ('BR','brązowy'), ('PO','pomarańczowy'), ('BI','biały'), ('CZA','czarny'), ('ZO','żółty'), 
('NI','niebieski'), ('FI','fioletowy'), ('SR','srebrny'), ('SZ','szary');

INSERT INTO cases.brand_model (brand, model)
VALUES ('Fiat', '500'), ('Fiat', 'Panda'), ('Nissan', 'Quashqai'), ('Opel', 'Astra Hatchback'), 
('Nissan', 'Navara'), ('Fiat', 'Tipo'), ('Yamaha', 'MT');

