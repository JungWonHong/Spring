package com.khcc.myweb.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khcc.myweb.model.ReportBean;




@Repository
public class ReportDAOImpl {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 게시판 저장
		public void insertreport(ReportBean rb) throws Exception{
			sqlSession.insert("report_insert", rb);
		}
	
		/* 자료실 총 게시물 수*/
		public int getListCount() throws Exception{
			int count=
		((Integer)sqlSession.selectOne("report_count")).intValue();
			return count;
		}
		


		/*번호를 기준으로 자료실 내용 가져오기 */
		public ReportBean getReportCont(int num) throws Exception{
			return (ReportBean)sqlSession.selectOne("report_cont", num);
		}

		// 게시물 목록
		public List<ReportBean> getReportList(int page)
		throws Exception{
			List<ReportBean> list = 
					sqlSession.selectList("report_list", page);
			return list;
		}
		
		/*자료실 삭제*/
		public void deleteReport(int r_NUM) throws Exception{
			sqlSession.delete("report_delete",r_NUM);		
		}

		public void submitReport(String illegal) {
			sqlSession.update("update_illegalmem", illegal);
		}

		public int checkPenalty(String illegal) {
			return sqlSession.selectOne("check_penalty", illegal);
		}
	
}
