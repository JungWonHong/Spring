package dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Member;

/*
 ** mybatis �����ӿ�ũ�� �ٽ� ������Ʈ
	1) SqlSession : ���� SQL�� �����ϴ� ��ü�� �� ��ü�� SQL�� ó���ϱ� ����
					JDBC����̹��� ����մϴ�.
					
	2) SqlSessionFactor : SqlSession ��ü�� �����մϴ�.
	
	3) SqlSessionFactoryBuilder : ���̹�Ƽ�� ���� ������ ������ ����
								  SqlSessionFactory�� �����մϴ�.
								  
	4) mybatis ���� ���� : ������ ���̽� ���� ����, Ʈ����� ����,
						mybatis ���� ���� ���� ���� ������ �����ϰ� �ֽ��ϴ�.
						SqlSessionFactory �� ���� �� ���˴ϴ�.
						
	5) SQL ���� ���� : SQL���� ��� �ִ� ���Ϸ� SqlSession ��ü�� �����մϴ�.
 
 ** SqlSession�� �ֿ� �޼���
 	1) selectList() : Select ���� �����մϴ�.
 					   �� ��ü(Value Object) ����� ��ȯ�մϴ�.
 	2) selectOne() : select ���� �����մϴ�. �ϳ��� �� ��ü�� ��ȯ�մϴ�.
 	3) insert() : insert���� �����մϴ�. ��ȯ���� �Է��� �������� �����Դϴ�.
 	4) update() : update���� �����մϴ�. ��ȯ���� ������ �������� �����Դϴ�.
 	5) delete() : delete���� �����մϴ�. ��ȯ���� ������ �������� �����Դϴ�.
 */
public class MemberDao_���� {
	private SqlSession getSession() { //mybatis������ SqlSession�� �ʿ�.  ������ Connection�� �����ƴ�.
		SqlSession session = null;
		Reader reader = null; //xml �о���� ���� �ʿ�
		try {
			//sqlMapConfig.xml�� �о���� ���� Resources Ŭ������ ����մϴ�.
			//getResourceAsReader() �޼��带 �̿��ϸ� �ڹ� Ŭ���� ��ο� �ִ�
			//������ �Է� ��Ʈ���� �ս��� ���� �� �ֽ��ϴ�.
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			//SqlSessionFactoryBulider : ���̹�Ƽ�� ���� ������ ������ ����
			//SqlSessionFactory�� �����մϴ�.
			//build()�� ���� SqlSessionFactory ��ü�� �����մϴ�.
			//build()�� �Ű����� ������ ���̹�Ƽ�� ���� ������ �Է� ��Ʈ���� �Ѱ��־�� �մϴ�.
			//���̹�Ƽ�� ���� ������ ���� �ڹ� Ŭ���� ���(CLASSPATH)�� �Ӵϴ�.
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader); //build�� ���ؼ� Factory ����
			
			//SqlSessionFactory�� ���ؼ� SqlSession��ü�� �����մϴ�.
			//openSession()�� �Ű����� ���� true�� �����ϸ� �ڵ� Ŀ���� �����ϴ�
			//SqlSession��ü�� ��ȯ�մϴ�.
			session = sf.openSession(true); //Factory�� ���� SqlSession ����
			//session = sf.openSession();
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
}
