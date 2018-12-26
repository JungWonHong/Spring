drop table goodsinfo;
create table goodsinfo(
	code varchar2(5) primary key,
	name varchar2(30) not null,
	price number(8) not null,
	maker varchar2(20)
);

insert into goodsinfo
values('10001', '디지털 TV', 350000, 'LG');

insert into goodsinfo
values('10002', 'DVD 플레이어', 250000, 'LG');

insert into goodsinfo
values('10003', '디지털 카메라', 210000, '삼성');

insert into goodsinfo
values('10004', '전자사전', 180000, '아이리버');

insert into goodsinfo
values('10005', '벽걸이 에어컨', 400000, '삼성');

select * from goodsinfo;
commit