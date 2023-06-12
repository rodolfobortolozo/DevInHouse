/*Crie a tabela Produto com os campos

ID tipo numero
Descrição tipo texto com 50 caracters
Status tipo boolean (precisa utilizar como number(1))
Cadastro tipo data e hora
QuantidadeEmEstoque tipo número
‌

Efetuar inserção dos dados de 10 registros na tabela
*/

CREATE TABLE PRODUTO(
  id NUMBER(18),
  descricao VARCHAR2(50),
  status NUMBER(1),
  cadastro DATE,
  quantidadeEmEstoque NUMBER(18,3),
  
  PRIMARY KEY (id)
)
/
DECLARE
nStatus INTEGER;
nquantidade NUMBER;

BEGIN
  FOR i in 1..10
    LOOP
      nStatus := dbms_random.value(0,1);
      nquantidade := dbms_random.value(0,30);
      INSERT INTO PRODUTO VALUES(i,'PRODUTO - '||i, nStatus, SYSDATE, nquantidade);
    END LOOP;
END;
/
SELECT * FROM PRODUTO
/*
Crie a tabela ProdutoPreco com os campos
ID tipo numero
ID Produto tipo número e sendo FK da tabela Produto
Valor tipo decimal (aqui precisa ser number(10, 2))
Status tipo boolean (precisa utilizar como number(1))
Cadastro tipo data e hora
Efetuar inserção dos dados de 15 registros na tabela
*/

CREATE TABLE PRODUTOPRECO(
  id NUMBER(18),
  idProduto NUMBER(18),
  valor NUMBER(18,3),
  status NUMBER(1),
  
  PRIMARY KEY (id),
  FOREIGN KEY (idProduto) REFERENCES PRODUTO (ID)
)
/
DECLARE
nProduto INTEGER;
nValor NUMBER;
nStatus INTEGER;

BEGIN
  FOR i in 1..15
    LOOP
      nStatus := dbms_random.value(0,1);
      nProduto:= dbms_random.value(1,10);
      nValor := dbms_random.value(50,1000);
      INSERT INTO PRODUTOPRECO VALUES(i, nProduto, nValor, nStatus);
    END LOOP;
END;
/
SELECT * FROM PRODUTOPRECO
/
SELECT PR.ID idProduto, PP.ID idPreco, PR.DESCRICAO, PP.Valor, TO_CHAR(PR.Cadastro,'MM/YYYY') dtaCadsatro 
FROM PRODUTO PR
  INNER JOIN PRODUTOPRECO PP
    ON PP.IDPRODUTO = PR.ID;
    
SELECT PR.ID idProduto, PR.DESCRICAO, 
       CASE 
          WHEN SUM(PP.Valor) <150 THEN
            'Soma do produto menor 150.00'
          WHEN SUM(PP.Valor) >=150 OR SUM(PP.Valor) <= 500 THEN
            'Soma do produto está entre 150 e 500'
       ELSE
         'Soma dos produtos está acima de 500,00'
       END Descricao,         
       TO_CHAR(PR.Cadastro,'MM/YYYY') dtaCadsatro 
FROM PRODUTO PR
  INNER JOIN PRODUTOPRECO PP
    ON PP.IDPRODUTO = PR.ID
GROUP BY PR.ID, PR.DESCRICAO,PR.Cadastro;


SELECT PR.ID idProduto, PP.ID idPreco, PR.DESCRICAO, PP.Valor, TO_CHAR(PR.Cadastro,'MM/YYYY') dtaCadsatro 
FROM PRODUTO PR
  LEFT JOIN PRODUTOPRECO PP
    ON PP.IDPRODUTO = PR.ID
WHERE PP.Id IS NULL;

BEGIN
  FOR i IN 1..3
    LOOP
      UPDATE PRODUTOPRECO SET Valor = Valor *0.15 WHERE valor>100 AND idProduto = i;
    END LOOP;
END;


SELECT PR.id, PR.descricao, DECODE(PR.status,0,'Inativo','Ativo') status, PR.cadastro, PR.QuantidadeEmEstoque 
FROM PRODUTO PR
