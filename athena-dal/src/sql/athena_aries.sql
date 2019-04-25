CREATE DATABASE `athena_aries`; /* 创建数据库 */


-- auto-generated definition
create table department
(
    id              int auto_increment comment '部门id'
        primary key,
    department_name varchar(100) null,
    leader_id       int          null comment '部门管理者，部长',
    up_id           int          null comment '上级部门id'
);



create table athena_aries.staff
(
	id int null,
	fullname varchar(20) null comment '全名',
	alias_name int null comment '别名',
	sex smallint(6) default 0 null comment '性别。0表示未设置。1表示男。2表示女。',
	email varchar(100) null,
	phone varchar(20) null,
	qq varchar(20) null,
	wechat varchar(20) null,
	job_level varchar(20) null comment '职级',
	on_job tinyint(1) default 0 null comment '是否在职',
	department_id int null comment '所属部门id',
	country_id smallint(6) null comment '国家编码。',
	city_id int null comment '城市id',
	gaea_id varchar(20) null comment '员工账号',
	employee_id varchar(40) null comment '员工号',
	identity_id int null comment '身份id。对应身份表里的身份信息。在中国指的是身份证相关信息。',
	address varchar(20) null comment '现住址',
	join_time timestamp default CURRENT_TIMESTAMP null comment '入职时间',
	constraint staff_pk
		unique (id)
)
comment '员工信息';

create index staff_gaea_id_index
	on athena_aries.staff (gaea_id);

