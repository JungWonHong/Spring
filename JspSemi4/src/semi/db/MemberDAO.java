package semi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import semi.db.bean.EMemberBean;
import semi.db.bean.PMemberBean;

public class MemberDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	ResultSet rs2;
	int result;

	// 생성자에서 JNDI 리소스를 참조하여 Connection 객체를 얻어옵니다.
	public MemberDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}

	public int insert(PMemberBean m) {
		String sql = "INSERT INTO P_MEMBER(P_ID, P_NAME, P_PW, P_EMAIL, P_HP, P_AGE) " + "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			con = ds.getConnection();
			System.out.println("getConnection");

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getP_id());
			pstmt.setString(2, m.getP_name());
			pstmt.setString(3, m.getP_pw());
			pstmt.setString(4, m.getP_email());
			pstmt.setString(5, m.getP_hp());
			pstmt.setInt(6, m.getP_age());

			result = pstmt.executeUpdate();

		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			result = -1;
			System.out.println("멤버 아이디 중복 에러입니다");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		}
		return result;
	}

	public int insert2(EMemberBean e) {
		String sql = "INSERT INTO E_MEMBER(E_MEMNAME, E_ID, E_PW, E_EMAIL, E_PHONE, E_COMPANY) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			con = ds.getConnection();
			System.out.println("getConnection");

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, e.getE_memname());
			pstmt.setString(2, e.getE_id());
			pstmt.setString(3, e.getE_pw());
			pstmt.setString(4, e.getE_email());
			pstmt.setString(5, e.getE_phone());
			pstmt.setString(6, e.getE_company());

			result = pstmt.executeUpdate();

		} catch (java.sql.SQLIntegrityConstraintViolationException ex) {
			result = -1;
			System.out.println("멤버 아이디 중복 에러입니다");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		}
		return result;
	}

	public int isPId(String id, String pass) {
		try {
			con = ds.getConnection();
			System.out.println("getConnection");

			String sql = "select p_id, p_pw from p_member where p_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(2).equals(pass)) {
					result = 1; // 아이디와 비밀번호 일치하는 경우
				} else {
					result = 0; // 비밀번호가 일치하지 않는 경우
				}
			} else {
				result = -1; // 아이디가 존재하지 않는 경우
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		}
		return result;

	}

	public int isEId(String id, String pass) {
		try {
			con = ds.getConnection();
			System.out.println("getConnection");

			String sql = "select e_id, e_pw from e_member where e_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(2).equals(pass)) {
					result = 1; // 아이디와 비밀번호 일치하는 경우
				} else {
					result = 0; // 비밀번호가 일치하지 않는 경우
				}
			} else {
				result = -1; // 아이디가 존재하지 않는 경우
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		}
		return result;

	}

	// 등록하려는 회원 아이디가 기존에 존재하는지 체크하는 메소드
	public int confirmId(String id) {
		String sql = "";
		String sql2 = "";
		int x = -1;

		try {
			con = ds.getConnection();
			System.out.println("getConnection");

			// 개인회원 중복검사
			sql = "select p_id from p_member where p_id = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			// 기업회원 중복검사
			sql2 = "select e_id from e_member where e_id = ?";

			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, id);
			rs2 = pstmt.executeQuery();

			if (rs.next()) {
				x = 1;
			} else if (rs2.next()) {
				x = 1;
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
		return x;
	}

	public List<PMemberBean> getPoolList(int page, int limit) {
		String sql = "select * " + "from (select rownum rnum, p_age, p_certi, p_comment, "
				+ "p_email, p_hp, p_id, p_name, p_portpolio " + "from (select * from p_member where p_resume <> 0)) "
				+ "where rnum>=? and rnum<=?";
		int startrow = (page - 1) * 10 + 1;
		int endrow = startrow + limit - 1;
		List<PMemberBean> list = new ArrayList<PMemberBean>();
		try {
			con = ds.getConnection();
			System.out.println("getConnection");

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PMemberBean data = new PMemberBean();
				data.setP_age(rs.getInt("p_age"));
				data.setP_certi(rs.getInt("p_certi"));
				data.setP_comment(rs.getString("p_comment"));
				data.setP_email(rs.getString("p_email"));
				data.setP_hp(rs.getString("p_hp"));
				data.setP_id(rs.getString("p_id"));
				data.setP_name(rs.getString("p_name"));
				data.setP_portpolio(rs.getString("p_portpolio"));
				list.add(data);
			}
			return list;
		} catch (Exception e) {
			System.out.println("getPoolList 에러" + e);
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
				}
		}
		return null;
	}

	public int getPoolListCount() {
		int num = 0;
		String sql = "select count(*) from p_member where p_resume <> 0";
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("getPoolListCount() 에러: " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		}
		return num;
	}

	public PMemberBean Pmember_info(String id) {
		PMemberBean m = new PMemberBean();
		try {
			con = ds.getConnection();

			String sql = "select* from P_MEMBER where P_id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				m.setP_id(rs.getString("p_id"));
				m.setP_name(rs.getString("p_name"));
				m.setP_age(rs.getInt("p_age"));
				m.setP_hp(rs.getString("p_hp"));
				m.setP_email(rs.getString("p_email"));
				m.setP_resume(rs.getInt("p_resume"));
				m.setP_certi(rs.getInt("p_certi"));
				m.setP_comment(rs.getString("p_comment"));
				m.setP_portpolio(rs.getString("p_portpolio"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		}
		return m;
	}

	public EMemberBean Emember_info(String id) {
		EMemberBean m = new EMemberBean();
		try {
			con = ds.getConnection();

			String sql = "select* from E_MEMBER where E_id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				m.setE_id(rs.getString(1));
				m.setE_company(rs.getString(2));
				m.setE_memname(rs.getString(3));
				m.setE_phone(rs.getString(4));
				m.setE_email(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		}
		return m;
	}

	public int PdeleteMember(String P_pw, String P_id) {

		String sql = "";
		int x = 0;

		try {
			con = ds.getConnection();
			sql = "select p_id, p_pw from P_MEMBER where p_id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, P_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String pass = rs.getString("p_pw");
				if (pass.equals(P_pw)) {
					sql = "delete from P_MEMBER where p_id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, P_id);
					x = pstmt.executeUpdate();
				}
				return x;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
			}
		}
		return x;
	}

	public int PdeleteMember(String p_id) {

		String sql = "";
		int x = 0;

		try {
			con = ds.getConnection();
			sql = "select p_id, p_pw from P_MEMBER where p_id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				sql = "delete from P_MEMBER where p_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, p_id);
				x = pstmt.executeUpdate();
				return x;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
			}
		}
		return x;
	}

	public int EdeleteMember(String E_pw, String E_id) throws SQLException {

		String sql = "";
		int x = 0;

		try {
			con = ds.getConnection();
			sql = "select e_id, e_pw from E_MEMBER where e_id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, E_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String pass = rs.getString("e_pw");

				if (pass.equals(E_pw)) {
					sql = "delete from E_MEMBER where e_id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, E_id);
					x = pstmt.executeUpdate();
				}
				return x;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
			}
		}
		return x;
	}

	public int EdeleteMember(String e_id) {
		String sql = "";
		int x = 0;

		try {
			con = ds.getConnection();
			sql = "select e_id, e_pw from E_MEMBER where e_id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, e_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				sql = "delete from E_MEMBER where e_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, e_id);
				x = pstmt.executeUpdate();
				return x;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
			}
		}
		return x;
	}

	public PMemberBean pinfo(String id) {
		PMemberBean pmember = new PMemberBean();
		try {
			con = ds.getConnection();

			String sql = "select p_id, p_name, p_hp, p_age, p_email from p_member where p_id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				pmember.setP_id(rs.getString(1));
				pmember.setP_name(rs.getString(2));
				pmember.setP_hp(rs.getString(3));
				pmember.setP_age(rs.getInt(4));
				pmember.setP_email(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		}
		return pmember;
	}

	public EMemberBean einfo(String id) {
		EMemberBean emember = new EMemberBean();
		try {
			con = ds.getConnection();

			String sql = "select * from e_member where e_id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				emember.setE_company(rs.getString("e_company"));
				emember.setE_email(rs.getString("e_email"));
				emember.setE_id(rs.getString("e_id"));
				emember.setE_memname(rs.getString("e_memname"));
				emember.setE_phone(rs.getString("e_phone"));
				emember.setE_pw(rs.getString("e_pw"));
				emember.setE_regdate(rs.getDate("e_regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		}
		return emember;

	}

	// 일반회원 정보
	public PMemberBean pview(String id) {
		String sql = "";
		PMemberBean pmember = null;
		try {
			con = ds.getConnection();
			sql = "select * from p_member where p_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				pmember = new PMemberBean();

				pmember.setP_id(rs.getString("p_id"));
				pmember.setP_name(rs.getString("p_name"));
				pmember.setP_email(rs.getString("p_email"));
				pmember.setP_age(rs.getInt("p_age"));
				pmember.setP_hp(rs.getString("p_hp"));
				pmember.setP_pw(rs.getString("p_pw"));
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
		return pmember;

	}

	// 일반회원 수정
	public int PModify(PMemberBean pmember) {
		String sql = null;
		String p_id = pmember.getP_id();
		int result = 0;
		try {
			con = ds.getConnection();
			sql = "update p_member set p_pw=?, p_hp=?, p_email=? where p_id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pmember.getP_pw());
			pstmt.setString(2, pmember.getP_hp());
			pstmt.setString(3, pmember.getP_email());
			pstmt.setString(4, p_id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("PModify Update 에러");
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
		return result;
	}

	// 기업회원정보
	public EMemberBean eview(String id) {
		String sql = null;
		EMemberBean emember = new EMemberBean();
		try {
			con = ds.getConnection();
			sql = "select * from e_member where e_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				emember.setE_memname(rs.getString("e_memname"));
				emember.setE_id(rs.getString("e_id"));
				emember.setE_company(rs.getString("e_company"));
				emember.setE_email(rs.getString("e_email"));
				emember.setE_phone(rs.getString("e_phone"));
				emember.setE_pw(rs.getString("e_pw"));
			}
			return emember;
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

	// 기업회원 수정
	public int EModify(EMemberBean emember) {
		String sql = "";
		String e_id = emember.getE_id();
		int result = 0;
		try {
			con = ds.getConnection();
			sql = "update e_member set e_phone=?, e_email=?, e_company=?, e_pw=? where e_id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emember.getE_phone());
			pstmt.setString(2, emember.getE_email());
			pstmt.setString(3, emember.getE_company());
			pstmt.setString(4, emember.getE_pw());
			pstmt.setString(5, e_id);
			result = pstmt.executeUpdate();
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
		return result;
	}

	// 기업회원 리스트
	public List<EMemberBean> ememlist() {
		List<EMemberBean> ememberlist = new ArrayList<EMemberBean>();
		try {
			con = ds.getConnection();

			String sql = "select * from e_member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EMemberBean emember = new EMemberBean();
				emember.setE_memname(rs.getString("e_memname"));
				emember.setE_id(rs.getString("e_id"));
				emember.setE_email(rs.getString("e_email"));
				emember.setE_company(rs.getString("e_company"));
				emember.setE_phone(rs.getString("e_phone"));
				ememberlist.add(emember);
			}
			return ememberlist;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		}
		return null;
	}

	// 일반회원 리스트
	public List<PMemberBean> pmemlist() {
		List<PMemberBean> pmemberlist = new ArrayList<PMemberBean>();
		try {
			con = ds.getConnection();

			String sql = "select * from p_member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PMemberBean pmember = new PMemberBean();
				pmember.setP_id(rs.getString("p_id"));
				pmember.setP_name(rs.getString("p_name"));
				pmember.setP_hp(rs.getString("p_hp"));
				pmember.setP_age(rs.getInt("p_age"));
				pmember.setP_email(rs.getString("p_email"));

				pmemberlist.add(pmember);
			}

			return pmemberlist;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		}
		return null;
	}

	public boolean resumeUpdate(PMemberBean pmem) {
		int result = 0;
		try {
			String sql = "update p_member " + "set p_resume=?, p_certi=?, p_comment=?, p_portpolio=? " + "where p_id=?";

			con = ds.getConnection();

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pmem.getP_resume());
			pstmt.setInt(2, pmem.getP_certi());
			pstmt.setString(3, pmem.getP_comment());
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

}
