create table products(
	id			number(11),
	name		varchar2(50),
	modelnumber	varchar2(15),
	series		varchar2(30)
)

select * from products;

insert into products values(1, '핸드폰', '갤럭시', 'S2');
insert into products values(2, '핸드폰', '갤럭시', 'S8');

delete from products where id > 4;

delete from products;