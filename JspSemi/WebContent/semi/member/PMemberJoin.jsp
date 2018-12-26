
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="./js/jquery-3.2.1.js"></script>
<script src="./js/pmjoin.js" charset="euc-kr"></script>
<script>
function openConfirmPid(PMemeberJoinform){
   var id=PMemeberJoinform.p_id.value;
   var url="./MemberIdCheckAction.com?p_id=" + PMemeberJoinform.p_id.value;
   
   if(id.length ==0){
      alert("���̵� �Է��ϼ���.");
      PMemeberJoinform.e_id.focus();
      return false;
   }
   
   open(url, "comfirm", "toobar=no, location=no, status=no, menubar=no," +
         "scrollbar=no, resizable=no, width=400, height=200");
   
}
</script>
<link href="./css/top.css" rel="stylesheet" type="text/css"/>
<link href="./css/board.css" type="text/css" rel="stylesheet">
<style>
input[type=text] {
	border-radius: 5px;
	border: 1px solid silver;
	height: 25px;
}

input[type=password] {
	border-radius: 5px;
	border: 1px solid silver;
	height: 25px;
}

body {
	font-family: 'Lato', sans-serif;
	background: #353535;
	color: #FFF;
}

table {text-align:left;}

tr, table td {
	height: 50px;
	text-align:left;
	padding:0px;
}

input[type=button] {
	background-color: #F7CA18;
	outline: 1;
	border: 1px;
	border-radius: 5px;
	padding: 5px;
	margin: 2px;
}
/* 
table {
	text-align:left;
}
 */
</style>

<title>���� ȸ�� �α���</title>
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<jsp:include page="JoinHeader.jsp"></jsp:include>
<form name = "PMemeberJoinform" action = "pjoinProcess.com" method = "post">
<h2>���� ȸ��</h2>
<table>
  <tr>
    <td>�̸�</td>
    <td><input type = "text" name = "p_name" id="p_name"></td>
  </tr>
   <tr>
    <td>����</td>
    <td><input type = "text" name = "p_age" id="p_age"></td>
  </tr>
  <tr>
    <td>ID</td>
    <td><input type = "text" name = "p_id" id="p_id">
    <input type = "button" name = "confirm_id" id="confirm_id" value = "ID�ߺ��˻�"
    onclick = "openConfirmPid(this.form)">
    <input type = "hidden" value="idDuplication" value = "idUncheck">
     </td>
  </tr>
  <tr>
    <td>P/W</td>
    <td><input type = "password" name = "p_pw" id="p_pw" placeholder="8�ڸ� �̻�"></td>
  </tr>
  <tr>
    <td>P/W CHECK</td>
    <td><input type = "password" name = "pw_check" id="pw_check"></td>
  </tr>
  <tr>
    <td>�޴�����ȣ</td>
    <td><input type = "text" name = "p_hp" id="p_hp"> -
        <input type = "text" name = "p_hp2" id="p_hp2"> -
        <input type = "text" name = "p_hp3" id="p_hp3"></td>
  </tr>
  <tr>
    <td>email</td>
    <td>
      <input type='text' name="p_email" id="p_email">@
      <input type='text' name="email_dns" id="email_dns">
              <select name="emailaddr" id="emailaddr">
                 <option value="">�����Է�</option>
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
    <td colspan = "2" align = center>
      <a id="pjoin" href = "javascript:PMemeberJoinform.submit()">ȸ������</a>
      &nbsp;&nbsp;
      <a href = "javascript:PMemeberJoinform.reset()">�ٽ��ۼ�</a>
    </td>
  </tr>
</table>
</form>
<jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>