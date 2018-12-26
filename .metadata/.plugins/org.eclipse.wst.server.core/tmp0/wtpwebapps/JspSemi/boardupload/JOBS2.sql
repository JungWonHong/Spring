SET TERMOUT On
SET ECHO On

GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO jobs2 IDENTIFIED BY semi ;
ALTER USER JOBS2 DEFAULT TABLESPACE USERS;
ALTER USER JOBS2 TEMPORARY TABLESPACE TEMP;
CONNECT jobs2/semi


DROP TABLE 기업회원;
DROP TABLE 댓글;
DROP TABLE 채용게시판;
DROP TABLE 기업리스트;
DROP TABLE 기업후기게시판;
DROP TABLE 소스게시판;
DROP TABLE 이력서관리;
DROP TABLE 개인회원;



CREATE TABLE 개인회원(
	아이디 varchar2(40) primary key,
	이름 varchar2(40) not null,
	비밀번호 varchar2(40) not null,
	핸드폰번호 varchar2(40) not null,
	이메일 varchar2(40) not null,
	회원등록일 date default sysdate not null ,
	나이 number not null,
	이력서등록여부 number default 0,
	IT자격증여부 number default 0,
	자기소개 varchar2(4000),
	포트폴리오 varchar2(40)
	) ; 

CREATE TABLE 이력서관리(
	작성자아이디 varchar2(40) not null,
	지원회사 varchar2(40) not null,
	자기소개 varchar2(4000) not null,
	포트폴리오 varchar2(40),
	자격증 varchar2(500),
	foreign key(작성자아이디) references 개인회원(아이디)
	);

CREATE TABLE 기업리스트(
	기업명 varchar2(40) primary key,
	기업대표 varchar2(40) unique not null,
	기업위치 varchar2(100) not null,
	기업업종 varchar2(40) not null,
	기업형태 NUMBER not null,
	근무형태 varchar2(40),
	근무자수 NUMBER not null
	);

CREATE TABLE 기업회원(
	이름 varchar2(40) not null,
	아이디 varchar2(40) primary key,
	비밀번호 varchar2(40) not null,
	이메일 varchar2(40) not null,
	핸드폰번호 varchar2(40) not null,
	기업명 varchar2(40) not null,
	회원등록일 date default sysdate not null
	);
	
CREATE TABLE 기업후기게시판(
	글번호 NUMBER primary key,
	작성일 DATE default sysdate not null,
	글제목 varchar2(50) not null,
	작성자 varchar2(40) not null,
	조회수 NUMBER default 0,
	내용 varchar2(4000) not null,
	기업점수 NUMBER default 0 not null
	);

CREATE TABLE 채용게시판(
	고용형태 NUMBER not null,
	경력 NUMBER not null,
	연봉 NUMBER default 0,
	기술능력 varchar2(50),
	근무시간 varchar2(50),
	제목 varchar2(50) not null,
	마감날짜 date not null,
	글번호 number primary key,
	내용 varchar2(4000) not null,
	기업명 varchar2(40) not null,
	기업사이트 varchar2(100),
	작성일 date default sysdate not null,
	foreign key(기업명) references 기업리스트(기업명)
	);


CREATE TABLE 소스게시판(
	글번호 number primary key,
	제목 varchar2(50) not null,
	작성자 varchar2(40) not null,
	작성일 date default sysdate not null,
	조회수 number default 0,
	내용 varchar2(4000) not null,
	첨부파일 varchar2(100)
	);
	
CREATE TABLE 댓글(
	댓글번호 number primary key,
	작성자 varchar2(40),
	내용 varchar2(400),
	게시글번호 number,
	작성일 date default sysdate not null,
	foreign key(게시글번호) references 소스게시판(글번호)
	);
		

COMMIT;

SET TERMOUT ON
SET ECHO ON