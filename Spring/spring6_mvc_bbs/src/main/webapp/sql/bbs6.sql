--bbs53

create table bbs6(
  bbs_num number(38) primary key
  , bbs_name varchar2(50) not null
  , bbs_pass varchar2(30) not null
  , bbs_subject varchar2(100) not null
  , bbs_content varchar2(4000) not null
  , bbs_file varchar2(100)
  , bbs_re_ref number /*글 그룹번호:답변글 */
  , bbs_re_lev number /*답변글 화면에 보이는 위치 */
  , bbs_re_seq number /*답변글 레벨 순서 */
  , bbs_readcount number /*조회수*/
  , bbs_date date /*등록날짜*/
  , bbs_original varchar2(100) 
);

select count(bbs_num) as 총개수 from bbs6;

create sequence bbs6_num_seq
                increment by 1 start with 1 nocache;
--노 캐쉬를 사용하면 캐쉬에 번호값을 저장하지 않는다.
--increment by 1 start 의미는 1부터 시작해서 1씩증가 
                
select * from bbs6;