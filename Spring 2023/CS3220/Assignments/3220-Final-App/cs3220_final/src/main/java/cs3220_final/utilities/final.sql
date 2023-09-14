drop table if exists readings;
drop table if exists users;

-- Create users table
create table users (
	id int primary key auto_increment,
    name varchar(255) unique not null
);

-- Create readings table
create table readings (
	id int primary key auto_increment,
    systolic int not null,
    diastolic int not null,
    user_id int,
    foreign key (user_id) references users(id),
    time varchar(255)
);

-- Insert initial data into users table
insert into users values ( 1, 'Mom');
insert into users values ( 2, 'Dad');

-- Insert initial data into readings table
insert into readings values ( 1, 110, 90, 1, '3/16/2013 9:01PM');
insert into readings values ( 2, 185, 115, 1, '3/15/2013 8:05PM');
insert into readings values ( 3, 115, 95, 1, '3/14/2013 8:15PM');
