create table products(
	id			number(11),
	name		varchar2(50),
	modelnumber	varchar2(15),
	series		varchar2(30)
);

select * from products;

select count(*) from products;

select max(id) from products;