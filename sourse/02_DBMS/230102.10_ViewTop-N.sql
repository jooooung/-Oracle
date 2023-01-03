-- [X] View, In-Line View, TOP-N
-- 1. VIEW : ������ ���̺� (1)�ܼ��� (2)���պ�

-- (1) �ܼ��� : �ϳ��� ���̺��� �̿��Ͽ� ���� ��
-- �������� ��������� �����͸� ������ ���̺�
DROP TABLE EMP1;
CREATE TABLE EMP1 AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;
SELECT * FROM EMP1;
INSERT INTO EMP1 (EMPNO, ENAME, JOB, DEPTNO) VALUES (1111, 'ȫ', 'ITMANAGER', 40);
SELECT * FROM EMP1 WHERE EMPNO=1111;
SELECT * FROM USER_TABLES WHERE TABLE_NAME LIKE 'EMP%';
DROP TABLE EMP1;

-- ������ ���̺� : �������� ��������� ������ X, ���� ���̺��� ��¥ ���̺��� �̿��Ͽ� ������ ��(��������)
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;
SELECT * FROM EMPv0;
SELECT * FROM USER_TABLES WHERE TABLE_NAME LIKE 'EMP%';     -- VIEW �� ��¥ ���̺��� �ƴϱ⿡ �� ���δ�
SELECT * FROM USER_VIEWS;
DROP VIEW EMPv0;        -- VIEW�� DROP ���� �ʾƵ� �Ȱ��� �̸����� ���� �� �ִ�
    -- ex. EMP���̺��� EMPNO, ENAME, JOB, DEPTNO �� �ִ� ������ ���̺� �� EMPv0 �����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'ITMANAGER', 40);  -- ���̺�ó�� INSERT �غ���
SELECT * FROM EMP;      -- EMPv0(VIEW)�� INSERT �Ͽ����� EMP(TABLE)���� INSERT �ȴ�
UPDATE EMPv0 SET JOB='ANALYST' WHERE EMPNO=1111;    -- EMPv0�� �ʵ带 �����ص� EMP�� �ʵ嵵 ����ȴ�
DELETE FROM EMPv0 WHERE EMPNO=1111;     -- ȫ ����

    -- EMPv0(VIEW) = EMP�� 30�� �μ��� �����ͼ� �����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO=30;
SELECT * FROM USER_VIEWS;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, SYSDATE, NULL, NULL, 40);      -- EMPv0�� 30�� �μ��� �����Ա⿡ 40���μ��� EMP�� INSERT�ȴ�
SELECT * FROM EMPv0;
SELECT * FROM EMP;
DELETE FROM EMPv0 WHERE EMPNO=1111;     -- 30�� �μ��� ������ �����ϴ� �ุ DELETE�� �ȴ�
DELETE FROM EMP WHERE EMPNO=1111;    
    -- �ܼ��信�� INSERT �� �Ұ��� ��� : �� ������ NOT NULL �ʵ带 �������� ���
CREATE OR REPLACE VIEW EMPv0 AS SELECT ENAME, JOB FROM EMP;
INSERT INTO ENMv0 VALUES ('ȫ', 'MANAGER');  -- PRIMARY KEY�� EMPNO�� �� ȣ���̹Ƿ� INSERT �Ұ�
SELECT * FROM EMP;
COMMIT;
-- VIEW�� ���� ����
-- WITH CHECK OPTION �߰� : ���� ���ǿ� �ش�Ǵ� �����͸� ����, ����, ������ ����
    -- ex. EMP���̺��� 30�� �μ��� ������ ���̺�(30���� DML����)
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO=30
    WITH CHECK OPTION;
INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1111, 'ȫ', 30);
INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1112, 'ȫ', 40);    -- WITH CHECK OPTION �� �߱⿡ 40�� �μ��� INSERT �Ұ�
SELECT * FROM EMP WHERE ENAME='SMITH';
DELETE FROM EMPvO WHERE ENAME='SMITH';  -- SMITH�� 20�� �μ��̱⿡ DELETE�� �Ұ�
-- WITH READ ONLY �߰� : �б� ���� ��
CREATE OR REPLACE VIEW EMPv0   
    AS SELECT * FROM EMP WHERE DEPTNO=20 WITH READ ONLY;
INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1113, 'ȫ', 20);    -- READ ONLY�� INSERT �Ұ�

-- (2) ���պ� : 2�� �̻��� ���̺�� ������ ��, ������ �ʵ带 �̿��� ���. DML���� ���������θ� ���
-- �� 2�� �̻��� ���̺�� ������ ��
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DNAME FROM DEPT D, EMP E WHERE E.DEPTNO=D.DEPTNO;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1112, 'HONG', 'MANAGER', 'SALES');
-- �� ������ �ʵ带 �̿��� ��� (�÷��� ��Ī�� ���)
CREATE OR REPLACE VIEW EMPv0        -- ��Ī ��� : ���� ����
    AS SELECT EMPNO, ENAME, SAL*12 YEAR_SAL FROM EMP WHERE DEPTNO=10;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1113, 'HONG', 12000);    

CREATE OR REPLACE VIEW EMPv0        -- ��Ī X : ���� X
    AS SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE DEPTNO=10;

    -- ex1. ���, �̸�, �޿�, 10�� �ڸ����� �ݿø��� �޿��� ��� ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, SAL, ROUND(SAL, -2) SAL2 FROM EMP;
    
    -- ex2. �ߺ��� ���ŵ� JOB, DEPTNO�� ��� ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT DISTINCT JOB, DEPTNO FROM EMP;
SELECT * FROM EMPv0;

    -- ex3. �μ���ȣ, �ּұ޿�, �ִ�޿�, �μ���ձ޿��� ������ EMPv0 �並 ����
CREATE OR REPLACE VIEW EMPv0 (DNO, MINSAL, MAXSAL, AVGSAL)
    AS SELECT DEPTNO, MIN(SAL), MAX(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO;
    
    -- ex4. �μ��� �ּұ޿� �ִ�޿� ��ձ޿��� ������ DEPTv0 �並 ����
CREATE OR REPLACE VIEW DEPTv0 (DNAME, MANSAL, MAXSAL, AVGSAL)
    AS SELECT DNAME, MIN(SAL), MAX(SAL), AVG(SAL) FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME;
SELECT * FROM DEPTv0;

-- 2. INLINE_VIEW (FROM���� ���� SUB QUERY) FROM ���� ���� ���������� VIEWó�� �ۿ�
    -- ���� : SELECT �ʵ� FROM ���̺�, (��������) ��Ī
--             WHERE ���� ����

    -- ex. �޿��� 2000�� �ʰ��ϴ� ����� ��� �޿�
SELECT AVG(SAL) FROM EMP WHERE SAL>2000;
SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL>2000) A;

    -- ex2. �μ��� ��� ���޺��� ���� ����� ���, �̸�, �޿�, �μ���ȣ, �μ����
SELECT  EMPNO, ENAME, E.DEPTNO, ROUND(AVGSAL)
    FROM EMP E, (SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) A
    WHERE E.DEPTNO=A.DEPTNO AND SAL>AVGSAL;


-- 3. TOP-N ���� (1~10��, 11~20�� ..)
-- �Լ��� �̿��� RANK ���(1~�õ�)
SELECT ENAME, RANK() OVER(ORDER BY SAL DESC) RANK,
        DENSE_RANK() OVER(ORDER BY SAL DESC) DENSE_RANK,
        ROW_NUMBER() OVER(ORDER BY SAL DESC) ROW_NUMBER
        FROM EMP;
        
-- ROWNUM(���̺�κ��� ������ ����), INLINE-VIEW�� �̿��� TOP-N
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO=20;  -- WHERE ���� ���̸� ����� �ű�
SELECT ROWNUM, ENAME, SAL FROM EMP;
SELECT ROWNUM, ENAME, SAL FROM EMP ORDER BY SAL;  -- ROWNUM�� EMP�� INSERT�� ������� �ű��
SELECT ROWNUM, ENAME, SAL FROM (SELECT * FROM EMP ORDER BY SAL);  -- 1�� ~����
-- FROM���� SAL�� ������ �־ ROWNUM�� ������ SAL�� �Ǿ���

    -- SAL �������� 1~5��
SELECT ROWNUM RK, A.*
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL) A
    WHERE ROWNUM < 6;
    -- SAL �������� 6~10��
SELECT ROWNUM RK, ENAME, SAL
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL) 
    WHERE ROWNUM BETWEEN 6 AND 10;      -- ���� �ȵ�
    
-- TOP-N
SELECT * FROM EMP ORDER BY SAL; -- 1�ܰ�
SELECT ROWNUM RN, A.*
    FROM (SELECT * FROM EMP ORDER BY SAL) A;  -- 2�ܰ�
SELECT ROWNUM, B.* 
    FROM (SELECT ROWNUM RN, A.*
         FROM (SELECT * FROM EMP ORDER BY SAL) A) B
    WHERE RN BETWEEN 6 AND 10;      -- 3�ܰ�(TOP-N)

    -- ex. �̸��� ���ĺ� ������ �����Ͽ� 6~10��° ���(����, �̸� ��� JOB MGR HIREDATE)
SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE
    FROM (SELECT * FROM EMP ORDER BY ENAME);
SELECT *
    FROM(SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE
         FROM (SELECT * FROM EMP ORDER BY ENAME))
    WHERE RN BETWEEN 6 AND 10;

    -- ex. �Ի������ 11~15��° ����� ��� �ʵ� ���(������ ��� X)
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO
    FROM(SELECT ROWNUM RN, A.* 
          FROM (SELECT * FROM EMP ORDER BY HIREDATE)A)
    WHERE RN BETWEEN 11 AND 15;
    
    -- <�� ��������>
-- 1. �μ���� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VU 
    AS SELECT DNAME, ENAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
SELECT * FROM DNAME_ENAME_VU;
-- 2. ������ ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW WORKER_MANAGER_VU
    AS SELECT W.ENAME WORKER, M.ENAME MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
SELECT * FROM WORKER_MANAGER_VU;
-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���). 
SELECT B.*
    FROM (SELECT A.*,  ROWNUM RN
         FROM (SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL)) A) B;
-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�.
SELECT B.*
    FROM (SELECT A.*,  ROWNUM RN
         FROM (SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL)) A) B
    WHERE RN BETWEEN 2 AND 3;
-- 4. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;
-- 5. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
SELECT ROWNUM, A.*
    FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) A
    WHERE ROWNUM BETWEEN 1 AND 5;
-- 6. ��� ���̺��� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� ���
SELECT *
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC)A)
    WHERE RN BETWEEN 6 AND 10;