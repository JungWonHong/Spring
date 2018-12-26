package ex8_09_abstract_method;
//추상 메소드를 포함하는 클래스 - 메시지 전송 클래스
public abstract class MessageSender { //클래스 자체도 추상 클래스로 선언
//public class MessageSender{
//The type MessageSender must be an abstract class to define abstract methods
	String title;		//제목
	String senderName;	//발송자 이름
	public MessageSender(String title, String senderName) {
		this.title = title;
		this.senderName = senderName;
	}
	
	//추상 메소드 - 메시지를 송신한다
	abstract void sendMessage(String recipient);

}
