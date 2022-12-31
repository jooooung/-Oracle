-- [ VII ] DDL, DCL, DML
-- SQL = DDL(���̺� ����, ���̺� ����, ���̺� ���� ����, ���̺��� ��� ������ ����)  + 
--       DML(SELECT, INSERT, UPDATE, DELETE) + 
--       DEL(����ڰ��� ����, ����� ���� �ο�, ���ѹ�Ż, ����ڰ��� ����, Ʈ����� ��ɾ�)

-- �� DDL ��
-- 1. ���̺� ����(CREATE TABLE ���̺��) : ���̺� ������ �����ϱ�
CREATE TABLE BOOK (
    BOOKID NUMBER(4),  -- BOOKID �ʵ��� Ÿ���� ���� 4�ڸ�
    BOOKNAME VARCHAR2(50),   -- BOOKNAME�ʵ��� Ÿ���� ���� 50BYTE
    PUBLISHER VARCHAR2(50), -- PUBLISHER �ʵ��� Ÿ���� ���� 50BYTE
    RDATE DATE,             -- RDATE �ʵ��� Ÿ���� DAET
    PRICE NUMBER(8, 2),      -- PRICE�ʵ��� Ÿ���� ����(��ü 8, �Ҽ��� 2, �Ҽ��� �� 6)
    PRIMARY KEY(BOOKID)     -- BOOKID�ʵ尡 ��Ű(PRIMARY KEY : NOT NULL, UNIQUE)
);
DESC BOOK:

DROP TABLE BOOK;    -- TABLE ����

CREATE TABLE BOOK(
    BID NUMBER(4) PRIMARY KEY,
    BNAME VARCHAR2(20),
    PUBLISHER VARCHAR2(20),
    RDATE DATE,
    PRICE NUMBER(9)
    );
SELECT * FROM BOOK;
DESC BOOK;

    -- ex. EMP ���̺�� ������ EMP01 �����
--        EMP01 : EMPNO(����4), ENAME(����10), SAL(���� 2)
CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10),
    SAL NUMBER(9));

    -- ex. DEPT01 ���̺� : DEPTNO(���� 2:PK), ENAME(����14), LOC(����13)
CREATE TABLE DEPT01(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13));
SELECT * FROM EMP01;

    -- EMP02 ���������� �̿��� ���̺� ���� 
CREATE TABLE EMP02
    AS 
    SELECT * FROM EMP;   -- �������� ����� EMP02 ���� �� �����͵� ��(�������� ������)
    -- EMP03 : EMP ���̺��� EMPNO, ENAME, DEPTNO�� ������ ������
CREATE TABLE EMP03 AS SELECT EMPNO, ENAME, DEPTNO FROM EMP;
SELECT * FROM EMP03;
    -- EMP04 : EMP ���̺��� 10�� �μ��� ����
CREATE TABLE EMP04 AS SELECT * FROM EMP WHERE DEPTNO = 10;
    -- EMP05 : EMP���̺� ������ ����(������ ���� X)
CREATE TABLE EMP05 AS SELECT * FROM EMP WHERE 0=1;   -- WHERE ���� �ݵ�� ������ ���� �ɱ�
SELECT ROWNUM, EMPNO, ENAME, JOB FROM EMP;  -- ���̺��� ���� ���� ����(�о�帰 ����)

-- 2. ���̺� ���� ����(ALTER TABLE ���̺�� ADD, MODIFY, DROP ~)
-- (1) �ʵ� �߰�(ADD)
SELECT * FROM EMP03;  --EMPNO(��4), ENAME(��10), DEPTNO(��2)
ALTER TABLE EMP03 ADD (JOB VARCHAR2(20), SAL NUMBER(7, 2) );    -- �ʵ� �߰� �� �����ʹ� NULL
ALTER TABLE EMP03 ADD (COMM NUMBER(7, 2) );

-- (2) �ʵ� ����(MODIFY)
SELECT * FROM EMP03;  --EMPNO(��4), ENAME(��10), DEPTNO(��2), JOB, SAL, COMM�� NULL
ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2(5));   -- ���ڵ����Ͱ� ����־� ���ڷ� ���� �Ұ�
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(5)); -- ���� �����ʹ� �ø��⸸ ����
ALTER TABLE EMP03 MODIFY (SAL VARCHAR2(10));    -- �����Ͱ� NULL �̸� ���� ����
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(20));  -- ���ڴ� �ø��� ���̱�(�������� �ּ� �ڸ���) ����

-- (3) �ʵ� ����(DROP)
ALTER TABLE EMP03 DROP COLUMN JOB;  
ALTER TABLE EMP03 DROP COLUMN DEPTNO;  -- �����ͱ��� �� �����ȴ�
-- �������� Ư�� �ʵ带 ���� ���ϵ��� (��)
ALTER TABLE EMP03 SET UNUSED (COMM);    -- COMM�� ����
-- �������� ���� �Ұ��ߴ� �ʵ带 ���������� ����(����)
ALTER TABLE EMP03 DROP UNUSED COLUMNS;

-- 3. ���̺� ����(DROP TABLE ���̺� ��)
DROP TABLE EMP01;   -- EMP01 ���̺� ����
DROP TABLE DEPT;    -- EMP ���̺��� DEPT ���̺��� �����ϴ� ��� ���� X(EMP ���� �� DEPT ���� ����)

-- 4. ���̺��� ��� ���� ����(TRUNCATE TABLE ���̺��) 
TRUNCATE TABLE EMP03;

-- 5. ���̺�� ����(RENAME ���̺�� TO �ٲ� ���̺��)
RENAME EMP02 TO EMP2;
SELECT * FROM EMP2;

-- 6. ������ ��ųʸ�(���ٺҰ�) - �����͵�ųʸ� �� (���ٿ�)
-- ����
    --(1) USER_XXX : �� ������ �����ϰ� �ִ� ��ü(���̺�, ��������, ��, �ε���)
       -- USER_TABLES, USER_CONSTRAINTS, USER_INDEXES, USER_VIEWS
SELECT * FROM USER_TABLES;
SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_INDEXES;
SELECT * FROM USER_VIEWS;
    --(2) ALL_XXX : �� �������� ���� ������ ��ü(���̺�, ��������, ��, �ε���)
       -- ALL_TABLES, ALL_CONSTRAINTS, ALL_INDEXES, ALL_VIEWS
SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_VIEWS;
    --(3) DBA_XXX ; DBA���ѿ����� ���ٰ���. DBMS�� ��� ��ü
       -- DBA_TABLES, DBA_CONSTRAINTS, DBA_INDEXES, DBA_VIEWS
SELECT * FROM DBA_TABLES;
        
-- �� �� �� DML �� �� ��
-- 1. INSERT INTO ���̺�� VALUES (��1, ��2, ...);
   -- INSERT INTO ���̺�� (�ʵ��1, �ʵ��2,..) VALUES (��1, ��2, ..);
SELECT * FROM DEPT01;
ROLLBACK;
INSERT INTO DEPT01 VALUES (50, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01 VALUES (60, 'SALES', NULL); -- ��������� NULL�߰�
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (70, 'RESEARCH', '���빮');
INSERT INTO DEPT01 (LOC, DEPTNO, DNAME) VALUES ('����', 80, 'IT');
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (90, 'OPERATION'); -- ���������� NULL �߰�
SELECT * FROM DEPT01;
-- ���������� �̿��� INSERT
    -- ex. dept���̺��� 10~30�� �μ��� dept01���̺�� 
INSERT INTO DEPT01 SELECT * FROM DEPT WHERE DEPTNO < 40;
SELECT * FROM DEPT01;
    -- ex BOOK (BID = 11, BNAME = '����������', ���ǻ�� '�Ѽ�����', ������ ����, ���� 90000)
DESC BOOK;      -- BOOK ���̺��� �ʵ� Ÿ�� Ȯ��
INSERT INTO BOOK VALUES (11, '����������', '�Ѽ�����', SYSDATE, 90000);

-- Ʈ������ ��ɾ� (DML ��ɾ���� ����)
    -- Ʈ�������� ������ ó���� �� ����. DML ��ɾ���� ����ʰ� ���ÿ� Ʈ����� ����
COMMIT; -- �� Ʈ������� �۾��� DB�� �ݿ�
INSERT INTO BOOK VALUES (12, '����������', '�Ѽ�����', SYSDATE, 90000);
SELECT * FROM BOOK;     -- ����� �ϳ��� DB �ϳ��� Ʈ����ǿ� �ִ� ���� - �ؿ��� �ѹ��Ͽ� DB�����͸� ����
ROLLBACK;   -- �� Ʈ������� �۾��� ���

-- ��������
--������ ���� ������ SAM01���̺��� �����Ͻÿ�. ���� �̸��� ���̺��� ������ ��� DROP TABLE��
--���� �� �����Ͻÿ�
--? SAM01�� ���� (EMPNO�� ��Ű��)
--? EMPNO(���) ? NUMBER(4)
--? ENAME(�̸�) ? VARCHAR2(10)
--? JOB(��å) ? VARCHAR2(9)
--? SAL(�޿�) ? NUMBER(7,2)
--? EMP �� ����� ��� �� 10�� �μ� �Ҽ� ����� ������ �߰��Ѵ�
--EMPNO ENAME JOB SAL
--1000 APPLE POLICE 10000
--1010 BANANA NURSE 15000
--1020 ORANGE DOCTOR 25000
--1030 VERY (NULL) 25000
--1040 CAT (NULL) 2000
--7782 CLARK MANAGER 2450
--7839 KING PRESIDENT 5000
--7934 MILLER CLERK 1300
DROP TABLE SAM01;
CREATE TABLE SAM01(
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10),
    JOB   VARCHAR2(9),
    SAL   NUMBER(7,2)
);
SELECT * FROM SAM01;
INSERT INTO SAM01 (EMPNO, ENAME, JOB, SAL) 
    VALUES (1000,'APPLE','POLICE',10000);
INSERT INTO SAM01 VALUES (1010,'BANANA','NURSE',15000);
INSERT INTO SAM01 VALUES (1020,'ORANGE','DOCTOR',25000);
INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1030,'VERY',25000);
INSERT INTO SAM01 VALUES (1040,'CAT',NULL, 2000);
INSERT INTO SAM01 
    SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO=10;
SELECT * FROM SAM01;
COMMIT;

-- 2. UPDATE ���̺�� SET �ʵ��1=��1(�ʵ��N=��N) (WHERE����);
    -- UPDATE�� ������ ���������� �ݵ�� ���� �� ���� ��
CREATE TABLE EMP01 AS SELECT * FROM EMP;
SELECT * FROM EMP01;
COMMIT;
    -- ex. �μ���ȣ�� 30���� ����
UPDATE EMP01 SET DEPTNO = 30;   -- WHERE���� ���� ������ DEPTNO ��ü ����   
ROLLBACK;
    -- ex. EMP01 ��� ������ SAL�� 10%�� �λ�
UPDATE EMP01 SET SAL = SAL*1.1;
    -- ex. EMP01 10�� �μ� ������ �Ի����� ���÷�, �μ���ȣ�� 30������ ����
UPDATE EMP01 SET HIREDATE = SYSDATE, DEPTNO=30 
    WHERE DEPTNO = 10;
SELECT * FROM EMP01;
    -- ex. SAL�� 3000�̻��� ����� �޿��� 10% �λ�
UPDATE EMP01 SET SAL = SAL*1.1 WHERE SAL >= 3000;
    -- ex. DALLAS�� �ٹ��ϴ� ������ �޿��� 1000$ �λ�
UPDATE EMP01 SET SAL = SAL+1000 
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');
    -- ex. EMP01 - SCOTT�� �μ���ȣ�� 20, JOB �� MANAGER, SAL�� COMM�� 500$ �λ�, ���� KING���� ����
UPDATE EMP01 
    SET DEPTNO=20, JOB='MANAGER', SAL=SAL+500, COMM=NVL(COMM,0)+500,
        MGR = (SELECT EMPNO FROM EMP WHERE ENAME='KING')
    WHERE ENAME='SCOTT';
    -- ex. DEPT01 �� 60�� LOC�� 20�� �μ��� LOC���� ����
UPDATE DEPT01 SET LOC=(SELECT LOC FROM DEPT01 WHERE DEPTNO=20)
    WHERE DEPTNO=60;
SELECT * FROM DEPT01;
    -- ex.EMP01���� ��� ����� �޿��� �Ի����� KING�� �޿��� �Ի��Ϸ� ����
UPDATE EMP01 SET SAL=(SELECT SAL FROM EMP01 WHERE ENAME='KING'), 
            HIREDATE=(SELECT HIREDATE FROM EMP01 WHERE ENAME='KING');
    
-- 3. DELETE FROM ���̺�� (WHERE ����);       ROLLBACK ����
DELETE FROM EMP01;
ROLLBACK;
    -- ex. EMP01 ���� 30�� �μ� ������ ����
DELETE FROM EMP01 WHERE DEPTNO=30;
    -- ex. EMP01 ���� 'FORD' ��� ���
DELETE FROM EMP01 WHERE ENAME='FORD';
    -- ex. SAM01���̺��� JOB�� �������� ���� ��� ��ü
DELETE FROM SAM01 WHERE JOB IS NULL;
    -- ex. EMP01 ���� �μ����� SALES�� ����� ����(�������� �̿�)
DELETE FROM EMP01 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
    -- ex. EMP01���� �μ����� RESEARCH�� ��� ����
DELETE FROM EMP01 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='RESEARCH');
COMMIT;

-- �� ��������(PDF 2~3) ��
--1. �Ǝm�� ������ �����ϴ� MY_DATA ���̺��� �����Ͻÿ�. �� ID�� PRIMARY KEY�̴�.
--ID - number(4) NAME - varchar2(10) USERID - varchar2(30) SALARY - number(10,2)
--1              Scott                sscott              10,000.00
--2              Ford                 fford               13,000.00
--3              Patel                ppatel              33,000.00
--4              Report               rreport             23,500.00
--5              Good                 ggood               44,450.00
--2. ������ ���̺� ���� ��ǥ�� ���� ���� �Է��ϴ� SQL���� �ۼ��Ͻÿ�.
--3. TO_CHAR ���� �Լ��� �̿��Ͽ� �Է��� �ڷḦ ���� ��ǥ�� ���� �������� ����ϴ�
--SQL���� �ۼ��Ͻÿ�.
--4. �ڷḦ ���������� �����ͺ��̽��� ����ϴ� ��ɾ �ۼ��Ͻÿ�.
--5. ID�� 3���� ����� �޿��� 65000.00���� �����ϰ� ���������� �����ͺ��̽��� �ݿ��϶�.
--6. NAME�� Ford�� ����� �����ϰ� ���������� �����ͺ��̽��� �ݿ��϶�.
--7. SALARY�� 15,000.00 ������ ����� �޿��� 15,000.00���� �����϶�
--8. ������ ������ ���̺��� �����϶�.

-- 1.
CREATE TABLE MY_DATA (
    ID NUMBER(4) PRIMARY KEY,
    NAME VARCHAR2(10),
    USERID VARCHAR2(30),
    SALARY NUMBER(10,2) );
-- 2.
INSERT INTO MY_DATA VALUES (1, 'Scott', 'sscott', 10000);
INSERT INTO MY_DATA VALUES (2, 'Ford', 'fford', 13000);
INSERT INTO MY_DATA VALUES (3, 'Patel', 'ppatel', 33000);
INSERT INTO MY_DATA VALUES (4, 'Report', 'rreport', 23500);
INSERT INTO MY_DATA VALUES (5, 'Good', 'ggood', 44450);
SELECT * FROM MY_DATA;
-- 3.
SELECT ID, NAME,USERID, TO_CHAR(SALARY, '99,999.99') SALARY FROM MY_DATA;
-- 4.
COMMIT;
-- 5.
UPDATE MY_DATA SET SALARY = 65000 WHERE ID = 3;
COMMIT;
-- 6.
DELETE FROM MY_DATA WHERE NAME='Ford';
COMMIT;
-- 7.
UPDATE MY_DATA SET SALARY=15000 
    WHERE SALARY IN (SELECT SALARY FROM MY_DATA WHERE SALARY <=15000);
-- 8.
DROP TABLE MY_DATA;

-- 1. EMP ���̺�� ���� ������ ���� ������ ���̺� EMP01�� ����
--    (���̺��� ������ ������ ��)�ϰ�, ��� ����� �μ���ȣ�� 30������ �����մϴ�.
DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP;
UPDATE EMP01 SET DEPTNO=30;
-- 3. EMP01���̺��� ��� ����� �޿��� 10% �λ��Ű�� UPDATE���� �ۼ�
UPDATE EMP01 SET SAL=SAL*1.1;
-- 4. �޿��� 3000�̻��� ����� �޿��� 10%�λ�
UPDATE EMP01 SET SAL=SAL*1.1 
    WHERE SAL IN (SELECT SAL FROM EMP01 WHERE SAL >= 3000);
-- 5. EMP01���̺��� ��DALLAS������ �ٹ��ϴ� �������� ������ 1000�λ� 
UPDATE EMP01 SET SAL = SAL+1000
     WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
-- 6. SCOTT����� �μ���ȣ�� 20������, ������ MANAGER�� �Ѳ����� ����
UPDATE EMP01 SET DEPTNO=20, JOB='MANAGER' WHERE ENAME='SCOTT';
-- 7. �μ����� SALES�� ����� ��� �����ϴ� SQL�ۼ�
DELETE FROM EMP01 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
-- 8. ������� ��FORD���� ����� �����ϴ� SQL �ۼ�
DELETE FROM EMP01 WHERE ENAME = 'FORD';
-- 9. SAM01 ���̺��� JOB�� NULL�� ����� �����Ͻÿ�
DELETE FROM SAM01 WHERE JOB IS NULL;
-- 10 .SAM01���̺��� ENAME�� ORANGE�� ����� �����Ͻÿ�
DELETE FROM SAM01 WHERE ENAME = 'ORANGE';

-- �� �������� �� 
-- (1) PRIMARY KEY : ���̺��� �� ���� ������ ������ �ĺ��ϱ� ���� �ʵ�
-- (2) FOREIGN KEY : ���̺��� ���� �ٸ� ���̺��� ���� ����
-- (3) NOT NULL : NULL�� �������� �ʴ´�
-- (4) UNIQUE : ��� ���� ���� �����ؾ� �Ѵ�. NULL�� �ߺ� ���
-- (5) CHECK(����) : �ش� ������ ����(NULL�� ���)
-- (6) DEFAULT : �⺻�� ����(�ش� ���� ������ ���Է½� NULL�� �ƴ� DEFAULT��)

    -- DEPT1 & EMP1 ���̺� ����
-- ���̺��� ������ ����(�ڽ����̺� ����)
DROP TABLE EMP1;
DROP TABLE DEPT1;
CREATE TABLE DEPT1 (
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME  VARCHAR2(14) NOT NULL UNIQUE,
    LOC    VARCHAR2(14) NOT NULL
);
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME='DEPT1';
CREATE TABLE DEPT1 (    -- �������� ����
    DEPTNO NUMBER(2) CONSTRAINT DEPT_PK PRIMARY KEY,
    DNAME  VARCHAR2(14) CONSTRAINT DEPT_U NOT NULL UNIQUE,
    LOC    VARCHAR2(14) CONSTRAINT DEPT_LOC NOT NULL
);
CREATE TABLE DEPT1 (    -- �������� ���� 2
    DEPTNO NUMBER(2),
    DNAME  VARCHAR2(14) NOT NULL,
    LOC    VARCHAR2(14) NOT NULL,
    CONSTRAINT DEPTNO_P PRIMARY KEY(DEPTNO),
    CONSTRAINT DNAME_U UNIQUE(DNAME)
);
SELECT * FROM USER_INDEXES WHERE TABLE_NAME ='DEPT1';

CREATE TABLE EMP1(  -- ���������� ������
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9) NOT NULL,
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE,
    SAL NUMBER(7,2) CHECK(SAL>0),
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2) REFERENCES DEPT1(DEPTNO)
);
CREATE TABLE EMP1( -- ���������� ������
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9) NOT NULL,
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE,
    SAL NUMBER(7,2),
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2),
    PRIMARY KEY(EMPNO),
    CHECK(SAL>0),
    FOREIGN KEY(DEPTNO) REFERENCES DEPT1(DEPTNO)
);
-- DEPT1 ������ �־��
INSERT INTO DEPT1 SELECT * FROM DEPT;
INSERT INTO DEPT1 (DEPTNO, DNAME, LOC) 
    VALUES ( 50, 'IT', 'SEOUL');
INSERT INTO DEPT1 VALUES (60, 'PLANNING', 'PUSAN');
INSERT INTO DEPT1 (DEPTNO, DNAME) VALUES (70, 'CS'); -- LOC�� NOT NULL�̱⿡ ����
INSERT INTO DEPT1 (DEPTNO, DNAME, LOC) 
    VALUES (70, 'CS', 'GANGNAM');
SELECT * FROM DEPT1;

-- EMP1 ������ �ֱ�
INSERT INTO EMP1 (EMPNO, ENAME, JOB)
    VALUES (1001, 'HONG', 'MANAGER');
SELECT * FROM EMP1; -- MGR, SAL, COMM, DEPTNO �� �ڵ����� NULL, HIREDATE�� =DEFAULT��
INSERT INTO EMP1 (EMPNO, ENAME, JOB, SAL)
    VALUES (1002, 'HONG', 'MANAGER', 10000);
INSERT INTO EMP1
    VALUES (1003, 'KIM', 'MANAGER', NULL, NULL, NULL, NULL, NULL);
    
    
-- �� ��������(PDF4) ��
DROP TABLE BOOK;
DROP TABLE BOOKCATEGORY CASCADE CONSTRAINTS;
CREATE TABLE BOOKCATEGORY(
    CATEGORYCODE NUMBER(4) PRIMARY KEY,
    CATEGORYNAME VARCHAR2(50) UNIQUE,
    OFFICE_LOC VARCHAR2(50) NOT NULL
);
INSERT INTO BOOKCATEGORY 
    VALUES (100, 'ö��', '3�� �ι���');
INSERT INTO BOOKCATEGORY 
    VALUES (200, '�ι�', '3�� �ι���');
INSERT INTO BOOKCATEGORY 
    VALUES (300, '�ڿ�����', '4�� ���н�');
INSERT INTO BOOKCATEGORY 
    VALUES (400, 'IT', '4�� ���н�');
SELECT * FROM BOOKCATEGORY;
DROP TABLE BOOKCATEGORY;

CREATE TABLE BOOK(
    CATEGORYCODE NUMBER(4),
    bookNO VARCHAR2(50),
    bookNAME VARCHAR2(50),
    PUBLISHER VARCHAR2(50),
    PUBYEAR NUMBER(4) DEFAULT TO_CHAR(SYSDATE, 'YYYY'),
    FOREIGN KEY(CATEGORYCODE) REFERENCES BOOKCATEGORY(CATEGORYCODE),
    PRIMARY KEY(bookNO)
);
SELECT * FROM BOOK;
INSERT INTO BOOK VALUES (100, '100A01', 'ö������ ��', '��������', 2021);
INSERT INTO BOOK VALUES (400, '400A01', '�̰���DB��', '��������', 2022);

-- ������ ������
SELECT * FROM BOOK;
DELETE FROM BOOKCATEGORY WHERE CATEGORYCODE=100;    -- CHILD���� �����ϰ� �־ DELETE �Ұ�
DELETE FROM BOOK WHERE CATEGORYCODE=100;    -- �����ϴ� BOOK ���� ����
DELETE FROM BOOKCATEGORY WHERE CATEGORYCODE=100;    -- ������ ������ DELETE ����
DELETE FROM BOOKCATEGORY WHERE CATEGORYCODE IN (200, 300);
DELETE FROM BOOK;
SELECT * FROM BOOK;
COMMIT;
DELETE FROM BOOKCATEGORY;   -- �ڽ����̺��� ���������Ͱ� ���� �� ������ DELETE ����
DROP TABLE BOOKCATEGORY;    -- �ڽ����̺��� �־ �������� ���� -> BOOK�� ���� ����� �����ߵ�
DROP TABLE BOOK;
DROP TABLE BOOKCATEGORY;

-- �������� 2
DROP TABLE STUDENT;
DROP TABLE MAJOR;

CREATE TABLE MAJOR (
    MAJOR_CODE NUMBER(2) PRIMARY KEY,
    MAJOR_NAME VARCHAR2(50), 
    major_OFFICE_LOC VARCHAR2(200)
);
INSERT INTO MAJOR VALUES (1, '��ǻ�Ͱ���', 'A101ȣ');
INSERT INTO MAJOR VALUES (2, '������', 'A102ȣ');
SELECT * FROM MAJOR;

CREATE TABLE STUDENT(
    student_code NUMBER(4) PRIMARY KEY,
    student_NAME VARCHAR2(20),
    SCORE NUMBER(3),
    MAJOR_CODE NUMBER(2),
    FOREIGN KEY(MAJOR_CODE) REFERENCES MAJOR(MAJOR_CODE),
    CHECK(0<=SCORE AND SCORE<=100)
);
INSERT INTO STUDENT VALUES (101, 'ȫ�浿', 99, 1);
INSERT INTO STUDENT VALUES (102, '�ű浿', 100, 2);
SELECT * FROM STUDENT;

SELECT S.*, M.* 
    FROM STUDENT S, MAJOR M 
    WHERE S.MAJOR_CODE=M.MAJOR_CODE
    ORDER BY S.MAJOR_CODE;
    
-- �� DCL (����ڰ�������, ����ڱ��Ѻο�, ���ѹ�Ż, ����ڰ�������) ��
-- ��������
CREATE USER scott2 IDENTIFIED BY tiger;
-- ���Ѻο�(���Ǻο�)
GRANT CREATE SESSION TO SCOTT2;
-- ���Ѻο�(TABLE, VIEW)
CREATE ROLE ROLEex;
GRANT CREATE TABLE, CREATE VIEW TO ROLEex;
GRANT ROLEex TO SCOTT2;
-- ���Ѻο�(EMP���̺��� ��� ����)
GRANT ALL ON EMP TO SCOTT2;
-- ���� �ο�(DEPT���̺��� SELECT ����)
GRANT SELECT ON DEPT TO SCOTT2;

-- ���� ��Ż(DEPT���̺�, EMP���̺� ����)  - ���� ���� �� ��Ż ��õ
REVOKE ALL ON EMP FROM SCOTT2;
REVOKE SELECT ON DEPT FROM SCOTT2;

-- ����� ���� ���� (�ݵ�� ���� ���� �� ����)
DROP USER scott2 CASCADE;