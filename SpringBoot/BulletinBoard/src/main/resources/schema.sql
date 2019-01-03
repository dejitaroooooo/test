drop database if exists messages;
create database messages;

use messages;

drop table if exists message;

create table message(
id int(8) primary key auto_increment,
name varchar(255),
text varchar(255),
remoteAddr varchar(255),
createdAt Timestamp
);

insert into message (name, text, remoteAddr, createdAt)
values ('taro','test', 'aaa','2016-06-06');
