create database productdb;

use productdb;

create table product(
id int AUTO_INCREMENT primary KEY,
name varchar(20) UNIQUE,
description varchar(50) UNIQUE,
price decimal (10,3)
);

select * from product;

