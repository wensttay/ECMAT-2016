﻿CREATE TABLE payment (

	date TIMESTAMP, 
	last_event_date TIMESTAMP,
	code TEXT, 
	reference VARCHAR(10),
	status VARCHAR(1),
	url TEXT,
	PRIMARY KEY(reference)
);

CREATE TABLE participant (

	id SERIAL, 
	payment_id VARCHAR(10) DEFAULT NULL,
	name TEXT, 
	birth_date DATE,
 	phone_ddd VARCHAR(2),
   	phone_number VARCHAR(12), 
   	titration VARCHAR(14), 
   	cpf VARCHAR(14) UNIQUE,
    email TEXT UNIQUE, 
    password TEXT, 
    country VARCHAR(3), 
    state TEXT, city TEXT, 
    district TEXT, 
    postal_code VARCHAR(10), 
    street TEXT, 
    house_number VARCHAR(5),
    PRIMARY KEY(id),
    FOREIGN KEY(payment_id) REFERENCES payment(reference)
);

CREATE TABLE password_reset_request(

	id SERIAL,
	token TEXT,
	is_valid BOOLEAN DEFAULT TRUE,
	creation_date TIMESTAMP,
	participant_email TEXT,
	PRIMARY KEY(id)
);	