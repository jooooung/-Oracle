-- ���α׷� �䱸���׿� �ʿ��� DML
-- ��ɺ� query �ۼ� (1, 2, 3)
-- 1. person �Է�
INSERT INTO PERSON 
    VALUES (pNO_SEQ.NEXTVAL, '������',
            (SELECT JNO FROM JOB WHERE JNAME='���'), 100, 100, 100);
--delete from person where pno=6;
-- 2. ������ ��ȸ
SELECT ROWNUM RN, A.* 
    FROM (SELECT pNAME||'('||pNO||'��)' pNO, jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) SUM 
            FROM PERSON P, JOB J WHERE P.jNO=J.jNO AND jNAME='���'
             ORDER BY SUM DESC) A
   ;
-- 3. ��ü ��ȸ
SELECT ROWNUM RN, A.* 
    FROM (SELECT pNAME||'('||pNO||'��)' pNO, jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) SUM 
            FROM PERSON P, JOB J WHERE P.jNO=J.jNO 
            ORDER BY SUM DESC) A;
SELECT JNAME FROM JOB;
commit;