      $(document).ready(function(){
         $(function(){
            //�ڵ�����ȣ �Է� 1
            $('#p_hp').keyup(function(){
               if($('#p_hp').val().length == 3){
                  if($.isNumeric($('#p_hp').val())){
                     $('#p_hp2').focus();
                  } else {
                     alert('���ڷ� �Է��ϼ���.');
                     $('#p_hp').val('');
                     $('#p_hp').focus();
                  }
               }
            });
            
            //�ڵ�����ȣ �Է� 2
            $('#p_hp2').keyup(function(){
               if($('#p_hp2').val().length == 4){
                  if($.isNumeric($('#p_hp2').val())){
                     $('#p_hp3').focus();
                  } else {
                     alert('���ڷ� �Է��ϼ���.');
                     $('#p_hp2').val('');
                     $('#p_hp2').focus();
                  }
               }
            });
            
            //�ڵ�����ȣ �Է� 3
            $('#p_hp3').keyup(function(){
               if($('#p_hp3').val().length == 4){
                  if(!$.isNumeric($('#p_hp3').val())){
                     alert('���ڷ� �Է��ϼ���.');
                     $('#p_hp3').val('');
                     $('#p_hp3').focus();
                  } else {
                     $('#p_email').focus();
                  }
               }
            });
            
            //������ ���� �κ�
            $('#emailaddr').change(function(){
               if($('#emailaddr').val() == ''){ //�����Է� ������ ���
                  $('#email_dns').val('').focus();
                  $('#email_dns').attr('disabled', false); //Ȱ��ȭ
               } else {
                  $('#email_dns').val($('#emailaddr').val());
                  $('#email_dns').attr('disabled', 'disabled'); //��Ȱ��ȭ
               }
            });
            
            var btnclick = false;
            //�ߺ��˻� ��ư Ŭ��
            $("#confirm_id").click(function(){
               btnclick = true;
            });
            
            //���̵��Է�â �ǵ��
            $("#p_id").keyup(function(){
               btnclick = false;
            });
            
            //ȸ�����Թ�ư Ŭ����
            $("#pjoin").click(function(){
               if($.trim($("#p_name").val())==""){
                  alert("�̸��� �Է��ϼ���");
                  $("#p_name").focus();
                  return false;
               }
               
               if($.trim($("#p_age").val())==""){
                  alert("���̸� �Է��ϼ���");
                  $("#p_age").focus();
                  return false;
               }
               if(!$.isNumeric($("#p_age").val())) {
                  alert("���̴� ���ڸ� �Է� �����մϴ�.");
                  $("#p_age").val("");
                  $("#p_age").focus();
                  return false;
               }
               
               if($.trim($("#p_id").val())==""){
                  alert("���̵� �Է��ϼ���");
                  $("#p_id").focus();
                  return false;
               }
               
               if(!btnclick){
                   alert("ID�ߺ��˻縦 ���ּ���");
                   return false;
                }
               
               if($.trim($("#p_pw").val())==""){
                  alert("��й�ȣ�� �Է��ϼ���");
                  $("#p_pw").focus();
                  return false;
               }
               
               if($("#p_pw").val().length < 8){
                  alert("��й�ȣ�� 8�ڸ� �̻��Դϴ�.");
                  $('#p_pw').val('');
                  $("#p_pw").focus();
                  return false;
               }
               
               if($.trim($("#pw_check").val())==""){
                  alert("��й�ȣ�� Ȯ�����ּ���");
                  $("#pw_check").focus();
                  return false;
               }
               
               if($.trim($("#p_pw").val()) != $.trim($("#pw_check").val())){
                  alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
                  $("#p_pw").val('');
                  $("#pw_check").val('');
                  $("#p_pw").focus();
               }
               
               if($.trim($("#p_email").val())=="") {
                  alert("E-mail ID�� �Է��ϼ���");
                  $("#p_email").focus();
                  return false;
               }
               
               if($.trim($("#email_dns").val())=="") {
                  alert("E-mail ������ �ּҸ� �Է��ϼ���");
                  $("#email_dns").focus();
                  return false;
               }
               
            });
         });
      })