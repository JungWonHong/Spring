drop table board;

CREATE TABLE BOARD11(
	BOARD_NUM		NUMBER,				--글 번호
	BOARD_NAME		VARCHAR2(30),		--작성자
	BOARD_PASS		VARCHAR2(30),		--비밀번호
	BOARD_SUBJECT	VARCHAR2(300),		--제목
	BOARD_CONTENT	VARCHAR2(4000),		--내용
	BOARD_FILE		VARCHAR2(50),		--첨부될 파일 명
	BOARD_RE_REF	NUMBER,				--답변 글 작성시 참조되는 글의 번호
	BOARD_RE_LEV	NUMBER,				--답변 글의 깊이
	BOARD_RE_SEQ	NUMBER,				--답변 글의 순서
	BOARD_READCOUNT	NUMBER,				--글의 조회수
	BOARD_DATE	DATE,					--글의 작성 날짜
	PRIMARY KEY(BOARD_NUM)
);

create sequence board11_seq
start with 1
increment by 1

select * from board11;

delete from board11;

select * 
from board
order by BOARD_RE_REF desc, BOARD_RE_SEQ asc