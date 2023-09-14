drop table if exists tasks;

create table tasks(
	id 				integer auto_increment primary key,
	task			varchar(255),
	detail			varchar(255),
    status			varchar(255) default 'New',
    user_id			integer default 0 references user(id)
	
);

insert into tasks (task, detail, status, user_id) values ('Call', 
	'Followup with Joe, call him at (234) 567-8901', 'In-Progress', 1);
insert into tasks (task, detail, status, user_id) values ('Email', 
	'Send an email to the manager to report the water leak', 'In-Progress', 2);
insert into tasks (task, detail, user_id) values ('Order', 
	'Order more ink for the printer', 0);

drop table if exists users;

create table users(
	id				integer auto_increment primary key,
	name			varchar(255)
);

insert into users (name) value ('John');
insert into users (name) value ('Jim');
insert into users (name) value ('Joe');