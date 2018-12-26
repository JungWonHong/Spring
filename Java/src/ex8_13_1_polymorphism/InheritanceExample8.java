package ex8_13_1_polymorphism;

public class InheritanceExample8 {

	public static void main(String[] args) {
		EMailSender obj1 = new EMailSender("������ �����մϴ�", "������", 
				"admin@dukeehop.co.kr", "10% ���������� ����Ǿ����ϴ�.");

		SMSSender obj2 = new SMSSender("������ �����մϴ�", "������", 
				"02-000-0000", "10% ���������� ����Ǿ����ϴ�.");

		// ���� Ŭ���� ��ü obj1, obj2�� ������ �޼ҵ带 ȣ��
		send(obj1, "hatman@yeyeye.com");
		send(obj1, "stickman@hahaha.com");
		send(obj2, "010-000-0000");
	}

	//MessageSender obj : ���� Ŭ���� Ÿ���� �Ķ����
	//MessageSender Ŭ�������� sendMessage �޼ҵ带 �ּ�ó���� ���
	//�����߻� : �ڹ� �����Ϸ��� ������ Ÿ������ �� �޼ҵ尡 �ִ��� ������ üũ�մϴ�.
	//MessageSender�� sendMessage()�޼��尡 �������� �ʾƼ�
	//The method sendMessage(String) is undefined for the type
	//���� �߻��߽��ϴ�.
	
	// MessageSender obj : ���� Ŭ���� Ÿ���� �Ķ����
	// �ڹ� ������(JVM)�� ��ü�� �޼ҵ带 ȣ���� �� ������ Ÿ�Կ� �������
	// ��ü�� ���ϴ� Ŭ������ �޼ҵ带 ȣ���մϴ�.  - �������ε�
	static void send(MessageSender obj, String recipient) {
		// ��� Ŭ������ sendMessage�޼ҵ尡 ȣ��ɱ��?
		obj.sendMessage(recipient);
	}

}
