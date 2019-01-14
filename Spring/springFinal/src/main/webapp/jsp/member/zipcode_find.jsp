<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- JSTL 태그라이브러리 -->
<html>
<head>
<title>우편번호 검색</title>

<!-- 
 select 객체에서 검색된 동을 선택했을때 change 이벤트가 발생합니다.
 zip1 변수에는 우편번호 앞 세자리를  
 zip2 변수에는 우편번호 뒷자리 세자리를  
 addr2변수에는 나머지 주소를 저장합니다.

*/ -->
<link rel="stylesheet" type="text/css" href="./resources/css/admin.css">
<link rel="stylesheet" type="text/css" href="./resources/css/member.css">
<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/member4.js"></script>
<script>
	$(function() {
		$("#inputdong").focus();

		$("#post_list").change(function() {
			var zip = $("#post_list").val();
			var zip1 = zip.substring(0, 3);//0번째 부터 3번째 미만(2번째)사이의 문자열 추출 - 첫번째 우편번호(123 추출)
			var zip2 = zip.substring(4, 7);//4번째 부터 7번째 미만(6번째)사이의 문자열 추출 - 두번째 우편번호 (456 추출)
			var addr2 = zip.substring(7, (zip.length)); //7번째 부터 끝문자까지  추출 - 나머지 주소값을 저장

			//		id 뒤에 opener.document 또는 parent.document 를 사용하여  부모창의 문서 객체를 제어합니다.
			$("#join_zip1", opener.document).val(zip1);
			$("#join_zip2", opener.document).val(zip2);
			$("#join_addr1", opener.document).val(addr2);

			/*  팝업 윈도우 창을 닫아줍니다. */
			window.close();
			
		});//change end

		//동을 입력하지 않을 경우 체크 합니다.
		$("#zipform").submit(function() {
			if ($("#inputdong").val() == "") {
				alert("동을 입력해 주세요!");
				$("#inputdong").focus();
				return false;
			}//if end
		});//form submit

	});//ready end
</script>

</head>
<body>
	<form method="post" action="zipcode_find_ok.nhn" id="zipform">
		<table border="0">
			<tr>
				<td colspan=2 bgcolor="#999999" align="center">
				<input type="image" src="./resources/images/ZipCode_img01.gif" 
						width="413" height="58"></td>
			</tr>
			<tr>
				<td colspan=2 bgcolor="f5ffea" align="center">
				<strong>
				<font color="#466d1b"> 
				<span class="style1">[거주지의 면.동을 입력하고 '찾기'버튼을 누르세요!!!]</span>
				</font>
				</strong>
				</td>
			</tr>
			<tr height="30">
				<td bgcolor="f5ffea" align="right">
					<input type="text" name="dong" id="inputdong" size="10" maxlength="10" height="19">
						&nbsp;
				</td>
				<td>
					<input type="image" src="./resources/images/m-i02.gif"
					width="69
					" height="19">
				</td>
			</tr>

			<!-- 동을 입력했다면 실행되는 JSTL if 문  -->
			<c:if test="${!empty dong}">
				<!-- 검색결과 주소값이 있을 경우만 실행되는 JSTL if 문 -->
				<c:if test="${!empty zipcodelist}">
					<tr>
						<td colspan=2 bgcolor="f5ffea" class="center30"><SELECT
							NAME="post_list" id="post_list">
								<option value="">----주소를 선택하세요----</option>

								<!-- items 속성에는 검색 결과의 주소값을 담고 있는 키값을 적습니다.
                      					addr2 변수에는 주소값을 받아서 저장합니다.-->
								<c:forEach var="addr2" items="${zipcodelist}">

									<%-- addr2.zipcode에는 ZipcodeBean 클래스의 getZipcode()메서드에서 구해온   우편번호,
                         			addr2.addr에는 ZipcodeBean 클래스의 getAddr()메서드를 가져와 시도 구군 동을 합친 값을 가져와서
                                                        변수 totaladdr에 저장합니다. 우편번호 시도 구군 동이 저장됩니다. 
                                                        예)[123-456] 서울시 개포1동 ~    --%>
									<c:set var="totaladdr" value="${addr2.zipcode}${addr2.addr}" />

									<%-- 결과 받아온 대로 option을 만듭니다. --%>
									<option value="${totaladdr}">[${addr2.zipcode}]&nbsp;${addr2.addr}</option>
								</c:forEach>
								<!-- JSTL c:forEach 반복문 -->
						</SELECT></td>
					</tr>
				</c:if>

				<!-- JSTL 에서 검색 주소값이 없을 경우 실행되는 if 문. -->
				<c:if test="${empty zipcodelist}">
					<tr>
						<td colspan=2 bgcolor="f5ffea" class="center30">
						<font color="#466d1b"><span class="style1">검색 결과가 없습니다.</span></font></td>
					</tr>
				</c:if>
			</c:if>
			<tr>
				<td bgcolor="508C0F" colspan="2" height="3"></td>
			</tr>
		</table>
	</form>
</body>
</html>