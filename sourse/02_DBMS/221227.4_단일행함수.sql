-- [ IV ] �������Լ�
-- �Լ�  = �������Լ�, �׷��Լ�(�����Լ�)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP;   --������ ������ ����
SELECT ENAME, INITCAP(ENAME) FROM EMP;  --ù ���ڸ� �빮��, �������Լ�(INPUT 1�� -> OUTPUT 1��)
SELECT SUM(SAL), AVG(SAL) FROM EMP;  -- �׷��Լ�(INPUT N�� -> OUTPUT 1��)
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO;   -- �׷��Լ�(INPUT N�� -> OUTPUT 1��)

-- �ڴ����� �Լ��� ���� : ���ڰ����Լ�, ���ڰ����Լ�, ��¥�����Լ�, ����ȯ�Լ�, NVL(), ETC...
-- 1. ���ڰ����Լ� 
    -- DUAL���̺�, DUMMY���̺� : ����Ŭ���� ���� 1��1�� ¥�� �������̺�
SELECT * FROM DUAL;
DESC DUAL;
SELECT * FROM DUMMY;
DESC DUMMY;
SELECT ABS(-1) FROM DUAL;  -- ABS() = ���밪 �Լ�
SELECT FLOOR(34.5678) FROM DUAL; --�Ҽ������� ����
SELECT FLOOR(34.5678*10)/10 FROM DUAL;  -- �Ҽ��� 2��° �ڸ����� ����
SELECT TRUNC(34.5678, 2) FROM DUAL;     -- �Ҽ��� 3��° �ڸ����� ����
SELECT TRUNC(34.5678) FROM DUAL;           --�Ҽ������� ���� 
SELECT TRUNC(34.5678, -1) FROM DUAL;    -- ���� �ڸ����� ����
    -- ex. EMP���̺��� �̸�, �޿�(���� �ڸ����� ����)
SELECT ENAME, SAL, TRUNC(SAL, -2) FROM EMP;     
SELECT CEIL(34.5678) FROM DUAL;   -- �Ҽ��� ���� �ڸ����� �ø�

SELECT ROUND(34.5678) FROM DUAL;    -- �Ҽ��� ���� �ڸ����� �ݿø�
SELECT ROUND(34.5678, 2) FROM DUAL;  -- �Ҽ��� �ι�° �ڸ� �������� �ݿø�
SELECT ROUND(34.5678, -1) FROM DUAL;  -- ���� �ڸ����� �ݿø�

SELECT MOD(9, 2) FROM DUAL;     -- ������ ������
    -- ex. Ȧ���⵵�� �Ի��� ����� ��� ���� ���
SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'RR'), 2) = 1;

-- 2. ���ڰ����Լ�
-- �� ��ҹ��� ����
SELECT INITCAP('WELCOM TO ORACLE') FROM DUAL;      -- INITCAP �ܾ��� ù ���ڸ� �빮�ڷ�
SELECT INITCAP('Welcom To Oracle') FROM DUAL;
SELECT UPPER('ABCabc') FROM DUAL; -- �빮�ڷ�
SELECT LOWER('ABCabc') FROM DUAL; -- �ҹ��ڷ�
    -- ex. �̸��� SCOTT �� ������ ��� �ʵ�
SELECT * FROM EMP WHERE UPPER(ENAME)='SCOTT';
SELECT * FROM EMP WHERE INITCAP(ENAME)='Scott';
    -- ex. job�� MANAGER �� ������ ��� �ʵ�
SELECT * FROM EMP WHERE UPPER(JOB) = 'MANAGER';
SELECT * FROM EMP WHERE INITCAP(JOB) = 'Manager';
SELECT * FROM EMP WHERE LOWER(JOB) = 'manager';

-- �� ���ڿ���(concat�Լ�, ||������)
SELECT 'AB'||'CD'||'EF'||'GH' FROM DUAL;
SELECT CONCAT(CONCAT('AB','CD'), CONCAT('EF','GH')) FROM DUAL;
    -- ex. SMITH�� manager��
SELECT CONCAT(CONCAT(ENAME, '�� '), CONCAT(JOB, '��')) FROM EMP;
SELECT ENAME || '�� ' || JOB || '��' FROM EMP;

-- �� SUBSTR(STR, ������ġ, ���ڰ���) : STR�� ������ġ���� ���ڰ�����ŭ ���� ����
                    -- (������ġ�� 1����, ������ġ�� �����̸� ������ �ڸ����� ���ϴ�)
  -- SUBSTRB(STR, ���۹���Ʈ��ġ, ���ڹ���Ʈ��)
SELECT SUBSTR('ORACLE', 3, 2) FROM DUAL; -- 3��° ���ں��� 2���� ����
SELECT SUBSTRB('ORACLE', 3, 2) FROM DUAL;-- 3��° ����Ʈ���� 2����Ʈ ����
SELECT SUBSTR('�����ͺ��̽�', 4, 3) FROM DUAL; -- 4��° ���ں��� 3���� ����(���̽�)
SELECT SUBSTRB('�����ͺ��̽�', 4, 3) FROM DUAL;-- 4��° ����Ʈ���� 3����Ʈ ����(��)
    -- O R A C L E
    -- 1 2 3 4 5 6(��ġ)
    ---6-5-4-3-2-1(��ġ)
SELECT SUBSTR('WELCOME TO ORACLE', -1, 1) FROM DUAL; -- �ڿ��� 1��° ���ں��� �ѱ��� ����
SELECT SUBSTR('ORACLE', -2, 2) FROM DUAL; -- ������ ���� 2���� ����
SELECT SUBSTR(123, 2, 1) FROM DUAL; -- ���ڵ� ����(���ڸ� ���ڷ� �ٲ� 2��° ���� 1���� ����)

    -- ex. 9���� �Ի��� ����� ��� �ʵ� 'RR/MM/DD'
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4, 2) = '09';      -- 4��° ���ں��� 2�� ���, DATE���� ����
SELECT * FROM EMP WHERE SUBSTR(TO_CHAR(HIREDATE, 'RR/MM/DD'), 4, 2) = '09';     -- ����ȯ
    
    -- ex. 9�Ͽ� �Ի��� ����� ��� �ʵ� 'RR/MM/DD'
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, -2, 2) = '09';     --�ڿ��� �ι�° ���ں��� 2�� ���
SELECT * FROM EMP WHERE SUBSTR(TO_CHAR(HIREDATE, 'RR/MM/DD'), -2, 2) = '09';

-- �� LENGTH(STR) : STR�� ���ڼ�
    -- LENGTHB(STR) : STR�� ����Ʈ ��
SELECT LENGTH('ABCD') FROM DUAL;
SELECT LENGTHB('ABCD') FROM DUAL;
SELECT LENGTH('����Ŭ') FROM DUAL;  -- ��� 3(���ڼ�)
SELECT LENGTHB('����Ŭ') FROM DUAL; -- ��� 9(����Ʈ ��)

-- �� INSTR(STR, ã������) : STR���� ù��° ���ں��� ã�� ���ڰ� ������ ��ġ(������ 0)
    -- INSTR(STR, ã������, ������ġ) : STR���� ������ġ ���ں��� ã�� ���ڰ� ������ ��ġ
SELECT INSTR('ABCABC', 'B') FROM DUAL; -- ó������ ã�Ƽ� ó�������� B�� ��ġ : 2
SELECT INSTR('ABCABC', 'B', 3) FROM DUAL; -- N��° ���ں��� ã�Ƽ� ó�� ������ B�� ��ġ : 5
SELECT INSTR('ABCABC', 'B', -3) FROM DUAL; -- �� N��°���� �ڷ� ã�Ƽ� ó�� ������ B�� ��ġ : 2
SELECT INSTR('ABCABCABC', 'B', -3) FROM DUAL;   -- �� N��°���� �ڷ� ã�Ƽ� ó�� ������ B�� ��ġ : 5

    -- ex. 9���� �Ի��� ���(INSTR�̿�) 'RR/MM/DD'
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 4) = 4;
SELECT * FROM EMP WHERE INSTR(TO_CHAR(HIREDATE, 'RR/MM/DD'), '09', 4) = 4;    -- ��¥ ������ �� �� ����ȯ

    -- ex. 9�Ͽ� �Ի��� ����� ��� �ʵ�(INSTR�̿�)
SELECT * FROM EMP WHERE INSTR (HIREDATE, '09', 7) = 7;
    
    -- ex. 9���� �ƴ� ���� �Ի��� ����� ��� �ʵ�(INSTR�̿�)
SELECT * FROM EMP WHERE INSTR (HIREDATE, '09', 7) = 0;    

-- �� LPAD(STR, �ڸ���, ä�﹮��) : STR�� �ڸ�����ŭ Ȯ���ϰ� ���� �� �ڸ��� ä�﹮�ڷ� ���
    -- LPAD(STR, �ڸ���) : STR�� �ڸ�����ŭ Ȯ���ϰ� ���� �� �ڸ��� ' '�� ���
    -- RPAD(STR, �ڸ���, ä�﹮��) : STR�� �ڸ�����ŭ Ȯ���ϰ� ������ �� �ڸ��� ä�� ���ڷ� ���
    -- RPAD(STR, �ڸ���) : STR�� �ڸ�����ŭ Ȯ���ϰ� ������ �� �ڸ��� ' '�� ���
SELECT LPAD('OLACLE', 10, '#') FROM DUAL; -- ��� : ####OLACLE
SELECT RPAD('OLACLE', 10, '*') FROM DUAL; -- ��� : OLACLE****
SELECT ENAME, SAL FROM EMP;
DESC EMP; -- ENAME�� 10���ڱ���, SAL�� 5�ڸ����� �Է� ����
SELECT ENAME, LPAD(SAL, 6, '*') FROM EMP;
SELECT RPAD(ENAME, 10, '#'), LPAD(SAL, 6, '*') FROM EMP;

    -- ex. ���, �̸�(S****)
SELECT EMPNO, RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*') ENAME 
    FROM EMP;

    -- ex. ��� �̸� ��å(9�ڸ�Ȯ��), �Ի��� 
        -- (7369, SMITH, ____****K 80/12/**
SELECT EMPNO, ENAME, LPAD(LPAD(SUBSTR(JOB, -1, 1), LENGTH(JOB), '*'), 9, '-') JOB, RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*') 
    FROM EMP;
SELECT EMPNO, ENAME, LPAD(LPAD(SUBSTR(JOB, -1, 1), LENGTH(JOB), '*'), 9, '-') JOB, TO_CHAR(HIREDATE, 'RR/MM/') || '**' 
    FROM EMP;    

    -- ex. �̸��� ����° �ڸ� ���ڰ� R�� ����� ��� �ʵ� ���
SELECT * FROM EMP WHERE SUBSTR(ENAME, 3, 1) = 'R';  -- SUBSTR
SELECT * FROM EMP WHERE ENAME LIKE '__R%';          -- LIKE
SELECT * FROM EMP WHERE INSTR(ENAME, 'R', 3) = 3;   -- INSTR

-- �� �������� : TRIM(STR), LTRIM(STR), RTRIM(STR)
SELECT TRIM('   ORACLE  ') MSG FROM DUAL;
SELECT LTRIM('   ORACLE  ') MSG FROM DUAL;
SELECT RTRIM('   ORACLE  ') MSG FROM DUAL;

-- �� REPLACE(STR, �ٲ���ҹ���, �ٲܹ���) : STR���� �ٲ���ҹ��ڸ� �ٲܹ��ڷ� ��ü
SELECT REPLACE(ENAME, 'A', 'XX') FROM EMP;
SELECT REPLACE(SAL, '0', 'X') FROM EMP;
SELECT REPLACE(HIREDATE, '0', 'X') FROM EMP;

-- 3. ��¥ ���� �Լ� �� �����
-- �� SYSDATE : ���� / (SYSTIMESTAMP) �� �Ⱦ�
SELECT SYSDATE FROM DUAL;
    -- ����Ŭ Ÿ�� : ����, ����, ��¥  - ����, ��¥ ���� ����(��¥�� + - �� ����)
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD HH24:MI:SS';
SELECT SYSDATE-1 ����, SYSDATE ����, SYSDATE+1 ���� FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

    -- ex. �ݳ�������
SELECT SYSDATE+14 FROM DUAL;

    -- ex. ������ ~ ��������� ��¥ ��� (������ : 22/11/28)
SELECT TRUNC(SYSDATE - TO_DATE('22/11/28', 'RR/MM/DD')) DAY FROM DUAL;

    -- ex. ���� ~ �����ϱ��� ��ĥ ���Ҵ��� (������ : 23/05/12)
SELECT TRUNC(TO_DATE('23/05/12', 'RR/MM/DD') - SYSDATE) DAY FROM DUAL;
    
    -- ex. EMP���� �̸�, �Ի���, �ٹ��ϼ�
SELECT ENAME, HIREDATE, TRUNC(SYSDATE - HIREDATE) DAY FROM EMP;

    -- ex. EMP���� �̸�, �Ի���, �ٹ��ϼ�, �ٹ��ּ�, �ٹ����
SELECT ENAME, HIREDATE, TRUNC(SYSDATE - HIREDATE) DAY, 
    TRUNC((SYSDATE - HIREDATE)/7) WEEK, TRUNC((SYSDATE - HIREDATE)/365) YEAR 
    FROM EMP;

-- �� MONTHS_BETWEEN(����1, ����2) : �� �������� ���� ��
    -- ex. �̸�, �Ի���, �ٹ�����
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) MONTH FROM EMP; 

    -- ex. �̸�, �Ի��� ���� ȸ�翡�� ���� ��(SAL�� 1�⿡ 12��, COMM�� 2��)�� ���
SELECT ENAME, SAL*12*TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))
    + NVL(COMM, 0)*2*TRUNC((SYSDATE - HIREDATE)/365) MONEY
    FROM EMP;
    
-- �� ADD_MONTHS(Ư������, ������) : Ư���������� �� ���� ���� ��¥ ��ȯ
    -- ex. �̸�, �Ի���, �����������(�����Ⱓ 6����)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) FROM EMP;
    -- �Ի����� 81/08/30�̸� ���� ��������� 82/02/28 (2���� 30���� ���� ����)
INSERT INTO EMP VALUES (9999, 'HONG', 'MANAGER', NULL, '81/08/30', NULL, NULL, 40);
ROLLBACK;

-- �� NEXT_DAY(Ư������, '����') : Ư���������� ó�� �����ϴ� ����
SELECT NEXT_DAY(SYSDATE, '��') FROM DUAL;

-- �� LAST_DAY(Ư������) : Ư�������� ���� ����
SELECT LAST_DAY(SYSDATE) FROM DUAL;
    -- ex. �̸� �Ի��� ù ���޳�(���޳��� ����)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) "FIRST SAL" FROM EMP;

-- �� ROUND(��¥, XX) : ��¥ �ݿø�(XX = YEAR, MONTH, DAY)  
    -- YEAR : ����� �⵵��, MONTH : ����� ����, DAY : ����� �Ͽ��Ϸ�  
SELECT ROUND(34.5678, 2) FROM DUAL;
SELECT ROUND(SYSDATE, 'YEAR') FROM DUAL;    -- SYSDATE=22/12/27  ���=23/01/01
SELECT ROUND(SYSDATE, 'MONTH') FROM DUAL;   -- SYSDATE=22/12/27  ���=23/01/01(1~15���� �̹���,16�Ϻ��ʹ� ������)
SELECT ROUND(SYSDATE, 'DAY') FROM DUAL;     -- SYSDATE=22/12/27  ���=22/12/25
SELECT ROUND(SYSDATE) FROM DUAL;            -- ����� 0��0������ (����=����, ����=����)

-- TRUNC(��¥, XX) : ��¥ ����
SELECT TRUNC(SYSDATE, 'YEAR') FROM DUAL;    -- ���� �� 1�� 1��
SELECT TRUNC(SYSDATE, 'MONTH') FROM DUAL;   -- ���� �� 1��
SELECT TRUNC(SYSDATE, 'DAY') FROM DUAL;     -- ���� �Ͽ���
SELECT TRUNC(SYSDATE) FROM DUAL;            -- ���� 0�� 0��

    -- ex. �̸�, �Ի���, ù ���޳�(11��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE+5, 'MONTH')+10 FROM EMP;

    -- ex. �̸�, �Ի���, ù ���޳�(25��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9, 'MONTH')+24 FROM EMP;

-- 4. ����ȯ �Լ� (TO_CHAR:���ڷ� ��ȯ, TO_DATE:��¥������ ��ȯ)
-- �� TO_CHAR(��¥��, '�������')  
    -- ������� -> YYYY, YY, RR, MM, DD, DY, HH24, HH12, AM/PM, MI, SS 
    -- ������Ŀ� ���ڸ� ������ ��� -> ""
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD HH24:MI:SS') FROM EMP;
SELECT TO_CHAR(SYSDATE, 'YYYY"��"-MM"��"-DD"��" DY"����" AM HH12"��" MI"��" SS"��"') FROM DUAL;
SELECT TO_CHAR(SYSTIMESTAMP, 'RR-MM-DD AM HH12:MI;SS:FF') FROM DUAL;  -- �и��������� ǥ���ϴ� ��

-- �� TO_CHAR(����, '�������')
    -- 0 : �ڸ���, ��������� �ڸ����� ������ 0���� ä��
    -- 9 : �ڸ���, ��������� �ڸ����� ���Ƶ� ���ڸ�ŭ�� ���
    -- , : ���ڸ�����, ����
    -- . : �Ҽ���
    -- $ : ��ȭ���� $ �߰��ϰ��� �� ��
    -- L : ������ȭ������ �߰��ϰ��� �� ��(OS�� ���� ����)
SELECT TO_CHAR(12345678, '000,000,000.00') FROM DUAL;   -- 012,345,678.00
SELECT TO_CHAR(12345678, '999,999,999.99') FROM DUAL;   -- 12,345,678.00
SELECT TO_CHAR(100.76, '999.9') FROM DUAL;              -- �Ҽ��� �ڸ����� ������ ��� �ݿø�
SELECT TO_CHAR(1200, 'L9,999') FROM DUAL;
SELECT ENAME, SAL, TO_CHAR(SAL, '$99,999') FROM EMP;

-- �� TO_DATE(����, '����') : ���ڸ� ���Ͽ� ���� ��¥�� ����
SELECT TO_DATE('20221227 14:53', 'YYYYMMDD HH24:MI') FROM DUAL;
    -- 81/05/01 ~ 83/05/01 ���̿� �Ի��� ������ ��� �ʵ�
SELECT * FROM EMP 
    WHERE HIREDATE BETWEEN TO_DATE('81/05/01', 'RR/MM/DD') 
        AND TO_DATE('83/05/01', 'RR/MM/DD');
        
-- �� TO_NUMBER(����, "����")
SELECT '3456'+1 FROM DUAL;
SELECT TO_NUMBER('3,456', '9,999')+1 FROM DUAL;

-- 5. NVL(NULL�� ���� �ִ� ������, NULL�� ��ȯ��) - �Ű����� 2���� Ÿ���� ��ġ�ؾ���
    -- ex. ����̸�, ���ӻ���̸�(���ӻ�簡 ������ CEO�� ���)
SELECT W.ENAME, NVL(M.ENAME, 'CEO')   
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
    
    -- ex. ����̸�, ���ӻ���� ���(���ӻ�簡 ������ CEO�� ���)
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') MGR FROM EMP;

-- 6. ETC
-- �� EXTRACT : �⵵, ��, �ϸ� �����ϰ��� �� ��
SELECT HIREDATE, EXTRACT(YEAR FROM HIREDATE) FROM EMP;  -- �⵵�� ���ڷ� ����
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY') FROM EMP;    -- �⵵�� ���ڷ� ����
SELECT SYSDATE, EXTRACT(MONTH FROM SYSDATE) FROM DUAL;  -- ���� ���ڷ� ����
SELECT SYSDATE, TO_CHAR(SYSDATE, 'MM') FROM DUAL;       -- ���� ���ڷ� ����
SELECT SYSDATE, EXTRACT(DAY FROM SYSDATE) FROM DUAL;    -- �ϸ� ���ڷ� ����
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DD') FROM DUAL;       -- �ϸ� ���ڷ� ����

-- �� ������ ���
SELECT LPAD('��', (LEVEL*2))|| ENAME FROM EMP
    START WITH MGR IS NULL 
    CONNECT BY PRIOR EMPNO=MGR;
    
-- <�� ��������>
    -- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date" FROM DUAL;

    -- 2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�,
    -- �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ����
SELECT EMPNO, ENAME, JOB, SAL*1.15 "New Salary", SAL*0.15 "Increase" FROM EMP;

    --3. �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, ROUND(ADD_MONTHS(HIREDATE, 6), 'DAY')+1 MON FROM EMP;

    --4. �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ���
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) MONTH, SAL, SAL*(TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))) TOTALSAL 
    FROM EMP;
    
    --5. ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ���
SELECT ENAME, LPAD(SAL, 15, '*') SAL FROM EMP; 

    --6. ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY')||'����' DAY FROM EMP;

    --7. �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ���
SELECT ENAME, ENAME, LENGTH(ENAME) LENGTH, JOB FROM EMP WHERE LENGTH(ENAME) >= 6;

    --8. ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ���
SELECT ENAME, JOB, SAL, NVL(COMM, 0) COMM, SAL+NVL(COMM, 0) TOTAL FROM EMP;

    -- 9.��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT SUBSTR(ENAME, 2, 3) NAME FROM EMP;

    --10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 
    --  �ý��ۿ� ���� DATEFORMAT �ٸ� �� �����Ƿ� �Ʒ��� ����� �˾ƺ���
SELECT EMPNO, ENAME, HIREDATE 
    FROM EMP
    WHERE TO_CHAR(HIREDATE, 'MM') = 12;

    --11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
    --EMPNO		ENAME		�޿�
    --7369		       SMITH		*******800
    --7499		       ALLEN		******1600
    --7521		       WARD		******1250
    --����. 
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') �޿� FROM EMP;

    -- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
    -- EMPNO	 ENAME 	�Ի���
    -- 7369	  SMITH		1980-12-17
    -- ��.
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') �Ի��� FROM EMP;

    --13. ��� ���̺��� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.
        --(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$99,999') SAL FROM EMP WHERE DEPTNO = 20;