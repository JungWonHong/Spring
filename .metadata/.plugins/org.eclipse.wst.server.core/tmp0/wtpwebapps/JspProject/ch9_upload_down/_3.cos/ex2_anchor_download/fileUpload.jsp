<%-- WebContent 폴더 아래 upload 폴더 생성 후 실행하세요~ --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- 업로드하기 위해 MultipartRequest 객체를 import합니다. --%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>

<%-- 파일 이름 중복 처리를 하기 위해 DefaultFileRenamePolicy 객체를 
	import 합니다. --%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>
<%
	request.setCharacterEncoding("euc-kr");
	//application.getRealPath(path);
	//웹 어플리케이션 path에 대한 로컬상의 실제 경로를 얻어옵니다.
	String uploadPath = application.getRealPath("upload");
	out.print(uploadPath);
	
	int size = 10*1024*1024; //파일 최대 크기를 10MB로 지정합니다.
	String name = "";
	String subject = "";
	String filename1 = "";
	String filename2 = "";
	String origfilename1="";
	String origfilename2="";
	 
	try{
	  /*
	    업로드를 담당하는 부분입니다.
	  -첫 번째 인자 request:폼에서 가져온 값을 얻기 위해 request객체를 전달해줍니다.
	  -두 번째 인자 uploadPath:업로드될 파일의 위치 입니ㅏㄷ.
	  -세 번째 인자 size:업로드 할 크기이며 지정 크기보다 크면 Exception발생
	  -네 번째 인자 "euc-kr": 파일 이름이 한글인 경우 처리하는 부분입니다.
	  -다섯 번째 인자:똑같은 파일을 업로드 할 경우 중복되지 않도록 자동으로 파일이름을 변환해주는 기능을 합니다.
	  */
	   MultipartRequest multi =new MultipartRequest(request, 
			   										uploadPath, 
			   										size, 
			   										"euc-kr", 
	                                   new DefaultFileRenamePolicy());
	   
	   name=multi.getParameter("name");
	   subject=multi.getParameter("subject");
	   
	   //폼에서 넘어온 파일 이름
	   Enumeration files = multi.getFileNames();
	   
	   //첫번째 파일 이름을 얻어 옵니다.
	   String file1 = (String)files.nextElement();
	   out.println("<br>첫번째 파일 files.nextElemet()=" + file1);
	   
	   //첫번째 업로드된 파일의 시스템 상에 업로드된 실제 파일명을 얻어 옵니다.
	   filename1 = multi.getFilesystemName(file1);
	   out.println("<br>multi.getFilesystemName(file1)=" + filename1);
	   
	   //첫번째 업로드된 파일의 원본 파일명을 얻어 옵니다.
	   origfilename1 = multi.getOriginalFileName(file1);
	   out.println("<br>multi.getOriginalFileName(file1)=" + origfilename1);
	   
	   //두번째 파일 이름을 얻어 옵니다.
	   String file2 = (String)files.nextElement();
	   out.println("<br>첫번째 파일 files.nextElemet()=" + file2);
	   
	   //첫번째 업로드된 파일의 시스템 상에 업로드된 실제 파일명을 얻어 옵니다.
	   filename2 = multi.getFilesystemName(file2);
	   out.println("<br>multi.getFilesystemName(file2)=" + filename2);
	   
	   //첫번째 업로드된 파일의 원본 파일명을 얻어 옵니다.
	   origfilename2 = multi.getOriginalFileName(file2);
	   out.println("<br>multi.getOriginalFileName(file2)=" + origfilename2);
	} catch(Exception e){
		//e.printStackTrace();
		out.print("에러 입니다.");
	}
%>
<html>
	<body>
		<form name="filecheck" action="fileCheck.jsp" method="post">
			<input type="hidden" name="name" value="<%=name %>">
			<input type="hidden" name="subject" value="<%=subject %>">
			<input type="hidden" name="filename1" value="<%=filename1 %>">
			<input type="hidden" name="filename2" value="<%=filename2 %>">
			<input type="hidden" name="origfilename1" value="<%=origfilename1 %>">
			<input type="hidden" name="origfilename2" value="<%=origfilename2 %>">
		</form>
		<!-- 링크를 클릭했을 때 폼 영역의 데이터들을 filecheck.jsp 페이지로 
			  전송 처리하는 부분입니다. -->
		<a href="#" onclick="javascript:filecheck.submit()">
		업로드 확인 및 다운로드 페이지 이동</a>
	</body>
</html>