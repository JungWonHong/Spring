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
	private SqlSession getSession() { //mybatis������ SqlSession�� �ʿ�.  ������ Connection�� �����ƴ�.
		SqlSession session = null;
		Reader reader = null; //xml �о���� ���� �ʿ�
		try {
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader); //build�� ���ؼ� Factory ����
			
			session = sf.openSession(true); //Factory�� ���� SqlSession ����
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return session;
	}
	
	public int chk(Member member){
		int result = 0; //���̵� ���� ���
		SqlSession session = null; //HttpSession�� �ƴ� mybatis�� ����ϱ� ���� session
		try {
			session = getSession();
			Member mem = (Member)session.selectOne("select", member.getId()); //select���� �ϳ��� ����� ������������� selectOne
			if(mem.getId().equals(member.getId())){
				result = -1; //���̵�� ���� ����� �ٸ� ���
				if(mem.getPassword().equals(member.getPassword())){
					result = 1; //���̵�� ����� ���� ���
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close(); //SqlSession �� �ݾ� �ڿ��� �����մϴ�.
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
			session.close(); //SqlSession �� �ݾ� �ڿ��� �����մϴ�.
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
			session.close(); //SqlSession �� �ݾ� �ڿ��� �����մϴ�.
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
			session.close(); //SqlSession �� �ݾ� �ڿ��� �����մϴ�.
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
			session.close(); //SqlSession �� �ݾ� �ڿ��� �����մϴ�.
		}
		return result;
	}
}
