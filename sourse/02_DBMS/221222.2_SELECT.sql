-- [ II ] SELECT �� - ��ȸ

-- 1. SELECT ���� �ۼ���
-- ������� (���� : CTRL+ENTER)
SHOW USER;      -- ����� ���� Ȯ��
SELECT * FROM TAB;  --�� ������ ������ �ִ� ���̺� ����
SELECT * FROM EMP;  --EMP���̺��� ��� ��(�ʵ�), ��� ��
SELECT * FROM DEPT; --DEPT ���̺��� ��� ��(�ʵ�), ��� ��
SELECT * FROM SALGRADE;

-- 2. Ư�� ���� ���
DESC EMP;   --EMP���̺��� ����
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;     --EMPNO, ENAME, SAL, JOB�ʵ� ��� �� �˻�
SELECT EMPNO, ENAME, SAL, JOB, MGR, SAL, COMM FROM EMP; 
--�ʵ忡 ��Ī �����ϱ�(AS ���� ����, �����̽��� ���ٸ� "" ��������, ���� ����� ����)
SELECT EMPNO AS "�� ��", ENAME AS "�� ��", SAL AS "�޿�", JOB AS "��å" FROM EMP;
SELECT EMPNO "�� ��", ENAME "�� ��", SAL "�޿�", JOB "��å" FROM EMP;
SELECT EMPNO "�� ��", ENAME �̸�, SAL �޿�, JOB ��å FROM EMP;
SELECT EMPNO NO, ENAME NAME, SAL SALARY, JOB 
    FROM EMP;  -- ���� SELECT�� FROM���� ������

-- 3. Ư�� �� ��� : WHERE ��(����) �񱳿����� : ����(=) �ٸ���(!=, ^=, <>)
SELECT EMPNO ���, ENAME �̸�, SAL �޿� FROM EMP WHERE SAL = 3000; -- ����
SELECT EMPNO NO, ENAME NAME, SAL FROM EMP WHERE SAL <> 3000; -- �ٸ���
SELECT EMPNO NO, ENAME NAME, SAL FROM EMP WHERE SAL != 3000; -- �ٸ���
SELECT EMPNO NO, ENAME NAME, SAL FROM EMP WHERE SAL ^= 3000; -- �ٸ���
DESC EMP;
    -- �� �����ڴ� ����, ����, ��¥�� ��� ����
    -- ex1. ����̸�(ENAME)�� 'A', 'B', 'C',�� �����ϴ� ����� ��� �ʵ�
    -- A < AA < AAA < AAAA < AAAAA < AAAAAA < AA...A(10��) < AA...A < A..AB..
SELECT * FROM EMP WHERE ENAME < 'D';  -- ENAME�� D���� ������ ���
    -- ex2. 81�⵵ ������ �Ի��� ����� ��� �ʵ� ���
SELECT * FROM EMP WHERE HIREDATE < '81/01/01';
    -- ex3. �μ���ȣ(DEPTNO)�� 10���� ����� ��� �ʵ� ���
SELECT * FROM EMP WHERE DEPTNO = '10';
    -- ex4. �̸�(ENAME)�� FORD�� ������ EMPNO, ENAME, MGR(����� ���)�� ���
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'FORD';

-- 4. �������� �������� : AND, OR, NOT
    -- ex1. �޿�(SAL)�� 2000�̻� 3000������ ������ ��� �ʵ� ���
SELECT * FROM EMP WHERE SAL >= '2000' AND SAL <= '3000';
    -- ex2. 82�⵵�� �Ի��� ����� ��� �ʵ� ���
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE <= '82/12/31';

-- ��¥ ǥ��� ���� ���� (���� : YY/MM/DD �Ǵ� RR/MM/DD)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-YYYY';
SELECT * FROM EMP;
SELECT * FROM EMP 
    WHERE TO_CHAR(HIREDATE, 'YY/MM/DD') >= '82/01/01' 
        AND TO_CHAR(HIREDATE, 'YY/MM/DD') <='82/12/31';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
    -- ex3. ������ 2400�̻��� ������ ENAME, SAL, ����(SAL*12) ���
SELECT ENAME, SAL, SAL*12 ANNUALSAL -- (3)
    FROM EMP                    -- (1)  
        WHERE SAL*12 >= 2400;   -- (2) WHERE������ �ʵ� ��Ī(ANNUALSAL) ��� �Ұ�
    -- ex4. ������ 10,000 �̻��� ������ ENAME, SAL ����(����������) ���
SELECT ENAME, SAL, SAL*12 ����  -- (4) 
    FROM EMP                -- (1)
    WHERE SAL*12 >= 10000   -- (2)
    ORDER BY ����;           -- (3)  ORDER BY : ��������(�⺻) 
                            --      ORDER BY () ASC ��������
                            --      ORDER BY () DESC ��������
    -- ex5. 10�� �μ�(DEPTNO)�̰ų� JOB�� MANAGER�� ������ ��� �ʵ� ���
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB = 'MANAGER';
    -- ex6. �μ���ȣ�� 10�� �μ��� �ƴ� ������ ��� �ʵ� ���
SELECT * FROM EMP WHERE NOT DEPTNO = 10;     -- NOT�� �ʵ�� �տ� �´�

-- 5. ���������
SELECT EMPNO, ENAME, SAL, SAL*1.1 UPGRADESAL FROM EMP;      
    -- ex. ��� ����� �̸�(ENAME), ����(SAL), ��(COMM), ����(SAL*12+COMM)�� ���
SELECT ENAME, SAL, COMM, SAL*12+COMM FROM EMP;
    -- ��������� ����� NULL ���� �� ����� NULL
    -- NVL(NULL�� ���� �ִ� �ʵ��, ��ġ��)�� �̿� - ������ : �ʵ��� ��ġ���� Ÿ���� ��ġ�ؾ� �ȴ�.
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM, 0) ���� FROM EMP;
    -- ex2. ��� ����� ENAME, MGR(��� ���)�� ��� (��簡 ������ CEO�� ���)
SELECT ENAME, NVL(MGR, 'CEO') FROM EMP;     -- MGR(����)�� CEO(����)�� Ÿ���� ��ġ���� �ʾ� ����
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') MGR FROM EMP;     
    --MGR�� TO_CHAR(MGR)�� CEO�� Ÿ���� ���� �����Ͽ���. ��Ī�� MGR

-- 6. ���Ῥ����(||) : �ʵ峪 ���ڸ� ����
SELECT ENAME || '��' || JOB RMPLOYEE FROM EMP;
    -- ex. ��� ����� ���Ͽ� 'SMITH : ANNUAL SALARY = XXXX'  �������� ��� (���� = SAL*12+COMM)
SELECT ENAME || ': ANNUAL SALARY = ' || (SAL*12+NVL(COMM, 0)) MESSAGE FROM EMP;

-- 7. �ߺ�����(DISTINCT)
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;

-- �� �������� ��
    -- 1. emp ���̺��� ���� ���
SELECT * FROM EMP;
    -- 2. emp ���̺��� ��� ������ ��� 
DESC EMP;
    -- 3. �� scott �������� ��밡���� ���̺� ���
SELECT * FROM TAB;
    -- 4. emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;
    -- 5. emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL < 2000;
    -- 6. �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE > '82/02/01';
    -- 7. ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB = 'SALESMAN';
    -- 8. ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB <> 'CLERK';
    -- 9. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >= 1500 AND SAL <= 3000;
    -- 10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;
    -- 11. ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB = 'SALESMAN' OR SAL >= 3000;
    -- 12. �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL >= 2500 AND JOB = 'MANAGER';
    -- 13.��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���(������ SAL*12+COMM)
SELECT ENAME || '�� ' || JOB || '�����̰� ������' || (SAL*12+NVL(COMM, 0)) || '��' FROM EMP;
    -- CF. "ENAME�� �󿩱��� 800" ����ϱ�
SELECT ENAME || '�� �󿩱���' || NVL(COMM, 0) FROM EMP;

-- 8. SQL������(BETWEEN, IN, LIKE, ISNULL)
    -- (1) BETWEEN A AND B : A���� B����(A B ����)
        -- ex. SAL�� 1500�̻� 3000������ ������ ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
        -- ex2. SAL�� 1500�̸�, 3000�ʰ�
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;
        -- ex3. �̸��� 'A', 'B', 'C'�� �����ϴ� ������ ��� �ʵ�
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'D' AND ENAME != 'D'; 
        -- ex4. 82�⵵�� �Ի��� ������ ��� �ʵ带 ���
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';
-- ���� ������ ���� �ٸ��� TO_CHAR(HIREDATE, 'RR/MM/DD') �� �ٲ��ش�
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') BETWEEN '82/01/01' AND '82/12/31';

    -- (2) IN 
        -- ex1. �μ���ȣ�� 10, 20, 40�� �μ��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO IN (10, 20, 40);
        -- ex2. �μ���ȣ�� 10, 20, 40���� ��ȸ�� �μ� ������ ��� �ʵ�
SELECT * FROM EMP WHERE NOT DEPTNO IN (10, 20, 40); 
        -- ex3. ����� 7902, 7788, 7566�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE EMPNO IN (7902, 7788, 7566);
        -- ex4. ��å�� MANAGER�̰ų� ANALYST�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE JOB IN ('MANAGER', 'ANALYST');

    -- (3) LIKE %(0���� �̻�), _(�ѱ���)�� ������ ����
        -- ex1. �̸��� M���� �����ϴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE 'M%';
        -- ex2. �̸��� N�� ���� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%N%';
        -- ex3. �̸��� N�� ���ų� JOB�� N�� ���� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%N%' OR JOB LIKE '%N%'; 
        -- ex4. �̸��� S�� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%S';
        -- ex5. SAL�� 5�� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE SAL LIKE '%5';
        -- ex6. 82�⵵�� �Ի��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
        -- ex7. 1���� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '%/01/%';
        -- ex8. �̸��� '%'�� �� ����� ��� �ʵ�
INSERT INTO EMP VALUES (9999, 'LISA%', NULL, NULL, NULL, 6000, 1500, 20);
-- ������ �߰�
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\';
ROLLBACK; -- DML(������ ���۾� : �߰�, ����, ����)�� ���

    -- (4) IS NULL (NULL���� �˻�)
        -- ex1. �󿩱��� �Էµ��� �ʴ� ����� ��� �ʵ� ���(COMM�� NULL, O)
SELECT * FROM EMP WHERE COMM IS NULL OR COMM = 0;
        -- ex2. �󿩱��� �޴� ����� ��� �ʵ�(COMM�� NULL�� �ƴϰ� 0 �� �ƴ�
SELECT * FROM EMP WHERE NOT COMM IS NULL AND COMM != 0;

-- 9. ����(��������, ��������) ORDER BY () (ASC) ��������  �⺻
--                          ORDER BY () DESC ��������
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL;
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC;
-- ���� ������ �� XX�� ������ �� ���(����, ����, ��¥ �� ����)
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC, ENAME;
-- �̸� abcd������
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY ENAME;
-- ORDER BY �� ��, �Լ��� �����ϴ�
SELECT ENAME, SAL, SAL*12+NVL(COMM, 0) ANNUALSAL FROM EMP ORDER BY SAL*12+NVL(COMM, 0);

DESC EMP;  -- ���̺� ���� Ȯ���ϱ�
-- ����ȯ �Լ�
-- ��¥��(HIREDATE)�� ���������� ��ȯ : TO_CHAR(��¥��������, ����)
SELECT TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP;
-- �������� ��¥������ ��ȯ : TO_DADE(����������, ����)
SELECT TO_DATE('01-12-1996', 'MM-DD-YYYY') FROM DUAL;       --DUAL : �� �ุ �ִ� ������ ����


-- <��������>
--1.	EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
SELECT EMPNO, ENAME, JOB, SAL 
    FROM EMP 
    WHERE SAL >=3000; 
--2.	EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT ENAME, DEPTNO   
    FROM EMP 
    WHERE EMPNO = 7788;
--3.	������ 24000�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT EMPNO, ENAME, SAL, SAL*12+NVL(COMM, 0) ANNUALSAL 
    FROM EMP 
    WHERE SAL*12+NVL(COMM, 0) >= 2400 
    ORDER BY SAL;
--4.	�Ի����� 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� �����, ��å, �Ի����� ��� (�� hiredate ������ ���)
SELECT ENAME, JOB, HIREDATE 
    FROM EMP 
    WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01' 
    ORDER BY HIREDATE;
--5.	deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP WHERE DEPTNO IN (10, 20) ORDER BY ENAME;
--6.	sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���
-- (�� HEADING�� employee�� Monthly Salary�� ���)
SELECT ENAME employee, SAL "Monthly Salary" FROM EMP WHERE SAL >= 1500 AND DEPTNO IN (10, 30);
--7.	hiredate�� 1982���� ����� ��� ������ ���
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YY') = 82;
--8.	�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT ENAME, SAL FROM EMP WHERE ENAME BETWEEN 'C' AND 'Q' AND ENAME != 'Q' ORDER BY ENAME;
--9.	comm�� sal���� 10%�� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� ����ϴ� SELECT ���� �ۼ�
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM > SAL*1.1;
--10.	job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� ��� ����� ������ ���
SELECT * FROM EMP WHERE JOB IN('CLERK', 'ANALYST') AND NOT SAL IN (1000, 3000, 5000);
--11.	ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� ����� 
--��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP WHERE ENAME LIKE '%L%L%' AND DEPTNO = 30 OR MGR = 7782;
--12.	�Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/%%/%%';
--13.	�Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, 
-- ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/%%/%%' AND NOT JOB = 'SALESMAN';
--14.	���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, 
-- �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE;
--15.	������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';
--16.	����� 'A'�� �� ����� ���, ������� ���
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '%A%';
--17.	����(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.  
SELECT EMPNO, ENAME, SAL*12+NVL(COMM, 0) ANNUALSAL FROM EMP WHERE SAL*12+NVL(COMM, 0) >= 35000;
