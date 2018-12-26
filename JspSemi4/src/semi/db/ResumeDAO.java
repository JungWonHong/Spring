package semi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import semi.db.bean.PMemberBean;
import semi.db.bean.ResumeBean;

public class ResumeDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	ResultSet rs2;
	int result;

	// 생성자에서 JNDI 리소스를 참조하여 Connection 객체를 얻어옵니다.
	public ResumeDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}

	public boolean resumeUpdate(PMemberBean pmem) {
		int result = 0;
		try {
			String sql = "update p_member " + "set p_resume=?, p_certi=?, p_comment=?, p_portpolio=? " + "where p_id=?";

			con = ds.getConnection();

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pmem.getP_resume());
			pstmt.setInt(2, pmem.getP_certi());
			pstmt.setString(3, pmem.getP_comment().replace("\r\n", "<br>"));
			pstmt.setString(4, pmem.getP_portpolio());
			pstmt.setString(5, pmem.getP_id());

			result = pstmt.executeUpdate();

			if (result != 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
		return false;
	}

	public boolean resumeApply(ResumeBean resume) {
		int result = 0;
		try {
			String sql = "insert into RESUME values (?, ?, ?, ?, ?)";

			con = ds.getConnection();

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, resume.getR_id());
			pstmt.setString(2, resume.getR_company());
			pstmt.setString(3, resume.getR_content().replace("\r\n", "<br>"));
			pstmt.setString(4, resume.getR_file());
			pstmt.setString(5, resume.getR_certi());

			result = pstmt.executeUpdate();

			if (result != 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
		return false;
	}

	public List<ResumeBean> getResumeList(String id) {
		List<ResumeBean> list = new ArrayList<ResumeBean>();
		String sql = "select * from RESUME where r_id = ?";
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ResumeBean rb = new ResumeBean();
				rb.setR_certi(rs.getString("r_certi"));
				rb.setR_company(rs.getString("r_company"));
				rb.setR_content(rs.getString("r_content").replaceAll("<br>", "\r\n"));
				rb.setR_file(rs.getString("r_file"));
				rb.setR_id(rs.getString("r_id"));
				list.add(rb);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
		return null;
	}

	public ResumeBean getResumeDetail(String id, String company) {
		ResumeBean rb = new ResumeBean();
		String sql = "select * from RESUME where r_id=? and r_company=?";
		try{
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, company);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				rb.setR_certi(rs.getString("r_certi"));
				rb.setR_company(rs.getString("r_company"));
				rb.setR_content(rs.getString("r_content").replaceAll("<br>", "\r\n"));
				rb.setR_file(rs.getString("r_file"));
				rb.setR_id(rs.getString("r_id"));
			}
			
			return rb;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
		return null;
	}

	public boolean checkResume(String id) {
		int cnt = 0;
		String sql = "select count(*) from RESUME where r_id=?";
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				cnt = rs.getInt(1);
				if(cnt == 3)
					return false;
				
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		} 
		return false;
	}

	public boolean deleteResume(String id, String company) {
		String sql = "delete from RESUME where r_id=? and r_company=?";
		int result = 0;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, company);
			
			result = pstmt.executeUpdate();
			
			if(result == 0)
				return false;
			else
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		} 
		return false;
	}

}
