<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="semi.db.bean.*" %>

<%	
	request.setCharacterEncoding("euc-kr");
	ArrayList<ResumeBean> list = (ArrayList<ResumeBean>)request.getAttribute("resumelist");
%>   
<!DOCTYPE html>
<html>
<head>
<title>�̷¼� LIST</title>
<link href="./css/top.css" type="text/css" rel="stylesheet">
<link href="./css/board.css" type="text/css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
<table width=570 border="0" cellpadding="0" cellspacing="0">
	<tr>
		<th width="70%">
			<div>���� ȸ��</div>
		</th>
		<th  width="30%">
			<div></div>
		</th>
	</tr>		
<%--db���� �� �����ͼ� �ۼ��� ��� �̱� --%>
<%
	//boardList ��ü���� ���� �������� �� ����� ����Ǿ�������, ����� �� ��ϸ�ŭ 
	//for���� ������ boardList�� �ִ� �۵��� �ϳ��� BoardBean ��ü�� ��ƿ���
	//������ �Ӽ� ���� ����Ѵ�.
	for(int i=0; i<list.size(); i++){
		ResumeBean pm = (ResumeBean)list.get(i);
%>
	<tr align="center" valign="middle"
		onmouseover="this.style.backgroundColor='F8F8F8'"		
		onmouseout="this.style.backgroundColor=''">
		<td>
			<div><%=pm.getR_company() %></div>
		</td>
		<td>
			<div><a href="./ResumeDetail.re?r_company=<%=pm.getR_company() %>&r_id=<%=pm.getR_id() %>">����</a></div>
		</td>
	</tr>	
<%
	}
%>
	</table>
	
	<jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>