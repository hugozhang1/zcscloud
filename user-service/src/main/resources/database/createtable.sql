--- 建表语句
-- 创建用户表
CREATE TABLE USER (
	id INT not NULL PRIMARY KEY auto_increment,
	name VARCHAR (20) NOT NULL,
	password VARCHAR (20) NOT NULL,
	email VARCHAR (50)
);