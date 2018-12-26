<%--
	* ǥ�����(Expression Language : EL)
	     ��Ĺ���� �����ϱ� ������ ���� ������ �ʿ� �����ϴ�.
	  JSP ��ũ��Ʈ ����Ͽ� �Ӽ� ������ �� �� �����ϰ� ����ϱ� ���� �����Ǵ� ����Դϴ�.
	  
	    ǥ���� �±�
	  1. <%=article.getId()%>  //article - �ڹٺ�
	  2. <%=session.getAttribute("test")%>
	  3. <%=request.getParameter("name")%>
	  4. <%=request.getParameterValues("hobby")%>
	  5. <%=request.getAttribute("hoho")%>
	  
	    ǥ�����(EL)
	  1. ${article.id} �Ǵ� ${article["id"]} �Ǵ� ${article['id']}
	  2. ${sessionScope.test}
	  3. ${param.name}
	  4. ${paramValues.hobby} ����� ��Ʈ�� �迭(String[])
	  	���ʴ�� ����� ���
	  	- ${paramValues.hobby[0] }
	  	- ${paramValues.hobby[1] }
	  	- ${paramValues.hobby[2] }
	  5. ${requestScope.hoho}
	  	  �Ǵ�
	  	 ${hoho} :
	  	 �� ��쿡�� page -> request -> session -> application ���� ������
	  	'hoho'�̸��� attribute�� ã���ϴ�.
 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
 <title>EL ���尴ü ��� ����</title>
 <style>
    table{margin : 0 auto}
    td{width:100px;height:30px;text-align:center}
    tr:nth-child(1){background:yellow}
    tr:nth-child(2){background:lime}
 </style>
</head>
<body>
  <form action="el_result.jsp" method="post">
   <table border=1>
	<tr>
	   <td>�̸�  </td>
	   <td><input type="text" name="name" value="ȫ�浿"></td>
	</tr> 
	<tr>
	  <td>���</td>
	  <td> 
	    <input type="checkbox" name="hobby" id="hobby1" value="����">����
		<input type="checkbox" name="hobby" id="hobby2" value="���">��� 
	   </td>
	</tr>
	<tr>
	   <td colspan="2" align="center">
	     <input type="submit" value="�Է�"></td>
	</tr>
   </table>
  </form>
</body>
</html>