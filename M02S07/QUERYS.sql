
BEGIN 
  FOR I IN (SELECT * FROM CURSO C
            INNER JOIN PROFESSOR F
                  ON F.IDPROFESSOR = C.IDPROFESSOR
            WHERE C.EAD = 0 
            AND F.CIDADE = 'Santa Catarina')
  LOOP
    UPDATE CURSO SET EAD = 1 WHERE IDCURSO = I.IDCURSO;
    COMMIT;
  END LOOP;
END;
--2 FORMA
UPDATE CURSO C SET C.EAD = 1
WHERE C.EAD =0
AND EXISTS (SELECT * FROM PROFESSOR P 
                        WHERE P.CIDADE = 'Santa Catarina' 
                        AND P.IDPROFESSOR = C.IDPROFESSOR)


DROP FROM CURSO WHERE IDCURSO = 1

SELECT * FROM CURSO
WHERE NROMAXALUNO>30
AND EAD = 1;


SELECT * FROM PROFESSOR
WHERE NACIONALIDADE = 'America do Sul';


SELECT * FROM ESTUDANTE
WHERE UPPER(NOME) LIKE 'J%'

SELECT * FROM ESTUDANTE
WHERE MEDIAGERAL>7
ORDER BY MEDIAGERAL DESC;


SELECT E.* FROM MATRICULA M
INNER JOIN ESTUDANTE E
      ON E.IDESTUDANTE = M.IDESTUDANTE
INNER JOIN CURSO C
      ON C.IDCURSO = M.IDCURSO
AND C.EAD = 1
-- 2 FORMA
SELECT E.* FROM MATRICULA M, ESTUDANTE E, CURSO C
WHERE E.IDESTUDANTE = M.IDESTUDANTE
AND C.IDCURSO = M.IDCURSO
AND C.EAD = 1


UPDATE ESTUDANTE SET MEDIAGERAL = 9
WHERE IDESTUDANTE = 1


