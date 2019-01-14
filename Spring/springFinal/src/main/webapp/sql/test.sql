select * from user_sequences;
select * from carpool;
select * from MEMBER;
update CARPOOL 
set cp_valid = 0 
where cp_valid = 1;
select * from reservation_pay;

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('cc', 'bmw520d.png', '중형', 'BMW520d', 12370, 170, '삼릉공원 정자각', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('aa', 'bmw520d.png', '중형', 'BMW520d', 12370, 170, '삼릉공원 비각', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('bb', 'merC.jpg', '준중형', 'C', 11111, 150, '서울상록회관', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('dd', 'merC.jpg', '준중형', 'C', 11111, 150, '역삼1동주민센터', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('ee', 'merC.jpg', '준중형', 'C', 11111, 150, '국기원', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('ff', 'merC.jpg', '준중형', 'C', 11111, 150, '역삼세무서', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('gg', 'merC.jpg', '준중형', 'C', 11111, 150, '역삼1동우체국', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('hh', 'merC.jpg', '준중형', 'C', 11111, 150, '국민건강보험공단 강남서부지', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('ii', 'merC.jpg', '준중형', 'C', 11111, 150, '한국과학기술회관 신관', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('jj', 'merC.jpg', '준중형', 'C', 11111, 150, '한국자산관리공사 서울지역본', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('kk', 'merC.jpg', '준중형', 'C', 11111, 150, '한국투자저축은행 테헤란로지', null, null, 0);


insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('ll', 'merC.jpg', '준중형', 'C', 11111, 150, '하나저축은행 본점', null, null, 0);


insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('mm', 'merC.jpg', '준중형', 'C', 11111, 150, '한국토지신탁', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('nn', 'merC.jpg', '준중형', 'C', 11111, 150, 'JT친애저축은행 본사', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('aa', 'bmw520d.png', '중형', 'BMW520d', 12370, 170, '삼릉공원 비각', null, null, 0);

insert into car (C_ID, C_IMG, C_KIND, C_MODEL, C_RENTFEE, C_OILFEE, C_PLACE, C_START, C_END, C_STATE) 
values('bb', 'merC.jpg', '준중형', 'C', 11111, 150, '서울상록회관', null, null, 0);

select * from car;
insert into carpool values(cp_num_seq.nextval, '3', '서울역', '부산역', '2017/09/10', sysdate, 100000, 300, 0);

insert into carpool values(cp_num_seq.nextval, '4', '강남역', '신논현역', '2017/09/12', sysdate-1, 80000, 1, 0);

insert into carpool values(cp_num_seq.nextval, '2', '용산역', '여의도역', '2017/09/12', sysdate-3, 6000, 5, 0);

insert into carpool values(cp_num_seq.nextval, '1', '대방역', '노량진역', '2017/09/12', sysdate-2, 8000, 3, 0);

insert into carpool values(cp_num_seq.nextval, '0', '서울역', '신촌역', '2017/09/12', sysdate-10, 80000, 10, 0);

insert into carpool values(cp_num_seq.nextval, '9', '신촌역', '이대역', '2017/09/12', sysdate, 1000, 4, 0);

insert into carpool values(cp_num_seq.nextval, '5', '대방역', '노량진역', '2017/09/12', sysdate-4, 8000, 3, 0);

insert into carpool values(cp_num_seq.nextval, '6', '대방역', '노량진역', '2017/09/12', sysdate, 8000, 3, 0);

insert into carpool values(cp_num_seq.nextval, '11', '강남역', '신논현역', '2017/09/12', sysdate-10, 4, 1, 0);

insert into carpool values(cp_num_seq.nextval, '13', '서울역', '부산역', '2017/09/12', sysdate, 100000, 300, 0);

insert into carpool values(cp_num_seq.nextval, '4', '강남역', '신논현역', '2017/09/12', sysdate-1, 80000, 1, 0);

insert into carpool values(cp_num_seq.nextval, '2', '용산역', '여의도역', '2017/09/12', sysdate-3, 6000, 5, 0);

insert into carpool values(cp_num_seq.nextval, '1', '대방역', '노량진역', '2017/09/12', sysdate-2, 8000, 3, 0);

insert into carpool values(cp_num_seq.nextval, '0', '서울역', '신촌역', '2017/09/12', sysdate-10, 80000, 10, 0);

insert into carpool values(cp_num_seq.nextval, '9', '신촌역', '이대역', '2017/09/12', sysdate, 1000, 4, 0);

insert into carpool values(cp_num_seq.nextval, '5', '대방역', '노량진역', '2017/09/12', sysdate-4, 8000, 3, 0);

commit

update carpool set cp_valid = 1 where cp_num = 1;

select count(*) from carpool where cp_depart like '서울역' and cp_valid = 0;

select * 
		from 
		  (select rownum rnum, cp_num, cp_id, cp_depart, 
		   cp_arrive, cp_time,  cp_regdate, cp_sum, cp_distance  
		   from  
	  	      (select * from carpool 
	  	       where cp_valid = 0 
	  	       order by cp_regdate desc)
	  	   );