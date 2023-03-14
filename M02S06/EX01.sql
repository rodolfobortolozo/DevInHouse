CREATE TABLE TABELAPRECO(
  idTabelPreco  NUMBER(8),
  descricao VARCHAR2(100),
  VlrLocacao NUMBER(8,2),
  
  PRIMARY KEY(idTabelPreco)
)
/
CREATE TABLE FILME(
  idFilme NUMBER(8),
  titulo VARCHAR2(100),
  classificacao NUMBER(8),
  idTabelPreco  NUMBER(8),
  
  PRIMARY KEY (idFilme),
  FOREIGN KEY (idFilme) REFERENCES TABELAPRECO (idTabelPreco)
)
/
CREATE TABLE CATEGORIA(
  idCategoria NUMBER(8),
  descricao VARCHAR2(100),
  
  PRIMARY KEY(idCategoria)
)
/
CREATE TABLE FILMECATEGORIA(
  idFilme NUMBER(8),
  idCategoria NUMBER(8),
  
  PRIMARY KEY(idFilme, idCategoria),
  FOREIGN KEY (idFilme) REFERENCES FILME (idFilme),
  FOREIGN KEY (idCategoria) REFERENCES CATEGORIA (idCategoria)
)
/
CREATE TABLE ATOR(
  idAtor NUMBER(8),
  nome VARCHAR2(1000),
  dtaNacto DATE,
  
  PRIMARY KEY (idAtor)
)
/
CREATE TABLE ELENCO(
  idElenco NUMBER(8),
  idFilme NUMBER(8),
  idAtor NUMBER(8),
  nomePersonagem VARCHAR2(1000),

  PRIMARY KEY(idElenco),
  FOREIGN KEY (idAtor) REFERENCES ATOR (idAtor),
  FOREIGN KEY (idFilme) REFERENCES FILME (idFilme)
)
/
CREATE TABLE CLIENTE(
  idCliente NUMBER(8),
  nome VARCHAR2(1000),
  sobrenome VARCHAR2(1000),
  telefone VARCHAR2(15),
  logradouro VARCHAR2(1000),
  nroLogradouro VARCHAR2(10),
  complemento VARCHAR(100),
  bairro VARCHAR(200),
  cidade VARCHAR(100),
  uf char(2),
  
  PRIMARY KEY(idCliente)
)
/
CREATE TABLE LOCACAO(
  idLocacao NUMBER(8),
  idCliente NUMBER(8),
  idFilme NUMBER(8),
  dtaLocacao DATE,
  dtaDevolucao DATE,
  
  PRIMARY KEY(idLocacao),
  FOREIGN KEY (idCliente) REFERENCES CLIENTE (idCliente),
  FOREIGN KEY (idFilme) REFERENCES FILME (idFilme)
)

/*
DROP TABLE LOCACAO;
DROP TABLE TABELAPRECO;
DROP TABLE FILMECATEGORIA;
DROP TABLE ELENCO;
DROP TABLE ATOR;
DROP TABLE CLIENTE;
DROP TABLE FILME;
DROP TABLE CATEGORIA;
*/
