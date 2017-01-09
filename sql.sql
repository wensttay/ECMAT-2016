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
	short_course_start_date TIMESTAMP,
	duration TEXT,
	title TEXT,
	description TEXT,
	professor TEXT,
	place TEXT,
	type TEXT,
	equipment_needed TEXT,
	url TEXT,
	PRIMARY KEY (id)
);


INSERT INTO short_course(max_enrollment, short_course_start_date, duration, title, type, url) 
VALUES
(30, '2016-08-25 07:00:', '4 Horas', 'INTRODUÇÃO AO LATEX', 'Minicurso', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgbUNJVmFOWTJsR1E/view?usp=sharing'),
(30, '2016-08-25 07:00:', '4 Horas', 'TRIGONOMETRIA', 'Minicurso', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgQU9aRjh3Z0xOLUk/view?usp=sharing'),
(30, '2016-08-25 07:00:', '4 Horas', 'AS COORDENADAS POLARES E ALGUMAS DE SUAS FUNÇÕES ESPECIAIS: REPRESENTAÇÕES GEOMÉTRICAS E ALGÉBRICAS', 'Minicurso', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgRFlqemlwOGZyeFE/view?usp=sharing'),
(30, '2016-08-25 07:00:', '4 Horas', 'DESMISTIFICANDO O USO DA CALCULADORA CIENTÍFICA', 'Minicurso', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgU1hQeWxkMW9SeWM/view?usp=sharing'),
(20, '2016-08-25 07:00:', '4 Horas', 'INTRODUÇÃO AO USO DO R', 'Minicurso', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgRmRVNTE0VDllc3c/view?usp=sharing'),
(30, '2016-08-25 07:00:', '4 Horas', 'CONSTRUÇÕES DAS FUNÇÕES TRIGONOMÉTRICAS COM O GEOGEBRA', 'Minicurso', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgRU96eUlnclc3clU/view?usp=sharing'),


(30, '2016-08-25 13:30:', '4 Horas', 'ENTRE CONJECTURAS E TEOREMAS - UM PASSEIO PELAS PRINCIPAIS TÉCNICAS DE DEMONSTRAÇÃO NA MATEMÁTICA', 'Minicurso', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgOTl0Y1piUE5XOWc/view?usp=sharing'),
(30, '2016-08-25 13:30:', '4 Horas', 'RECORRÊNCIAS LINEARES DE PRIMEIRA ORDEM: UM ESTUDO ATRAVÉS DA RESOLUÇÃO DE UM PROBLEMA CLÁSSICO', 'Minicurso', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgd1BoR2d6azkwWEE/view?usp=sharing'),
(30, '2016-08-25 13:30:', '4 Horas', 'UMA ABORDAGEM TEÓRICA SOBRE TESTES ESTATÍSTICOS NÃO PARAMÉTRICOS', 'Minicurso', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgSWQ1aENLTG14N0E/view?usp=sharing'),
(30, '2016-08-25 13:30:', '4 Horas', 'COMO ELABORAR UM ARTIGO CIENTÍFICO', 'Oficina', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgVXk1TzRvZ0tFbjQ/view?usp=sharing'),
(20, '2016-08-25 13:30:', '4 Horas', 'APLICAÇÃO DO ORIGAMI NO ENSINO DE GEOMETRIA: MODELAGEM DOS POLIEDROS DE PLATÃO DE FACES TRIANGULARESO', 'Oficina', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgcTViQkw5T25xdTQ/view?usp=sharing'),
(20, '2016-08-25 13:30:', '4 Horas', 'TRIGONOMETRIA NA CIRCUNFERÊNCIA E AS RAZÕES TRIGONOMÉTRICAS DE: SENO, COSSENO, TANGENTE, COTANGENTE, SECANTE E COSSECANTE', 'Laboratório de Matemática', 'Oficina', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgd0d1cnM5S2ZVRWM/view?usp=sharing')


(30, '2016-08-25 19:00:', '3 Horas', 'CONTAGEM DE ELEMENTOS DE UM CONJUNTO: DEFINIÇÃO FORMAL E O CUIDADO COM O INFINITO', 'Minicurso', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgcGFNZUsyRFd5bXM/view?usp=sharing'),
(30, '2016-08-25 19:00:', '3 Horas', 'O ENSINO DA MATEMÁTICA PARA ALUNOS COM DEFICIÊNCIA VISUAL: POSSIBILIDADES E DESAFIOS', 'Minicurso', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgZmdRVV9WSWxLWWs/view?usp=sharing'),
(30, '2016-08-25 19:00:', '3 Horas', 'INTRODUÇÃO AO LATEX', 'Minicurso', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgRDBDNFhISlE3YTA/view?usp=sharing'),
(30, '2016-08-25 19:00:', '3 Horas', 'CRITÉRIOS DE DIVISIBILIDADE PARA NÚMEROS PRIMOS MENORES QUE 100', 'Minicurso', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgQU1sUDMteFNoWEk/view?usp=sharing'),
(30, '2016-08-25 19:00:', '3 Horas', 'AS BARRAS DE NAPIER NA RESOLÇÃO DAS OPERAÇÕES DE MULTIPLICAÇÃO, DIVISÃO E RADICIAÇÃO: CONTEXTO HISTÓRICO, CONSTRUÇÃO E UTILIZAÇÃO', 'Minicurso', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgaU9IM2stdmdLZ00/view?usp=sharing'),
(30, '2016-08-25 19:00:', '3 Horas', 'APLICAÇÃO CLÁSSICA DA PROGRAMAÇÃO LINEAR: O PROBLEMA DE TRANSPORTE', 'Minicurso', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgb1R2QU9zb1NvV3M/view?usp=sharing'),
(30, '2016-08-25 19:00:', '3 Horas', 'COMO ELABORAR UM ARTIGO CIENTÍFICO: O PROBLEMA DE TRANSPORTE', 'Oficina', 'https://drive.google.com/file/d/0Bwx-SPHSFVqgVWJybWpKSG5ubFU/view?usp=sharing');


CREATE TABLE short_course_participant(

	short_course_id INT,
	participant_id INT,

	FOREIGN KEY(short_course_id) REFERENCES short_course(id),
	FOREIGN KEY(participant_id) REFERENCES participant(id),

	PRIMARY KEY (short_course_id, participant_id)
);


UPDATE short_course SET place = 'Laboratório 4 de Informática' WHERE title ~* 'Introdução ao Latex';
UPDATE short_course SET place = 'Sala 06' WHERE title ~* 'Trigonometria';
UPDATE short_course SET place = 'Sala 07' WHERE title ~* 'As coordenadas polares e algumas de suas funções especiais: representações geométricas e algébricas';
UPDATE short_course SET place = 'Laboratório 02 de Informática' WHERE title ~* 'Introdução ao uso do R';
UPDATE short_course SET place = 'Núcleo de artes' WHERE title ~* 'Aplicação do Origami no ensino de Geometria: modelagem dos poliedros de Platão de faces triangulares';
UPDATE short_course SET place = 'Sala 01' WHERE title ~* 'Contagem de elementos de um conjunto: definição formal e o cuidado com o infinito';
UPDATE short_course SET place = 'Sala 02' WHERE title ~* 'Recorrências Lineares de primeira ordem: um estudo através da resolução de um problema clássico';
UPDATE short_course SET place = 'Sala 05' WHERE title ~* 'Uma abordagem teórica sobre testes estatísticos não paramétricos';
UPDATE short_course SET place = 'Sala 06' WHERE title ~* 'Aplicação clássica da programação linear: o problema de transporte';
UPDATE short_course SET place = 'Sala 07' WHERE title ~* 'A importância das desigualdades das médias aritmética e geométrica e de cauchy-schuarz na resolução de alguns problemas de matemática.';
UPDATE short_course SET place = 'Sala 07' WHERE title ~* 'Como elaborar um artigo científico';
UPDATE short_course SET place = 'Sala 11' WHERE title ~* 'ENTRE CONJECTURAS E TEOREMAS - UM PASSEIO PELAS PRINCIPAIS TÉCNICAS DE DEMONSTRAÇÃO NA MATEMÁTICA';
UPDATE short_course SET place = 'Sala 12' WHERE title ~* 'O ENSINO DA MATEMÁTICA PARA ALUNOS COM DEFICIÊNCIA VISUAL: POSSIBILIDADES E DESAFIOS';
UPDATE short_course SET place = 'Sala 13' WHERE title ~* 'A ÁLGEBRA BABILÔNICA: UMA DISCUSSÃO A PARTIR DA ANÁLISE DA TÁBUA PLIMPTON 322';
UPDATE short_course SET place = 'Sala 14' WHERE title ~* 'CRITÉRIOS DE DIVISIBILIDADE PARA NÚMEROS PRIMOS MENORES QUE 100';
UPDATE short_course SET place = 'Sala 15' WHERE title ~* 'AS BARRAS DE NAPIER NA RESOLÇÃO DAS OPERAÇÕES DE MULTIPLICAÇÃO, DIVISÃO E RADICIAÇÃO: CONTEXTO HISTÓRICO, CONSTRUÇÃO E UTILIZAÇÃO';
UPDATE short_course SET place = 'Sala 17' WHERE title ~* 'Desmistificando o uso da Calculadora Científica';
UPDATE short_course SET place = 'Sala 18' WHERE title ~* 'COMO ELABORAR UM ARTIGO CIENTÍFICO: O PROBLEMA DE TRANSPORTE';
UPDATE short_course SET place = 'Sala 03' WHERE title ~* 'CONSTRUÇÕES DAS FUNÇÕES TRIGONOMÉTRICAS COM O GEOGEBRA';

