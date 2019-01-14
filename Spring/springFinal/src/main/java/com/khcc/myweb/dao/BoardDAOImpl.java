package com.khcc.myweb.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khcc.myweb.model.QaBean;
import com.khcc.myweb.model.QnaBean;
import com.khcc.myweb.model.FaqBean;
import com.khcc.myweb.model.NtBean;
/*
@Component를 이용해서 스프링 컨테이너가 해당 클래스 객체를 생성하도록 설정할 수 있지만   
 모든 클래스에 @Component를 할당하면 어떤 클래스가 어떤 역할을 수행하는지 파악하기 어렵습니다
 스프링 프레임워크에서는 이런 클래스들을 분류하기 위해서 @Component를 상속하여 다음과 같은 세 개의 애노테이션을 제공합니다.

1. @Controller - 사용자의 요청을 제어하는 Controller 클래스
2. @Repository - 데이터 베이스 연동을 처리하는 DAO클래스
3. @Service - 비즈니스 로직을 처리하는 Service 클래스 

*/
@Repository
public class BoardDAOImpl {

	@Autowired
	private SqlSessionTemplate sqlSession, ntsqlSession, faqsqlSession, qnasqlSession;

	/*qa자료실 저장*/
	public void insertQa(QaBean qabean) throws Exception{
		sqlSession.insert("qa_insert",qabean);		
	}
	/*nt자료실 저장*/
	public void insertNt(NtBean ntbean) throws Exception{
		ntsqlSession.insert("nt_insert",ntbean);		
	}
	/*faq자료실 저장*/
	public void insertFaq(FaqBean faqbean) throws Exception{
		faqsqlSession.insert("faq_insert",faqbean);		
	}

	/* qa자료실 총 게시물 수*/
	public int getListCount() throws Exception{
		int count=
	((Integer)sqlSession.selectOne("qa_count")).intValue();
		return count;
	}
	/* nt자료실 총 게시물 수*/
	public int getntListCount() throws Exception{
		int ntcount=
	((Integer)ntsqlSession.selectOne("nt_count")).intValue();
		return ntcount;
	}
	/* faq자료실 총 게시물 수*/
	public int getfaqListCount() throws Exception{
		int faqcount=
	((Integer)faqsqlSession.selectOne("faq_count")).intValue();
		return faqcount;
	}
	
	/* qa자료실 목록과 페이징 */
	public List<QaBean> getQaList(int page) throws Exception {
		List<QaBean>  list = 
				sqlSession.selectList("qa_list", page);
	    return list;
	}
	/* nt자료실 목록과 페이징 */
	public List<NtBean> getNtList(int ntpage) throws Exception {
		List<NtBean>  ntlist = 
				ntsqlSession.selectList("nt_list", ntpage);
	    return ntlist;
	}
	/* faq자료실 목록과 페이징 */
	public List<FaqBean> getFaqList(int faqpage) throws Exception {
		List<FaqBean>  faqlist = 
				faqsqlSession.selectList("faq_list", faqpage);
	    return faqlist;
	}

	/*qa번호를 기준으로 자료실 내용 가져오기 */
	public QaBean getQaCont(int num) throws Exception{
		return (QaBean)sqlSession.selectOne("qa_cont", num);
	}
	/*nt번호를 기준으로 자료실 내용 가져오기 */
	public NtBean getNtCont(int ntnum) throws Exception{
		return (NtBean)ntsqlSession.selectOne("nt_cont", ntnum);
	}
	/*faq번호를 기준으로 자료실 내용 가져오기 */
	public FaqBean getFaqCont(int faqnum) throws Exception{
		return (FaqBean)faqsqlSession.selectOne("faq_cont", faqnum);
	}

	/*qa내용보기 할때만 조회수 증가*/
	public void qaHit(int num) throws Exception{
		sqlSession.update("qa_hit",num);		
	}
	/*nt내용보기 할때만 조회수 증가*/
	public void ntHit(int ntnum) throws Exception{
		ntsqlSession.update("nt_hit",ntnum);		
	}
	/*faq내용보기 할때만 조회수 증가*/
	public void faqHit(int faqnum) throws Exception{
		faqsqlSession.update("faq_hit",faqnum);		
	}

	/*qa자료실 수정*/
	public void editQa(QaBean qabean) throws Exception{
		sqlSession.update("qa_edit",qabean);		
	}
	/*nt자료실 수정*/
	public void editNt(NtBean ntbean) throws Exception{
		ntsqlSession.update("nt_edit",ntbean);		
	}
	/*faq자료실 수정*/
	public void editFaq(FaqBean faqbean) throws Exception{
		faqsqlSession.update("faq_edit",faqbean);		
	}

	/*qa자료실 삭제*/
	public void deleteQa(int qa_num) throws Exception{
		sqlSession.delete("qa_delete",qa_num);		
	}
	/*nt자료실 삭제*/
	public void deleteNt(int nt_num) throws Exception{
		ntsqlSession.delete("nt_delete",nt_num);		
	}
	/*faq자료실 삭제*/
	public void deleteFaq(int faq_num) throws Exception{
		faqsqlSession.delete("faq_delete",faq_num);		
	}

	/*qa검색 결과 게시물 수*/
//	public int getListCount3(String find_name,String find_field) throws SQLException{
	public int getListCount3(Map m) throws Exception{
		int count=0;
		count=((Integer)sqlSession.selectOne("qafind_cnt", m)).intValue();
		return count;
	}
	/*nt검색 결과 게시물 수*/
	public int getntListCount3(Map ntm) throws Exception{
		int ntcount=0;
		ntcount=((Integer)ntsqlSession.selectOne("ntfind_cnt", ntm)).intValue();
		return ntcount;
	}
	/*faq검색 결과 게시물 수*/
	public int getfaqListCount3(Map faqm) throws Exception{
		int faqcount=0;
		faqcount=((Integer)faqsqlSession.selectOne("faqfind_cnt", faqm)).intValue();
		return faqcount;
	}

	/*qa검색 결과 페이징 목록*/
	public List<QaBean> getQaList3(Map m) throws Exception {
		List<QaBean>  list = sqlSession.selectList("qa_find", m);
	    return list;
	}
	/*nt검색 결과 페이징 목록*/
	public List<NtBean> getNtList3(Map ntm) throws Exception {
		List<NtBean>  ntlist = ntsqlSession.selectList("nt_find", ntm);
	    return ntlist;
	}
	/*faq검색 결과 페이징 목록*/
	public List<FaqBean> getFaqList3(Map faqm) throws Exception {
		List<FaqBean>  faqlist = faqsqlSession.selectList("faq_find", faqm);
	    return faqlist;
	}

	/*qa답변글 레벨 증가*/
	public void refEdit(QaBean qabean) throws Exception{
		sqlSession.update("qa_Level",qabean); 		
	}
	/*nt답변글 레벨 증가*/
	public void refntEdit(NtBean ntbean) throws Exception{
		ntsqlSession.update("nt_Level",ntbean); 		
	}
	/*faq답변글 레벨 증가*/
	public void reffaqEdit(FaqBean faqbean) throws Exception{
		faqsqlSession.update("faq_Level",faqbean); 		
	}

	/*조회수 랭크1*/
	public QaBean qaReadFirst() throws Exception {
		return sqlSession.selectOne("qa_readfirst");
	}
	
	/*조회수 랭크2*/
	public QaBean qaReadSecond() throws Exception {
		return sqlSession.selectOne("qa_readsecond");
	}
	
	/*조회수 랭크3*/
	public QaBean qaReadThird() throws Exception {
		return sqlSession.selectOne("qa_readthird");
	}
	
	/*이미지 파일1*/
	public QaBean qaImageFirst() throws Exception {
		return sqlSession.selectOne("qa_imagefirst");
	}
	
	/*이미지 파일2*/
	public QaBean qaImageSecond() throws Exception {
		return sqlSession.selectOne("qa_imagesecond");
	}
	
	/*이미지 파일3*/
	public QaBean qaImageThird() throws Exception {
		return sqlSession.selectOne("qa_imagethird");
	}
	
	/*qa답변글 저장*/
	public void qaReplyOk(QaBean qabean) throws Exception{
		sqlSession.insert("qa_reply",qabean);
	}
	/*nt답변글 저장*/
	public void ntReplyOk(NtBean ntbean) throws Exception{
		ntsqlSession.insert("nt_reply",ntbean);
	}
	/*faq답변글 저장*/
	public void faqReplyOk(FaqBean faqbean) throws Exception{
		faqsqlSession.insert("faq_reply",faqbean);
	}
	
	/*qna자료실 저장*/
	public void insertQna(QnaBean qnabean) throws Exception{
		qnasqlSession.insert("qna_insert",qnabean);		
	}

	/* qna자료실 총 게시물 수*/
	public int getqnaListCount() throws Exception{
		int count=
	((Integer)qnasqlSession.selectOne("qna_count")).intValue();
		return count;
	}
	
	/* qna자료실 목록과 페이징 */
	public List<QnaBean> getQnaList(int qnapage) throws Exception {
		List<QnaBean>  list = 
				qnasqlSession.selectList("qna_list", qnapage);
	    return list;
	}

	/*qna번호를 기준으로 자료실 내용 가져오기 */
	public QnaBean getQnaCont(int num) throws Exception{
		return (QnaBean)qnasqlSession.selectOne("qna_cont", num);
	}

	/*qna내용보기 할때만 조회수 증가*/
	public void qnaHit(int num) throws Exception{
		qnasqlSession.update("qna_hit",num);		
	}

	/*qna자료실 수정*/
	public void editQna(QnaBean qnabean) throws Exception{
		qnasqlSession.update("qna_edit",qnabean);		
	}

	/*qna자료실 삭제*/
	public void deleteQna(int qna_num) throws Exception{
		qnasqlSession.delete("qna_delete",qna_num);		
	}

	/*qna검색 결과 게시물 수*/
//	public int getListCount3(String find_name,String find_field) throws SQLException{
	public int getqnaListCount3(Map qnam) throws Exception{
		int count=0;
		count=((Integer)qnasqlSession.selectOne("qnafind_cnt", qnam)).intValue();
		return count;
	}

	/*qna검색 결과 페이징 목록*/
	public List<QnaBean> getQnaList3(Map qnam) throws Exception {
		List<QnaBean>  list = qnasqlSession.selectList("qna_find", qnam);
	    return list;
	}

	/*qna답변글 레벨 증가*/
	public void refqnaEdit(QnaBean qnabean) throws Exception{
		qnasqlSession.update("qna_Level",qnabean); 		
	}
	
	/*qna답변글 저장*/
	public void qnaReplyOk(QnaBean qnabean) throws Exception{
		qnasqlSession.insert("qna_reply",qnabean);
	}
	
	
}











