ALTER TABLE endereco MODIFY COLUMN logradouro VARCHAR(256) NOT NULL;

ALTER TABLE endereco ADD COLUMN endereco_tipo VARCHAR(32) NOT NULL;

ALTER TABLE endereco ADD COLUMN endereco_titulo VARCHAR(32);

ALTER TABLE endereco DROP COLUMN bairro;

ALTER TABLE endereco DROP COLUMN complemento;

ALTER TABLE endereco DROP COLUMN estado;

ALTER TABLE endereco DROP COLUMN pais;

ALTER TABLE endereco DROP COLUMN cep;
