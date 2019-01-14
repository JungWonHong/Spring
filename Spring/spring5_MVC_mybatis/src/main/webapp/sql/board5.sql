delete table board5;

create table board5(
	board_num number(38) primary key,
	board_name varchar2(50) not null,
	board_pass varchar2(30) not null,
	board_subject varchar2(100) not null,
	board_content varchar2(4000) not null,
	board_re_ref number, --글 그룹번호:답변글
	board_re_lev number, --답변글 레벨 순서
	board_re_seq number, --답변글 화면에 보이는 위치
	board_readcount number,
	board_date date
);

delete sequence board5_num_seq;

create sequence board5_num_seq 
	increment by 1
	start with 1 nocache;
--노 캐쉬를 사용하면 캐쉬에 번호값을 저장하지 않는다.
--incerment by 1 start 의미는 1부터 시작해서 1씩 증가
select * from board5;

--select * from tab;
--commit;