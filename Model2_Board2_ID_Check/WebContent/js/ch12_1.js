$(document).ready(function() {
	// ������ ����ϴ�.
	$("#result").hide();
	var data_check = -1; //���̵� �ߺ� Ȯ�� ��ư Ŭ�� ������ Ȯ���ϱ� ���� ����
						//DB�� ���̵� ������(data_check==-1)
	sid=$("#id").val();
	$("a:first-child").click(function() {
		sid2 = $("#id").val(); //��밡���� ���̵��ε� ������ ��츦 üũ�ϱ� ���� ���� �������ϴ�.
		/*
		  1.(data_check==1) : DB�� ���̵� ������
		  2.(sid != sid2) : �ߺ� üũ �� ��밡���� ���̵��� �޽��� ��������
		  					���̵� �����ϰ� �ߺ� üũ���� ���� ���
		 */
		if(sid != sid2 || data_check == 1){
			alert("ID�ߺ��˻縦 ���ּ���");
			return false;
		}
		
		
		if ($.trim($("input").eq(0).val()) == "") {
			alert("ID�� �Է��ϼ���");
			$("input:eq(0)").focus();
			return false;
		}
		if ($.trim($("input").eq(2).val()) == "") {
			alert("��й�ȣ�� �Է��ϼ���");
			$("input:eq(2)").focus();
			return false;
		}
		if ($.trim($("input").eq(3).val()) == "") {
			alert("�̸��� �Է��ϼ���");
			$("input:eq(3)").focus();
			return false;
		}
		if ($.trim($("input").eq(4).val()) == "") {
			alert("���̸� �Է��ϼ���");
			$("input:eq(4)").focus();
			return false;
		}
		if (!$.isNumeric($("input").eq(4).val())) {
			alert("���̴� ���ڷ� �Է��ϼ���");
			$("input:eq(4)").val('');
			$("input:eq(4)").focus();
			return false;
		}

		if ($.trim($("input").eq(7).val()) == "") {
			alert("�̸����� �Է��ϼ���");
			$("input:eq(7)").focus();
			return false;
		}
	});

	// id �ߺ� Ȯ�� Ŭ����
	$("#idcheck").click(function() {
		// id�� �Է����� ���� ���
		if ($.trim($("#id").val()) == "") {
			alert("ID�� �Է��ϼ���");
			$("#id").focus();
			return false;
		}

		// ���̵� �ߺ�Ȯ�� ���۽�
		sid = $("#id").val();
		$.ajax({
			type : "post",
			url : "Idcheckajax.net",
			data : {
				"id" : sid
			},
			cache : false,
			success : function(data) {
				data_check = data;
				if (data == 1) {// DB�� ���̵� ������
					// $("#result").text("���̵� �̹� �����մϴ�.").css("color", "red");
					// $("#result").css("color", "red");
					// $("#result").show();
					var newtext = '�ߺ� ���̵��Դϴ�.';
					$("#result").text('');
					$("#result").show();
					$("#result").css('color', 'red').append(newtext);
					$("#id").val('').focus();
				} else if (data == -1) {// DB�� ���̵� ������
					// $("#result").text("���̵� ��� �����մϴ�.").css("color", "blue");
					// $("#result").show();
					var newtext = '��밡���� ���̵��Դϴ�.';
					$("#result").text('');
					$("#result").show();
					$("#result").css('color', 'blue').append(newtext);
					check = true;
				}
			},
			error : function() {
				alert("data error2");
			}
		});// $.ajax
	}); // ���̵� �ߺ�üũ end
});// ready() end
