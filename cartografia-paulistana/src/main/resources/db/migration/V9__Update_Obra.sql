ALTER TABLE obra MODIFY COLUMN latitude VARCHAR(128) NOT NULL;

ALTER TABLE obra MODIFY COLUMN longitude VARCHAR(128) NOT NULL;

ALTER TABLE obra MODIFY COLUMN nome_oficial VARCHAR(256) NOT NULL;

ALTER TABLE obra MODIFY COLUMN uso_original VARCHAR(128) NOT NULL;

ALTER TABLE obra MODIFY COLUMN uso_atual VARCHAR(128);

ALTER TABLE obra CHANGE COLUMN condicao status VARCHAR(128);

ALTER TABLE obra DROP COLUMN ano_demolicao;

ALTER TABLE obra DROP COLUMN ano_reforma;


