drop table DEPARTMENT;
CREATE TABLE DEPARTMENT(
  DEPTNO    NUMBER(3,0)  PRIMARY KEY,
  DNAME     VARCHAR2(30) NOT NULL,
  COLLEGE   NUMBER(3,0)  NOT NULL,
  LOC       VARCHAR2(10) NOT NULL
);

insert into department values(203, '����Ʈ���� ���а�', 200, '201ȣ');
insert into department values(205, '��ǻ�� ���а�', 500, '501ȣ');
select * from department;
delete department where deptno = 255;
commit