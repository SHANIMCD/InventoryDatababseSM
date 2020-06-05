insert into items (item_name, price, category) values ('prawn crackers', 0.99, 'appetizer' );
insert into items (item_name, price, category) values ('hot and sour soup', 3.99, 'appetizer' );
insert into items (item_name, price, category) values ('salt and pepper spare ribs', 5.99, 'appetizer' );
insert into customer (first_name, last_name, address, email, password) values ('Jenny', 'Lopez', 'the block', 'jlo@email.com', 'blahblah');
insert into orders (cust_id_fk, item_id_fk) values (1, 2);
insert into orders (cust_id_fk, item_id_fk) values (1, 1);

