<%-- �۾��� �� ������ --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<html>
<head>
<title>MVC �Խ���</title>
<script src="./js/jquery-3.2.1.js"></script>
<script src="./js/rcwrite.js"></script>
<link href="./css/board.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<form action="./RecruitAddAction.bo" method="post" name="boardform" enctype="multipart/form-data">

		<table>
			<tr class="center">
				<th colspan="2">ä��Խ��� write</th>
			</tr>
			<tr>
				<td>
					<div>�����</div>
				</td>
				<td><input id="rc_company" name="rc_company" type="text" value=""></td>
			</tr>
			<tr>
				<td>�������</td>
				<td><select id="rc_hirekind" name="rc_hirekind">
						<option value="">�����ϼ���</option>
						<option value="1">������</option>
						<option value="2">�����</option>
				</select></td>
			</tr>
			<tr>
				<td>��¿���</td>
				<td><select id="rc_career" name="rc_career">
						<option value="">�����ϼ���</option>
						<option value="1">����</option>
						<option value="2">���</option>
						<option value="3">����/���</option>
				</select></td>
			</tr>
			<tr>
				<td>
					<div>�޿�</div>
				</td>
				<td><input id="rc_sal" name="rc_sal" type="text" value=""></td>
			</tr>
			<tr>
				<td>
					<div>ä�� �о�</div>
				</td>
				<td><input id="rc_ability" name="rc_ability" type="text" value=""></td>
			</tr>
			<tr>
				<td>
					<div>�ٷ� �ð�</div>
				</td>
				<td><input id="rc_worktime" name="rc_worktime" type="text" placeholder="ex)��5��  09:00 ~ 18:00" value=""></td>
			</tr>
			<tr>
				<td>
					<div>���� ��¥</div>
				</td>
				<td><input id="rc_expire" type="date" name="rc_expire"></td>
			</tr>
			<tr>
				<td>
					<div>�� ��</div>
				</td>
				<td><input id="rc_title" name="rc_title" type="text" value=""></td>
			</tr>
			<tr>
				<td>
					<div>�󼼳���</div>
				</td>
				<td><textarea name="rc_content" cols="83" rows="15"></textarea>
				</td>
			</tr>
			<tr>
				<td>
					<div>�̷¼����</div>
				</td>
				<td><input name="rc_file" type="file"></td>
			</tr>
			<tr class="center">
				<td colspan="2" class="h30 lime">
					<!-- ����� Ŭ���� ���  addboard()�� ȣ���մϴ�.--> 
					<a id="addrecruit" href="javascript:addboard()">[���]</a>&nbsp;&nbsp; <!-- �ڷθ� Ŭ���� ��� ���� �������� �̵��մϴ�. -->
					<a href="javascript:history.go(-1)">[�ڷ�]</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>