<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<title>REVIEW 수정</title>
<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/qa2_4.js"></script>
<style>
.qaedit_title{font-size: 30pt; font-weight: bold;}
#qaedit_t{margin-top:10%}
th {
	border: 2px solid lightgray;
	width: 100px;
	height: 50px;
	background-color: #2ABCB4;
}

td {
	border: 2px solid lightgray;
	width: 510px;
	height: 50px;
}
.qaedit_pass,.qaedit_name,.qaedit_subject{width:550px;height: 50px;}
.qaedit_text,.qaedit_td{    width:660px;
	height: 300px;}
.file_input label {
	margin-left: 70%;
	display: inline-block;
	overflow: hidden;
	width: 100px;
	height: 30px;
	background: #2ABCB4;
	text-align: center;
	line-height: 30px;
}

.file_input label input {
	position: absolute;
	width: 0;
	height: 0;
	overflow: hidden;
}

.file_input input[type=text] {
	display: inline-block;
	width: 350px;
	height: 28px;
	line-height: 28px;
	font-size: 12px;
	border: 1px solid #777;
	margin-top:-5%;
	margin-left:4%
}


.qaedit_bt{    
    width: 100px;
	height: 30px;
	background: #2ABCB4;
	border: 0px;}
	
.qaedit_back{	width: 100px;
	height: 30px; 
	background: lightgray;
	border: 0px;}	
.qnafilediv{margin-top:-5%}
#qawrite_menu{margin-top:5%; margin-left:36%}
</style>
</head>
<body>
 <div id="qawrite_wrap">
  <div class="qaedit_title">REVIEW 수정</div>

  
  <form method="post" action="qa_edit_ok.nhn" 
  onsubmit="return check()" enctype="multipart/form-data">
  <input type="hidden" name="login_email" id="login_email" value="${login_email}"/>
  <input type="hidden" name="qa_num" value="${qabean.qa_num}" />
  <input type="hidden" name="page" value="${page}" />
  
   <table id="qaedit_t">
    <tr>
     <th>ID</th>
     <td>
     <input name="qa_name" id="qa_name"
     value="${qabean.qa_name}" class="qaedit_name" readonly />
     </td>
    </tr>
    
    <tr>
     <th>PW</th>
     <td>
      <input type="password" name="qa_pass" id="qa_pass"
             class="qaedit_pass" />
     </td>
    </tr>
    
    <tr>
     <th>제목</th>
     <td>
      <input name="qa_subject" id="qa_subject" 
      value="${qabean.qa_subject}" class="qaedit_subject" />
     </td>
    </tr>
    
    <tr>
     <td colspan="2" class="qaedit_td">
      <textarea name="qa_content" id="qa_content"
      class="qaedit_text">${qabean.qa_content}</textarea>
     </td>
    </tr>
    
    <tr>
     <th>이미지등록</th>
     <td>
			<div class="file_input">

							<label> 파일 첨부 
								<input type="file" name="uploadfile" id="uploadfile">

							</label> 
							<div class="qnafilediv">
								<input title="File Route" type="text" readonly="readonly" id="nt_file">
                            </div>
						</div>   
     </td>
    </tr>
   </table>
   
   <div id="qawrite_menu">
   	  <input type="hidden" name="qa_num" value="${qabean.qa_num}" id="qa_num" />
    <input type="submit" value="수정" class="qaedit_bt"/>
    <input type="reset" value="취소" class="qaedit_back"
    onclick="history.back();" />
   </div>
  </form>
 </div>
</body>
</html>
