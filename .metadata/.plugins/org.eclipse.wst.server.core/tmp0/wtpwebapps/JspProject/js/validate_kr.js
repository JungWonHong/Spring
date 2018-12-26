$(document).ready(function(){
	
	//ID�ߺ��˻� �κ�
	$('#idcheck').click(function(){
		if($.trim($('#id').val()) == ''){
			alert('ID�� �Է� �ϼ���');
			$('#id').focus();
			return false;
		} else {
			var ref = 'idcheck.jsp?id=' + $("#id").val();
			window.open(ref, 'idcheck', 'width=350, height=200');
		}
	});
	
	//����˻� ��ư �κ�
	$('#postcode').click(function(){
		window.open('post.jsp', 'post', 'width=400, height=500, scrollbars=yes');
	});
	
	//������ ���� �κ�
	$('#sel').change(function(){
		if($('#sel').val() == ''){ //�����Է� ������ ���
			$('#domain').val('').focus();
			$('#domain').attr('disabled', false); //Ȱ��ȭ
		} else {
			$('#domain').val($('#sel').val());
			$('#domain').attr('disabled', 'disabled'); //��Ȱ��ȭ
		}
	});
	
	//�ֹι�ȣ ���ڸ��� ��Ŀ�� �̵�
	$('#jumin1').keyup(function(){
		if($('#jumin1').val().length == 6){
			if($.isNumeric($('#jumin1').val())){
				$('#jumin2').focus();
			} else {
				alert('���ڷ� �Է��ϼ���.');
				$('#jumin1').val('');
				$('#jumin1').focus();
			}
		}
	});
	
	$('#jumin2').keyup(function(){
		if($('#jumin2').val().length == 7){
			if(!$.isNumeric($('#jumin2').val())){
				alert('���ڷ� �Է��ϼ���.');
				$('#jumin2').val('');
				$('#jumin2').focus();
			}
		}
	});
	
	//ȸ������ ��ư Ŭ���Ҷ� �̺�Ʈ ó�� �κ�
	$('form').submit(function(){
		if($.trim($('#id').val()) == ''){
			alert('ID�� �Է� �ϼ���');
			$('#id').focus();
			return false;
		}
		
		if($.trim($('#pass').val()) == ''){
			alert('��й�ȣ�� �Է� �ϼ���');
			$('#pass').focus();
			return false;
		}
		
		if($.trim($('#jumin1').val()) == ''){
			alert('�ֹι�ȣ ���ڸ��� �Է� �ϼ���');
			$('#jumin1').focus();
			return false;
		}
		
		if($.trim($('#jumin1').val().length) != 6){
			alert('�ֹι�ȣ ���ڸ� 6�ڸ��� �Է��ϼ���');
			$('#jumin1').val('');
			$('#jumin1').focus();
			return false;
		}
		
		if(!$.isNumeric($('#jumin1').val())){
			alert("�ֹι�ȣ ���ڸ��� ���ڸ� �Է� �����մϴ�.");
			$('#jumin1').val('');
			$('#jumin1').focus();
			return false;
		}
		
		if($.trim($('#jumin2').val()) == ''){
			alert('�ֹι�ȣ ���ڸ��� �Է� �ϼ���');
			$('#jumin2').focus();
			return false;
		}
		
		if($.trim($('#jumin2').val().length) != 7){
			alert('�ֹι�ȣ ���ڸ� 7�ڸ��� �Է��ϼ���');
			$('#jumin2').val('');
			$('#jumin2').focus();
			return false;
		}
		
		if(!$.isNumeric($('#jumin2').val())){
			alert("�ֹι�ȣ ���ڸ��� ���ڸ� �Է� �����մϴ�.");
			$('#jumin2').val('');
			$('#jumin2').focus();
			return false;
		}
		
		if($.trim($('#email').val()) == ''){
			alert("E-Mail id�� �Է� �ϼ���");
			$('#email').focus();
			return false;
		}
		
		if($.trim($('#domain').val()) == ''){
			alert("E-Mail �������� �Է� �ϼ���");
			$('#domain').focus();
			return false;
		}
		
		//���1
		var gender1 = $('#gender1').is(':checked');
		var gender2 = $('#gender2').is(':checked'); 
		if(gender1 == false && gender2 == false){
			alert("��, �� �߿��� 1���� ���� �ϼ���.");
			return false;
		}
		
	    //���2.
/*	    if(!$('#gender1').is(':checked') && !$('#gender2').is(':checked')){
	    	alert('��, �� �߿��� 1���� �����ϼ���');
	        return false;
	    }*/
		
		var cnt = 0;
		//���1
/*		if($("#hobby1").is(":checked"))
			cnt++;
		if($("#hobby2").is(":checked"))
			cnt++;
		if($("#hobby3").is(":checked"))
			cnt++;
		if($("#hobby4").is(":checked"))
			cnt++;
		if($("#hobby5").is(":checked"))
			cnt++;*/
			   
		//���2
		$('input:checkbox').each(function(index) {
			id="#hobby"+index;
			if($(id).is(":checked"))
				cnt++;
		});

		//���3
/*		for(var i=0; i<5; i++){
			if($('#hobby' + (i+1)).is(':checked'))
				cnt++;
		}*/
		if(cnt<2){
			alert("2�� �̻� ��̸� ���� �ϼ���.");
			return false;
		}
		
		if($.trim($('#post1').val()) == ''){
			alert("�����ȣ ���ڸ� �Է��ϼ���");
			$('#post1').focus();
			return false;
		}
		
		if(!$.isNumeric($('#post1').val())){
			alert('���ڸ� �Է� ���� �մϴ�.');
			$('#post1').val('');
			$('#post1').focus();
			return false;
		}
		
		if($.trim($('#post2').val()) == ''){
			alert("�����ȣ ���ڸ� �Է��ϼ���");
			$('#post2').focus();
			return false;
		}
		
		if(!$.isNumeric($('#post2').val())){
			alert('���ڸ� �Է� ���� �մϴ�.');
			$('#post2').val('');
			$('#post2').focus();
			return false;
		}
		
		if($.trim($('#address').val()) == ''){
			alert("�ּҸ� �Է��ϼ���");
			$('#address').focus();
			return false;
		}
		
		if($.trim($('#intro').val()) == ''){
			alert("�ڱ�Ұ��� �Է��ϼ���");
			$('#intro').focus();
			return false;
		}
		
	})
});