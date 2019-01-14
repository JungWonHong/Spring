--bbs53

create table bbs6(
  bbs_num number(38) primary key
  , bbs_name varchar2(50) not null
  , bbs_pass varchar2(30) not null
  , bbs_subject varchar2(100) not null
  , bbs_content varchar2(4000) not null
  , bbs_file varchar2(100)
  , bbs_re_ref number /*�� �׷��ȣ:�亯�� */
  , bbs_re_lev number /*�亯�� ȭ�鿡 ���̴� ��ġ */
  , bbs_re_seq number /*�亯�� ���� ���� */
  , bbs_readcount number /*��ȸ��*/
  , bbs_date date /*��ϳ�¥*/
  , bbs_original varchar2(100) 
);

select count(bbs_num) as �Ѱ��� from bbs6;

create sequence bbs6_num_seq
                increment by 1 start with 1 nocache;
--�� ĳ���� ����ϸ� ĳ���� ��ȣ���� �������� �ʴ´�.
--increment by 1 start �ǹ̴� 1���� �����ؼ� 1������ 
                
select * from bbs6;