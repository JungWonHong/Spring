// addboard()�� ȣ��Ǹ� ���� submit �մϴ�.
function addboard() {
	boardform.submit();
}

$(document).ready(function() {
	$('#sbwrite').click(function() {
		if ($.trim($("#sb_title").val()) == "") {
			alert("�������� �Է��ϼ���");
			$("#sb_title").focus();
			return false;
		}

		if ($.trim($("#sb_content").val()) == "") {
			alert("�۳����� �Է��ϼ���");
			$("#sb_content").focus();
			return false;
		}

	})
})