SET TERMOUT On
SET ECHO On

GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO jobs IDENTIFIED BY semi ;
ALTER USER JOBS DEFAULT TABLESPACE USERS;
ALTER USER JOBS TEMPORARY TABLESPACE TEMP;
CONNECT jobs/semi

DROP TABLE EVENT_BOARD;
DROP TABLE E_MEMBER;
DROP TABLE COMMENTS;
DROP TABLE RECRUIT_BOARD;
DROP TABLE E_LIST;
DROP TABLE REVIEW_BOARD;
DROP TABLE SOURCE_BOARD;
DROP TABLE RESUME;
DROP TABLE P_MEMBER;



CREATE TABLE P_MEMBER(
	p_id varchar2(40) primary key,
	p_name varchar2(40) not null,
	p_pw varchar2(40) not null,
	p_hp varchar2(40) not null,
	p_email varchar2(40) not null,
	p_regdate date default sysdate not null ,
	p_age number not null,
	p_resume number default 0,
	p_certi number default 0,
	p_comment varchar2(4000),
	p_portpolio varchar2(40)
	) ; 

CREATE TABLE RESUME(
	r_id varchar2(40) not null,
	r_company varchar2(40) not null,
	r_content varchar2(4000) not null,
	r_file varchar2(40),
	r_certi varchar2(500),
	foreign key(r_id) references P_MEMBER(p_id)
	);

CREATE TABLE E_LIST(
	el_company varchar2(40) primary key,
	el_head varchar2(40) unique not null,
	el_loc varchar2(100) not null,
	el_part varchar2(40) not null,
	el_forms NUMBER not null,
	el_environment varchar2(40),
	el_workernum NUMBER not null
	);

CREATE TABLE E_MEMBER(
	e_memname varchar2(40) not null,
	e_id varchar2(40) primary key,
	e_pw varchar2(40) not null,
	e_email varchar2(40) not null,
	e_phone varchar2(40) not null,
	e_company varchar2(40) not null,
	e_regdate date default sysdate not null
	);
	
CREATE TABLE REVIEW_BOARD(
	rv_no NUMBER primary key,
	rv_date DATE default sysdate not null,
	rv_title varchar2(50) not null,
	rv_id varchar2(40) not null,
	rv_count NUMBER default 0,
	rv_content varchar2(4000) not null,
	rv_score NUMBER default 0 not null
	);

CREATE TABLE RECRUIT_BOARD(
	rc_hirekind NUMBER not null,
	rc_career NUMBER not null,
	rc_sal NUMBER default 0,
	rc_ability varchar2(50),
	rc_worktime varchar2(50),
	rc_title varchar2(50) not null,
	rc_expire date not null,
	rc_no number primary key,
	rc_content varchar2(4000) not null,
	rc_company varchar2(40) not null,
	rc_url varchar2(100),
	rc_date date default sysdate not null,
	foreign key(rc_company) references E_LIST(el_company)
	);

CREATE TABLE EVENT_BOARD(
	eb_no number primary key,
	eb_date date default sysdate not null,
	eb_expire date not null,
	eb_title varchar2(50) not null,
	eb_content varchar2(4000)
	);

CREATE TABLE SOURCE_BOARD(
	sb_no number primary key,
	sb_title varchar2(50) not null,
	sb_id varchar2(40) not null,
	sb_date date default sysdate not null,
	sb_count number default 0,
	sb_content varchar2(4000) not null,
	sb_file varchar2(100)
	);
	
CREATE TABLE COMMENTS(
	com_no number primary key,
	com_id varchar2(40),
	com_content varchar2(400),
	com_re_ref number,
	com_date date default sysdate not null,
	foreign key(com_re_ref) references SOURCE_BOARD(sb_no)
	);
		

COMMIT;

SET TERMOUT ON
SET ECHO ON