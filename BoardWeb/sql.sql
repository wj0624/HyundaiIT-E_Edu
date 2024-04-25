CREATE TABLE board (
	post_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    content TEXT,
    author VARCHAR(20) NOT NULL,
    name VARCHAR(20) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE board DROP FOREIGN KEY author;
ALTER TABLE board ADD CONSTRAINT fk_author FOREIGN KEY (author) REFERENCES member(userID) ON DELETE NO ACTION ON UPDATE CASCADE;


drop table board;
drop table comment;

CREATE TABLE comment (
    comment_id INT AUTO_INCREMENT PRIMARY KEY,
    userID VARCHAR(20) NOT NULL,
    userName VARCHAR(20) NOT NULL,
    content TEXT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    post_id INT
);

CREATE TABLE member (
    userID VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20) NOT NULL,
    name VARCHAR(20) NOT NULL,
    birthday DATE,
    gender CHAR(1) CHECK (gender IN ('M', 'F'))
);

ALTER TABLE member
MODIFY COLUMN gender VARCHAR(1) CHECK (gender IN ('M', 'F'));

ALTER TABLE member
MODIFY COLUMN birthday VARCHAR(20);

SELECT * from member;
SELECT * from board;
DELETE FROM board WHERE post_id = 1;

SELECT b.post_id, b.title, b.content, m.name, b.created_date
FROM board b JOIN member m ON b.author = m.userID;

SELECT b.post_id, b.title, b.content, m.name, b.author, b.created_date
FROM board b JOIN member m ON b.author = m.userID
WHERE b.post_id = 2;

UPDATE board
SET title = "수정할래",
	content = "수정하고싶어"
WHERE post_id = 4;

SELECT name FROM member WHERE userID = "hi";
INSERT INTO board (title, content, author, name)
VALUES ("제목", "내용", "hi", (SELECT name FROM member WHERE userID = "hi"));

SELECT post_id, title, content, name, created_date
FROM board
ORDER BY post_id DESC;

SELECT post_id, title, content, name, created_date
FROM board
WHERE post_id = ${post_id}