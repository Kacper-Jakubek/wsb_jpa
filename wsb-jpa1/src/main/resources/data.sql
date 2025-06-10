insert into address (id, address_line1, address_line2, city, postal_code)
            values (901, 'xx', 'yy', 'city', '60-400');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (902, 'xxx', 'yyy', 'city', '62-400');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (903, 'xxxx', 'yyyy', 'city', '63-400');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (904, 'xxxxx', 'yyyyy', 'city', '64-400');

insert into doctor (id, address_id, doctor_number, email, first_name, last_name, telephone_number, specialization)
            values ( 901, 901, '123','test@mail.com','Jan','Kowalski','+48 123 345 567','SURGEON');

insert into patient ( id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, married, registration_date)
            values ( 901, 'Piotr', 'Kowalski', '+48 987 765 543', 'mail@test.com', '1', '1999-01-01', 902, true, '2025-06-01');

insert into patient ( id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, married, registration_date)
            values ( 902, 'Adam', 'Kowalski', '+48 987 765 542', 'mail2@test.com', '2', '1999-01-01', 903, true, '2025-05-01');

insert into patient ( id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, married, registration_date)
            values ( 903, 'Adam', 'Nowak', '+48 987 765 541', 'mail3@test.com', '3', '1999-01-01', 904, true, '2025-04-01');

insert into visit (id, description, time, patient_id, doctor_id)
            values (234, 'opis', '2025-03-13T17:10:10', 901, 901);

insert into visit (id, description, time, patient_id, doctor_id)
            values (235, 'opis', '2025-03-14T17:10:10', 902, 901);

insert into visit (id, description, time, patient_id, doctor_id)
            values (236, 'opis', '2025-03-15T17:10:10', 902, 901);

insert into visit (id, description, time, patient_id, doctor_id)
            values (237, 'opis', '2025-03-16T17:10:10', 902, 901);

insert into medical_treatment (id, description, type, visit_id)
            values (567, 'opis', 'EKG', 234);