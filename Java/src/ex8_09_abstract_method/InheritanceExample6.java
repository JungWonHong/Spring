package ex8_09_abstract_method;

public class InheritanceExample6 {

	public static void main(String[] args) {
		EMailSender obj1 =
				new EMailSender("������ �����մϴ�", "������", 
				"admin@dukeeshop.co.kr", "10% ���������� ����Ǿ����ϴ�.");
		SMSSender obj2 =
				new SMSSender("������ �����մϴ�", "������", 
				"02-000-0000", "10% ���������� ����Ǿ����ϴ�.");
		
		//�߻�޼��带 ������ �޼��� ȣ��
		obj1.sendMessage("hatman@yeyeye.com");
		obj2.sendMessage("stickman@hahaha.com");
		obj2.sendMessage("010-000-0000");
	}

}
