package ex8_13_1_polymorphism;
//�߻� �޼ҵ带 �����ϴ� Ŭ���� - �޽��� ���� Ŭ����
public abstract class MessageSender { //Ŭ���� ��ü�� �߻� Ŭ������ ����
//public class MessageSender{
//The type MessageSender must be an abstract class to define abstract methods
	String title;		//����
	String senderName;	//�߼��� �̸�
	public MessageSender(String title, String senderName) {
		this.title = title;
		this.senderName = senderName;
	}
	
	//�߻� �޼ҵ� - �޽����� �۽��Ѵ�
	abstract void sendMessage(String recipient);

}
