<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>    
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="semi.db.bean.*" %>
<%@ page import="semi.db.*" %>  
<%	
	String id=(String)session.getAttribute("id");
	List boardList=(List)request.getAttribute("boardlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
%>    
<html>
<head>
<title>Review �Խ���</title>
<link href="./css/board.css" rel="stylesheet" type="text/css"/>
<link href="./css/top.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<!-- �Խ��� ����Ʈ -->
<table width=570 border="0" cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="4">������ �Ҹ�</td>
		<td align=right>
			<font size=2>�� ���� : <%=listcount %></font>
		</td>
	</tr>
	<tr>
		<th  width="8%">
			<div>��ȣ</div>
		</th>
		<th width="50%">
			<div>����</div>
		</th>
		<th width="14%">
			<div>�۾���</div>
		</th>
		<th width="17%">
			<div>�ۼ���</div>	
		</th>
		<th width="11%">
			<div>��ȸ��</div>
		</th>	
	</tr>		
<%--db���� �� �����ͼ� �ۼ��� ��� �̱� --%>
<%
	//boardList ��ü���� ���� �������� �� ����� ����Ǿ�������, ����� �� ��ϸ�ŭ 
	//for���� ������ boardList�� �ִ� �۵��� �ϳ��� BoardBean ��ü�� ��ƿ���
	//������ �Ӽ� ���� ����Ѵ�.
	for(int i=0; i<boardList.size(); i++){
		ReviewBoardBean rv=(ReviewBoardBean)boardList.get(i);
%>
	<tr align="center" valign="middle"
		onmouseover="this.style.backgroundColor='F8F8F8'"		
		onmouseout="this.style.backgroundColor=''">
		<td><%=rv.getRv_no() %></td>
		<td>
			<div>
			<a href="./rvBoardDetailAction.bo?num=<%=rv.getRv_no()%>">
				<%=rv.getRv_title() %>
			</a>	
			</div>
		</td>
		<td>
			<div><%=rv.getRv_id() %></div>
		</td>
		<td>
			<div><%=rv.getRv_date() %></div>
		</td>
		<td>
			<div><%=rv.getRv_count() %></div>
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
			<a href="./rvBoardList.bo?page=<%=nowpage-1 %>">[����]</a>&nbsp;
			<%} %>
			<!-- �ش� ������ �׷��� ���� ���������� ������ ���������� for���� ������. -->
			<%for(int a=startpage; a<=endpage; a++){ 
				//ǥ���� �̵� ������ ������ �� ���� �������� ��ũ�� ���� �ʰ� ǥ��.
				if(a==nowpage){%>
					<b>[<%=a %>]</b>
				<!-- ������������ ������ ������ �̵� ������ �������� ǥ���� ���� ������ �̵��� �ǵ��� ��ũ�� �Ǵ�. -->	
				<%}else{ %>
				<a href="./rvBoardList.bo?page=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			<% if(nowpage>=maxpage){%>
				[����]
			<% }else{ %>
			<a href="./rvBoardList.bo?page=<%=nowpage+1 %>">[����]</a>&nbsp;	
			<%} %>
		</td>
	</tr>
	<tr align="right">
		<td colspan="4">
			<%if(id!=null&&id.length()!=0){%>
				<a href="./rvBoardWrite.bo">[�۾���]</a>	
		</td>
	<%} else {%>
	<tr align="right">
		<td colspan="4">
		&nbsp;
		</td>
	<%} %>	
		<td colspan="1" align="center">
			<a href="./rvBoardList.bo">[ó��]</a>
		</td>	
	</tr>	 
</table>
	<jsp:include page="./rvboard_search.jsp"></jsp:include>
	<jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>