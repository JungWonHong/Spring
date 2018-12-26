<%-- WebContent ���� �Ʒ� upload ���� ���� �� �����ϼ���~ --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- ���ε��ϱ� ���� MultipartRequest ��ü�� import�մϴ�. --%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>

<%-- ���� �̸� �ߺ� ó���� �ϱ� ���� DefaultFileRenamePolicy ��ü�� 
	import �մϴ�. --%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>
<%
	request.setCharacterEncoding("euc-kr");
	//application.getRealPath(path);
	//�� ���ø����̼� path�� ���� ���û��� ���� ��θ� ���ɴϴ�.
	String uploadPath = application.getRealPath("upload");
	out.print(uploadPath);
	
	int size = 10*1024*1024; //���� �ִ� ũ�⸦ 10MB�� �����մϴ�.
	String name = "";
	String subject = "";
	String[] filename = new String[3];
	String[] origfilename = new String[3];
	 
	try{
	  /*
	    ���ε带 ����ϴ� �κ��Դϴ�.
	  -ù ��° ���� request:������ ������ ���� ��� ���� request��ü�� �������ݴϴ�.
	  -�� ��° ���� uploadPath:���ε�� ������ ��ġ �ԴϤ���.
	  -�� ��° ���� size:���ε� �� ũ���̸� ���� ũ�⺸�� ũ�� Exception�߻�
	  -�� ��° ���� "euc-kr": ���� �̸��� �ѱ��� ��� ó���ϴ� �κ��Դϴ�.
	  -�ټ� ��° ����:�Ȱ��� ������ ���ε� �� ��� �ߺ����� �ʵ��� �ڵ����� �����̸��� ��ȯ���ִ� ����� �մϴ�.
	  */
	   MultipartRequest multi =new MultipartRequest(request, 
			   										uploadPath, 
			   										size, 
			   										"euc-kr", 
	                                   new DefaultFileRenamePolicy());
	   
	   name=multi.getParameter("name");
	   subject=multi.getParameter("subject");
	   
	   String paramfilename = "fileName";
	   for(int i=0; i<3; i++){
		   filename[i] = multi.getFilesystemName(paramfilename + (i+1));
		   origfilename[i] = multi.getOriginalFileName(paramfilename + (i+1));
	   }
	} catch(Exception e){
		//e.printStackTrace();
		out.print("���� �Դϴ�.");
	}
%>
<html>
	<body>
		<form name="filecheck" action="fileCheck.jsp" method="post">
			<input type="hidden" name="name" value="<%=name %>">
			<input type="hidden" name="subject" value="<%=subject %>">
			<input type="hidden" name="filename1" value="<%=filename[0] %>">
			<input type="hidden" name="filename2" value="<%=filename[1] %>">
			<input type="hidden" name="filename3" value="<%=filename[2] %>">
			<input type="hidden" name="origfilename1" value="<%=origfilename[0] %>">
			<input type="hidden" name="origfilename2" value="<%=origfilename[1] %>">
			<input type="hidden" name="origfilename3" value="<%=origfilename[2] %>">
		</form>
		<!-- ��ũ�� Ŭ������ �� �� ������ �����͵��� filecheck.jsp �������� 
			  ���� ó���ϴ� �κ��Դϴ�. -->
		<a href="#" onclick="javascript:filecheck.submit()">
		���ε� Ȯ�� �� �ٿ�ε� ������ �̵�</a>
	</body>
</html>