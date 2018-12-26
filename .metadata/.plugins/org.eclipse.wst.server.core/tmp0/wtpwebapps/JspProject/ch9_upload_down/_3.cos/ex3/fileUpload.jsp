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
	String[] filename = new String[3];
	String[] origfilename = new String[3];
	 
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
	   
	   String paramfilename = "fileName";
	   for(int i=0; i<3; i++){
		   filename[i] = multi.getFilesystemName(paramfilename + (i+1));
		   origfilename[i] = multi.getOriginalFileName(paramfilename + (i+1));
	   }
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
			<input type="hidden" name="filename1" value="<%=filename[0] %>">
			<input type="hidden" name="filename2" value="<%=filename[1] %>">
			<input type="hidden" name="filename3" value="<%=filename[2] %>">
			<input type="hidden" name="origfilename1" value="<%=origfilename[0] %>">
			<input type="hidden" name="origfilename2" value="<%=origfilename[1] %>">
			<input type="hidden" name="origfilename3" value="<%=origfilename[2] %>">
		</form>
		<!-- 링크를 클릭했을 때 폼 영역의 데이터들을 filecheck.jsp 페이지로 
			  전송 처리하는 부분입니다. -->
		<a href="#" onclick="javascript:filecheck.submit()">
		업로드 확인 및 다운로드 페이지 이동</a>
	</body>
</html>