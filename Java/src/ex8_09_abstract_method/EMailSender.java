package ex8_09_abstract_method;
//�޽��� �߼� Ŭ������ ��ӹ޴� �̸��� �۽� Ŭ����
public class EMailSender extends MessageSender{
//must implement the inherited abstract method 
	String senderAddr;	//�߼��� �̸��� �ּ�
	String emailBody;	//�̸��� ����

	EMailSender(String title, String senderName, 
				String senderAddr, String emailBody) {
		super(title, senderName);
		this.senderAddr = senderAddr;
		this.emailBody = emailBody;
	}

	//���� Ŭ������ �޼ҵ带 �������̵��ϴ� �޼ҵ�
	//�߻�޼ҵ带 ����(implement)
	void sendMessage(String recipient) {
		System.out.println("----------------------");
		System.out.println("����: " + title);
		System.out.println("������ ���: " + senderName + 
							" " + senderAddr);
		System.out.println("�޴� ���: " + recipient);
		System.out.println("����: " + emailBody);
	}
}
