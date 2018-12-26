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
<style>
input[type=submit]{
background-color: #F7CA18;
border-radius: 5px;
border : 0px;
padding : 5px;
margin-left : 10px;
margin-top:40px;
height : 50px;
width : 70px;
}
</style>
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<jsp:include page="../menubar.jsp"></jsp:include>
	
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
						} else if(r.getRc_company().equals("우리은행")){
							company = "woori";
						} else if(r.getRc_company().equals("SK텔레콤")){
							company = "sktelecom";
						}  else if(r.getRc_company().equals("신세계")){
							company = "shinsegae";
						}  else if(r.getRc_company().equals("신한은행")){
							company = "shinhan";
						}  else if(r.getRc_company().equals("삼성SDS")){
							company = "sds";
						}  else if(r.getRc_company().equals("네이버")){
							company = "naver";
						}  else if(r.getRc_company().equals("롯데정보통신")){
							company = "lotte";
						}  else if(r.getRc_company().equals("KT")){
							company = "kt";
						}  else if(r.getRc_company().equals("KIA")){
							company = "kia";
						}  else if(r.getRc_company().equals("국민은행")){
							company = "kb";
						}  else if(r.getRc_company().equals("카카오")){
							company = "kakao";
						}  else if(r.getRc_company().equals("하나은행")){
							company = "hanabank";
						}  else if(r.getRc_company().equals("Google")){
							company = "google";
						}  else if(r.getRc_company().equals("아시아나")){
							company = "asiana";
						}  else if(r.getRc_company().equals("두산 정보통신")){
							company = "doosan";
						}  else if(r.getRc_company().equals("휴맥스")){
							company = "humax";
						} 
						%>
						<img src="./image/<%=company %>.JPG" alt=<%=r.getRc_company() %>></a>
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