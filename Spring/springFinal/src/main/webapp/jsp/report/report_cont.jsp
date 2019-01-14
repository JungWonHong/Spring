<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
	margin-left: 5%;
	margin-top: 10%;
}

#title {
	font-size: 30pt;
	font-weight: bold;
}

.senpt {
	font-weight: bold;
}

#title1 {
	font-size: 15pt;
	margin-left: 32%;
	margin-top: -7%;
}

#id1, #rid, #file {
	border: 2px solid lightgray;
	width: 100px;
	height: 50px;
	background-color: #2ABCB4;
}

#id11, #file1 {
	border: 2px solid lightgray;
	width: 550px;
	height: 50px;
}

#rid1 {
	border: 2px solid lightgray;
}

#R_CATEGORY, #R_ILLEGALID {
	margin-left: 5%;
	width: 200px;
	height: 25px;
}

#R_CONTENT {
	width: 660px;
	height: 300px;
	margin-left: 0%;
	margin-top: 2%;
	border: 2px solid lightgray;
}

#message {
	width: 110px;
	height: 80px;
	margin-top: 6%;
	margin-left: 15%
}

.delbt {
	width: 100px;
	height: 30px;
	margin-left: 35%;
	background: #2ABCB4;
	border: 0px;
}

.listbt {
	width: 100px;
	height: 30px;
	margin-left: 0%;
	background: lightgray;
	border: 0px;
}

.textdiv {
	margin-top: -20%
}
</style>
<script>
	function report_submit(){
		
	}
</script>
</head>
<body>
	<img src="./resources/images/sender.png" id="message" />
	<div id="title1">
		<span class="senpt">${reportbean.r_SENDER}</span>님이 신고한 쪽지입니다.
	</div>


	<table>

		<tr>
			<td id="id1">신고 유형</td>
			<td id="id11">${reportbean.r_CATEGORY}</td>
		</tr>

		<tr>
			<td id="rid">신고할 회원</td>
			<td id="rid1">${reportbean.r_ILLEGALID}</td>
		</tr>

		<tr>

			<td colspan="2" id="file1">
				<div class="file_input">
					<img src="./resources/upload${reportbean.r_IMG }" width="660"
						height="400" />
				</div>
			</td>
		</tr>

		<tr>
			<td colspan="2" id="R_CONTENT"><div class="textdiv">${reportbean.r_CONTENT}</div></td>
		</tr>
	</table>
	<div>
		<input type="hidden" id="r_num" value="${reportbean.r_NUM}">
   		<input type="hidden" id="r_page" value="${page }">
		<input type="button" id="r_submit" value="접수" class="delbt"
			onclick="javascript:location.href='./submit_report.nhn?illegal=${reportbean.r_ILLEGALID}';" />
		<input type="button" value="목록" class="listbt"
			onclick="location='khcc_reportlist.nhn?page=${page}'" />
	</div>

</body>
</html>