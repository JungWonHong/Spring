<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>CSV(Comma Separated Values) ����</title>
		<script>
			var input = '';
			input += 'ȫ�浿, �����, 25��\n';
			input += '�Ż��Ӵ�, ����, 45��';
			
			//�� �پ� �ڸ��ϴ�.
			input = input.split('\n');
			alert(input);
			
			for(var i=0; i< input.length; i++){
				//��ǥ�� �������� �ڸ��ϴ�.
				input[i] = input[i].split(',');
				for(var j=0; j< input[i].length; j++){
					input[i][j] = input[i][j].trim();
					alert(input[i][j]);
				}
			}
		</script>
	</head>
	<body>
		
	</body>
</html>