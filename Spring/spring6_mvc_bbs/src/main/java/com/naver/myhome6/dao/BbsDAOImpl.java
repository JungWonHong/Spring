package com.naver.myhome6.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.myhome6.model.BbsBean;
/*
@Component�� �̿��ؼ� ������ �����̳ʰ� �ش� Ŭ���� ��ü�� �����ϵ��� ������ �� ������   
 ��� Ŭ������ @Component�� �Ҵ��ϸ� � Ŭ������ � ������ �����ϴ��� �ľ��ϱ� ��ƽ��ϴ�
 ������ �����ӿ�ũ������ �̷� Ŭ�������� �з��ϱ� ���ؼ� @Component�� ����Ͽ� ������ ���� �� ���� �ֳ����̼��� �����մϴ�.

1. @Controller - ������� ��û�� �����ϴ� Controller Ŭ����
2. @Repository - ������ ���̽� ������ ó���ϴ� DAOŬ����
3. @Service - ����Ͻ� ������ ó���ϴ� Service Ŭ���� 

*/
@Repository
public class BbsDAOImpl {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/*�ڷ�� ����*/
	public void insertBbs(BbsBean bbsbean) throws Exception{
		sqlSession.insert("bbs_insert",bbsbean);		
	}

	/* �ڷ�� �� �Խù� ��*/
	public int getListCount() throws Exception{
		int count=
	((Integer)sqlSession.selectOne("bbs_count")).intValue();
		return count;
	}
	
	/* �ڷ�� ��ϰ� ����¡ */
	public List<BbsBean> getBbsList(int page) throws Exception {
		List<BbsBean>  list = 
				sqlSession.selectList("bbs_list", page);
	    return list;
	}

	/*��ȣ�� �������� �ڷ�� ���� �������� */
	public BbsBean getBbsCont(int num) throws Exception{
		return (BbsBean)sqlSession.selectOne("bbs_cont", num);
	}

	/*���뺸�� �Ҷ��� ��ȸ�� ����*/
	public void bbsHit(int num) throws Exception{
		sqlSession.update("bbs_hit",num);		
	}

	/*�ڷ�� ����*/
	public void editBbs(BbsBean bbsbean) throws Exception{
		sqlSession.update("bbs_edit",bbsbean);		
	}

	/*�ڷ�� ����*/
	public void deleteBbs(int bbs_num) throws Exception{
		sqlSession.delete("bbs_delete",bbs_num);		
	}

	/*�˻� ��� �Խù� ��*/
//	public int getListCount3(String find_name,String find_field) throws SQLException{
	public int getListCount3(Map m) throws Exception{
		int count=0;
		count=((Integer)sqlSession.selectOne("bbsfind_cnt", m)).intValue();
		return count;
	}

	/*�˻� ��� ����¡ ���*/
	public List<BbsBean> getBbsList3(Map m) throws Exception {
		List<BbsBean>  list = sqlSession.selectList("bbs_find", m);
	    return list;
	}

	/*�亯�� ���� ����*/
	public void refEdit(BbsBean bbsbean) throws Exception{
		sqlSession.update("bbs_Level",bbsbean); 		
	}

	/*�亯�� ����*/
	public void bbsReplyOk(BbsBean bbsbean) throws Exception{
		sqlSession.insert("bbs_reply",bbsbean);
	}
}











