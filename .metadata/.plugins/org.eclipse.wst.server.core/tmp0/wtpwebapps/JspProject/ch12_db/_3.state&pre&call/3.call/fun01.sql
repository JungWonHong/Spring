create table emp12
as
select * from emp;
--���� ���� �� ALT+X

--���ν��� �����մϴ�.
drop procedure del_all

--���ν��� ������ ���ϴ�.
select * from user_source where name = upper('del_all');

create or replace procedure del_all
is
begin
	delete from emp12;
end;
--���� ���� �� ALT+C

select * from emp12;

select * from emp;

