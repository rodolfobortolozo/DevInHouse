CREATE TABLE CLIENTES(
  ID NUMBER GENERATED ALWAYS AS IDENTITY,
  NOME VARCHAR2(200),
  LOGRADOURO VARCHAR2(200),
  NROLOGRADOURO VARCHAR2(10),
  BAIRRO VARCHAR2(100),
  COMPLEMENTO VARCHAR2(100),
  CIDADE VARCHAR2(100),
  UF CHAR(2),
  ATIVO NUMBER(1) DEFAULT 1,
  DTACREATED TIMESTAMP,
  DTAUPDATE TIMESTAMP,

  PRIMARY KEY(ID)
);

ALTER TABLE CLIENTES ADD CHECK (ATIVO IN (0, 1));
