<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
.delspan{font-size:14pt; margin-left:20%; margin-top:13%}
.sub{width: 100px;
	height: 30px;
	margin-left: 9%;
	background: #2ABCB4;
	border: 0px; margin-top:19%}
.close{width: 100px;
	height: 30px;
	margin-left: 5%;
	background: lightgray;
	border: 0px;
	 margin-top:3%
	}
</style>
</head>
<body>
	<form action="khcc_reportdelete_ok.nhn" method="post">
	<input type="hidden" name="r_NUM" value="${num }"/>
	<input type="hidden" name="page" value="${page }"/>
	<input type="hidden" name="state" value="${state }"/>
	<br>
   <span class="delspan"> 삭제하시겠습니까?</span>
   <input type="submit" value="확인" class="sub"/>
   <input type="button" value="취소" class="close" onclick="javascript:self.close();"/>
   </form>
</body>
</html>