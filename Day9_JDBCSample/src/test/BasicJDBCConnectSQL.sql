-- 데이터베이스 선택은 use 구문을 이용함 --
use employees;

show tables;


-- employees 테이블의 모든 컬럼에 대해 모든 row 가져오기 --
select * from employees;

-- employees 테이블에서 여성 직원만 추출 --
select * from employees where gender = 'F';