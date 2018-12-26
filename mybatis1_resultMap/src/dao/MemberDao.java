package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Member;

public class MemberDao {
	private SqlSession getSession() { //mybatis에서는 SqlSession이 필요.  전에는 Connection만 있음됐다.
		SqlSession session = null;
		Reader reader = null; //xml 읽어오기 위해 필요
		try {
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader); //build를 통해서 Factory 생성
			
			session = sf.openSession(true); //Factory를 통해 SqlSession 생성
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return session;
	}
	
	public int chk(Member member){
		int result = 0; //아이디가 없는 경우
		SqlSession session = null; //HttpSession이 아닌 mybatis를 사용하기 위한 session
		try {
			session = getSession();
			Member mem = (Member)session.selectOne("select", member.getId()); //select에서 하나의 결과만 가져오고싶으면 selectOne
			if(mem.getId().equals(member.getId())){
				result = -1; //아이디는 같고 비번이 다른 경우
				if(mem.getPassword().equals(member.getPassword())){
					result = 1; //아이디와 비번이 같은 경우
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close(); //SqlSession 을 닫아 자원을 해제합니다.
		}
		return result;
	}

	public int insert(Member member) {
		int result = 0;
		SqlSession session = null;
		try {
			session = getSession();
			result = session.insert("Member1.insert", member);
			//result = session.insert("insert", member);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	public List<Member> list() {
		List<Member> list = new ArrayList<Member>();
		SqlSession session = null;
		try {
			session = getSession();
			list = session.selectList("list");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close(); //SqlSession 을 닫아 자원을 해제합니다.
		}
		return list;
	}

	public Member select(String id) {
		Member mem = null;
		SqlSession session = null;
		try {
			session = getSession();
			mem = (Member) session.selectOne("select", id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close(); //SqlSession 을 닫아 자원을 해제합니다.
		}
		return mem;
	}

	public int update(Member mem) {
		int result = 0;
		SqlSession session = null;
		try {
			session = getSession();
			result = session.update("update", mem);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close(); //SqlSession 을 닫아 자원을 해제합니다.
		}
		return result;
	}

	public int delete(String id) {
		int result = 0;
		SqlSession session = null;
		try {
			session = getSession();
			result = session.delete("delete", id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close(); //SqlSession 을 닫아 자원을 해제합니다.
		}
		return result;
	}
}
