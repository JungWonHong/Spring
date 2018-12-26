/*
	DAO(Data Access Object) 클래스
	- 데이터 베이스와 연동하여 레코드의 추가, 수정, 삭제 작업이 이루어지는 클래스 입니다.
	- 어떤 Action 클래스가 호출되더라도 그에 해당하는 데이터 베이스 연동 처리는
	  DAO 클래스에서 이루어지게 됩니다.
 */
package ch12.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
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
	
	public void member_delete(String id){
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			
			String sql = "delete from member where id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(pstmt != null)
				try {
					pstmt.close();
				} catch(SQLException e) {
				}
			if(con != null)
				try {
					con.close();
				} catch(SQLException e) {
				}
		}
		
	}
	
	public Member member_info(String id){
		Member m = new Member();
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			
			String sql = "select * from member where id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				m.setId(rs.getString(1));
				m.setPassword(rs.getString(2));
				m.setName(rs.getString(3));
				m.setAge(rs.getInt(4));
				m.setGender(rs.getString(5));
				m.setEmail(rs.getString(6));
			}
		} catch (Exception e) {
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
		return m;
	}
	
	public List<Member> getList(){
		List<Member> list = new ArrayList<Member>();
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			
			String sql = "select * from member";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member data = new Member();
				data.setId(rs.getString(1));
				data.setPassword(rs.getString(2));
				data.setName(rs.getString(3));
				data.setAge(rs.getInt(4));
				data.setGender(rs.getString(5));
				data.setEmail(rs.getString(6));
				list.add(data);
			}
		} catch (Exception e) {
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
		
		return list;
	}
	
	public int isId(String id, String pass) {
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			
			String sql = "select id, password from member where id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				if(rs.getString(2).equals(pass)) {
					result = 1; //아이디와 비밀번호 일치하는 경우
				} else {
					result = 0; //비밀번호가 일치하지 않는 경우
				}
			} else {
				result = -1; //아이디가 존재하지 않는 경우
			}
		} catch (Exception e) {
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
		
		return result;
	}
	
	public int insert(Member m) {
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			
			String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getName());
			pstmt.setInt(4, m.getAge());
			pstmt.setString(5, m.getGender());
			pstmt.setString(6, m.getEmail());
			
			result = pstmt.executeUpdate(); //인설트가 되면 인설트된 row수 1이 리턴, 아니면 0이 리턴
		} catch (java.sql.SQLIntegrityConstraintViolationException se) {
			//primary key 제약조건 위반했을 경우 발생하는 에러
			result = -1;
			System.out.println("멤버 아이디 중복 에러입니다.");
		} catch (Exception e){
			System.out.println("insert failed");
			e.printStackTrace();
		} finally {
			if(pstmt != null)
				try {
					pstmt.close();
				} catch(SQLException e) {
				}
			if(con != null)
				try {
					con.close();
				} catch(SQLException e) {
				}
		}
		
		return result;
	}
}
