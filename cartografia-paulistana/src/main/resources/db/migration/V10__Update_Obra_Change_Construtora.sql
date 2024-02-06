ALTER TABLE obra DROP FOREIGN KEY obra_ibfk_1;

ALTER TABLE obra MODIFY COLUMN construtora_id INT;

ALTER TABLE obra
ADD CONSTRAINT obra_construtora_fk
FOREIGN KEY (construtora_id)
REFERENCES construtora(id);


