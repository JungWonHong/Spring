<%@ page language="java" 
       contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
   <title>dispatcher.jsp</title>
</head>
<body>
   ����� dispatcher.jsp �Դϴ�. <br>
<!-- request ������ �Ӽ� "food"��� �̸����� ����Ǿ� �ִ� ���� �����ͼ�
   ����϶�� �ǹ��Դϴ�. -->
<%-- jsp���� <%= ~ %>�� �ǹ̴� ����� �ǹ��Դϴ�. --%>
   request �Ӽ� �� : <%=request.getAttribute("food") %>   
</body>
</html>
<%-- ���� �� �ּҶ��� �� Ȯ���� ������.
�������� �ּ� ǥ������ URL ������ ������ ������ jsp�� ���� request ������
�����ϱ� ������ ������ �� jsp ���������� request ������ �����Ǿ� �ִ� ����
������ �����մϴ�. --%>