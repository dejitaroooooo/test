set names utf8;
set foreign_key_checks = 0;
drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;

create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
insert_date datetime,
updated_date datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(30),
item_genre varchar(30),
item_price int,
item_stock int,
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
delete_date datetime
);

drop table if exists genre_transaction;

create table genre_transaction(
id int not null primary key auto_increment,
genre_id int unique,
genre_name varchar(20) unique,
insert_date datetime,
update_date datetime
);

insert into genre_transaction(genre_id, genre_name, insert_date) values(1, "文房具", now());
insert into genre_transaction(genre_id, genre_name, insert_date) values(2, "家具", now());
insert into genre_transaction(genre_id, genre_name, insert_date) values(3, "家電", now());
insert into genre_transaction(genre_id, genre_name, insert_date) values(4, "食材", now());

insert into item_info_transaction(item_name, item_genre, item_price, item_stock, insert_date) values("ノートブック", "文房具", 100, 50, now());
insert into item_info_transaction(item_name, item_genre, item_price, item_stock, insert_date) values("消しゴム", "文房具", 100, 50, now());
insert into item_info_transaction(item_name, item_genre, item_price, item_stock, insert_date) values("シャープペンシル", "文房具", 100, 50, now());
insert into item_info_transaction(item_name, item_genre, item_price, item_stock, insert_date) values("ベッド", "家具", 10000, 5, now());
insert into item_info_transaction(item_name, item_genre, item_price, item_stock, insert_date) values("本棚", "家具", 5000, 5, now());
insert into item_info_transaction(item_name, item_genre, item_price, item_stock, insert_date) values("エアコン", "家電", 100, 50, now());
insert into item_info_transaction(item_name, item_genre, item_price, item_stock, insert_date) values("洗濯機", "家電", 100, 50, now());
insert into item_info_transaction(item_name, item_genre, item_price, item_stock, insert_date) values("そうめん", "食材", 300, 50, now());
insert into item_info_transaction(item_name, item_genre, item_price, item_stock, insert_date) values("ひやむぎ", "食材", 300, 50, now());
insert into item_info_transaction(item_name, item_genre, item_price, item_stock, insert_date) values("そば", "食材", 300, 50, now());
insert into login_user_transaction(login_id, login_pass, user_name, insert_date) values("yamada", "taro", "test", now());
insert into login_user_transaction(login_id, login_pass, user_name, insert_date) values("internous", "internous01", "test", now());