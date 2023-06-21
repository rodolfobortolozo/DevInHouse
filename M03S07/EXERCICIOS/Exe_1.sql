-- Crie um Cursor utilizando um loop que faça um UPDATE na tabela Produto mudando a coluna Status = 0 dos registros 1, 2 e 3;
DECLARE
  CURSOR cursor_produtos IS
    SELECT ID
    FROM Produto
    WHERE ROWNUM <= 3;
  
  v_id NUMBER;
BEGIN
  OPEN cursor_produtos;
  LOOP
    FETCH cursor_produtos INTO v_id;
    EXIT WHEN cursor_produtos%NOTFOUND;
    
    UPDATE Produto
    SET Status = 0
    WHERE ID = v_id;
    
    DBMS_OUTPUT.PUT_LINE('Registro atualizado: ' || v_id);
  END LOOP;
  CLOSE cursor_produtos;
END;