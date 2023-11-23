ALTER TABLE obra
ADD COLUMN endereco_id INT,
ADD CONSTRAINT fk_obra_endereco
    FOREIGN KEY (endereco_id)
    REFERENCES endereco(id);
    
ALTER TABLE endereco
DROP COLUMN obra_id,
DROP CONSTRAINT endereco_ibfk_1;
