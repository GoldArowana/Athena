
CREATE DATABASE `athena` character set utf8mb4;

create table partner
(
	id int auto_increment
		primary key,
	company_id int null,
	company_name varchar(100) null,
	password varchar(100) null,
	keyword varchar(32) null,
	insert_time timestamp default CURRENT_TIMESTAMP null,
	update_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

create index paterners_keyword_index
	on partner (keyword);

