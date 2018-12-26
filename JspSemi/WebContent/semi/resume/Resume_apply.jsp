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
<title>이력서 작서</title>
<script src="./js/jquery-3.2.1.js"></script>
<script src="./js/resume.js"></script>
<script>
	var count = 0;
	var addCount;
	//행추가
	function addInputBox() {
		if (count == 4) {
			alert('자격증은 최대 3개입니다.')
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

	//행삭제
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
				alert("삭제할 행을 체크해 주세요.");
			}
		} else {
			alert("더이상 삭제할 수 없습니다.");
		}
	}
</script>
<link href="./css/board.css" rel="stylesheet" type="text/css" />
<link href="./css/top.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<jsp:include page="../menubar.jsp"></jsp:include>
	<form name="applyResume" method="post" enctype="multipart/form-data"
		action="ApplyCompany.re">
		<table>
			<h3>이력서 등록</h3>
			<tr>
				<td>이름</td>
				<td><%=pmember.getP_name()%></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><%=pmember.getP_age()%></td>
			</tr>
			<tr>
				<td>ID</td>
				<td><%=pmember.getP_id()%> <input type="hidden" name="p_id"
					value=<%=pmember.getP_id()%>></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><%=pmember.getP_hp()%></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><%=pmember.getP_email()%></td>
			</tr>
			<tr>
				<td>지원회사명</td>
				<td><%=cmpname%><input type="hidden" name="cmpname"
					value=<%=cmpname%>></td>
			</tr>
			<tr>
				<td>입사 후 포부(100~500자)</td>
				<td>
					<div>
						<textarea id="comment" rows="10" cols="50" name="comment"></textarea>
						<p id="remain">0/500</p>
					</div>
				</td>
			</tr>
			<tr>
				<td>포트폴리오 첨부</td>
				<td><input type="file" name="portpolio"></td>
			</tr>
			<tr>
				<td>IT관련 자격증(최대 3개)</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
					value="자격증 추가" onclick="javascript:addInputBox();"> | <input
					type="button" value="자격증 삭제"
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
				<td><a id="addResume" href="javascript:applyResume.submit()">[지원]</a>
				</td>
				<td><a href="javascript:history.go(-1)">[뒤로]</a></td>
			</tr>

		</table>
	</form>
	<jsp:include page="../Footer.jsp"></jsp:include>
</body>

</html>