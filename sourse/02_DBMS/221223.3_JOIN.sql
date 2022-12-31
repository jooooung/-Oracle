-- [ III ] JOIN : 2�� �̻��� ���̺��� �����Ͽ� �����͸� �˻��ϴ� ���
SELECT * FROM EMP 
    WHERE ENAME = 'SCOTT';
SELECT * FROM DEPT;

-- CROSS JOIN (FROM ���� ���̺��� 2�� �̻�)
SELECT * FROM EMP, DEPT WHERE ENAME = 'SCOTT'; --1(EMP���̺��� ����)*4(DEPT���̺� ����)

SELECT * FROM EMP WHERE ENAME = 'SCOTT';  
SELECT * FROM SALGRADE;
SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT';

-- SELF JOIN
SELECT * FROM EMP WHERE ENAME = 'SCOTT';

-- �� 1. EQUI JOIN(���� �ʵ��� DEPTNO���� ��ġ�Ǵ� ���Ǹ� JOIN) ��

SELECT * FROM EMP, DEPT 
    WHERE ENAME = 'SCOTT' AND EMP.DEPTNO = DEPT.DEPTNO;  --DEPTNO�� �ι� ��µ�
    
    -- ex. ��� ����� ��� �̸� ��å ����� �μ���ȣ �μ��̸� �ٹ���
SELECT EMPNO, ENAME, JOB, MGR, EMP.DEPTNO, DNAME, LOC 
    FROM EMP, DEPT 
    WHERE EMP.DEPTNO = DEPT.DEPTNO;
    
SELECT EMPNO, ENAME, JOB, MGR, E.DEPTNO, DNAME, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO;       --EQUI JOIN �ϼ���
    
    -- ex1. �޿��� 2000�̻��� ������ �̸�, ��å, �޿�, �μ���, �ٹ��� ���
SELECT ENAME, JOB, SAL, DNAME, LOC
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO
    AND SAL >= 2000;
    
    -- ex2. 20�� �μ��� ������ �̸� �μ���ȣ �ٹ��� ���
SELECT ENAME, E.DEPTNO, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO
    AND E.DEPTNO = 20;
    
    -- ex3. LOC�� CHOCAGO�� ����� �̸� ���� �޿� �μ��� �ٹ����� ���
SELECT ENAME, JOB, SAL, DNAME, LOC      --���� ��ġ�� ���� �ִٸ� ��Ī�� ����� ��
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND LOC='CHICAGO';      --JOIN �� ���ǹ�
    
    -- ex4. DEPTNO�� 10�̰ų� 20�� ����� �̸� ���� �ٹ����� ���(�޿���)
SELECT ENAME, JOB, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO IN (10, 20) ORDER BY SAL;
    
    -- ex5. JOB�� SALESMAN �̰ų� MANAGER�� ����� �̸� �޿� �󿩱� ����((SAL+COM)*12) �μ��� �ٹ����� ���(������ ū ������ ����)
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM, 0)*12) ANNUALSAL, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND JOB IN ('SALESMAN', 'MANAGER')
    ORDER BY ANNUALSAL DESC;
    
    -- ex6. COMM�� NULL�̰� SAL�� 1200�̻��� ����� �̸� �޿� �Ի��� �μ���ȣ �μ��� ���(�μ��� ��, �޿� ū �� ����)
SELECT ENAME, SAL, HIREDATE, D.DEPTNO, DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NULL AND SAL >=1200
    ORDER BY DNAME, SAL DESC;
    
    -- ex7. NEW YORK���� �ٹ��ϴ� ����� �̸��� �޿��� ����Ͻÿ�
SELECT ENAME, SAL 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';
    
    -- ex8. ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի����� ����Ͻÿ�
SELECT ENAME, HIREDATE
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = 'ACCOUNTING';
    
    -- ex9. ������ MANAGER�� ����� �̸�, �μ����� ����Ͻÿ�
SELECT ENAME, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND JOB = 'MANAGER';
    
    -- ex10. Comm�� null�� �ƴ� ����� �̸�, �޿�, �μ��ڵ�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, D.DEPTNO, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND NOT COMM IS NULL;
    
-- ��2.NON-EQUI JOIN��

SELECT * FROM EMP WHERE ENAME = 'SCOTT';
SELECT * FROM SALGRADE;
SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT'; --CROSS JOIN
SELECT * FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL AND ENAME = 'SCOTT'; -- NON-EQEUI JOIN
    
    -- ex11. ��� ����� ���, �̸�, ��å, �����, �޿�, �޿����(1���, 2���...)
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE||'���' GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
    
    -- źźex1. Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ���ȣ, �μ��̸�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, GRADE, E.DEPTNO, DNAME, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL 
    AND NOT COMM IS NULL;
    
    -- źźex2. �̸�, �޿�, �Ի���, �޿����
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL;
    
    -- źźex3. �̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;
    
    -- źźex4. �̸�, �޿�, ���, �μ��ڵ�, �ٹ���. �� comm �� null�ƴ� ���
SELECT ENAME, SAL, GRADE, E.DEPTNO, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND NOT COMM IS NULL;
    
    -- źźex5. �̸�, �޿�, �޿����, ����, �μ���, �μ��� ���, �μ��� ������ ������. ����=(sal+comm)*12 comm�� null�̸� 0
SELECT ENAME, SAL, GRADE, SAL*12+NVL(COMM, 0) ANNUALSAL , DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL 
    ORDER BY DNAME, ANNUALSAL;
    
    -- źźex6. �̸�, ����, �޿�, ���, �μ��ڵ�, �μ��� ���. �޿��� 1000~3000����. �������� : �μ���, �μ������� ������, ���������� �޿� ū��
SELECT ENAME, JOB, SAL, GRADE, D.DEPTNO, DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
    AND SAL BETWEEN 1000 AND 3000 ORDER BY DNAME, JOB, SAL DESC;
    
    -- źźex7. �̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū��
SELECT ENAME, SAL, GRADE, HIREDATE, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND TO_CHAR(HIREDATE, 'YY') = '81' 
    ORDER BY GRADE DESC;
    
-- ��3.SELF-JOIN��

SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'SMITH';
SELECT EMPNO, ENAME FROM EMP WHERE EMPNO = 7902;
SELECT WORKER.EMPNO, WORKER.ENAME, WORKER.MGR, MANAGER.EMPNO, MANAGER.ENAME 
    FROM EMP WORKER, EMP MANAGER
    WHERE WORKER.ENAME = 'SMITH' AND WORKER.MGR = MANAGER.EMPNO;
    -- ex1. ��� ����� ���, �̸�, ����� ���, �̸�
SELECT W.EMPNO, W.ENAME, M.EMPNO, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;  --KING�� MGR�� NULL�̶� ����
DESC EMP;

    -- ex2. 'SMITH�� ���� FORD��' �������� ���
SELECT W.ENAME || '�� ���� ' || M.ENAME || '��' MESSAGE
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
    
    -- źźex1. �Ŵ����� KING�� ������� �̸��� ������ ����Ͻÿ�.
SELECT WORKER.ENAME, WORKER.JOB
    FROM EMP WORKER, EMP MANAGER
    WHERE WORKER.MGR=MANAGER.EMPNO AND MANAGER.ENAME='KING';
    
    -- źźex2. SCOTT�� ������ �μ���ȣ���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�
SELECT M.ENAME
    FROM EMP W, EMP M  
    WHERE W.ENAME = 'SCOTT' AND W.DEPTNO = M.DEPTNO AND M.ENAME <> 'SCOTT';
    
    -- źźex3. SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�(2�ܰ� ��������)
SELECT * FROM EMP WHERE ENAME = 'SCOTT';
SELECT * FROM DEPT;
INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
INSERT INTO EMP VALUES (9999, 'ȫ', NULL, NULL, NULL, 6000, NULL, 50);

SELECT E2.ENAME
    FROM EMP E1, DEPT D1, EMP E2, DEPT D2
    WHERE E1.DEPTNO = D1.DEPTNO AND E2.DEPTNO = D2.DEPTNO
        AND E1.ENAME = 'SCOTT' AND D1.LOC = D2.LOC AND E2.ENAME <> 'SCOTT';
        
-- ȫ������, 50�� �μ� ������ ���󺹱�(����)
ROLLBACK;
SELECT * FROM EMP;

-- ��4.OUTER-JOIN��  EQUI & SELF JOIN ���ǿ� �������� �ʴ� �൵ ��Ÿ���� ����
-- (1) SELP JOIN������ OUTER JOIN
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);  
    
    -- ex. 'SMITH�� ���� FORD'  'KING�� ���� ����'
SELECT W.ENAME || '�� ����' || NVL(M.ENAME, '����')
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);

    -- ex. ���� ��� ���(��簡 �ƴ� ���)
SELECT M.EMPNO, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL;
    
-- (2) EQUI JOIN������ OUTER JOIN
SELECT * FROM EMP;  -- 14��
SELECT * FROM DEPT; -- 4��
SELECT * FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO;  -- 40�� �μ��� ��� �ȵ�
SELECT * FROM EMP E, DEPT D WHERE E.DEPTNO(+) = D.DEPTNO; 

-- �� <��������> PART1
--1. �̸�, ���ӻ���
SELECT E1.ENAME, E2.ENAME MGR
    FROM EMP E1, EMP E2
    WHERE E1.MGR = E2.EMPNO;
    
--2. �̸�, �޿�, ����, ���ӻ���
SELECT E1.ENAME, E1.SAL, E1.JOB, E2.ENAME MGR
    FROM EMP E1, EMP E2
    WHERE E1.MGR = E2.EMPNO;
    
--3. �̸�, �޿�, ����, ���ӻ��� . (��簡 ���� �������� ��ü ���� �� ���.
    --��簡 ���� �� '����'���� ���)
SELECT E1.ENAME, E1.SAL, E1.JOB, NVL(E2.ENAME, '����') MGR
    FROM EMP E1, EMP E2
    WHERE E1.MGR = E2.EMPNO(+);    

--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT E1.ENAME, E1.SAL, D1.DNAME, E2.ENAME MGR
    FROM EMP E1, DEPT D1, EMP E2
    WHERE E1.DEPTNO = D1.DEPTNO AND E1.MGR = E2.EMPNO; 

--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT E1.ENAME, E1.SAL, E1.DEPTNO, D1.DNAME, LOC, NVL(E2.ENAME, '����') MGR
    FROM EMP E1, DEPT D1, EMP E2
    WHERE E1.DEPTNO = D1.DEPTNO AND E1.MGR = E2.EMPNO(+);                                         
    
--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT W.ENAME, W.SAL, GRADE, DNAME, M.ENAME MANAGER
    FROM EMP W, SALGRADE, DEPT D, EMP M
    WHERE W.SAL BETWEEN LOSAL AND HISAL AND W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO
        AND W.SAL >= 2000;

--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT E1.ENAME, E1.SAL, GRADE, D1.DNAME, NVL(E2.ENAME, '����') MGR
    FROM EMP E1, DEPT D1, SALGRADE, EMP E2
    WHERE E1.DEPTNO = D1.DEPTNO 
        AND E1.SAL BETWEEN LOSAL AND HISAL
        AND E1.MGR = E2.EMPNO(+) ORDER BY D1.DNAME;                       
        
--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT W.ENAME, W.SAL, GRADE, D.DNAME, W.SAL*12+NVL(W.COMM, 0) ANNUALSAL, M.ENAME MGR
    FROM EMP W, DEPT D, SALGRADE, EMP M
    WHERE W.MGR = M.EMPNO AND W.DEPTNO = D.DEPTNO
        AND W.SAL BETWEEN LOSAL AND HISAL;
        
--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT W.ENAME, W.SAL, GRADE, DNAME, (W.SAL+NVL(W.COMM, 0))*12 ANNUALSAL, M.ENAME MANAGER
    FROM EMP W, EMP M, SALGRADE, DEPT D
    WHERE W.MGR=M.EMPNO AND W.SAL BETWEEN LOSAL AND HISAL AND W.DEPTNO=D.DEPTNO
    ORDER BY DNAME, W.SAL DESC; -- ORDER BY DNAME, SAL DESC�� ���� 
        
--  PART2
--1.EMP ���̺��� ��� ����� ���� �̸�, �μ���ȣ, �μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME, E.DEPTNO, D.DNAME
    FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO;
    
--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�, ����, �޿�, �μ����� ���
SELECT ENAME, E.JOB, E.SAL, D.DNAME
    FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';
    
--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT ENAME, DNAME, LOC
    FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND COMM > 0;

--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT ENAME, JOB, DNAME, LOC
    FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME LIKE '%L%';

--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO, ENAME, E.DEPTNO, DNAME
    FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO ORDER BY ENAME;
    
--6. ���, �����, �޿�, �μ����� �˻��϶�. 
    --�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, SAL, DNAME
    FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND SAL >= 2000 ORDER BY SAL DESC;
    
--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
-- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO, ENAME, JOB, SAL, DNAME
    FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO
        AND JOB = 'MANAGER' AND SAL >= 2500 ORDER BY EMPNO;

--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, JOB, SAL, GRADE
    FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL ORDER BY SAL DESC;

--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT E1.ENAME, E1.MGR, NVL(E2.ENAME, '����') MGRNAME
    FROM EMP E1, EMP E2 
    WHERE E1.MGR = E2.EMPNO(+);

--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT E1.ENAME, E2.ENAME MGR, E3.ENAME MGR2
    FROM EMP E1, EMP E2, EMP E3
    WHERE E1.MGR = E2.EMPNO AND E2.MGR = E3.EMPNO;

--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT E1.ENAME, E2.ENAME MGR, E3.ENAME MGR2
    FROM EMP E1, EMP E2, EMP E3
    WHERE E1.MGR = E2.EMPNO(+) AND E2.MGR = E3.EMPNO(+);
