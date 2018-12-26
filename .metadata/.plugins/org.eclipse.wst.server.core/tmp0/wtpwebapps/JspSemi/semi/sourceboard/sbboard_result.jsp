<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>    
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="semi.db.bean.*" %>
<%@ page import="semi.db.*" %>  
<%	
	String id=(String)session.getAttribute("id");
	ArrayList boardList=(ArrayList)request.getAttribute("boardlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
	String keyField=(String)request.getAttribute("keyField");
	String keyWord=(String)request.getAttribute("keyWord");

%>    
<html>
<head>
<title>Source Board</title>
<link href="./css/top.css" type="text/css" rel="stylesheet">
<link href="./css/board.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<jsp:include page="../menubar.jsp"></jsp:include>
<!-- �Խ��� ����Ʈ -->
<table width=570 border="0" cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="4">�ڵ� �Խ���(�˻� ���â)</td>
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
		SourceBoardBean sb=(SourceBoardBean)boardList.get(i);
%>
	<tr align="center" valign="middle"
		onmouseover="this.style.backgroundColor='F8F8F8'"		
		onmouseout="this.style.backgroundColor=''">
		<td><%=sb.getSb_no() %></td>
		<td>
			<div>
			<a href="./sbBoardDetailAction.bo?num=<%=sb.getSb_no()%>">
				<%=sb.getSb_title() %>
			</a>	
			</div>
		</td>
		<td>
			<div><%=sb.getSb_id() %></div>
		</td>
		<td>
			<div><%=sb.getSb_date() %></div>
		</td>
		<td>
			<div><%=sb.getSb_count() %></div>
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
			<a href="./sbBoardSearchAction.bo?page=<%=nowpage-1 %>&keyField=<%=keyField%>&keyWord=<%=keyWord%>">[����]</a>&nbsp;
			<%} %>
			<!-- �ش� ������ �׷��� ���� ���������� ������ ���������� for���� ������. -->
			<%for(int a=startpage; a<=endpage; a++){ 
				//ǥ���� �̵� ������ ������ �� ���� �������� ��ũ�� ���� �ʰ� ǥ��.
				if(a==nowpage){%>
					<b>[<%=a %>]</b>
				<!-- ������������ ������ ������ �̵� ������ �������� ǥ���� ���� ������ �̵��� �ǵ��� ��ũ�� �Ǵ�. -->	
				<%}else{ %>
				<a href="./sbBoardSearchAction.bo?page=<%=a %>&keyField=<%=keyField%>&keyWord=<%=keyWord%>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			<% if(nowpage>=maxpage){%>
				[����]
			<% }else{ %>
			<a href="./sbBoardSearchAction.bo?page=<%=nowpage+1 %>&keyField=<%=keyField%>&keyWord=<%=keyWord%>'">[����]</a>&nbsp;	
			<%} %>
		</td>
	</tr>
	<%if(id!=null&&id.length()!=0){ %>
	<tr align="right">
		<td colspan="4">
			<a href="./sbBoardWrite.bo">[�۾���]</a>	
		</td>	
	<%} else {%>
	<tr align="right">
		<td colspan="4">
		&nbsp;
		</td>
	<%} %>	
		<td colspan="1" align="center">
			<a href="./sbBoardList.bo">[ó��]</a>
		</td>	
	</tr>	 
</table>
	<jsp:include page="./sbboard_search.jsp"></jsp:include>
	<jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>