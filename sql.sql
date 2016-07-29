CREATE TABLE payment (

	date TIMESTAMP, 
	last_event_date TIMESTAMP,
	code TEXT, 
	reference VARCHAR(28),
	status VARCHAR(1),
	url TEXT,
	PRIMARY KEY(reference)
);

CREATE TABLE participant (

	id SERIAL, 
	payment_id VARCHAR(28) DEFAULT NULL,
	name TEXT,  
	birth_date DATE,
	phone_ddd VARCHAR(2),
	phone_number VARCHAR(12), 
	titration VARCHAR(14), 
	cpf VARCHAR(14) UNIQUE,
	email TEXT UNIQUE, 
	password TEXT, 
	country VARCHAR(3), 
	state VARCHAR(2), 
	city VARCHAR(50), 
	district VARCHAR(50), 
	postal_code VARCHAR(8), 
	street VARCHAR(50), 
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

CREATE TABLE payment_log (
	
	id SERIAL,
	occurrence_date TIMESTAMP,
	occurrence TEXT, 
	stack_trace TEXT, 
	notification_code TEXT,
	PRIMARY KEY(id)
);

CREATE TABLE participant_recover(

	token TEXT,
	is_valid BOOLEAN DEFAULT TRUE,
	participant_email TEXT UNIQUE,
	PRIMARY KEY (token)
);

CREATE TABLE short_course(

	id SERIAL,
	max_enrollment INT,
	short_course_date TIMESTAMP,
	title TEXT,
	professor TEXT,
	PRIMARY KEY (id)
);

CREATE TABLE short_course_participant(

	short_course_id INT,
	participant_id INT,

	FOREIGN KEY(short_course_id) REFERENCES short_course(id),
	FOREIGN KEY(participant_id) REFERENCES participant(id),

	PRIMARY KEY (short_course_id, participant_id)
);