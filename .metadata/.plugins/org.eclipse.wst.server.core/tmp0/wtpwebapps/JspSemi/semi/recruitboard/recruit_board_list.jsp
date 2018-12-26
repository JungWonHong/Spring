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
<title>ä�� �Խ���</title>
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
		<input type="submit" value="�۾���">
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
						if(r.getRc_company().equals("�Ｚ����")){
							company = "samsung";
						} else if(r.getRc_company().equals("LG����")){
							company = "lg";
						} else if(r.getRc_company().equals("CJ�ø����Ʈ����")){
							company = "cj";
						} else if(r.getRc_company().equals("IBM")){
							company = "ibm";
						} else if(r.getRc_company().equals("�츮����")){
							company = "woori";
						} else if(r.getRc_company().equals("SK�ڷ���")){
							company = "sktelecom";
						}  else if(r.getRc_company().equals("�ż���")){
							company = "shinsegae";
						}  else if(r.getRc_company().equals("��������")){
							company = "shinhan";
						}  else if(r.getRc_company().equals("�ＺSDS")){
							company = "sds";
						}  else if(r.getRc_company().equals("���̹�")){
							company = "naver";
						}  else if(r.getRc_company().equals("�Ե��������")){
							company = "lotte";
						}  else if(r.getRc_company().equals("KT")){
							company = "kt";
						}  else if(r.getRc_company().equals("KIA")){
							company = "kia";
						}  else if(r.getRc_company().equals("��������")){
							company = "kb";
						}  else if(r.getRc_company().equals("īī��")){
							company = "kakao";
						}  else if(r.getRc_company().equals("�ϳ�����")){
							company = "hanabank";
						}  else if(r.getRc_company().equals("Google")){
							company = "google";
						}  else if(r.getRc_company().equals("�ƽþƳ�")){
							company = "asiana";
						}  else if(r.getRc_company().equals("�λ� �������")){
							company = "doosan";
						}  else if(r.getRc_company().equals("�޸ƽ�")){
							company = "humax";
						} 
						%>
						<img src="./image/<%=company %>.JPG" alt=<%=r.getRc_company() %>></a>
					</div>
					<div class="info_box">
						<a style="text-decoration: none" href="./RecruitDetailAction.bo?no=<%=r.getRc_no() %>">
							<dl style="margin-top: 0px;padding-top:0px;">
								<dt><%=r.getRc_ability() %></dt> 
								<dd class="ib_01">���� : <%=r.getRc_expire() %></dd>
								<%if(r.getRc_hirekind() == 1) 
									hirekind = "������";
								  else
									hirekind = "�����";  
								%>
								<dd class="ib_02"><%=hirekind %></dd> 
								<%if(r.getRc_career() == 1)
									career = "����";
								else if(r.getRc_career() == 2)
									career = "���";
								else
									career = "����/���";
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