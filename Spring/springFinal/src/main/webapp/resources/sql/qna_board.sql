--qna_board
drop table qna_board
create table qna_board(
    qna_num number(38) primary key
  , qna_name varchar2(50) not null
  , qna_pass varchar2(30) not null
  , qna_subject varchar2(100) not null
  , qna_content varchar2(4000) not null
  , qna_file varchar2(100)
  , qna_re_ref number /*글 그룹번호:답변글 */
  , qna_re_lev number /*답변글 화면에 보이는 위치 */
  , qna_re_seq number /*답변글 레벨 순서 */
  , qna_readcount number /*조회수*/
  , qna_date date /*등록날짜*/
  , qna_original varchar2(100) 
  , FOREIGN KEY(qna_name) REFERENCES member(m_email)
);

select countqna_num) as 총개수 from qna_board;

drop sequence qna_board_num_seq
create sequence qna_board_num_seq
                increment by 1 start with 1 nocache;
                
select * from qna_board;