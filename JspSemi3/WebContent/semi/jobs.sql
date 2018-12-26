select * 
  from (select rownum rnum, p_age, p_certi, p_comment, p_email, p_hp, p_id, p_name, p_portpolio 
  		from (select * from p_member where p_resume = 0));

select * 
  from (select rownum rnum, sb_no, sb_date, sb_title, sb_id, sb_count 
  		from source_board 
  		order by sb_no desc) 
  where rnum>=1 and rnum<=10
  
select * from RESUME;
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
	values ('CJ올리브네트웍스', '이경배', '서울특별시 용산구 한강대로 366 트윈시티 10층', 'S/W', 2, '4대보험', 6000); 
	
insert into E_LIST 
	values ('IBM', '장화진', '서울특별시 영등포구 국제금융로 10(여의도동)', 'S/W', 1, '4대보험', 2600); 
	
insert into E_LIST 
	values ('우리은행', '이광구', '서울특별시 중구 소공로 51 (회현동1가)', '금융', 1, '4대보험', 15534); 
	
insert into E_LIST 
	values ('SK텔레콤', '박정호', '서울특별시 중구 을지로 65 (을지로2가)', '전기/통신', 2, '4대보험', 4399); 

insert into E_LIST 
	values ('신세계', '이명희', '서울특별시 중구 소공로 63', '종합소매', 1, '4대보험', 3368); 

insert into E_LIST 
	values ('신한은행', '위성호', '서울특별시 중구 세종대로9길 20(태평로2가)(대경빌딩))', '금융', 1, '4대보험', 13937); 

insert into E_LIST 
	values ('삼성SDS', '정유성', '서울특별시 송파구 올림픽로35길 125 ', 'IT서비스', 2, '4대보험', 13038); 
	
insert into E_LIST 
	values ('네이버', '한성숙', '경기도 성남시 분당구 불정로 6 (정자동, 네이버그린팩토리)', 'IT서비스', 1, '4대보험', 2693); 
	
insert into E_LIST 
	values ('롯데정보통신', '마용득', '서울 금천구 가산디지털2로 179', 'IT서비스', 2, '4대보험', 1861); 
	
insert into E_LIST 
	values ('KT', '황창규', '경기도 성남시 분당구 불정로 90', '통신', 1, '4대보험', 23531);
	
insert into E_LIST 
	values ('KIA', '박한우', '서울특별시 서초구 헌릉로 12 (양재동)', '자동차 제조', 1, '4대보험', 34102); 
	
insert into E_LIST 
	values ('국민은행', '윤종규', '	서울특별시 중구 남대문로 84 (을지로2가)', '금융', 1, '4대보험', 20222); 
	
insert into E_LIST 
	values ('카카오', '임지훈', '제주특별자치도 제주시 첨단로 242 (영평동)', 'IT기업', 1, '4대보험', 2697); 
	
insert into E_LIST 
	values ('하나은행', '함영주', '서울특별시 중구 을지로 66(을지로2가)', '금융', 1, '4대보험', 14756);
	
insert into E_LIST 
	values ('Google', '선다 피차이', '미국, 캘리포니아 주 마운틴뷰 구글플렉스', 'S/W', 1, '4대보험', 57100);
	
insert into E_LIST 
	values ('아시아나', '김수천', '서울특별시 강서구 오정로 443-83 (오쇠동) 아시아나타운', '운송', 2, '4대보험', 9125); 
	
insert into E_LIST 
	values ('두산 정보통신', '박정원', '서울특별시 중구 장충단로 275 (을지로6가)', 'IT서비스', 1, '4대보험', 600);
	
insert into E_LIST 
	values ('휴맥스', '변대규', '경기 성남시 분당구 수내동 11-4 휴맥스 빌리지', '제조', 1, '4대보험', 770);
	
	
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