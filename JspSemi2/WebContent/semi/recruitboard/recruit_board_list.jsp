<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="semi.db.bean.*" %>
<%@ page import="semi.db.*" %>
<%
	request.setCharacterEncoding("euc-kr");
	List<RecruitBoardBean> recruitlist = (ArrayList<RecruitBoardBean>)request.getAttribute("recruitlist");
	String hirekind = "";
	String career = "";
%>
<!DOCTYPE html>
<html>
<head>
<title>채용 게시판</title>
<link href="./css/recruit.css" rel="stylesheet" type="text/css"/>
<link href="./css/recruit2.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<%
		String id = (String)session.getAttribute("id");
		if(id!=null && id.length()!=0) {
			if(id.equals("admin")){	
	%>
	<form action="RecruitWrite.bo" method="post">
		<input type="submit" value="글쓰기">
	</form>
	<%}} %>
	<div class="premium_banner">
		<ul>
		<% 
			for(RecruitBoardBean r : recruitlist){
		%>
			<li class="list">
				<div class="box">
					<div class="photo">
						<a href="./RecruitDetailAction.bo?no=<%=r.getRc_no() %>">
						<% 
						String company = "";
						if(r.getRc_company().equals("삼성전자")){
							company = "samsung";
						} else if(r.getRc_company().equals("LG전자")){
							company = "lg";
						} else if(r.getRc_company().equals("CJ올리브네트웍스")){
							company = "cj";
						} else if(r.getRc_company().equals("IBM")){
							company = "ibm";
						}%>
						<img src="./image/<%=company %>.jpg" alt=<%=r.getRc_company() %>></a>
					</div>
					<div class="info_box">
						<a style="text-decoration: none" href="./RecruitDetailAction.bo?no=<%=r.getRc_no() %>">
							<dl style="margin-top: 0px;padding-top:0px;">
								<dt><%=r.getRc_ability() %></dt> 
								<dd class="ib_01">마감 : <%=r.getRc_expire() %></dd>
								<%if(r.getRc_hirekind() == 1) 
									hirekind = "정규직";
								  else
									hirekind = "계약직";  
								%>
								<dd class="ib_02"><%=hirekind %></dd> 
								<%if(r.getRc_career() == 1)
									career = "신입";
								else if(r.getRc_career() == 2)
									career = "경력";
								else
									career = "신입/경력";
								%>
								<dd class="ib_03"><%=career %></dd> 
							</dl>
						</a>
					</div>	
				</div>
			</li>
		<%} %>
		</ul>
	</div>

<jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>