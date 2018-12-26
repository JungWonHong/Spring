select * 
  from (select rownum rnum, p_age, p_certi, p_comment, p_email, p_hp, p_id, p_name, p_portpolio 
  		from (select * from p_member where p_resume = 0));

select * 
  from (select rownum rnum, sb_no, sb_date, sb_title, sb_id, sb_count 
  		from source_board 
  		order by sb_no desc) 
  where rnum>=1 and rnum<=10
select * from comments;
delete from COMMENTS;
select * from P_MEMBER;
select * from E_MEMBER;
select * from E_LIST;
select * from SOURCE_BOARD;
select * from review_board;
select * from RECRUIT_BOARD where RC_EXPIRE>sysdate ORDER BY RC_EXPIRE;
delete from RECRUIT_BOARD;
select EL_LOC from E_LIST where EL_COMPANY = '�Ｚ����';
drop table comments;
drop table source_board;

insert into E_LIST 
	values ('�Ｚ����', '�ǿ���', '��⵵ ������ ���뱸 �Ｚ�� 129 (��ź��) �Ｚ�����ֽ�ȸ��', 'S/W', 1, '4�뺸��', 95000);
	
insert into E_LIST 
	values ('LG����', '������', '����� �������� ���Ǵ�� 128 LGƮ��Ÿ��', 'S/W', 1, '4�뺸��', 35000); 
	
insert into E_LIST 
	values ('CJ�ø����Ʈ����', '�̰��', '����Ư���� ��걸 �Ѱ���� 366 Ʈ����Ƽ 10��', 'S/W', 1, '4�뺸��', 6000); 
	
insert into E_LIST 
	values ('IBM', '��ȭ��', '����Ư���� �������� ���������� 10(���ǵ���)', 'S/W', 1, '4�뺸��', 2600); 
	
insert into RECRUIT_BOARD(RC_HIREKIND, RC_CAREER, RC_SAL, RC_ABILITY, RC_WORKTIME, RC_TITLE, RC_EXPIRE, RC_NO, RC_CONTENT, RC_COMPANY)
	values (1, 2, 0, '������Ʈ �Ŵ���', '��40�ð�', '�Ｚ���� ����� ä��', '2017/08/24', 1, '����', '�Ｚ����');
	
insert into RECRUIT_BOARD(RC_HIREKIND, RC_CAREER, RC_SAL, RC_ABILITY, RC_WORKTIME, RC_TITLE, RC_EXPIRE, RC_NO, RC_CONTENT, RC_COMPANY)
	values (2, 1, 2800, '������', '��40�ð�', '�Ｚ���� ���԰����� ä��', '2017/08/30', 2, '����', '�Ｚ����');
	
insert into RECRUIT_BOARD(RC_HIREKIND, RC_CAREER, RC_SAL, RC_ABILITY, RC_WORKTIME, RC_TITLE, RC_EXPIRE, RC_NO, RC_CONTENT, RC_COMPANY)
	values (1, 2, 0, '������Ʈ �Ŵ���', '��40�ð�', 'LG���� ����� ä��', '2017/08/26', 3, '����', 'LG����');
	
insert into RECRUIT_BOARD(RC_HIREKIND, RC_CAREER, RC_SAL, RC_ABILITY, RC_WORKTIME, RC_TITLE, RC_EXPIRE, RC_NO, RC_CONTENT, RC_COMPANY)
	values (2, 1, 2800, '������', '��40�ð�', 'LG���� ���԰����� ä��', '2017/08/28', 4, '����', 'LG����');
	
insert into RECRUIT_BOARD(RC_HIREKIND, RC_CAREER, RC_SAL, RC_ABILITY, RC_WORKTIME, RC_TITLE, RC_EXPIRE, RC_NO, RC_CONTENT, RC_COMPANY)
	values (1, 2, 0, '������Ʈ �Ŵ���', '��40�ð�', 'CJ�ø����Ʈ���� ����� ä��', '2017/08/01', 5, '����', 'CJ�ø����Ʈ����');
	
insert into RECRUIT_BOARD(RC_HIREKIND, RC_CAREER, RC_SAL, RC_ABILITY, RC_WORKTIME, RC_TITLE, RC_EXPIRE, RC_NO, RC_CONTENT, RC_COMPANY)
	values (2, 1, 2800, '������', '��40�ð�', 'CJ�ø����Ʈ���� ���԰����� ä��', '2017/08/02', 6, '����', 'CJ�ø����Ʈ����');

insert into RECRUIT_BOARD(RC_HIREKIND, RC_CAREER, RC_SAL, RC_ABILITY, RC_WORKTIME, RC_TITLE, RC_EXPIRE, RC_NO, RC_CONTENT, RC_COMPANY)
	values (1, 2, 0, '������Ʈ �Ŵ���', '��40�ð�', 'IBM ����� ä��', '2017/08/14', 7, '����', 'IBM');
	
insert into RECRUIT_BOARD(RC_HIREKIND, RC_CAREER, RC_SAL, RC_ABILITY, RC_WORKTIME, RC_TITLE, RC_EXPIRE, RC_NO, RC_CONTENT, RC_COMPANY)
	values (2, 1, 2800, '������', '��40�ð�', 'IBM ���԰����� ä��', '2017/08/13', 8, '����', 'IBM');