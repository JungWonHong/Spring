<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- JSTL xml�� xml�������� ���� ���Ǵ� ��ɵ��� �±� ���̺귯���� ��� ���� ���Դϴ�. -->
<!-- JSTL xml���̺귯���� ����ϱ� ���� uri �Ӽ��� prefix �Ӽ��� �����մϴ�.-->
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<!DOCTYPE html>
<html>
	<head>
		<title>JSTL xml ���̺귯�� ��� ����(jstl_xml_ex3_jquery.jsp)</title>
	</head>
	<body>
		<div></div>
	</body>
	<script src="../../js/jquery-3.2.1.js"></script>
	<script>
		data = '<students>'
		data += ' <student>'
		data += '  <name lang="�ѱ�">ȫ�浿</name>'
		data += '  <age>18</age>'
		data += '  <gender>��</gender>'
		data += '  <phone>010-3456-11xx</phone>'
		data += ' </student>'
		data += ' <student>'
		data += '  <name lang="�Ϻ�">��浿</name>'
		data += '  <age>19</age>'
		data += '  <gender>��</gender>'
		data += '  <phone>010-4567-00xx</phone>'
		data += ' </student>'
		data += ' <student>'
		data += '  <name lang="�̱�">ȫ���</name>'
		data += '  <age>18</age>'
		data += '  <gender>��</gender>'
		data += '  <phone>����</phone>'
		data += ' </student>'
		data += ' <student>'
		data += '  <name lang="�̱�">����</name>'
		data += '  <age>18</age>'
		data += '  <gender>��</gender>'
		data += '  <phone>����</phone>'
		data += ' </student>'
		data += ' </students>'
		
		//$(document).ready(function(){ //body �Ʒ��� �ֱ� ������ $(document).ready�� �����൵ �ȴ�.
			var xmlData = $.parseXML(data);
			stu = $(xmlData).find('student');
			$(stu).each(function(){
				name = $(this).find('name').text();
				if (name != 'ȫ���') {
					output = name + " ";
					output += $(this).find('age').text() + " ";
					output += $(this).find('gender').text() + " ";
					output += $(this).find('name').attr('lang');
					
					phone = $(this).find('phone').text();
					if (phone == '����')
						phone_message = "��ȭ����";
					else
						phone_message = "��ȭ��ȣ : " + phone;
					
					output += "[" + phone_message + "]<br>";
					
					//innerHTML �Ӽ��� �߰��Ͽ� ����մϴ�.
					document.body.innerHTML += output;
				}
			});
			/* $(xmlData).find('student').each(function(){
				var output = '';
				if($(this).find('name').text() != 'ȫ���'){
					output += $(this).find('name').text() + '&nbsp;';
					output += $(this).find('age').text() + '&nbsp;';
					output += $(this).find('gender').text() + '&nbsp;';
					output += $(this).find('name').attr('lang') + '&nbsp;';
					if($(this).find('phone').text() != '����')
						output += '[��ȭ��ȣ : ' + $(this).find('phone').text() + ']';
					else
						output += '[��ȭ ����]';
					output += '<br>';
				}
				document.body.innerHTML += output;
			}); */
		//});
	</script>
</html>	