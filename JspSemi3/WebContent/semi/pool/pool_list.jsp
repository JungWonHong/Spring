<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="semi.db.bean.*" %>

<%	
	ArrayList<PMemberBean> list = (ArrayList<PMemberBean>)request.getAttribute("poollist");
	int listcount=((Integer)request.getAttribute("poollistcount")).intValue();
	int nowpage=((Integer)request.getAttribute("poolpage")).intValue();
	int maxpage=((Integer)request.getAttribute("poolmaxpage")).intValue();
	int startpage=((Integer)request.getAttribute("poolstartpage")).intValue();
	int endpage=((Integer)request.getAttribute("poolendpage")).intValue();
%>   
<!DOCTYPE html>
<html>
<head>
<title>����POOL - LIST</title>
<link href="./css/top.css" type="text/css" rel="stylesheet">
<link href="./css/board.css" type="text/css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
<table width=570 border="0" cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="4">���� POOL</td>
		<td align=right>
			<font size=2>���� LIST : <%=listcount %></font>
		</td>
	</tr>
	<tr>
		<th  width="20%">
			<div>ID</div>
		</th>
		<th  width="20%">
			<div>����</div>
		</th>
		<th width="25%">
			<div>�ڰ��� ��/��</div>
		</th>
		<th width="25%">
			<div>��Ʈ������ ��/��</div>
		</th>
		<th  width="10%">
			<div></div>
		</th>
	</tr>		
<%--db���� �� �����ͼ� �ۼ��� ��� �̱� --%>
<%
	//boardList ��ü���� ���� �������� �� ����� ����Ǿ�������, ����� �� ��ϸ�ŭ 
	//for���� ������ boardList�� �ִ� �۵��� �ϳ��� BoardBean ��ü�� ��ƿ���
	//������ �Ӽ� ���� ����Ѵ�.
	for(int i=0; i<list.size(); i++){
		PMemberBean pm = (PMemberBean)list.get(i);
%>
	<tr align="center" valign="middle"
		onmouseover="this.style.backgroundColor='F8F8F8'"		
		onmouseout="this.style.backgroundColor=''">
		<td>
			<div><%=pm.getP_id() %></div>
		</td>
		<td>
			<div><%=pm.getP_age() %></div>
		</td>
		<% 
		String certi = "";
		if(pm.getP_certi() == 1) 
			certi = "���� �ڰ��� ����";
		else
			certi = "�ڰ��� ����";
		%>
		<td>
			<div><%=certi %></div>
		</td>
		<% 
		String portpolio = "";
		if(pm.getP_portpolio() != null && pm.getP_portpolio().length() != 0) 
			portpolio = "��Ʈ������ ����";
		else
			portpolio = "��Ʈ������ ����";
		%>
		<td>
			<div><%=portpolio %></div>
		</td>
		<td>
			<div><a href="./PoolView.bo?p_id=<%=pm.getP_id() %>">����</a></div>
		</td>
	</tr>	
<%
	}
%>
	<tr align=center height=20>
		<td colspan=7>
			<!-- ���� �������� 1�� ��� [����]�� ǥ���� �� ��ũ�� ���� �ʴ´�. ���� ��ġ�� �������� 2�̻��� ��츸
			���� �������� ���ư� �� �����Ƿ�, ���� ������ ���� 1�� ������ ��ũ�� �ʿ䰡 ����. -->
			<%if(nowpage<=1){ %>
			[����]&nbsp;
			<%}else{ %>
			<a href="./Pool.bo?poolpage=<%=nowpage-1 %>">[����]</a>&nbsp;
			<%} %>
			<!-- �ش� ������ �׷��� ���� ���������� ������ ���������� for���� ������. -->
			<%for(int a=startpage; a<=endpage; a++){ 
				//ǥ���� �̵� ������ ������ �� ���� �������� ��ũ�� ���� �ʰ� ǥ��.
				if(a==nowpage){%>
					[<%=a %>]
				<!-- ������������ ������ ������ �̵� ������ �������� ǥ���� ���� ������ �̵��� �ǵ��� ��ũ�� �Ǵ�. -->	
				<%}else{ %>
				<a href="./Pool.bo?poolpage=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			<% if(nowpage>=maxpage){%>
				[����]
			<% }else{ %>
			<a href="./Pool.bo?poolpage=<%=nowpage+1 %>">[����]</a>&nbsp;	
			<%} %>
		</td>
	</tr>
	</table>
	
	<jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>