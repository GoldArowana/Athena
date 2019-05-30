create table daily_sign
(
	id bigint auto_increment primary key,
	staff_id bigint null,
	insert_time timestamp default CURRENT_TIMESTAMP null
);

create index daily_sign_staff_id_index
	on daily_sign (staff_id);

