-- Table만 하나 새롭게 생성해서 사용 --
-- SQL은 대소문자 구분 x
-- 그런데 관용적으로 키워드는 대문자로 쓰고 식별자는 소문자를 이용

CREATE TABLE user (
	id VARCHAR(10) NOT NULL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL
);