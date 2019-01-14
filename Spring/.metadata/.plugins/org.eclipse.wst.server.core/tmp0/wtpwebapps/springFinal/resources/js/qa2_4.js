function find_check() {
	if ($.trim($("#qa_pass").val()) == "") {
		alert("비밀번호를 입력하세요!");
		$("#qa_pass").val("").focus();
		return false;
	}
	if ($.trim($("#qa_subject").val()) == "") {
		alert("글제목을 입력하세요!");
		$("#qa_subject").val("").focus();
		return false;
	}
	if ($.trim($("#qa_content").val()) == "") {
		alert("글내용을 입력하세요!");
		$("#qa_content").val("").focus();
		return false;

	}
}

function ntfind_check() {
	/*if ($.trim($("#nt_name").val()) == "") {
		alert("글쓴이를 입력하세요!");
		$("#nt_name").val("").focus();
		return false;
	}
	if ($.trim($("#nt_pass").val()) == "") {
		alert("비밀번호를 입력하세요!");
		$("#nt_pass").val("").focus();
		return false;
	}*/
	if ($.trim($("#nt_subject").val()) == "") {
		alert("글제목을 입력하세요!");
		$("#nt_subject").val("").focus();
		return false;
	}
	if ($.trim($("#nt_content").val()) == "") {
		alert("글내용을 입력하세요!");
		$("#nt_content").val("").focus();
		return false;
	}
}

function faqfind_check() {
	/*if ($.trim($("#faq_name").val()) == "") {
		alert("글쓴이를 입력하세요!");
		$("#faq_name").val("").focus();
		return false;
	}
	if ($.trim($("#faq_pass").val()) == "") {
		alert("비밀번호를 입력하세요!");
		$("#faq_pass").val("").focus();
		return false;
	}*/
	if ($.trim($("#faq_subject").val()) == "") {
		alert("글제목을 입력하세요!");
		$("#faq_subject").val("").focus();
		return false;
	}
	if ($.trim($("#faq_content").val()) == "") {
		alert("글내용을 입력하세요!");
		$("#faq_content").val("").focus();
		return false;

	}
}

function qnafind_check() {
	/*if ($.trim($("#qna_name").val()) == "") {
		alert("글쓴이를 입력하세요!");
		$("#qna_name").val("").focus();
		return false;
	}
	if ($.trim($("#qna_pass").val()) == "") {
		alert("비밀번호를 입력하세요!");
		$("#qna_pass").val("").focus();
		return false;
	}*/
	if ($.trim($("#qna_subject").val()) == "") {
		alert("글제목을 입력하세요!");
		$("#qna_subject").val("").focus();
		return false;
	}
	if ($.trim($("#qna_content").val()) == "") {
		alert("글내용을 입력하세요!");
		$("#qna_content").val("").focus();
		return false;

	}
}

function write_window() {
	if ($.trim($("#login_email").val()) == ""){
		alert("로그인이 필요한 서비스 입니다!");
		window.location.href = 'khcc_login.nhn';
		/*window.location.href = 'qa_list.nhn';*/
		/*$(location).attr('href','khcc_login.nhn');*/
	}else{
	window.open("qa_write.nhn", "", "width=700,height=700,scrollbars=no");
	}
	// 폭이 420이고 높이가 200,스크롤바가 생성되는 새로운 팝업창을 만듬
}

function ntwrite_window() {
	window.open("nt_write.nhn", "", "width=700,height=700,scrollbars=no");
	// 폭이 420이고 높이가 200,스크롤바가 생성되는 새로운 팝업창을 만듬
	
}
function list()	{	
	    
		//senddata = 'ntpage='  + $("#page").val();
		$.ajax({
		url:'./nt_list.nhn',
		dataType : 'html',
	     success: function(redata){
	    	 output = $(redata).find("#cont").html()	    	
	    	 
	    	 $('#cont').empty();
	    	 
	         $('#cont').append(output);
	  
	    	
	     },
	     error:function(){
	    	 alert("error");
	    	 
	     }
		
	});
	
}

function ntedit_window() {
	var nt_num = document.getElementById('nt_num').value;
	var page = document.getElementById('page').value;
	var url = 'nt_edit.nhn?nt_num=' + nt_num + '&page=' + page + '&state=edit';
	window.open(url, "nt_edit_ok",
			"toolbar = no, status = yes, menubar = no,"
					+ "width = 700, height = 700");
}



function editcont()	{	
	    
	/*senddata = 'page='  + $("#page").val() + '&num=' + $("#nt_num").val() +  '&state=cont'
		$.ajax({
		url:'./nt_cont.nhn',
		data: senddata ,
		dataType : 'html',
	     success: function(redata){
	    	 
	    	 console.log(redata);
	    	 
	    	 output = $(redata).find("div:first").html();	    	
	    	  console.log(output);
	    	  
	    	 $('#cont').empty();	    	 
	         $('#cont').append(output);
	  
	    	
	     },
	     error:function(){
	    	 alert("error");
	    	 
	     }
		
	});*/
	
	$.ajax({
		url:'./nt_cont_ajax.nhn',
		data: "num=" + $("#nt_num").val(),
		dataType: 'html',
	     success: function(redata){
	    	//alert(redata);
	    	 $('#cont').empty();			    	
	    	 $('#cont').append(redata);
	    	 $('#cont script').remove();
	     }
		
	})
	
	
}




function faqwrite_window() {
	window.open("faq_write.nhn", "", "width=700,height=700,scrollbars=no");
	// 폭이 420이고 높이가 200,스크롤바가 생성되는 새로운 팝업창을 만듬
}

function qnawrite_window() {
	if ($.trim($("#login_email").val()) == ""){
		alert("로그인이 필요한 서비스 입니다!");
		window.location.href = 'khcc_login.nhn';
	}else{
	window.open("qna_write.nhn", "", "width=700,height=700,scrollbars=no");
	}
	// 폭이 420이고 높이가 200,스크롤바가 생성되는 새로운 팝업창을 만듬
}

function qnadel_window() {
	var qna_num = document.getElementById('qna_num').value;
	var page = document.getElementById('page').value;
	var url = 'qna_delete.nhn?qna_num=' + qna_num + '&page=' + page + '&state=del';
	window.open(url, "qna_delete_ok",
			"toolbar = no, status = yes, menubar = no,"
					+ "width = 300, height = 200");
}


function qnaedit_window() {
	var qna_num = document.getElementById('qna_num').value;
	var page = document.getElementById('page').value;
	var url = 'qna_edit.nhn?qna_num=' + qna_num + '&page=' + page + '&state=edit';
	window.open(url, "qna_edit_ok",
			"toolbar = no, status = yes, menubar = no,"
					+ "width = 700, height = 700");
} 

function qareply_window() {
	var num = document.getElementById('num').value;
	var page = document.getElementById('page').value;
	var url = 'qa_reply.nhn?num=' + num + '&page=' + page + '&state=reply';
	window.open(url, "qa_reply_ok",
			"toolbar = no, status = yes, menubar = no,"
					+ "width = 700, height = 700");
} 



function qnareply_window() {
	var num = document.getElementById('re_num').value;
	var page = document.getElementById('page').value;
	var url = 'qna_reply.nhn?num=' + num + '&page=' + page + '&state=reply';
	window.open(url, "qna_reply_ok",
			"toolbar = no, status = yes, menubar = no,"
					+ "width = 700, height = 700");
} 


function dellist(){

	$.ajax({
		url:'./qna_list.nhn',
		dataType: 'html',
	     success: function(redata){
	    	console.log(redata);
	    	 $('#qnalist').empty();			    	
	    	 $('#qnalist').append(redata);
	    
	     }
		
	})


	
}
function qadellist(){

	$.ajax({
		url:'./qa_list.nhn',
		dataType: 'html',
	     success: function(redata){
	    	console.log(redata);
	    	 $('#qashow').empty();			    	
	    	 $('#qashow').append(redata);
	    
	     }
		
	})
	
}
function qadel_window() {
	var qa_num = document.getElementById('qa_num').value;
	var page = document.getElementById('page').value;
	var url = 'qa_delete.nhn?qa_num=' + qa_num + '&page=' + page + '&state=del';
	window.open(url, "qa_delete_ok",
			"toolbar = no, status = yes, menubar = no,"
					+ "width = 300, height = 200");
}


function qnaeditcont()	{	
    

	$.ajax({
		url:'./qna_cont_ajax.nhn',
		data: "num=" + $("#qna_num").val(),
		dataType: 'html',
	     success: function(redata){
	    	//alert(redata);
	    	 $('#qnalist').empty();			    	
	    	 $('#qnalist').append(redata);
	    	 $('#cont script').remove();
	     }
		
	})
	
	
}

function qaeditcont()	{	

	$.ajax({
		url:'./qa_cont_ajax.nhn',
		data: "num=" + $("#qa_num").val() + '&state=cont',
		dataType: 'html',
	     success: function(redata){
	    	//alert(redata);
	    	 $('#qashow').empty();			    	
	    	 $('#qashow').append(redata);
	    	 $('#cont script').remove();
	     }
		
	})
	
}

$(document).ready(function(){
	$('.file_input input[type=file]').change(function() {

		var fileName = $(this).val();
		var fileCount = $(this).get(0).files.length;

		if ($(this).get(0).files.length == 1) {

			$('.file_input input[type=text]').val(fileName);

		}

		else {

			$('.file_input input[type=text]').val('파일 ' + fileCount + '개');

		}

	});
	
});



  
