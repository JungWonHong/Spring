package ex8_09_abstract_method;

public class InheritanceExample6 {

	public static void main(String[] args) {
		EMailSender obj1 =
				new EMailSender("생일을 축하합니다", "고객센터", 
				"admin@dukeeshop.co.kr", "10% 할인쿠폰이 발행되었습니다.");
		SMSSender obj2 =
				new SMSSender("생일을 축하합니다", "고객센터", 
				"02-000-0000", "10% 할인쿠폰이 발행되었습니다.");
		
		//추상메서드를 구현한 메서드 호출
		obj1.sendMessage("hatman@yeyeye.com");
		obj2.sendMessage("stickman@hahaha.com");
		obj2.sendMessage("010-000-0000");
	}

}
