  $(document).ready(function() {
    	$("form").submit(function() {
    	 if($("#email").val()==""){
    		alert("�̸����� �Է��ϼ���~");
    		$("#email").focus();
    	    return false;
    	 }
    	 if($("#address").val()==""){
    	    alert("�ּҸ� �Է��ϼ���~"); 
    		$("#address").focus();
    		return false;
    	 }
    	 if($("#tel").val()==""){
     	    alert("��ȭ��ȣ�� �Է��ϼ���~"); 
     		$("#tel").focus();
     		return false;
     	 }
    	});	 
    }); 