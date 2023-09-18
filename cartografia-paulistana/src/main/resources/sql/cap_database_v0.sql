
CREATE TABLE IF NOT EXISTS ARQUITETO(
	id INT AUTO_INCREMENT,
	nome VARCHAR(25) NOT NULL,
    nome_meio VARCHAR(25),
    sobrenome VARCHAR(30),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS CONSTRUTORA(
	id INT AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS OBRA(
	id INT AUTO_INCREMENT,
	latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL,
    construtora_id INT NOT NULL,
    nome_oficial VARCHAR(80) NOT NULL,
    ano_projeto INT,
    ano_construcao INT,
    condephaat INT,
    conpresp INT,
    iphan INT,
    uso_original VARCHAR(30) NOT NULL,
    codigo_original VARCHAR(30) NOT NULL,
    uso_atual VARCHAR(30),
    codigo_atual VARCHAR(30),
    condicao VARCHAR(30),
    ano_demolicao INT,
    ano_reforma INT,
    referencias VARCHAR(1024) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (construtora_id) REFERENCES CONSTRUTORA(id)
);

CREATE TABLE IF NOT EXISTS ARQUITETO_OBRA(
	id INT AUTO_INCREMENT,
	arquiteto_id INT,
    obra_id INT,
    FOREIGN KEY (arquiteto_id) REFERENCES ARQUITETO(id),
    FOREIGN KEY (obra_id) REFERENCES OBRA(id),
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS ENDERECO(
	id INT AUTO_INCREMENT,
    obra_id INT NOT NULL,
    cep VARCHAR(8) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    numero INT NOT NULL,
    complemento VARCHAR(50),
    bairro VARCHAR(50) NOT NULL,
    distrito VARCHAR (50) NOT NULL,
    municipio VARCHAR (50) NOT NULL,
    estado VARCHAR (50) NOT NULL,
    pais VARCHAR (50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (obra_id) REFERENCES OBRA(id)
);