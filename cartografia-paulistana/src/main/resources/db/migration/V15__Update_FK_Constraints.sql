ALTER TABLE obra DROP FOREIGN KEY obra_construtora_fk;
ALTER TABLE obra ADD CONSTRAINT obra_construtora_fk FOREIGN KEY (construtora_id) REFERENCES construtora(id) ON DELETE SET NULL;

ALTER TABLE referencia DROP FOREIGN KEY referencia_ibfk_1;
AlTER TABLE referencia ADD CONSTRAINT referencia_obra_fk FOREIGN KEY (obra_id) REFERENCES obra(id) ON DELETE CASCADE;