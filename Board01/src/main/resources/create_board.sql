create database board;
use board;

create table users(
	id varchar(8) primary key,
	password varchar(8),
	name varchar(20),
	role varchar(5)
);

create table board(
	seq int auto_increment primary key,
	title varchar(200),
	writer varchar(20),
	content varchar(2000),
	regdate datetime default current_timestamp,
	cnt int default 0
);

insert into users values('test', 'test123', '관리자', 'Admin');
insert into users values('user1', 'user1', '홍길동', 'User');

insert into board(title, writer, content) values('가입인사', '관리자', 'ㅋㅋㅋ');
