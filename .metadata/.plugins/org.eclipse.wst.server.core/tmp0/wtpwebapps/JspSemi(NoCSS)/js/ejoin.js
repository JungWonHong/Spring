$(document).ready(function() {
	$(function() {
		// �ڵ�����ȣ �Է� 1
		$('#e_hp').keyup(function() {
			if ($('#e_hp').val().length == 3) {
				if ($.isNumeric($('#e_hp').val())) {
					$('#e_hp2').focus();
				} else {
					alert('���ڷ� �Է��ϼ���.');
					$('#e_hp').val('');
					$('#e_hp').focus();
				}
			}
		});

		// �ڵ�����ȣ �Է� 2
		$('#e_hp2').keyup(function() {
			if ($('#e_hp2').val().length == 4) {
				if ($.isNumeric($('#e_hp2').val())) {
					$('#e_hp3').focus();
				} else {
					alert('���ڷ� �Է��ϼ���.');
					$('#e_hp2').val('');
					$('#e_hp2').focus();
				}
			}
		});

		// �ڵ�����ȣ �Է� 3
		$('#e_hp3').keyup(function() {
			if ($('#e_hp3').val().length == 4) {
				if (!$.isNumeric($('#e_hp3').val())) {
					alert('���ڷ� �Է��ϼ���.');
					$('#e_hp3').val('');
					$('#e_hp3').focus();
				} else {
					$('#email').focus();
				}
			}
		});

		// ������ ���� �κ�
		$('#sel').change(function() {
			if ($('#sel').val() == '') { // �����Է� ������ ���
				$('#domain').val('').focus();
				$('#domain').attr('disabled', false); // Ȱ��ȭ
			} else {
				$('#domain').val($('#sel').val());
				$('#domain').attr('disabled', 'disabled'); // ��Ȱ��ȭ
			}
		});

		var btnclick = false;
		// �ߺ��˻� ��ư Ŭ��
		$("#memcheck").click(function() {
			btnclick = true;
		});

		// ���̵��Է�â �ǵ��
		$("#e_id").keyup(function() {
			btnclick = false;
		});

		// ȸ�����Թ�ư Ŭ����
		$("#esubmit").click(function() {
			if ($.trim($("#e_memname").val()) == "") {
				alert("�̸��� �Է��ϼ���");
				$("#e_memname").focus();
				return false;
			}

			if ($.trim($("#e_id").val()) == "") {
				alert("���̵� �Է��ϼ���");
				$("#e_id").focus();
				return false;
			}

			if (!btnclick) {
				alert("ID�ߺ��˻縦 ���ּ���");
				return false;
			}

			if ($.trim($("#e_pw1").val()) == "") {
				alert("��й�ȣ�� �Է��ϼ���");
				$("#e_pw1").focus();
				return false;
			}

			if ($("#e_pw1").val().length < 8) {
				alert("��й�ȣ�� 8�ڸ� �̻��Դϴ�.");
				$('#e_pw1').val('');
				$("#e_pw1").focus();
				return false;
			}

			if ($.trim($("#e_pw2").val()) == "") {
				alert("��й�ȣ�� Ȯ�����ּ���");
				$("#e_pw2").focus();
				return false;
			}

			if ($.trim($("#e_pw1").val()) != $.trim($("#e_pw2").val())) {
				alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				$("#e_pw1").val('');
				$("#e_pw2").val('');
				$("#e_pw1").focus();
			}

			if ($.trim($("#e_hp").val()) == "" || $.trim($("#e_hp2").val()) || $.trim($("#e_hp3").val())) {
				alert("�޴��� ��ȣ�� �Է��ϼ���");
				$("#e_hp").val('');
				$("#e_hp2").val('');
				$("#e_hp3").val('');
				$("#e_hp").focus();
			}
			
			if ($.trim($("#email").val()) == "") {
				alert("E-mail ID�� �Է��ϼ���");
				$("#email").focus();
				return false;
			}

			if ($.trim($("#domain").val()) == "") {
				alert("E-mail ������ �ּҸ� �Է��ϼ���");
				$("#domain").focus();
				return false;
			}

			if ($.trim($("#e_company").val()) == "") {
				alert("ȸ����� �Է����ּ���");
				$("#e_company").focus();
				return false;
			}
		});
	});
})