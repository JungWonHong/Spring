<%--
 1. Java Naming and Directory Interface(JNDI)��
	Java ����Ʈ���� Ŭ���̾�Ʈ�� �̸�(name)�� �̿��Ͽ�
	������ �� ��ü�� ã�� �� �ֵ��� �����ִ� ���丮 ���񽺿� ���� Java API�Դϴ�.
	
	* JNDI�� ����ϸ� Java ���α׷��̳� JSP ����������
	    ���� ���α׷� ���� �Ǵ� �ܺο��� ������ �ڿ��� ���� �� �� �ֽ��ϴ�.
	* ������ ���̽� Ŀ�ؼ� Ǯ���� ����ϰ� �� DataSource ��ü��
	    ���̹� ���񽺸� ���� �����̳ʿ��� �����մϴ�.
	    
 2. DBCP(Database Connection Pool)
 	�����ͺ��̽��� ����� Ŀ�ؼ��� �̸� ���� Ǯ(pool) �ӿ� ������ �ΰ� �ִٰ�
 	�ʿ��� �� Ŀ�ؼ��� Ǯ���� ���� �ٽ� Ǯ�� ��ȯ�ϴ� ����� ���մϴ�.
 	�� ���α׷������� �����ͺ��̽��� ȯ�漳���� ���� ���� ���� ����  XML�����̳�
 	�Ӽ� ������ ����ؼ� �����ϰ�,
 	�̷��� ������ ������ �̸��� ����Ͽ� ȹ���ϴ� ����� ����մϴ�.
 	
 	* DBCP�� �̿��� Ŀ�ؼ� Ǯ�� ����ϱ� ���� ���� ��Ĺ ������
 	  DataSource�� ����ؾ� �մϴ�.
 	  context.xml(���ø����̼� ���ؽ�Ʈ�� ���õ� ������ �ϴ� ����)���Ͽ���
 	    �� �� ������ ��ġ�� META-INF�� �����մϴ�.
 	
 	* DBCP ���̺귯�� : tomcat-dbcp.jar ����
 	
 3. DataSource �̿� ���
 	(1) JNDI Server���� lookup()�޼ҵ带 ���� DataSource ��ü�� ���ɴϴ�.
 	(2) DataSource ��ü�� getConnection()�޼ҵ带 ���ؼ� 
 		Connection Pool���� Connection�� ȹ���մϴ�. 
 	(3) Connection ��ü�� ���� DBMS �۾��� �����մϴ�.
 	(4) ��� �۾��� ������ DataSource��ü�� ���ؼ� Connection Pool��
 		Connection�� �ݳ��մϴ�.
 --%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--  Connection ��ü�� JNDI�� ����ϱ� ���� ��Ű���� import�մϴ�.--%>
<%--  �Ϲ� ������ ���̽� �۾��� ���� import�մϴ�. --%>
<%@ page import="java.sql.*" %>

<%-- javax.sql.DataSource ��ü�� ����ϱ� ���� import�մϴ�. --%>
<%@ page import="javax.sql.*" %>

<%-- JNDI�۾��� �ϱ� ����ϱ� ���� import�մϴ�. --%>
<%@ page import="javax.naming.*"  %>
<%
	Connection conn= null;
   
	try{
		//context.xml�� ���ҽ��� ������ ����(JNDI�� ������ ����)
		//jdbc/oracleDB�� �����Ͽ� Connection ��ü�� ��� �ɴϴ�.
		
		//JNDI�� �̿��ϱ� ���� ��ü �����մϴ�.
		Context init = new InitialContext();
		
		// JNDI�� ��� �̸��� �⺻������ java:comp/env�� ��ϵǾ� �ֽ��ϴ�.
		// jdbc/OracleDB : JNDI ���񽺿� �����ϱ� ���� �̸��Դϴ�.
		// lookup(): ��ϵ� naming���񽺷κ��� �ڿ��� ã������ �� ����ϴ� �޼����Դϴ�.
		// Context��ü�� ����Ͽ� �̸����� Resource�� ȹ���մϴ�.
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		
		// JNDI�� �̿��Ͽ� ����� Connection ��ü�� �����ɴϴ�.
		// �� ��ü�� ���� Container�� DBCP�� ���� �����˴ϴ�.
		conn = ds.getConnection();
		
		out.println("<h3>Ŀ�ؼ� Ǯ�� ����Ǿ����ϴ�.</h3>");
		conn.close();
	} catch (Exception e) {
		out.println("<h3>Ŀ�ؼ� Ǯ ���ῡ �����Ͽ����ϴ�.</h3>");
		e.printStackTrace();
	}
%>