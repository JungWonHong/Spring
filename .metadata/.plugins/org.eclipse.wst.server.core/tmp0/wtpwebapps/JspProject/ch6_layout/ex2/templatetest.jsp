<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String pagefile = request.getParameter("page");
	if (pagefile == null) {
		pagefile = "newitem";
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<title>templatetest.jsp</title>
		<link rel="stylesheet" href="style.css" type="text/css">
	</head>
	<body>
		<header>
			<h1>Header</h1><br>
		</header>
		<nav>
			<jsp:include page="top.jsp"/><br><br>
		</nav>
		<div id="wrap">
			<aside>
				<jsp:include page="left.jsp"/>
			</aside>
			<section>
				<jsp:include page='<%=pagefile + ".jsp" %>'/>
			</section>
		</div>
		<footer>
			<jsp:include page="bottom.jsp"/>
		</footer>
	</body>
</html>