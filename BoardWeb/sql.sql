CREATE TABLE board (
	post_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    content TEXT,
    author VARCHAR(20) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (author) REFERENCES member(userID)
);

drop table board;
drop table comment;

CREATE TABLE comment (
    comment_id INT AUTO_INCREMENT PRIMARY KEY,
    author VARCHAR(20) NOT NULL,
    content TEXT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    post_id INT,
    FOREIGN KEY (author) REFERENCES member(userID),
    FOREIGN KEY (post_id) REFERENCES board(post_id)
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

SELECT * FROM member