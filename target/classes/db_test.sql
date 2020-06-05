CREATE DATABASE IF NOT EXISTS gamesdb;
use gamesdb;
CREATE TABLE customer (
    customer_ID INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    email VARCHAR(50),
    password VARCHAR(30),
    PRIMARY KEY (customer_ID)
);

DESCRIBE customer;


CREATE TABLE games (
	product_ID INT NOT NULL auto_increment,
    product_name varchar(200) NOT NULL,
    quantity INT NOT NULL,
    price dec(3,2),
	primary key (product_ID)
);

DROP TABLE games;
    
CREATE TABLE orders (
	order_ID INT NOT NULL auto_increment,
    fk_customer_ID INT NOT NULL,
    placed DATE,
    total DEC(7 , 2 ),
    primary key (order_ID),
	foreign key(fk_customer_ID) references customer(customer_ID)
);

DROP TABLE orders;


# number of orders placed by each customer
select * from orders;
select * from customer;

SELECT count(*) as orders_placed, fk_customer_id from orders group by fk_customer_ID;

insert into orders (fk_customer_ID)
values (1),(3),(4),(5),(6),(7),(8);

# Grouped by cust id
# counted the orders with the count
# set the alias as orders placed



CREATE TABLE orderline (
	line_ID INT NOT NULL auto_increment,
    fk_order_ID INT NOT NULL,
    fk_product_ID INT NOT NULL,
    qty_items INT,
    primary key (line_ID),
    foreign key (fk_order_ID) references orders (order_ID),
    foreign key (fk_product_ID) references games (product_ID)
);

DESCRIBE orderline;

INSERT INTO customer (name, address, email, password)
VALUES ('Shani', 'The Whitehouse', 'shani@email.com', 'somePassword');

INSERT INTO customer (name, address, email, password)
VALUES ('Simone', 'Downing Street', 'simone@email.com', 'somePassword');

INSERT INTO customer (name, address, email, password)
VALUES ('Katie', 'Four Seasons', 'katie@email.com', 'somePassword');

INSERT INTO customer (name, address, email, password, age)
VALUES ('Andre', 'The Moon', 'andre@email.com', 'apassword', 30);

INSERT INTO customer (name, address, email, password, age)
VALUES ('Andrew', 'Saturn', 'andrew@email.com', 'password', 30);

describe customer;
SELECT * FROM customer;
SELECT name, address from customer;
SELECT distinct(address) from customer;

SELECT * from customer WHERE age BETWEEN 23 AND 30;

SELECT city, AVG(age) from customer;


SELECT * FROM games;

DELETE FROM customer WHERE (customer_ID = 2); 

ALTER TABLE customer
ADD postcode varchar(20) NOT NULL DEFAULT 'not specified';

ALTER TABLE customer
ADD city varchar(15) DEFAULT 'undeclared';

ALTER TABLE customer
ADD age INT(100) NOT NULL DEFAULT 18;

ALTER TABLE games
ADD release_date DATE NOT NULL;



UPDATE customer
SET name = 'Shani', password = 'newPassword', age = 27
WHERE customer_ID = 1;


update customer
SET city = 'Edinburgh' 
where customer_ID = 4;

 update customer
 SET postcode = 'newpostcode'
WHERE customer_ID BETWEEN 1 AND 8;




# Create an sql, that accumulates the total money earned (in the day)
CREATE DATABASE IF NOT EXISTS shopdb;
use shopdb;

CREATE TABLE sales (
	id INT NOT NULL auto_increment,
    itemName varchar(50) NOT NULL,
    itemPrice DEC(3,2) NOT NULL,
    datePurchased timestamp default CURRENT_TIMESTAMP,
    primary key (id)
);

describe sales;

insert into sales (itemName, itemPrice)
VALUES ('bread', 0.90);


insert into sales (itemName, itemPrice)
VALUES ('oranges', 1.90);

select * from sales ORDER BY itemPrice DESC;

# count
select itemName, count(itemPrice) from sales group by itemName;

# Sum
select itemName, sum(itemPrice) as total_amount_taken from sales group by itemName order by SUM(itemPrice) DESC;



 




