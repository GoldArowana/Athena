CREATE DATABASE `athena_aries` character set utf8mb4;
use `athena_aries`;
create table department
(
	id int auto_increment comment '部门id'
		primary key,
	department_name varchar(100) null,
	leader_id int default 0 null comment '部门管理者，部长',
	up_id int default 0 null comment '上级部门id'
);

create table athena_aries.staff
(
	id int auto_increment primary key,
	fullname varchar(20) null comment '全名',
	alias_name int null comment '别名',
	sex smallint(6) default 0 null comment '性别。0表示未设置。1表示男。2表示女。',
	email varchar(100) null,
	phone varchar(20) null,
	qq varchar(20) null,
	wechat varchar(20) null,
	job_level varchar(20) null comment '职级',
	job_group int null comment '职位类别。如"后台开发"',
	on_job tinyint(1) default 1 null comment '是否在职, 0不在职, 1在职',
	department_id int null comment '所属部门id',
	country_id smallint(6) null comment '国家编码。',
	city_id int null comment '城市id',
	gaea_account varchar(20) null comment '员工账号',
	employee_id varchar(40) null comment '员工号',
	identity_id int null comment '身份id。对应身份表里的身份信息。在中国指的是身份证相关信息。',
	address varchar(20) null comment '现住址',
	join_time timestamp default CURRENT_TIMESTAMP null comment '入职时间'
)
comment '员工信息';

create index staff_gaea_account_index
	on athena_aries.staff (gaea_account);

