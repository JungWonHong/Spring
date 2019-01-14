<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 수정</title>
<link rel="stylesheet" type="text/css" href="./resources/css/admin.css" />
<link rel="stylesheet" type="text/css" href="./resources/css/member.css" />
<script src="./resources/js/jquery-1.12.0.js"></script>
<script src="./resources/js/member.js"></script>
</head>
<body>
	<div id="join_wrap">
		<h2 class="join_title">회원수정</h2>
		<form name="f" method="post" action="member_edit_ok.nhn"
			onsubmit="return edit_check()" enctype="multipart/form-data">
			<!-- 이진파일을 업로드 할려면 enctype 속성을 지정 -->
			<table id="join_t">
				<tr>
					<th>회원아이디</th>
					<td>${id}</td>
				</tr>

				<tr>
					<th>회원비번</th>
					<td><input type="password" name="join_pwd" id="join_pwd"
						size="14" class="input_box" /></td>
				</tr>

				<tr>
					<th>회원비번확인</th>
					<td><input type="password" name="join_pwd" id="join_pwd"
						size="14" class="input_box" /></td>
				</tr>

				<tr>
					<th>회원이름</th>
					<td><input name="join_name" id="join_name" size="14"
						class="input_box" value="${editm.join_name}" /></td>
				</tr>

				<tr>
					<th>우편번호</th>
					<td><input name="join_zip1" id="join_zip1" size="3" class="input_box" readonly 
							onclick="post_search()" value="${editm.join_zip1}" />-
						<input name="join_zip2" id="join_zip2" size="3" class="input_box" readonly
							onclick="post_search()" value="${editm.join_zip2}" /> 
						<input type="button" value="우편번호검색" class="input_button"
							onclick="post_check()" /></td>
				</tr>

				<tr>
					<th>주소</th>
					<td><input name="join_addr1" id="join_addr1" size="50" class="input_box" readonly 
							value="${editm.join_addr1}" onclick="post_search()" /></td>
				</tr>

				<tr>
					<th>나머지 주소</th>
					<td><input name="join_addr2" id="join_addr2" size="37" value="${editm.join_addr2}" 
							class="input_box" /></td>
				</tr>

				

				<tr>
					<th>휴대전화번호</th>
					<td><%@ include file="../include/mypage_include.jsp"%>
						<select name="join_phone1">
							<c:forEach var="p" items="${phone}" begin="0" end="5">
								<c:if test="${join_phone1 == p}">
									<option value="${p}" selected>${p}</option>
								</c:if>
								<c:if test="${join_phone1 != p}">
									<option value="${p}">${p}</option>
								</c:if>
							</c:forEach>


						</select>-
							<input name="join_phone2" id="join_phone2" size="4" maxlength="4"
									class="input_box" value="${join_phone2}" />-
							<input name="join_phone3" id="join_phone3" size="4" maxlength="4"
									class="input_box" value="${join_phone3}" /></td>
				</tr>

				<tr>
					<th>전자우편</th>
					<td><input name="join_mailid" id="join_mailid" size="10"
								class="input_box" value="${join_mailid}" />@ 
						<input name="join_maildomain" id="join_maildomain" size="20"
								class="input_box" readonly value="${join_maildomain}" /> 
						<!--readonly는 단지 쓰기,수정이 불가능하고 읽기만 가능하다 //-->

						<select name="mail_list" onchange="domain_list()">
							<option value="">=이메일선택=</option>
							<c:forEach var="d" items="${email}" begin="0" end="5">
								<c:if test="${join_maildomain == d}">
									<option value="${d}" selected>${d}</option>
								</c:if>
								<c:if test="${join_maildomain != d}">
									<option value="${d}">${d}</option>
								</c:if>
							</c:forEach>
							<option value="0">직접입력</option>
					</select></td>
				</tr>

				<tr>
					<th>프로필사진</th>
					<td><input type="file" name="join_profile" /></td>
				</tr>
			</table>

			<div id="join_menu">
				<input type="submit" value="회원수정" class="input_button" /> 
				<input type="reset" value="수정취소" class="input_button"
						onclick="$('#join_pwd1').focus();" />
			</div>
		</form>
	</div>
</body>
</html>