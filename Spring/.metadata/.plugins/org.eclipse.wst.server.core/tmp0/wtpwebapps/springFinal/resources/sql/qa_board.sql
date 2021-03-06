--qa_board
drop table qa_board
create table qa_board(
    qa_num number(38) primary key
  , qa_name varchar2(50) not null
  , qa_pass varchar2(30) not null
  , qa_subject varchar2(100) not null
  , qa_content varchar2(4000) not null
  , qa_file varchar2(100)
  , qa_re_ref number /*글 그룹번호:답변글 */
  , qa_re_lev number /*답변글 화면에 보이는 위치 */
  , qa_re_seq number /*답변글 레벨 순서 */
  , qa_readcount number /*조회수*/
  , qa_date date /*등록날짜*/
  , qa_original varchar2(100)
  , FOREIGN KEY(qa_name) REFERENCES member(m_email)
);

select countqa_num) as 총개수 from qa_board;

drop sequence qa_board_num_seq
create sequence qa_board_num_seq
                increment by 1 start with 1 nocache;
                
select * from qa_board;