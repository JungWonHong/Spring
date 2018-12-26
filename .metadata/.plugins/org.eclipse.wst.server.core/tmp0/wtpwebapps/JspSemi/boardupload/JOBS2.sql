SET TERMOUT On
SET ECHO On

GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO jobs2 IDENTIFIED BY semi ;
ALTER USER JOBS2 DEFAULT TABLESPACE USERS;
ALTER USER JOBS2 TEMPORARY TABLESPACE TEMP;
CONNECT jobs2/semi


DROP TABLE ���ȸ��;
DROP TABLE ���;
DROP TABLE ä��Խ���;
DROP TABLE �������Ʈ;
DROP TABLE ����ı�Խ���;
DROP TABLE �ҽ��Խ���;
DROP TABLE �̷¼�����;
DROP TABLE ����ȸ��;



CREATE TABLE ����ȸ��(
	���̵� varchar2(40) primary key,
	�̸� varchar2(40) not null,
	��й�ȣ varchar2(40) not null,
	�ڵ�����ȣ varchar2(40) not null,
	�̸��� varchar2(40) not null,
	ȸ������� date default sysdate not null ,
	���� number not null,
	�̷¼���Ͽ��� number default 0,
	IT�ڰ������� number default 0,
	�ڱ�Ұ� varchar2(4000),
	��Ʈ������ varchar2(40)
	) ; 

CREATE TABLE �̷¼�����(
	�ۼ��ھ��̵� varchar2(40) not null,
	����ȸ�� varchar2(40) not null,
	�ڱ�Ұ� varchar2(4000) not null,
	��Ʈ������ varchar2(40),
	�ڰ��� varchar2(500),
	foreign key(�ۼ��ھ��̵�) references ����ȸ��(���̵�)
	);

CREATE TABLE �������Ʈ(
	����� varchar2(40) primary key,
	�����ǥ varchar2(40) unique not null,
	�����ġ varchar2(100) not null,
	������� varchar2(40) not null,
	������� NUMBER not null,
	�ٹ����� varchar2(40),
	�ٹ��ڼ� NUMBER not null
	);

CREATE TABLE ���ȸ��(
	�̸� varchar2(40) not null,
	���̵� varchar2(40) primary key,
	��й�ȣ varchar2(40) not null,
	�̸��� varchar2(40) not null,
	�ڵ�����ȣ varchar2(40) not null,
	����� varchar2(40) not null,
	ȸ������� date default sysdate not null
	);
	
CREATE TABLE ����ı�Խ���(
	�۹�ȣ NUMBER primary key,
	�ۼ��� DATE default sysdate not null,
	������ varchar2(50) not null,
	�ۼ��� varchar2(40) not null,
	��ȸ�� NUMBER default 0,
	���� varchar2(4000) not null,
	������� NUMBER default 0 not null
	);

CREATE TABLE ä��Խ���(
	������� NUMBER not null,
	��� NUMBER not null,
	���� NUMBER default 0,
	����ɷ� varchar2(50),
	�ٹ��ð� varchar2(50),
	���� varchar2(50) not null,
	������¥ date not null,
	�۹�ȣ number primary key,
	���� varchar2(4000) not null,
	����� varchar2(40) not null,
	�������Ʈ varchar2(100),
	�ۼ��� date default sysdate not null,
	foreign key(�����) references �������Ʈ(�����)
	);


CREATE TABLE �ҽ��Խ���(
	�۹�ȣ number primary key,
	���� varchar2(50) not null,
	�ۼ��� varchar2(40) not null,
	�ۼ��� date default sysdate not null,
	��ȸ�� number default 0,
	���� varchar2(4000) not null,
	÷������ varchar2(100)
	);
	
CREATE TABLE ���(
	��۹�ȣ number primary key,
	�ۼ��� varchar2(40),
	���� varchar2(400),
	�Խñ۹�ȣ number,
	�ۼ��� date default sysdate not null,
	foreign key(�Խñ۹�ȣ) references �ҽ��Խ���(�۹�ȣ)
	);
		

COMMIT;

SET TERMOUT ON
SET ECHO ON