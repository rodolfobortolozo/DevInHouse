-- Criar procedure para efetuar o Deletar do registro na tabela recebendo o parametro ID.

-- Dica, pode utilizar o Cursor com FORALL

--  Regra

--  Verificar se o produto não está sendo utilizado na tabela ProdutoPreco
--  Verificar se o status do produto está ativo
--  Caso essas regras não existam pode excluir o registro, se não mostrar mensagem de erro

CREATE OR REPLACE PROCEDURE DeletarProduto(p_id NUMBER)
IS
  v_status NUMBER(1);
  v_produto_id NUMBER;
  v_produto_utilizado EXCEPTION;
  v_produto_desativado EXCEPTION;
  PRAGMA EXCEPTION_INIT(v_produto_utilizado, -20003);
  PRAGMA EXCEPTION_INIT(v_produto_desativado, -20004);
  
  CURSOR c_produto_preco IS
    SELECT IDProduto
    FROM PRECOPRODUTO
    WHERE IDProduto = p_id;
BEGIN
  OPEN c_produto_preco;
  FETCH c_produto_preco INTO v_produto_id;
  CLOSE c_produto_preco;
  
  IF v_produto_id IS NOT NULL THEN
    RAISE v_produto_utilizado;
  END IF;
  
  SELECT Status INTO v_status
  FROM Produto
  WHERE ID = p_id;
  
  IF v_status = 1 THEN
    RAISE v_produto_desativado;
  END IF;

  DELETE FROM Produto
  WHERE ID = p_id;

  DBMS_OUTPUT.PUT_LINE('Registro excluído com sucesso.');
EXCEPTION
  WHEN v_produto_utilizado THEN
    DBMS_OUTPUT.PUT_LINE('Erro (20003): O produto está sendo utilizado na tabela ProdutoPreco.');
  WHEN v_produto_desativado THEN
    DBMS_OUTPUT.PUT_LINE('Erro (20004): O status do produto está ativo.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Erro ao excluir o registro.');
END;