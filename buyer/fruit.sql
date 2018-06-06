drop table buyer;
drop table seller;

create table buyer (
	id varchar(10) not null primary key,
	passwd varchar(10) not null,
	money int default 10000,
	apple_count int default 0
);

create table seller (
	id varchar(10) not null primary key,
	passwd varchar(10) not null,
	money int default 0,
	apple_count int default 10,
	apple_price int default 1000
);

insert into buyer(id, passwd) values('b01', '1234');
insert into buyer(id, passwd, money) values('b02', '1234', 100000);
insert into seller(id, passwd) values('s01', '1234');
insert into seller(id, passwd, apple_count) values('s02', '1234', 78);
