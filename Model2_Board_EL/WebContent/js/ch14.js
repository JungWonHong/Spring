//addboard()�� ȣ��Ǹ� ���� submit �մϴ�.

function addboard() {
	boardform.submit();
}

$(document).ready(function() {
	$("a:first-child").click(function() {
		if ($.trim($("input:eq(0)").val()) == "") {
			alert("�۾��̸� �Է��ϼ���");
			$("input:eq(0)").focus();
			return false;
		}
		if ($.trim($("input").eq(1).val()) == "") {
			alert("��й�ȣ�� �Է��ϼ���");
			$("input:eq(1)").focus();
			return false;
		}
		if ($.trim($("input").eq(2).val()) == "") {
			alert("������ �Է��ϼ���");
			$("input:eq(2)").focus();
			return false;
		}
		if ($.trim($("textarea").val()) == "") {
			alert("������ �Է��ϼ���");
			$("textarea").focus();
			return false;
		}
	});
})