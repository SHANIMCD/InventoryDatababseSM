CREATE DATABASE IF NOT exists inventorydb;
use inventorydb;
CREATE TABLE items (item_id INT NOT NULL auto_increment, item_name varchar(200) not null,price dec(5,2) not null,category varchar(100) not null,primary key (item_id));
CREATE TABLE customer (customer_id int not null auto_increment, first_name varchar(50) not null,last_name varchar(50) not null,address varchar(200) not null,email varchar(50) not null unique,password varchar(30),primary key (customer_id));
CREATE TABLE orders (order_id int not null auto_increment, cust_id_fk int not null,item_id_fk int not null,datetime_placed datetime,primary key (order_id),foreign key (cust_id_fk) references customer(customer_id),foreign key (item_id_fk) references items (item_id));

