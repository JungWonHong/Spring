<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<title>REVIEW 수정</title>

<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/qa2_2.js"></script>
<style>
#ntedit_t{margin-top:10%}
.ntedit_title{	font-size: 30pt;
	font-weight: bold;}
.th1{
	border: 2px solid lightgray;
	width: 100px;
	height: 50px;
	background-color: #2ABCB4;
}

.edtd{
	border: 2px solid lightgray;
	width: 540px;
	height: 50px;
}

.text {
    width:850px;
	height: 300px;
}

#nt_content {
	width: 670px;
	height: 300px
}

#nt_subject {
	width: 560px;
	height: 50px;
}

.file_input span {
	margin-left: 70%;
	display: inline-block;
	overflow: hidden;
	width: 100px;
	height: 30px;
	background: #2ABCB4;
	text-align: center;
	line-height: 30px;
}

.file_input span input {
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

.edit_bt {	
    width: 100px;
	height: 30px;
	background: #2ABCB4;
	border: 0px;
	
}
.subdiv{margin-left:35%; margin-top:5%}
.backdiv{margin-left:52%; margin-top:-4.4%}
.edit_close{
	width: 100px;
	height: 30px; 
	background: lightgray;
	border: 0px;
	
}
.ntfilediv{margin-top:-5%}
</style>
</head>
<body>
 <div id="qawrite_wrap">
  <h2 class="ntedit_title">NOTICE 수정</h2>
  <form method="post" action="nt_edit_ok.nhn" 
  onsubmit="return check()" enctype="multipart/form-data">
  <input type="hidden" name="nt_num" value="${ntbean.nt_num}" />
  <input type="hidden" name="page" value="${page}" />
  
       <input type="hidden" name="nt_name" id="nt_name"
     value="${ntbean.nt_name}" class="input_box" />
     <input type="hidden" name="state" value="${state }"/>
   
   
   <table id="ntedit_t">

    
    <tr>
     <th class="th1">제목</th>
     <td  class="edtd">
      <input name="nt_subject" id="nt_subject" 
      value="${ntbean.nt_subject}" class="input_box" />
     </td>
    </tr>
    
    <tr>
     <td class="edtd" colspan=2>
      <textarea name="nt_content" id="nt_content"
      class="input_box">${ntbean.nt_content}</textarea>
     </td>
    </tr>
    
   <tr>
     <th class="th1">이미지등록</th>
     <td class="edtd">
   
       	<div class="file_input" >

		<span> 파일 첨부 
		<input type="file" name="uploadfile" id="uploadfile">
		</span> 
		<div class="ntfilediv">
		<input title="File Route" type="text" readonly="readonly" id="nt_file">
        </div>
	  </div>
     </td>
    </tr>
   </table>
   
   <div id="qawrite_menu">
   
   <div class="subdiv">
   
        <input type="hidden" name="num" value="${ntbean.nt_num}" id="num" />
        <input type="hidden" name="page" value="${page}" id="page" /> 
    <input type="submit" value="수정" class=edit_bt/>
    </div>
    
    <div class="backdiv">
    <input type="reset" value="취소" class="edit_close"
    onclick="self.close();" />
    </div>
   </div>
  </form>
 </div>
</body>
</html>
<!-- onclick="$('#nt_name').focus(); -->