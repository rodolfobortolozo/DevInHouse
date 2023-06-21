--Criar uma Procedure que imprimi todos os dados da tabela Produto utilizando um Cursor

--Na Procedure ExibirTodosProdutos colocar a exception NO_DATA_FOUD e imprimir a mensagem com Erro, dados não encontrados

CREATE OR REPLACE PROCEDURE ExibirTodosProdutos IS
    CURSOR c_produto IS SELECT * FROM produto;
    
    v_id PRODUTO.ID%TYPE;
    v_descricao PRODUTO.DESCRICAO%TYPE;
    v_status PRODUTO.STATUS%TYPE;
    v_cadastro PRODUTO.CADASTRO%TYPE;
    v_quantidade_em_estoque PRODUTO.QUANTIDADE_EM_ESTOQUE%TYPE;
    v_valor PRODUTO.VALOR%TYPE;
    
BEGIN
    OPEN c_produto;
    LOOP
        FETCH c_produto INTO 
        v_id, 
        v_descricao, 
        v_status, 
        v_cadastro, 
        v_quantidade_em_estoque,
        v_valor;
        EXIT WHEN c_produto%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('ID: ' || v_id);
        DBMS_OUTPUT.PUT_LINE('Descricao: ' || v_descricao);
        DBMS_OUTPUT.PUT_LINE('Status: ' || v_status);
        DBMS_OUTPUT.PUT_LINE('Data de cadastro: ' || v_cadastro);
        DBMS_OUTPUT.PUT_LINE('Quantidade em estoque: ' || v_quantidade_em_estoque);
        DBMS_OUTPUT.PUT_LINE('Valor: ' || v_valor);
        DBMS_OUTPUT.PUT_LINE('--------------------------------------------');
        
    END LOOP;        
    CLOSE c_produto;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Erro: DADOS NÃO ENCONTRADOS.'); 
END;