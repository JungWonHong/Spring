  $(document).ready(function() {
    	$("form").submit(function() {
    	 if($("#name").val()==""){
    		alert("이름을 입력하세요~");
    		$("#name").focus();
    	    return false;
    	 }
    	 if($("#id").val()==""){
    	    alert("아이디를 입력하세요~"); 
    		$("#id").focus();
    		return false;
    	 }
    	});	 
    }); 