package com.khcc.myweb.dao;
import java.util.List;
import java.util.Map;

import com.khcc.myweb.model.QaBean;
import com.khcc.myweb.model.QnaBean;
import com.khcc.myweb.model.FaqBean;
import com.khcc.myweb.model.NtBean;
public interface BoardService {
	
	/*------------------REVIEW----------------------*/
	/*자료실 저장*/
	public void insertQa(QaBean qabean) throws Exception;

	/* 자료실 총 게시물 수*/
	public int getListCount() throws Exception;
	
	/* 자료실 목록과 페이징 */
	public List<QaBean> getQaList(int page) throws Exception ;

	/*번호를 기준으로 자료실 내용 가져오기 */
	public QaBean getQaCont(int num) throws Exception;

	/*내용보기 할때만 조회수 증가*/
	public void qaHit(int num) throws Exception;

	/*조회수 랭킹1*/
	public QaBean qaReadFirst() throws Exception;
	
	/*조회수 랭킹2*/
	public QaBean qaReadSecond() throws Exception;
	
	/*조회수 랭킹3*/
	public QaBean qaReadThird() throws Exception;
	
	/*이미지파일1*/
	public QaBean qaImageFirst() throws Exception;
	
	/*이미지파일2*/
	public QaBean qaImageSecond() throws Exception;
	
	/*이미지파일3*/
	public QaBean qaImageThird() throws Exception;
	
	/*자료실 수정*/
	public void editQa(QaBean qabean) throws Exception;

	/*자료실 삭제*/
	public void deleteQa(int qa_num) throws Exception;

	/*검색 결과 게시물 수*/
//	public int getListCount3(String find_name,String find_field) throws SQLException{
	public int getListCount3(Map m) throws Exception;

	/*검색 결과 페이징 목록*/
	public List<QaBean> getQaList3(Map m) throws Exception ;

	/*답변글 레벨 증가*/
	public void refEdit(QaBean qabean) throws Exception;

	/*답변글 저장*/
	public void qaReplyOk(QaBean qabean) throws Exception;
	
	/*------------------NT----------------------*/
	
	/*자료실 저장*/
	public void insertNt(NtBean ntbean) throws Exception;

	/* 자료실 총 게시물 수*/
	public int getntListCount() throws Exception;
	
	/* 자료실 목록과 페이징 */
	public List<NtBean> getNtList(int ntpage) throws Exception ;

	/*번호를 기준으로 자료실 내용 가져오기 */
	public NtBean getNtCont(int ntnum) throws Exception;

	/*내용보기 할때만 조회수 증가*/
	public void ntHit(int ntnum) throws Exception;
	
	/*자료실 수정*/
	public void editNt(NtBean ntbean) throws Exception;

	/*자료실 삭제*/
	public void deleteNt(int nt_num) throws Exception;

	/*검색 결과 게시물 수*/
	public int getntListCount3(Map ntm) throws Exception;

	/*검색 결과 페이징 목록*/
	public List<NtBean> getNtList3(Map ntm) throws Exception ;

	/*답변글 레벨 증가*/
	public void refntEdit(NtBean ntbean) throws Exception;

	/*답변글 저장*/
	public void ntReplyOk(NtBean ntbean) throws Exception;
	
/*------------------FAQ----------------------*/
	
	/*자료실 저장*/
	public void insertFaq(FaqBean faqbean) throws Exception;

	/* 자료실 총 게시물 수*/
	public int getfaqListCount() throws Exception;
	
	/* 자료실 목록과 페이징 */
	public List<FaqBean> getFaqList(int faqpage) throws Exception ;

	/*번호를 기준으로 자료실 내용 가져오기 */
	public FaqBean getFaqCont(int faqnum) throws Exception;

	/*내용보기 할때만 조회수 증가*/
	public void faqHit(int faqnum) throws Exception;
	
	/*자료실 수정*/
	public void editFaq(FaqBean faqbean) throws Exception;

	/*자료실 삭제*/
	public void deleteFaq(int faq_num) throws Exception;

	/*검색 결과 게시물 수*/
	public int getfaqListCount3(Map faqm) throws Exception;

	/*검색 결과 페이징 목록*/
	public List<FaqBean> getFaqList3(Map faqm) throws Exception ;

	/*답변글 레벨 증가*/
	public void reffaqEdit(FaqBean faqbean) throws Exception;

	/*답변글 저장*/
	public void faqReplyOk(FaqBean faqbean) throws Exception;
	
	/*------------------QNA----------------------*/
	/*자료실 저장*/
	public void insertQna(QnaBean qnabean) throws Exception;

	/* 자료실 총 게시물 수*/
	public int getqnaListCount() throws Exception;
	
	/* 자료실 목록과 페이징 */
	public List<QnaBean> getQnaList(int qnapage) throws Exception ;

	/*번호를 기준으로 자료실 내용 가져오기 */
	public QnaBean getQnaCont(int qnanum) throws Exception;

	/*내용보기 할때만 조회수 증가*/
	public void qnaHit(int qnanum) throws Exception;

	/*자료실 수정*/
	public void editQna(QnaBean qnabean) throws Exception;

	/*자료실 삭제*/
	public void deleteQna(int qna_num) throws Exception;

	/*검색 결과 게시물 수*/
//	public int getListCount3(String find_name,String find_field) throws SQLException{
	public int getqnaListCount3(Map qnam) throws Exception;

	/*검색 결과 페이징 목록*/
	public List<QnaBean> getQnaList3(Map qnam) throws Exception ;

	/*답변글 레벨 증가*/
	public void refqnaEdit(QnaBean qnabean) throws Exception;

	/*답변글 저장*/
	public void qnaReplyOk(QnaBean qnabean) throws Exception;

}
