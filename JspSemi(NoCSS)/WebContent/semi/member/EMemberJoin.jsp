<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>기업 회원 로그인</title>
<script src="./js/jquery-3.2.1.js"></script>
<script src="./js/ejoin.js" charset="euc-kr"></script>
<script>
function openConfirmEid(EMemeberJoinform){
	var id=EMemeberJoinform.e_id.value;
	var url="./MemberIdCheckAction.com?e_id=" + EMemeberJoinform.e_id.value;
	
	if(id.length ==0){
		alert("아이디를 입력하세요.");
		EMemeberJoinform.e_id.focus();
		return false;
	}
	
	open(url, "comfirm", "toobar=no, location=no, status=no, menubar=no," +
			"scrollbar=no, resizable=no, width=400, height=200");
	
}
</script>


</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<jsp:include page="JoinHeader.jsp"></jsp:include>
<form name = "EMemeberJoinform" action = "ejoinProcess.com" method = "post">
<table>
 <h2>기업 회원</h2>
  <tr>
    <td>가입자명</td>
    <td><input type = "text" name = "e_memname" id="e_memname"></td>
  </tr>
  <tr>
    <td>ID</td>
     <td><input type = "text" name = "e_id" id="e_id">
    <input id="memcheck" type = "button" name = "confirm_id" value = "ID중복검사"
    onclick = "openConfirmEid(this.form)">
    <input type = "hidden" value="idDuplication" value = "idUncheck">
    </td>
  </tr>
  <tr>
    <td>PW</td>
    <td><input type = "password" name = "e_pw" id="e_pw1" placeholder="8자리 이상"></td>
  </tr>
  <tr>
    <td>PW CHECK</td>
    <td><input type = "password" name = "e_pw2" id="e_pw2"></td>
  </tr>
  <tr>
    <td>전화번호</td>
    <td><input type = "text" name = "e_hp" id = "e_hp"> -
        <input type = "text" name = "e_hp2" id = "e_hp2"> -
        <input type = "text" name = "e_hp3" id = "e_hp3">
    </td>
  </tr>
  <tr>
    <td>email</td>
    <td>
      <input type='text' name="e_email" id="email">@
      <input type='text' name="email_dns" id="domain">
              <select name="emailaddr" id="sel">
                 <option value="">직접입력</option>
                 <option value="daum.net">daum.net</option>
                 <option value="empal.com">empal.com</option>
                 <option value="gmail.com">gmail.com</option>
                 <option value="hanmail.net">hanmail.net</option>
                 <option value="msn.com">msn.com</option>
                 <option value="naver.com">naver.com</option>
                 <option value="nate.com">nate.com</option>
              </select>
    </td>
  </tr>
  <tr>
    <td>회사명</td>
    <td><input type = "text" name = "e_company" id="e_company"></td>
  </tr>
   <tr>
    <td colspan = "2" align = center>
      <a id="esubmit" href = "javascript:EMemeberJoinform.submit()">회원가입</a>
      &nbsp;&nbsp;
      <a href = "javascript:EMemeberJoinform.reset()">다시작성</a>
    </td>
  </tr>  
</table>
</form>
</body>
</html>