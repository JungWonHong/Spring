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
select EL_LOC from E_LIST where EL_COMPANY = '삼성전자';
drop table comments;
drop table source_board;

insert into E_LIST 
	values ('삼성전자', '권오현', '경기도 수원시 영통구 삼성로 129 (매탄동) 삼성전자주식회사', 'S/W', 1, '4대보험', 95000);
	
insert into E_LIST 
	values ('LG전자', '정도현', '서울시 영등포구 여의대로 128 LG트윈타워', 'S/W', 1, '4대보험', 35000); 
	
insert into E_LIST 
	values ('CJ올리브네트웍스', '이경배', '서울특별시 용산구 한강대로 366 트윈시티 10층', 'S/W', 1, '4대보험', 6000); 
	
insert into E_LIST 
	values ('IBM', '장화진', '서울특별시 영등포구 국제금융로 10(여의도동)', 'S/W', 1, '4대보험', 2600); 
	
insert into RECRUIT_BOARD(RC_HIREKIND, RC_CAREER, RC_SAL, RC_ABILITY, RC_WORKTIME, RC_TITLE, RC_EXPIRE, RC_NO, RC_CONTENT, RC_COMPANY)
	values (1, 2, 0, '프로젝트 매니저', '주40시간', '삼성전자 경력직 채용', '2017/08/24', 1, '제곧내', '삼성전자');
	
insert into RECRUIT_BOARD(RC_HIREKIND, RC_CAREER, RC_SAL, RC_ABILITY, RC_WORKTIME, RC_TITLE, RC_EXPIRE, RC_NO, RC_CONTENT, RC_COMPANY)
	values (2, 1, 2800, '개발자', '주40시간', '삼성전자 신입개발자 채용', '2017/08/30', 2, '제곧내', '삼성전자');
	
insert into RECRUIT_BOARD(RC_HIREKIND, RC_CAREER, RC_SAL, RC_ABILITY, RC_WORKTIME, RC_TITLE, RC_EXPIRE, RC_NO, RC_CONTENT, RC_COMPANY)
	values (1, 2, 0, '프로젝트 매니저', '주40시간', 'LG전자 경력직 채용', '2017/08/26', 3, '제곧내', 'LG전자');
	
insert into RECRUIT_BOARD(RC_HIREKIND, RC_CAREER, RC_SAL, RC_ABILITY, RC_WORKTIME, RC_TITLE, RC_EXPIRE, RC_NO, RC_CONTENT, RC_COMPANY)
	values (2, 1, 2800, '개발자', '주40시간', 'LG전자 신입개발자 채용', '2017/08/28', 4, '제곧내', 'LG전자');
	
insert into RECRUIT_BOARD(RC_HIREKIND, RC_CAREER, RC_SAL, RC_ABILITY, RC_WORKTIME, RC_TITLE, RC_EXPIRE, RC_NO, RC_CONTENT, RC_COMPANY)
	values (1, 2, 0, '프로젝트 매니저', '주40시간', 'CJ올리브네트웍스 경력직 채용', '2017/08/01', 5, '제곧내', 'CJ올리브네트웍스');
	
insert into RECRUIT_BOARD(RC_HIREKIND, RC_CAREER, RC_SAL, RC_ABILITY, RC_WORKTIME, RC_TITLE, RC_EXPIRE, RC_NO, RC_CONTENT, RC_COMPANY)
	values (2, 1, 2800, '개발자', '주40시간', 'CJ올리브네트웍스 신입개발자 채용', '2017/08/02', 6, '제곧내', 'CJ올리브네트웍스');

insert into RECRUIT_BOARD(RC_HIREKIND, RC_CAREER, RC_SAL, RC_ABILITY, RC_WORKTIME, RC_TITLE, RC_EXPIRE, RC_NO, RC_CONTENT, RC_COMPANY)
	values (1, 2, 0, '프로젝트 매니저', '주40시간', 'IBM 경력직 채용', '2017/08/14', 7, '제곧내', 'IBM');
	
insert into RECRUIT_BOARD(RC_HIREKIND, RC_CAREER, RC_SAL, RC_ABILITY, RC_WORKTIME, RC_TITLE, RC_EXPIRE, RC_NO, RC_CONTENT, RC_COMPANY)
	values (2, 1, 2800, '개발자', '주40시간', 'IBM 신입개발자 채용', '2017/08/13', 8, '제곧내', 'IBM');