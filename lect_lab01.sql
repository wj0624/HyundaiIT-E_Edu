-- 4-4 ������(��)
select * from emp;

-- 4-5 ��������(��)
select empno, ename, deptno
from emp;

-- 4-6 �ߺ�����
select DISTINCT deptno
from emp;

-- 4-7 �ߺ�����(��å, �μ���ȣ)
select DISTINCT job, deptno
from emp;

-- 4-8 �ߺ����
select all job, deptno
from emp;

-- 4-9 �ǽ� ����
-- ������̺��� �����, ����, ������ ����ϼ���
select ename, sal, sal*12+comm
from emp;

/*--------------5/3--------------*/

-- 4-11
-- ������̺��� �����, ����, ������ ��� ������ ANNSAL�� ���
select ename, sal, sal*12+NVL(comm, 0) as annsal
from emp;

-- ������� ���� �� �μ���ȣ�� �μ����� ����Ͻÿ�
-- ��, �׸���� "�μ���", "�μ���ȣ"�� ����Ͻÿ�
select deptno as "�μ���ȣ", dname as "�μ���"
from dept;

-- 4-12
-- ��������� ���޼����� �����Ͽ� ���
select *
from emp
order by sal;   --asc

-- 4-13
-- ��������� ���޿������� �����Ͽ� ���
select *
from emp
order by sal desc;

-- 4-14
-- ������̺��� ��ü���� �μ���ȣ(��������), �޿�(��������)���� �����Ͽ� ���
select *
from emp
order by deptno asc, sal desc;

-- p92, Q2
select DISTINCT job
from emp

-- p92, Q3
select EMPNO EMPLOYEE_NO, 
        ENAME EMPLOYEE_NAME,
        MGR MANAGER,
        SAL SALARY, 
        COMM COMMISSION,
        DEPTNO DEPARTMENT_NO,
        sal*12+comm ANNSAL
from emp
order by deptno desc, ename, annsal;

SELECT DEPTNO AS �μ���ȣ,
           DEPTNO AS "�μ� ��ȣ1",
           SAL*12+COMM AS ANNSAL,
           SAL*12+COMM AS "ANNSAL1"
FROM EMP
ORDER BY "�μ� ��ȣ1" DESC;

-- 5-2
-- ��� �� �μ���ȣ�� 30�� ����� ���
SELECT *
FROM EMP
WHERE DEPTNO=30;

-- �����ȣ�� 7782�� ����� ���
SELECT *
FROM EMP
WHERE EMPNO = 7782;

-- 5-4
-- �μ���ȣ�� 20�̰ų� ��å�� SALESMAN�� ���
SELECT *
FROM EMP
WHERE DEPTNO = 20 OR
            JOB = 'SALESMAN';
            
-- 5-5
-- ������ 36000�� ���
SELECT *
FROM EMP
WHERE (SAL*12) = 36000;

SELECT *
FROM EMP
WHERE SAL >= 2500 AND
           JOB = 'ANALYST';
            
/* ��� ��������� 1�� ���� �Ѿ��� ANNSAL�� ���� �Ѿ׼����� �����ؼ� ����Ͻÿ�
    ��, ���� �Ѿ��� 36000 �̾�� �� */

SELECT EMP.*, SAL*12 AS ANLSAL
FROM EMP
WHERE SAL*12 = 36000
ORDER BY ANLSAL DESC;

-- 5-7
-- �̸� ù���ڰ� 'F' ���ķ� �����ϴ� ����� ���
SELECT *
FROM EMP
WHERE ENAME >= 'F';

-- 5-9
-- �޿��� 3000�� �ƴ� ����� ���
-- 1) != ���
SELECT *
FROM EMP
WHERE SAL != 3000;

-- 2) <> ���
SELECT *
FROM EMP
WHERE SAL <> 3000;

-- 3) ^= ���
SELECT *
FROM EMP
WHERE SAL ^= 3000;

-- 4) NOT ���
SELECT *
FROM EMP
WHERE NOT SAL = 3000;

-- 5-12
SELECT *
FROM EMP
WHERE NOT SAL = 3000;

-- ��å�� 'MANAGER', 'SALESMAN'�� ����� ����Ͻÿ�(�ΰ��� ���)
-- 1)
SELECT *
FROM EMP
WHERE JOB = 'MANAGER' OR JOB = 'SALESMAN';

-- 2)
SELECT *
FROM EMP
WHERE JOB IN ('MANAGER', 'SALESMAN');

-- ��å�� 'MANAGER', 'SALESMAN'�� ������ ����� ����Ͻÿ�(�ΰ��� ���)
-- 1)
SELECT *
FROM EMP
WHERE JOB != 'MANAGER' AND JOB != 'SALESMAN';

-- 2)
SELECT *
FROM EMP
WHERE JOB NOT IN ('MANAGER', 'SALESMAN');

-- �޿��� 2000���� 3000 ������ ����� ��� ����Ͻÿ�
SELECT *
FROM EMP
WHERE SAL >= 2000 AND
            SAL <= 3000;

SELECT *
FROM EMP
WHERE SAL BETWEEN 2000 AND 3000;

-- �޿��� 2000 �̸� 3000���� ū ����� ��� ����Ͻÿ�
SELECT *
FROM EMP
WHERE SAL < 2000 OR
            SAL > 3000;
            
SELECT *
FROM EMP
WHERE SAL NOT BETWEEN 2000 AND 3000;

-- ����� 'S'�� ���۵Ǵ� ����� ����Ͻÿ�
SELECT *
FROM EMP
WHERE ENAME LIKE 'S%';

-- ������� �ι�° ���ڰ� L�� ����� ����Ͻÿ�
SELECT *
FROM EMP
WHERE ENAME LIKE '_L%';

-- ����� �� AM�� ���Ե� ����� ����Ͻÿ�
SELECT *
FROM EMP
WHERE ENAME LIKE '%AM%';

SELECT *
FROM EMP
WHERE ENAME LIKE '%\%%';

-- ����� �� AM�� ���Ե��� �ʴ� ����� ����Ͻÿ�
SELECT *
FROM EMP
WHERE ENAME NOT LIKE '%AM%';

-- ����� ��� ������ ����ϰ�, ����(����*12 +����)�� ����Ͽ� ���
-- ��, ������ NULL �� ����� �����Ͻÿ�
SELECT EMP.*, SAL*12+COMM AS ANNSAL
FROM EMP
WHERE COMM IS NOT NULL;

SELECT EMP.*, SAL*12+COMM AS ANNSAL
FROM EMP
WHERE COMM = NULL;

-- �Ŵ����� ���� ���
SELECT *
FROM EMP
WHERE MGR IS NULL;

-- 5-28
SELECT *
FROM EMP
WHERE SAL > NULL AND
    COMM IS NULL;
    
SELECT *
FROM EMP
WHERE SAL > NULL;

SELECT *
FROM EMP
WHERE COMM IS NULL;

SELECT *
FROM EMP
WHERE SAL > NULL
            OR COMM IS NULL;
            
-- 5-34            
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO =10
UNION
SELECT MGR, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO = 20
UNION
SELECT DEPTNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO = 30
UNION
SELECT DEPTNO, DNAME, 0, DEPTNO
FROM DEPT
WHERE DEPTNO = 30;

-- 5-35
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO =10
UNION ALL
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO = 10;

-- 5-37
-- ��ü ��� �� �μ���ȣ�� 10�� ������� ��� - ������
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
INTERSECT
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO=10;


-- ��ü ��� �� �μ���ȣ�� 10�� �ƴ� ������� ���
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
MINUS
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO=10;

/* p.125 ���� */
--INSERT INTO EMP VALUES
--            (7876, 'ADAMS', 'CLERK', 7788,
--            TO_DATE('12-01-1983', 'DD-MM-YYYY'), 1100, NULL, 20);
--INSERT INTO EMP VALUES
--            (7788, 'SCOTT', 'ANALYST', 7566,
--            TO_DATE('09-12-1982', 'DD-MM-YYYY'), 3000, NULL, 20);

-- Q1. ��� �̸��� S�� ������ ��� �����͸� ���
SELECT *
FROM EMP
WHERE ENAME LIKE '%S';

-- Q2. 30�� �μ����� �ٹ��ϴ� ��� �� SALESMAN�� �����
--      �����ȣ, �̸�, ��å, �޿�, �μ���ȣ ���
SELECT EMPNO, ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE DEPTNO = 30 AND JOB = 'SALESMAN';

-- Q3. 20, 30�� �μ��� �ٹ��ϴ� ��� �� �޿��� 2000 �ʰ��� �����
--      �ΰ��� ������� ��� ��ȣ, �̸�, �޿�, �μ���ȣ ���
-- 1) ���տ����� ��� X
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO IN (20, 30) AND SAL > 2000;

-- 2) ���տ����� ��� O
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO IN (20, 30)
INTERSECT
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE SAL > 2000;

-- Q4. NOT BETWEEN A AND B �����ڸ� ���� �ʰ�, SAL�� 2000 �̻� 3000 ����
--      ���� �̿��� ���� ���� ������ ���
SELECT *
FROM EMP
WHERE SAL < 2000 OR SAL > 3000
ORDER BY EMPNO;

-- Q5. ����̸��� E�� ���ԵǾ� �ִ� 30�� �μ� ��� �� 
--       �޿��� 1000~2000 ���̰� �ƴ� ����̸�, �����ȣ, �޿�, �μ���ȣ�� ���
SELECT ENAME, EMPNO, SAL, DEPTNO
FROM EMP
WHERE  ENAME LIKE '%E%'
            AND DEPTNO = 30
            AND SAL NOT BETWEEN 1000 AND 2000;
            
-- Q6. �߰� ������ �������� �ʰ�, ����ڰ� �ְ�, ��å�� MANAGER, CLERK�̰�
--      �ι�° ���ڰ� L�� �ƴ� ��� ���
SELECT *
FROM EMP
WHERE COMM IS NULL
            AND MGR IS NOT NULL
            AND JOB IN ('MANAGER', 'CLERK')
            AND ENAME NOT LIKE '_L%';