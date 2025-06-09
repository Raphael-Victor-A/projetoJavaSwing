CREATE TABLE usuario (
    nomeUsuario VARCHAR(255) PRIMARY KEY,
    senha INT NOT NULL
);

CREATE TABLE filmes (
    idFilme SERIAL PRIMARY KEY,
    nomeFilme VARCHAR(255) NOT NULL,
    anoPublicacao INT,
    autor VARCHAR(255),
    genero VARCHAR(255),
    idioma VARCHAR(255),
    duracaoMinutos INT
);

CREATE TABLE filmesAvaliados (
    idAvaliacao SERIAL PRIMARY KEY,
    idFilme INT NOT NULL,
    nomeUsuario VARCHAR(255) NOT NULL,
    nota INT,
    comentarios TEXT,
    FOREIGN KEY (idFilme) REFERENCES filmes (idFilme),
    FOREIGN KEY (nomeUsuario) REFERENCES usuario (nomeUsuario)
);

INSERT INTO usuario (nomeUsuario, senha) VALUES ('admin', 12345);
select * from usuario

