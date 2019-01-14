--faq_board
drop table faq_board;
create table faq_board(
    faq_num number(38) primary key
  , faq_name varchar2(50) not null
  , faq_pass varchar2(30) not null
  , faq_subject varchar2(100) not null
  , faq_content varchar2(4000) not null
  , faq_file varchar2(100)
  , faq_re_ref number /*글 그룹번호:답변글 */
  , faq_re_lev number /*답변글 화면에 보이는 위치 */
  , faq_re_seq number /*답변글 레벨 순서 */
  , faq_readcount number /*조회수*/
  , faq_date date /*등록날짜*/
  , faq_original varchar2(100) 
  , FOREIGN KEY(faq_name) REFERENCES member(m_email)
);

select countfaq_num) as 총개수 from faq_board;
drop sequence faq_board_num_seq
create sequence faq_board_num_seq
                increment by 1 start with 1 nocache;
                
select * from faq_board;