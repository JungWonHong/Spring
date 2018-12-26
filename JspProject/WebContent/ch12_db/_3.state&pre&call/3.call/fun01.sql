create table emp12
as
select * from emp;
--영역 설정 후 ALT+X

--프로시저 삭제합니다.
drop procedure del_all

--프로시저 내용을 봅니다.
select * from user_source where name = upper('del_all');

create or replace procedure del_all
is
begin
	delete from emp12;
end;
--영역 설정 후 ALT+C

select * from emp12;

select * from emp;

