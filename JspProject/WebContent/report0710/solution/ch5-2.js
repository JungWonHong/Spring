  $(document).ready(function() {
    	$("form").submit(function() {
    	 if($("#name").val()==""){
    		alert("�̸��� �Է��ϼ���~");
    		$("#name").focus();
    	    return false;
    	 }
    	 if($("#id").val()==""){
    	    alert("���̵� �Է��ϼ���~"); 
    		$("#id").focus();
    		return false;
    	 }
    	});	 
    }); 