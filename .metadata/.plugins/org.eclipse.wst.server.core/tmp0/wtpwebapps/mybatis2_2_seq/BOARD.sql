drop table board11 purge;
drop sequence board11_seq;

CREATE TABLE BOARD11(
	BOARD_NUM		NUMBER,				--�� ��ȣ
	BOARD_NAME		VARCHAR2(30),		--�ۼ���
	BOARD_PASS		VARCHAR2(30),		--��й�ȣ
	BOARD_SUBJECT	VARCHAR2(300),		--����
	BOARD_CONTENT	VARCHAR2(4000),		--����
	BOARD_FILE		VARCHAR2(50),		--÷�ε� ���� ��
	BOARD_RE_REF	NUMBER,				--�亯 �� �ۼ��� �����Ǵ� ���� ��ȣ
	BOARD_RE_LEV	NUMBER,				--�亯 ���� ����
	BOARD_RE_SEQ	NUMBER,				--�亯 ���� ����
	BOARD_READCOUNT	NUMBER,				--���� ��ȸ��
	BOARD_DATE	DATE,					--���� �ۼ� ��¥
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