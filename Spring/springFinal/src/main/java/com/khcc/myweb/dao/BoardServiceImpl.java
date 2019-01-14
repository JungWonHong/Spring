package com.khcc.myweb.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khcc.myweb.model.QaBean;
import com.khcc.myweb.model.QnaBean;
import com.khcc.myweb.model.FaqBean;
import com.khcc.myweb.model.NtBean;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	/*----------------------REVIEW---------------------------*/
	
    @Autowired
	private BoardDAOImpl qaDAO;

	@Override
	public void insertQa(QaBean qabean) throws Exception {
		qaDAO.insertQa(qabean);
	}

	@Override
	public int getListCount() throws Exception {
		return qaDAO.getListCount();
	}

	@Override
	public List<QaBean> getQaList(int page) throws Exception {
		return qaDAO.getQaList(page);
	}

	@Override
	public QaBean getQaCont(int num) throws Exception {
		return qaDAO.getQaCont(num);
	}

	@Override
	public void qaHit(int num) throws Exception {
        qaDAO.qaHit(num);		
	}

	@Override
	public void editQa(QaBean qabean) throws Exception {
         qaDAO.editQa(qabean);		
	}

	@Override
	public void deleteQa(int qa_num) throws Exception {
         qaDAO.deleteQa(qa_num);		
	}

	@Override
	public int getListCount3(Map m) throws Exception {
		return qaDAO.getListCount3(m);
	}

	@Override
	public List<QaBean> getQaList3(Map m) throws Exception {
		return qaDAO.getQaList3(m);
	}

	@Override
	public void refEdit(QaBean qabean) throws Exception {
        qaDAO.refEdit(qabean);		
	}

	@Override
	public void qaReplyOk(QaBean qabean) throws Exception {
        qaDAO.qaReplyOk(qabean);		
	}

	@Override
	public QaBean qaReadFirst() throws Exception {
		return qaDAO.qaReadFirst();
	}

	@Override
	public QaBean qaReadSecond() throws Exception {
		return qaDAO.qaReadSecond();
	}

	@Override
	public QaBean qaReadThird() throws Exception {
		return qaDAO.qaReadThird();
	}

	@Override
	public QaBean qaImageFirst() throws Exception {
		return qaDAO.qaImageFirst();
	}

	@Override
	public QaBean qaImageSecond() throws Exception {
		return qaDAO.qaImageSecond();
	}

	@Override
	public QaBean qaImageThird() throws Exception {
		return qaDAO.qaImageThird();
	}
	
	/*----------------------NT---------------------------*/
	
	@Autowired
	private BoardDAOImpl ntDAO;

	@Override
	public void insertNt(NtBean ntbean) throws Exception {
		ntDAO.insertNt(ntbean);
	}

	@Override
	public int getntListCount() throws Exception {
		return ntDAO.getntListCount();
	}

	@Override
	public List<NtBean> getNtList(int ntpage) throws Exception {
		return ntDAO.getNtList(ntpage);
	}

	@Override
	public NtBean getNtCont(int ntnum) throws Exception {
		return ntDAO.getNtCont(ntnum);
	}

	@Override
	public void ntHit(int ntnum) throws Exception {
        ntDAO.ntHit(ntnum);		
	}

	@Override
	public void editNt(NtBean ntbean) throws Exception {
         ntDAO.editNt(ntbean);		
	}

	@Override
	public void deleteNt(int nt_num) throws Exception {
         ntDAO.deleteNt(nt_num);		
	}

	@Override
	public int getntListCount3(Map ntm) throws Exception {
		return ntDAO.getntListCount3(ntm);
	}

	@Override
	public List<NtBean> getNtList3(Map ntm) throws Exception {
		return ntDAO.getNtList3(ntm);
	}

	@Override
	public void refntEdit(NtBean ntbean) throws Exception {
        ntDAO.refntEdit(ntbean);		
	}

	@Override
	public void ntReplyOk(NtBean ntbean) throws Exception {
        ntDAO.ntReplyOk(ntbean);		
	}
	
	/*----------------------FAQ---------------------------*/
	
	@Autowired
	private BoardDAOImpl faqDAO;

	@Override
	public void insertFaq(FaqBean faqbean) throws Exception {
		faqDAO.insertFaq(faqbean);
	}

	@Override
	public int getfaqListCount() throws Exception {
		return faqDAO.getfaqListCount();
	}

	@Override
	public List<FaqBean> getFaqList(int faqpage) throws Exception {
		return faqDAO.getFaqList(faqpage);
	}

	@Override
	public FaqBean getFaqCont(int faqnum) throws Exception {
		return faqDAO.getFaqCont(faqnum);
	}

	@Override
	public void faqHit(int faqnum) throws Exception {
		faqDAO.faqHit(faqnum);
	}

	@Override
	public void editFaq(FaqBean faqbean) throws Exception {
		faqDAO.editFaq(faqbean);
	}

	@Override
	public void deleteFaq(int faq_num) throws Exception {
		faqDAO.deleteFaq(faq_num);
	}

	@Override
	public int getfaqListCount3(Map faqm) throws Exception {
		return faqDAO.getfaqListCount3(faqm);
	}

	@Override
	public List<FaqBean> getFaqList3(Map faqm) throws Exception {
		return faqDAO.getFaqList3(faqm);
	}

	@Override
	public void reffaqEdit(FaqBean faqbean) throws Exception {
		faqDAO.reffaqEdit(faqbean);
	}

	@Override
	public void faqReplyOk(FaqBean faqbean) throws Exception {
		faqDAO.faqReplyOk(faqbean);
	}

	/*----------------------QNA---------------------------*/
	@Autowired
	private BoardDAOImpl qnaDAO;
	
	@Override
	public void insertQna(QnaBean qnabean) throws Exception {
		qnaDAO.insertQna(qnabean);
	}

	@Override
	public int getqnaListCount() throws Exception {
		return qnaDAO.getqnaListCount();
	}

	@Override
	public List<QnaBean> getQnaList(int qnapage) throws Exception {
		return qnaDAO.getQnaList(qnapage);
	}

	@Override
	public QnaBean getQnaCont(int qnanum) throws Exception {
		return qnaDAO.getQnaCont(qnanum);
	}

	@Override
	public void qnaHit(int qnanum) throws Exception {
		qnaDAO.qnaHit(qnanum);
	}

	@Override
	public void editQna(QnaBean qnabean) throws Exception {
		qnaDAO.editQna(qnabean);
	}

	@Override
	public void deleteQna(int qna_num) throws Exception {
		qnaDAO.deleteQna(qna_num);
	}

	@Override
	public int getqnaListCount3(Map qnam) throws Exception {
		return qnaDAO.getqnaListCount3(qnam);
	}

	@Override
	public List<QnaBean> getQnaList3(Map qnam) throws Exception {
		return qnaDAO.getQnaList3(qnam);
	}

	@Override
	public void refqnaEdit(QnaBean qnabean) throws Exception {
		qnaDAO.refqnaEdit(qnabean);
	}

	@Override
	public void qnaReplyOk(QnaBean qnabean) throws Exception {
		qnaDAO.qnaReplyOk(qnabean);
	}

}
