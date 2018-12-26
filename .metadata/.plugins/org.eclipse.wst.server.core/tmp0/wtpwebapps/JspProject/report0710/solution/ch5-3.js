  $(document).ready(function() {
    	$("form").submit(function() {
    	 if($("#email").val()==""){
    		alert("이메일을 입력하세요~");
    		$("#email").focus();
    	    return false;
    	 }
    	 if($("#address").val()==""){
    	    alert("주소를 입력하세요~"); 
    		$("#address").focus();
    		return false;
    	 }
    	 if($("#tel").val()==""){
     	    alert("전화번호를 입력하세요~"); 
     		$("#tel").focus();
     		return false;
     	 }
    	});	 
    }); 