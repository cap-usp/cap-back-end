CREATE TABLE IF NOT EXISTS referencia(
	id INT AUTO_INCREMENT,
	url VARCHAR(1024) NOT NULL,
    obra_id INT NOT NULL,
	PRIMARY KEY(id),
    FOREIGN KEY (obra_id) REFERENCES obra(id)
);

ALTER TABLE obra
DROP COLUMN referencias;