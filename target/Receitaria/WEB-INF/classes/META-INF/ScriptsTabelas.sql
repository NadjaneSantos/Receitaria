-- Scripts para criacao das tabelas usuario, receita, ingrediente e profissional --

CREATE TABLE usuario (
   email VARCHAR(50) NOT NULL,
   nome VARCHAR(100) NOT NULL,
   senha VARCHAR(10) NOT NULL,
   PRIMARY KEY (EMAIL)
);

CREATE TABLE receita (
   id INTEGER IDENTITY PRIMARY KEY,
   titulo VARCHAR(100) NOT NULL,
   categoria VARCHAR(20) NOT NULL,
   modoPreparo VARCHAR(255) NOT NULL
);

CREATE TABLE ingrediente(
	id INTEGER IDENTITY PRIMARY KEY,
	quantidade VARCHAR(10) NOT NULL,
	medida VARCHAR(20) NOT NULL,
	nome VARCHAR(50) NOT NULL,
	id_receita INTEGER NOT NULL
);

CREATE TABLE profissional(
	id INTEGER IDENTITY PRIMARY KEY,
	nome VARCHAR(20) NOT NULL,
	matricula VARCHAR(20) NOT NULL,
	id_receita INTEGER NOT NULL
);

ALTER TABLE profissional
ADD FOREIGN KEY (id_receita) 
REFERENCES receita(id);

ALTER TABLE ingrediente
ADD FOREIGN KEY (id_receita) 
REFERENCES receita(id);
