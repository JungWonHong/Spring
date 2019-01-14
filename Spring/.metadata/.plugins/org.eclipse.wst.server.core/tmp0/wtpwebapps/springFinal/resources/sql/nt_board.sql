--nt_board
drop table nt_board;
create table nt_board(
    nt_num number(38) primary key
  , nt_name varchar2(50) not null
  , nt_pass varchar2(30) not null
  , nt_subject varchar2(100) not null
  , nt_content varchar2(4000) not null
  , nt_file varchar2(100)
  , nt_re_ref number /*글 그룹번호:답변글 */
  , nt_re_lev number /*답변글 화면에 보이는 위치 */
  , nt_re_seq number /*답변글 레벨 순서 */
  , nt_readcount number /*조회수*/
  , nt_date date /*등록날짜*/
  , nt_original varchar2(100) 
  , FOREIGN KEY(nt_name) REFERENCES member(m_email)
);

select countnt_num) as 총개수 from nt_board;
drop sequence nt_board_num_seq
create sequence nt_board_num_seq
                increment by 1 start with 1 nocache;
                
select * from nt_board;