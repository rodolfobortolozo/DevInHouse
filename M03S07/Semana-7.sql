--AULA 1 CURSORES
DELETE FROM Produto;
DELETE FROM Orcamento;

INSERT INTO Produto(Id, Descricao, Valor, Cadastro) VALUES (1, 'PRODUTO A', 17.80, TO_DATE('2022-06-04', 'YYYY-MM-DD'));
INSERT INTO Produto(Id, Descricao, Valor, Cadastro) VALUES (2, 'PRODUTO B', 27.80, TO_DATE('2021-07-04', 'YYYY-MM-DD'));
INSERT INTO Produto(Id, Descricao, Valor, Cadastro) VALUES (3, 'PRODUTO C', 79.80, TO_DATE('2021-05-04', 'YYYY-MM-DD'));
INSERT INTO Produto(Id, Descricao, Valor, Cadastro) VALUES (4, 'PRODUTO D', 7.80, TO_DATE('2023-05-04', 'YYYY-MM-DD'));
INSERT INTO Produto(Id, Descricao, Valor, Cadastro) VALUES (5, 'PRODUTO E', 15.75, TO_DATE('2020-05-05', 'YYYY-MM-DD'));
INSERT INTO Produto(Id, Descricao, Valor, Cadastro) VALUES (6, 'PRODUTO F', 12.30, TO_DATE('2022-11-06', 'YYYY-MM-DD'));
INSERT INTO Produto(Id, Descricao, Valor, Cadastro) VALUES (7, 'PRODUTO G', 8.99, TO_DATE('2023-05-07', 'YYYY-MM-DD'));
INSERT INTO Produto(Id, Descricao, Valor, Cadastro) VALUES (8, 'PRODUTO H', 11.50, TO_DATE('2023-05-08', 'YYYY-MM-DD'));
INSERT INTO Produto(Id, Descricao, Valor, Cadastro) VALUES (9, 'PRODUTO I', 6.25, TO_DATE('2023-11-09', 'YYYY-MM-DD'));
INSERT INTO Produto(Id, Descricao, Valor, Cadastro) VALUES (10, 'PRODUTO J', 14.99, TO_DATE('2023-06-10', 'YYYY-MM-DD'));

--Inserir dinamicamente na tabela orcamento
BEGIN
  FOR i IN 1..50000 LOOP
    INSERT INTO Orcamento(Id, IdProduto, ValorVenda, Quantidade)
    VALUES(i, ROUND(DBMS_RANDOM.VALUE(1, 10)), ROUND(DBMS_RANDOM.VALUE(1000, 10000), 2), ROUND(DBMS_RANDOM.VALUE(1, 100)));
  END LOOP;
  
  COMMIT;
END;


-- Query entre Produto e Orcamento
SELECT * FROM Produto INNER JOIN Orcamento ON Produto.Id = Orcamento.IdProduto;


--Exemplo Um para Cursor

DECLARE 
    v_ano NUMBER := 2020;
    CURSOR cursor_quantidade_produto IS SELECT Cadastro, Valor FROM Produto WHERE EXTRACT(YEAR FROM Cadastro) = v_ano;
    v_soma_produtos NUMBER(12, 2) := 0.00;
    v_cadastro DATE;
    v_valor DECIMAL(12, 2) := 0.00;
BEGIN
    OPEN cursor_quantidade_produto;
        LOOP
            FETCH cursor_quantidade_produto INTO v_cadastro, v_valor;
                EXIT WHEN cursor_quantidade_produto%NOTFOUND;
                    v_soma_produtos := v_soma_produtos + v_valor;
        END LOOP;
    CLOSE cursor_quantidade_produto;
    
    DBMS_OUTPUT.PUT_LINE('Ano selecionado ' || v_ano);
    DBMS_OUTPUT.PUT_LINE('Soma Total Dos Produtos ' || v_soma_produtos);
END;

-- Examplo 2 Cursor
-- Bloco 1
DECLARE
    CURSOR cursor_produto  IS SELECT Id, Valor FROM Produto;
    v_id NUMBER;
    v_valor_produto NUMBER(10, 2);
    v_idprodutoOrcamento NUMBER;
    v_valor_orcamento NUMBER (12, 2);
BEGIN
    OPEN cursor_produto;
        LOOP
            FETCH cursor_produto INTO v_id, v_valor_produto;
                EXIT WHEN cursor_produto%NOTFOUND;
                
                SELECT SUM(ValorVenda) INTO v_valor_orcamento FROM Orcamento WHERE IdProduto = v_id;
                DBMS_OUTPUT.PUT_LINE('Id Produto : '  || v_id  || ' Soma do valor orcamento ' ||  v_valor_orcamento);
        END LOOP; 
    CLOSE cursor_produto;
END;


-- Bloco 2 Para validar
SELECT SUM(ValorVenda),  COUNT(*) FROM Orcamento WHERE IdProduto = 10;


-- Example Criado pelo Rodolfo

DECLARE
    CURSOR cProduto is SELECT ID FROM PRODUTO;
    CURSOR cProdPreco is SELECT IDPRODUTO, VALORVENDA FROM ORCAMENTO;
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

                DBMS_OUTPUT.put_line('PRODUTO ' || nID || ' - ' || nTOTAL);
            CLOSE cProdPreco;
        END LOOP;
    CLOSE cProduto;
END;

-- Aula 2

-- EXCEPTION Example UM

DECLARE 
    vDivisor NUMBER := 0;
    vResultado NUMBER := 0;
    vValor VARCHAR2(100) := 'teste';

BEGIN
    vResultado := to_number(vValor) / vdivisor;

EXCEPTION
    WHEN ZERO_DIVIDE THEN
        DBMS_OUTPUT.PUT_LINE('Erro: Divisão por zero.'); 
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erro: NÃO SEI O O QUE É'); 
        DBMS_OUTPUT.PUT_LINE('Erro: Nr do Erro gerado' || SQLCODE);
        DBMS_OUTPUT.PUT_LINE('Mensagem Oracle: ' || SQLERRM);
END;

-- Exception Customizada

DECLARE 
    vContador NUMBER := 0;
    vMinhaException EXCEPTION;

    PRAGMA EXCEPTION_INIT(vMinhaException, -29055);
    
BEGIN
    SELECT COUNT(*) INTO vContador FROM Produto;
    
    IF vContador = 10 THEN
        RAISE vMinhaException;
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('Contador Total de Produtos ' || vContador); 

EXCEPTION
    WHEN vMinhaException THEN
        DBMS_OUTPUT.PUT_LINE('Erro Customizado: Contador não pode ser igual a 10'); 
        DBMS_OUTPUT.PUT_LINE('Erro: Nr do Erro gerado' || SQLCODE);
        DBMS_OUTPUT.PUT_LINE('Mensagem Oracle: ' || SQLERRM);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erro: Nr do Erro gerado' || SQLCODE);
        DBMS_OUTPUT.PUT_LINE('Mensagem Oracle: ' || SQLERRM);
END;

-- Aula 3 
-- Exemplo 01 Procedure

CREATE OR REPLACE PROCEDURE Exemplo
IS
   vContador NUMBER := 0;
BEGIN
    SELECT COUNT(*) INTO vContador FROM Produto;
    
    DBMS_OUTPUT.PUT_LINE('Contador ' || vContador); 
END;

-- Exemplo 2 recebendo IN dos parametros

--Criar uma procedure de update de produtos e devolver o valor antigo
--pNomeVariavel = Parametro da Procedure
--nNomeVarivel Number 
--vNomeVariavel VARCHAR
-- Pegando o tipo da coluna conforme a estrutura Tabela.Coluna%Type
    -- Exemplo   Produto.Valor%Type igual a delcaração do tipo  NUMBER
CREATE OR REPLACE PROCEDURE AtualizarPrecoProduto(pIdProduto IN VARCHAR, pValorProduto IN Produto.Valor%Type) IS
BEGIN
    UPDATE Produto SET Valor = pValorProduto WHERE Id = TO_NUMBER(pIdProduto);
END;


-- Exemplo 3

--Criar uma procedure de update de produtos e devolver o valor antigo
--pNomeVariavel = Parametro da Procedure
--nNomeVarivel Number 
--vNomeVariavel VARCHAR
-- Pegando o tipo da coluna conforme a estrutura Tabela.Coluna%Type
    -- Exemplo   Produto.Valor%Type igual a delcaração do tipo  NUMBER
CREATE OR REPLACE PROCEDURE AtualizarPrecoProduto(pIdProduto IN Produto.Valor%Type, pValorProduto IN Produto.Valor%Type) IS
BEGIN
    UPDATE Produto SET Valor = pValorProduto WHERE Id = pIdProduto;
END;


-- Formato de execuções 
-- Exemplo 1
DECLARE
  PIDPRODUTO NUMBER;
  PVALORPRODUTO NUMBER(12, 2);
BEGIN
  PIDPRODUTO := 1;
  PVALORPRODUTO := 30.99;

  ATUALIZARPRECOPRODUTO(PIDPRODUTO, PVALORPRODUTO);
END;

-- Exemplo 2 - NÃO Esquecer que decimal precisa estar entre '0,12'
BEGIN
  ATUALIZARPRECOPRODUTO(1, '30,99');
END;

--Exemplo 3

DECLARE
  PIDPRODUTO NUMBER;
  PVALORPRODUTO NUMBER;
BEGIN
  PIDPRODUTO := 1;
  PVALORPRODUTO := 30.99;

  ATUALIZARPRECOPRODUTO(
    PIDPRODUTO => PIDPRODUTO,
    PVALORPRODUTO => PVALORPRODUTO
  );
END;


-- Exemplo de uma Procedure complexa
-- PROCEDURE 1

CREATE OR REPLACE PROCEDURE AtualizarPrecoProduto(pIdProduto IN Produto.Valor%Type, pValorProduto IN Produto.Valor%Type, pMensagem OUT VARCHAR) IS
    nValorAntigo NUMBER(12,2);
    
BEGIN
    SELECT Valor INTO nValorAntigo FROM Produto WHERE Id = pIdProduto;
    UPDATE Produto SET Valor = pValorProduto WHERE Id = pIdProduto;
    
    IF pIdProduto = 3 THEN
        pMensagem := 'Erro';
    ELSE
        pMensagem := 'ATUALIZAÇÃO FEITA COM SUCESSO, SEGUE O VALOR ANTIGO DO PRODUTO ' || nValorAntigo;
    END IF;
END;


-- PROCEDURE 2

CREATE OR REPLACE PROCEDURE AtulizarPrecoAnual IS
  PIDPRODUTO NUMBER;
  PVALORPRODUTO NUMBER;
  PMENSAGEM VARCHAR2(200);
  
BEGIN  
    FOR itemProduto IN (SELECT Id, Valor FROM Produto) LOOP
        DBMS_OUTPUT.PUT_LINE('Id Produto : ' || itemProduto.Id);

        PIDPRODUTO := itemProduto.Id;
        PVALORPRODUTO := itemProduto.Valor * 0.05;

        ATUALIZARPRECOPRODUTO(PIDPRODUTO, PVALORPRODUTO, PMENSAGEM);
        
        IF PMENSAGEM = 'Erro' THEN
            DBMS_OUTPUT.PUT_LINE('Erro no produto' || itemProduto.Id);
            EXIT;
        END IF;
        
    END LOOP;
END;


-- CHAMADA DA PROCEDURE 2 NO BLOCO DE CÓDIGO

EXECUTE AtulizarPrecoAnual;


-- Aula 4
-- Exemplo Um Procedure 

CREATE OR REPLACE PROCEDURE CALCULARMEDIAPRODUTOSVENDIDOS
IS
    nTotalVendas NUMBER := 0.0;
    nContador    NUMBER := 0;
    nMedia       NUMBER := 0.0;
BEGIN
    
    FOR produtosVendidos IN (SELECT ValorVenda, Quantidade FROM Orcamento) LOOP
      nTotalVendas := nTotalVendas + (produtosVendidos.ValorVenda / produtosVendidos.Quantidade);
      nContador := nContador + 1;
    END LOOP;
    
    --SELECT COUNT(*) INTO nContador FROM Orcamento;
    
    IF nContador > 0 THEN
        nMedia := nTotalVendas / nContador;
        DBMS_OUTPUT.PUT_LINE('Média dos produtos Sem ROUND ' || nMedia);
        nMedia := ROUND(nMedia, 2);
        DBMS_OUTPUT.PUT_LINE('Média dos produtos Com ROUND ' || nMedia);
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erro no calculo da média');    
END;

--- Fim Exemplo Um

-- Exemplo Dois

--Criar procedure com cursor para atualizar produtos exclusivos

CREATE OR REPLACE PROCEDURE AtualizarOrcamentoParaAmigos(pId NUMBER, pValorVenda NUMBER, pQuantidade NUMBER, pMensagem OUT VARCHAR2) 
IS
    CURSOR cValidarOrcamento IS SELECT Id FROM Orcamento WHERE Id = pId;
    nId NUMBER;
BEGIN
    pMensagem := 'Atualização Não efetuada';
    
    OPEN cValidarOrcamento;
        LOOP
            FETCH cValidarOrcamento INTO nId;
                EXIT WHEN cValidarOrcamento%NOTFOUND;
                
                UPDATE Orcamento SET ValorVenda = pValorVenda, Quantidade = pQuantidade WHERE Id = pId;
                pMensagem := 'ATUALIZA COM SUCESSO';
        END LOOP;
    CLOSE cValidarOrcamento;
END;

-- Fim Exemplo Dois