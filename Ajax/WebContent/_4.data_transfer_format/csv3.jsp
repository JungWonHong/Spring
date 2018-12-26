<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>CSV ������ ������ ��������</title>
		<style>
			td{
				border : 1px solid gray;
			}
		</style>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script>
		/*
		 * jQuery.get() = $.get()
		 - ������ �����͸� HTTP GET������� ������ ������ ������ XML, CSV �������� �޽��ϴ�.
		 - $.get() �Լ��� �̿��ؼ� data.csv ������ �ҷ��ɴϴ�.
		 - $.get() �Լ��� ù��° �Ű��������� ������ URL �ּҸ� �����մϴ�.
		 - $.get() �Լ��� �ι�° �Ű������� �ݹ��Լ��� �̿��ؼ� �������� ������ csv ������
		       �����͸� input���� �޽��ϴ�.
		*/
		$(function(){
			$("button").click(function(){ //��ư�� Ŭ���ϸ�
				$.get("data.csv", function(input){
					//input���� data.csv�� ������ ����ֽ��ϴ�.
					
					alert(input);
					
					//�� �پ� �ڸ��ϴ�.
					input = input.split('\n');
					
					//$("#treeData").empty();
					
					$("#treeData").append("<tr><td>�̸�</td><td>����</td><td>����</td></tr>");
					
					var str = "";
					/*
						str += "<tr><td>�̸�</td><td>����</td><td>����</td></tr>";
					*/
					
					for(var i=0; i< input.length; i++){
						//��ǥ�� �������� �ڸ��ϴ�.
						input[i] = input[i].split(',');
						str += "<tr>";
						for(var j=0; j< input[i].length; j++){
							input[i][j] = input[i][j].trim();
							str += "<td>" + input[i][j] + "</td>";
						}
						str += "</tr>";
					}
					
					$("#treeData").append(str);
				}); //get end
			});	//click end
		});	//ready end
		</script>
	</head>
	<body>
		<button>������ �ҷ�����</button>
		<table>
			<tbody id="treeData"></tbody>
		</table>
	</body>
</html>