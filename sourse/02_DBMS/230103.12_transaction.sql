-- [XII] Transaction : COMMIT(Ʈ����� �ݿ�), ROLLBACK(Ʈ����� ���), SAVEPOINT(Ʈ����� ����)
-- COMMIT �� : ���ο� Ʈ����� ����
-- ROLLBACK �� : �� Ʈ��������� ��
-- SAVEPOINT ���̺�����Ʈ�� : �� ������ ���̺�����Ʈ�� ����
-- ROLLBACK TO SAVEPOINT��; : SAVEPOINT�� ���ư���

DROP TABLE DEPT01;
CREATE TABLE DEPT01 AS SELECT * FROM DEPT;
COMMIT;
-------------------------- ���ο� Ʈ����� ����
SELECT * FROM DEPT01;
DELETE FROM DEPT01 WHERE DEPTNO=20;
DELETE FROM DEPT01 WHERE DEPTNO=30; 
ROLLBACK;
-------------------------- ���ο� Ʈ����� ����
SELECT * FROM DEPT01;
DELETE FROM DEPT01 WHERE DEPTNO=40;     
COMMIT;
-------------------------- ���ο� Ʈ����� ����
SELECT * FROM DEPT01; -- 10,20,30
DELETE FROM DEPT01 WHERE DEPTNO=30;
SELECT * FROM DEPT01; -- 10, 20
SAVEPOINT c1;   -- c1 ���� : 10, 20
DELETE FROM DEPT01 WHERE DEPTNO=20;
SELECT * FROM DEPT01;   -- 10
SAVEPOINT c2;   -- c2 ���� : 10
DELETE FROM DEPT01 WHERE DEPTNO=10;
SELECT * FROM DEPT01;
ROLLBACK TO c2;     -- c2�� ���ư�
SELECT * FROM DEPT01;
ROLLBACK TO c1;
SELECT * FROM DEPT01;
COMMIT;
