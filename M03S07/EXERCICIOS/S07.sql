/*
Crie um Cursor utilizando um loop que faça um UPDATE na tabela Produto mudando a coluna Status = 0 dos registros 1, 2 e 3;
*/
DECLARE
CURSOR cProduto is SELECT * FROM PRODUTO FOR UPDATE OF ID;

BEGIN
  --OPEN cProduto;
  FOR i in cProduto LOOP
    UPDATE PRODUTO SET STATUS = 0 WHERE CURRENT OF cProduto;
    --COMMIT;
  END LOOP;
END LOOP;

/

/*
Crie um Cursor que imprima na tela os dados Id, Status e Preco, utilizando FORALL para listar e IF e Else para verificar se o status do produto está ativo e se o preço está menor que 1000,00.
*/
  
DECLARE
CURSOR cProduto is SELECT ID, STATUS, QUANTIDADEEMESTOQUE FROM PRODUTO;
nID NUMBER;
nSTATUS NUMBER;
nQUANTIDADEEMESTOQUE NUMBER(18,3);

BEGIN
  OPEN cProduto;
  LOOP
    FETCH cProduto INTO nID, nSTATUS, nQUANTIDADEEMESTOQUE;
    EXIT WHEN cProduto%NOTFOUND;
      IF( nQUANTIDADEEMESTOQUE<1000 and nSTATUS=1) THEN
        DBMS_OUTPUT.put_line(nID||' - '||nSTATUS||' - '||nQUANTIDADEEMESTOQUE);
      END IF;
  END LOOP;
  CLOSE cProduto;
END;

/*
Criar uma Procedure que imprimi todos os dados da tabela Produto utilizando o Cursor
*/

CREATE PROCEDURE IMPRIMI_PRODUTO AS 
BEGIN
  DECLARE
CURSOR cProduto is SELECT ID, STATUS, QUANTIDADEEMESTOQUE FROM PRODUTO;
nID NUMBER;
nSTATUS NUMBER;
nQUANTIDADEEMESTOQUE NUMBER(18,3);

BEGIN
  OPEN cProduto;
  LOOP
    FETCH cProduto INTO nID, nSTATUS, nQUANTIDADEEMESTOQUE;
    EXIT WHEN cProduto%NOTFOUND;
      IF( nQUANTIDADEEMESTOQUE<1000 and nSTATUS=1) THEN
        DBMS_OUTPUT.put_line(nID||' - '||nSTATUS||' - '||nQUANTIDADEEMESTOQUE);
      END IF;
  END LOOP;
  CLOSE cProduto;
END;
END;

BEGIN
  IMPRIMI_PRODUTO;
END;

/*
Na Procedure ExibirTodosProdutos colocar a exception NO_DATA_FOUD e imprimir a mensagem com Erro, dados não encontrados
*/

CREATE PROCEDURE EXIBITODOSPRODUTOS AS
BEGIN
  DECLARE
    CURSOR cProduto is SELECT * FROM PRODUTO WHERE ;
END;



END;

///








DECLARE
  CURSOR cProduto is SELECT ID FROM PRODUTO;
  CURSOR cProdPreco is SELECT IDPRODUTO, VALOR FROM PRODUTOPRECO;
  nID NUMBER(18);
  nIDPROD NUMBER(18);
  nVALOR NUMBER(18,3):=0;
  nTOTAL NUMBER(18,3):=0;
  
BEGIN
  OPEN cProduto;
  LOOP
    FETCH cProduto INTO nID;
      EXIT WHEN cProduto%NOTFOUND;
      OPEN cProdPreco;
      nTOTAL := 0;
      LOOP
        
         FETCH cProdPreco INTO nIDPROD, nVALOR;
         EXIT WHEN cProdPreco%NOTFOUND;
         
         IF(nIDPROD = nID) THEN
           nTOTAL := nTOTAL + nVALOR;
         END IF;
      END LOOP;
      
      DBMS_OUTPUT.put_line('PRODUTO '||nID||' - '||nTOTAL);
      CLOSE cProdPreco;
  END LOOP;
  CLOSE cProduto;
END;    
/

select idproduto, sum(valor) from PRODUTOPRECO
group by idproduto
