-- ������� ���� ���� ������ Ȯ���� �� ����

SELECT * FROM TAB;
SELECT * FROM USER_TABLES;  -- �� ������ ���� �ִ� ���̺�
SELECT * FROM DBA_TABLES; -- DBA ���� ���� USER�� ��� ����
SELECT * FROM ALL_TABLES   -- ���� ������ �� �ִ� ���̺�
    WHERE TABLE_NAME='EMP';
SELECT * FROM SCOTT.EMP;    -- EMP�� ������ �޾ұ⿡ ��� ����
SELECT * FROM SCOTT.DEPT;   -- DEPT�� ������ �޾ұ⿡ ��� ����
EXIT;