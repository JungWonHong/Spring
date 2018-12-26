<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="semi.db.bean.*"%>
<%
	PMemberBean pmember = (PMemberBean) request.getAttribute("pmember");
	String cmpname = (String) request.getAttribute("cmpname");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�̷¼� �ۼ�</title>
<script src="./js/jquery-3.2.1.js"></script>
<script src="./js/resume.js"></script>
<script>
	var count = 0;
	var addCount;
	//���߰�
	function addInputBox() {
		if (count == 4) {
			alert('�ڰ����� �ִ� 3���Դϴ�.')
			return false;
		}
		
		if (count == 0)
			count++;
		for (var i = 1; i <= count; i++) {
			if (!document.getElementsByName("test" + i)[0]) {
				addCount = i;
				break;
			} else
				addCount = count;
		}

		var addStr = "<tr><td><input type=checkbox name=checkList value=" + addCount + " size=80 >    "
				+ "<input type=text name=test"+addCount+" id='lbfile' size=20 ></td></tr>";
		var table = document.getElementById("dynamic_table");
		var newRow = table.insertRow();
		var newCell = newRow.insertCell();
		newCell.innerHTML = addStr;
		count++;
	}

	//�����
	function subtractInputBox() {
		var table = document.getElementById("dynamic_table");
		//var max = document.gForm.checkList.length;
		//alert(max);
		var rows = dynamic_table.rows.length;
		var checkbox = document.getElementsByName("checkList")
		var chk = 0;
		if (rows > 0) {
			for (var i = 0; i < checkbox.length; i++) {
				if (checkbox[i].checked == true) {
					table.deleteRow(i);
					i--;
					count--;
					chk++;
				}
			}
			if (chk <= 0) {
				alert("������ ���� üũ�� �ּ���.");
			}
		} else {
			alert("���̻� ������ �� �����ϴ�.");
		}
	}
</script>
<link href="./css/board.css" rel="stylesheet" type="text/css" />
<link href="./css/top.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<form name="applyResume" method="post" enctype="multipart/form-data"
		action="ApplyCompany.re">
		<table>
			<h3>�̷¼� ���</h3>
			<tr>
				<td>�̸�</td>
				<td><%=pmember.getP_name()%></td>
			</tr>
			<tr>
				<td>����</td>
				<td><%=pmember.getP_age()%></td>
			</tr>
			<tr>
				<td>ID</td>
				<td><%=pmember.getP_id()%> <input type="hidden" name="p_id"
					value=<%=pmember.getP_id()%>></td>
			</tr>
			<tr>
				<td>����ó</td>
				<td><%=pmember.getP_hp()%></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><%=pmember.getP_email()%></td>
			</tr>
			<tr>
				<td>����ȸ���</td>
				<td><%=cmpname%><input type="hidden" name="cmpname"
					value=<%=cmpname%>></td>
			</tr>
			<tr>
				<td>�Ի� �� ����(100~500��)</td>
				<td>
					<div>
						<textarea id="comment" rows="10" cols="50" name="comment"></textarea>
						<p id="remain">0/500</p>
					</div>
				</td>
			</tr>
			<tr>
				<td>��Ʈ������ ÷��</td>
				<td><input type="file" name="portpolio"></td>
			</tr>
			<tr>
				<td>IT���� �ڰ���(�ִ� 3��)</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
					value="�ڰ��� �߰�" onclick="javascript:addInputBox();"> | <input
					type="button" value="�ڰ��� ����"
					onclick="javascript:subtractInputBox();">
				</td>
			</tr>
			<tr>
				<td colspan=2>
					<table id="dynamic_table" border="1">
					</table>
				</td>
			</tr>
			<tr>
				<td><a id="addResume" href="javascript:applyResume.submit()">[����]</a>
				</td>
				<td><a href="javascript:history.go(-1)">[�ڷ�]</a></td>
			</tr>

		</table>
	</form>
	<jsp:include page="../Footer.jsp"></jsp:include>
</body>

</html>