insert into address (id, address_line1, address_line2, city, postal_code)
            values (901, 'xx', 'yy', 'city', '60-400');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (902, 'xxx', 'yyy', 'city', '62-400');

insert into doctor (id, address_id, doctor_number, email, first_name, last_name, telephone_number, specialization)
            values ( 1, 901, '123','test@mail.com','Jan','Kowalski','+48 123 345 567','SURGEON');

insert into patient ( id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
            values ( 1, 'Piotr', 'Kowalski', '+48 987 765 543', 'mail@test.com', '1', '1999-01-01', 902);

insert into visit (id, description, time, patient_id, doctor_id)
            values (234, 'opis', '2025-03-13T17:10:10', 1, 1);

insert into medical_treatment (id, description, type, visit_id)
            values (567, 'opis', 'EKG', 234);