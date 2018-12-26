package ex8_13_1_polymorphism;

public class InheritanceExample8 {

	public static void main(String[] args) {
		EMailSender obj1 = new EMailSender("생일을 축하합니다", "고객센터", 
				"admin@dukeehop.co.kr", "10% 할인쿠폰이 발행되었습니다.");

		SMSSender obj2 = new SMSSender("생일을 축하합니다", "고객센터", 
				"02-000-0000", "10% 할인쿠폰이 발행되었습니다.");

		// 서브 클래스 객체 obj1, obj2를 가지고 메소드를 호출
		send(obj1, "hatman@yeyeye.com");
		send(obj1, "stickman@hahaha.com");
		send(obj2, "010-000-0000");
	}

	//MessageSender obj : 슈퍼 클래스 타입의 파라미터
	//MessageSender 클래스에서 sendMessage 메소드를 주석처리할 경우
	//에러발생 : 자바 컴파일러는 변수의 타입으로 그 메소드가 있는지 없는지 체크합니다.
	//MessageSender에 sendMessage()메서드가 존재하지 않아서
	//The method sendMessage(String) is undefined for the type
	//에러 발생했습니다.
	
	// MessageSender obj : 슈퍼 클래스 타입의 파라미터
	// 자바 가상기계(JVM)는 객체의 메소드를 호출할 대 변수의 타입에 상관없이
	// 객체가 속하는 클래스의 메소드를 호출합니다.  - 동적바인딩
	static void send(MessageSender obj, String recipient) {
		// 어느 클래스의 sendMessage메소드가 호출될까요?
		obj.sendMessage(recipient);
	}

}
