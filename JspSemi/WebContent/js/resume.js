$(document).ready(function() {
	$(function() {
		$('#comment').keyup(function() {
			// ���� ���� ���� ���մϴ�.
			var inputLength = $(this).val().length;
			var cur = inputLength;
			var remain = 500 - inputLength;

			// ���� ��ü�� �Է��մϴ�.
			$('#remain').html(cur + "/500");

			if (remain <= 0) {
				alert("���ڼ� �ʰ�");
			}
		});

		$("#addResume").click(function() {

			if ($("#comment").val().length < 100) {
				if ($.trim($("#comment").val()).length == 0) {
					alert("�Ի� �� ���θ� �ۼ����ּ���")
				} else {
					alert("�Ի� �� ���δ� 100 ~ 500�� �Դϴ�");
				}
				$("#comment").focus();
				return false;
			}
		});
	});
})