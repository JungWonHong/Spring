package ex8_09_abstract_method;
//메시지 발송 클래스를 상속받는 이메일 송신 클래스
public class EMailSender extends MessageSender{
//must implement the inherited abstract method 
	String senderAddr;	//발송자 이메일 주소
	String emailBody;	//이메일 내용

	EMailSender(String title, String senderName, 
				String senderAddr, String emailBody) {
		super(title, senderName);
		this.senderAddr = senderAddr;
		this.emailBody = emailBody;
	}

	//슈퍼 클래스의 메소드를 오버라이드하는 메소드
	//추상메소드를 구현(implement)
	void sendMessage(String recipient) {
		System.out.println("----------------------");
		System.out.println("제목: " + title);
		System.out.println("보내는 사람: " + senderName + 
							" " + senderAddr);
		System.out.println("받는 사람: " + recipient);
		System.out.println("내용: " + emailBody);
	}
}
