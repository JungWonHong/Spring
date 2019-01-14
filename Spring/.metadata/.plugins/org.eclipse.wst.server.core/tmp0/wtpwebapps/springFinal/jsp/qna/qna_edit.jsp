<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<title>Q&A 수정</title>
<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/qa2_3.js"></script>
<style>
#qnaedit_t{margin-top:10%}
.qnaedit_title{font-size: 30pt; font-weight: bold;}
th {
	border: 2px solid lightgray;
	width: 100px;
	height: 50px;
	background-color: #2ABCB4;
}

td {
	border: 2px solid lightgray;
	width: 540px;
	height: 50px;
}
.text {
    width:690px;
	height: 300px;
}
#qna_content {
	width: 660px;
	height: 300px
}
#qna_subject {
	width: 550px;
	height: 50px;
}
#qna_pass{
	width: 550px;
	height: 50px;}
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
.qna_edit{	
    width: 100px;
	height: 30px;
	background: #2ABCB4;
	border: 0px;
	
}
.qna_editback {
	width: 100px;
	height: 30px; 
	background: lightgray;
	border: 0px;
	
}

#qnaeditdiv{margin-left:35%; margin-top:5%}
.qnafilediv{margin-top:-5%}

</style>

</head>
<body>
 <div id="qawrite_wrap">
  <h2 class="qnaedit_title">1:1문의 수정</h2>
  <form method="post" action="qna_edit_ok.nhn" 
  onsubmit="return check()" enctype="multipart/form-data">
  <input type="hidden" name="qna_num" value="${qnabean.qna_num}" />
  <input type="hidden" name="page" value="${page}" />
  
   <table id="qnaedit_t">
    <tr>
     <th>ID</th>
     <td>
     <input name="qna_name" id="qna_name"
     value="${qnabean.qna_name}" />
     </td>
    </tr>
    
    <tr>
     <th>PW</th>
     <td>
      <input type="password" name="qna_pass" id="qna_pass" size="14"
             class="input_box" />
     </td>
    </tr>
    
    <tr>
     <th>제목</th>
     <td>
      <input name="qna_subject" id="qna_subject" size="40" 
      value="${qnabean.qna_subject}" class="input_box" />
     </td>
    </tr>
    
    <tr>
     <td colspan="2" class="text">
      <textarea name="qna_content" id="qna_content" rows="8" cols="50"
      class="input_box">${qnabean.qna_content}</textarea>
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
   
   <div id="qnaeditdiv">
    <input type="submit" value="수정" class="qna_edit" />
    <input type="reset" value="취소" class="qna_editback"
    onclick="history.back();" />
   </div>
  </form>
 </div>
</body>
</html>
