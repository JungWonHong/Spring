
create table emp13
as
select * from emp;
--영역 설정 후 ALT+X

create or replace procedure
	del_name(vename emp.ename%TYPE)
is
begin
	delete from emp13 where ename = vename;
end;
--영역 설정 후 ALT+C

select * from emp13

drop table emp13

SELECT num, name FROM STUDENT;