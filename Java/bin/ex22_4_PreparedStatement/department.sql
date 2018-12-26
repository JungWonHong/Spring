drop table DEPARTMENT;
CREATE TABLE DEPARTMENT(
  DEPTNO    NUMBER(3,0)  PRIMARY KEY,
  DNAME     VARCHAR2(30) NOT NULL,
  COLLEGE   NUMBER(3,0)  NOT NULL,
  LOC       VARCHAR2(10) NOT NULL
);

insert into department values(203, '소프트웨어 공학과', 200, '201호');
insert into department values(205, '컴퓨터 공학과', 500, '501호');
select * from department;
delete department where deptno = 255;
commit