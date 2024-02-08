ALTER TABLE obra ADD CONSTRAINT unique_nome_oficial UNIQUE (nome_oficial);

ALTER TABLE arquiteto ADD CONSTRAINT unique_nome_sobrenome UNIQUE (nome, sobrenome);

ALTER TABLE construtora ADD CONSTRAINT unique_nome UNIQUE (nome);

ALTER TABLE usuario ADD CONSTRAINT unique_login UNIQUE (login);

ALTER TABLE usuario ADD CONSTRAINT unique_email UNIQUE (email);

ALTER TABLE usuario ADD CONSTRAINT unique_numero_usp UNIQUE (numero_usp);