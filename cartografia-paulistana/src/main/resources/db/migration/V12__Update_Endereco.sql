ALTER TABLE endereco MODIFY COLUMN municipio VARCHAR(256) NOT NULL;

ALTER TABLE endereco ADD COLUMN complemento VARCHAR(256);

ALTER TABLE endereco ADD COLUMN cep VARCHAR(8) NOT NULL;

ALTER TABLE endereco DROP COLUMN distrito;