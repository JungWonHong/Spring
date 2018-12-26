<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- JSTL xml�� xml�������� ���� ���Ǵ� ��ɵ��� �±� ���̺귯���� ��� ���� ���Դϴ�. -->
<!-- JSTL xml���̺귯���� ����ϱ� ���� uri �Ӽ��� prefix �Ӽ��� �����մϴ�. -->
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
	<head>
		<title>JSTL xml ���̺귯�� ��� ����(jstl_xml_ex.jsp)</title>
	</head>
	<body>
		<!-- XML �����͸� �Ľ�(Ư�������� �о� �鿩�� �̸� �ٸ� ���α׷��̳� ���η�ƾ�� ����� �� �ִ�
			������ ǥ�� ������� ��ȯ���� �ִ� ��)�ϱ� ���� �ڵ��Դϴ�.
			x:parse�±� ���̿� �ִ� XMl ������ �Ľ��Ͽ� xmldata ������ �����մϴ�. -->
		<x:parse var="xmldata">
		<students><%-- student ������Ʈ : XML ������ �Դϴ�. --%>
			<student>
				<name lang="�ѱ�">ȫ�浿</name>
				<age>18</age>
				<gender>��</gender>
				<phone>010-4567-11xx</phone>
			</student>
			<student>
				<name lang="�Ϻ�">��浿</name>
				<age>19</age>
				<gender>��</gender>
				<phone>010-4567-00xx</phone>
			</student>
			<student>
				<name>ȫ���</name>
				<age>18</age>
				<gender>��</gender>
				<phone>����</phone>
			</student>
			<student>
				<name lang="�̱�">����</name>
				<age>18</age>
				<gender>��</gender>
				<phone>����</phone>
			</student>
		</students>
		</x:parse>
		
		<!-- xmldata ������ �ִ� XML ������ ��� student������Ʈ�� ���ʴ�� �����ؼ�
			  �ݺ��մϴ�. -->
		<x:forEach select="$xmldata//student">
			<x:if select="./name!='ȫ���'"> <!-- �̸��� 'ȫ���'�� �ƴҰ�� -->
				<%--name������Ʈ�� ���� ����մϴ�.
					".�ǹ�"(students��� student��� :/students/student )
					"./name"(students��� student��� name���:
								/students/student/name)
				 --%>
				<x:out select="./name"/>
				
				<!-- age������Ʈ�� ���� age������ �����մϴ�. -->
				<x:set select="./age" var="age"/>
				
				<!-- age���� ���� ����մϴ�. -->
				<x:out select="$age"/>
				
				<!-- gender������Ʈ�� ���� ����մϴ�. -->
				<x:out select="./gender"/>
				
				<x:out select=".//@lang"/>
				
				<!-- ���ǹ� -->
				<x:choose>
					<x:when select="./phone!='����'">
						[��ȭ��ȣ : <x:out select="./phone"/>]
					</x:when>
					<x:otherwise>
						[��ȭ ����]
					</x:otherwise>
				</x:choose>
				<br>
			</x:if>
		</x:forEach>
	</body>
</html>