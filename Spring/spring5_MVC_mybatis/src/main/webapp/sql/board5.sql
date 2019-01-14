delete table board5;

create table board5(
	board_num number(38) primary key,
	board_name varchar2(50) not null,
	board_pass varchar2(30) not null,
	board_subject varchar2(100) not null,
	board_content varchar2(4000) not null,
	board_re_ref number, --�� �׷��ȣ:�亯��
	board_re_lev number, --�亯�� ���� ����
	board_re_seq number, --�亯�� ȭ�鿡 ���̴� ��ġ
	board_readcount number,
	board_date date
);

delete sequence board5_num_seq;

create sequence board5_num_seq 
	increment by 1
	start with 1 nocache;
--�� ĳ���� ����ϸ� ĳ���� ��ȣ���� �������� �ʴ´�.
--incerment by 1 start �ǹ̴� 1���� �����ؼ� 1�� ����
select * from board5;

--select * from tab;
--commit;