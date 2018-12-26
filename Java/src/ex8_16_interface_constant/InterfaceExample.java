package ex8_16_interface_constant;

public class InterfaceExample {

	public static void main(String[] args) {
		SeparateVolume obj = new SeparateVolume("863ㅂ", "나무", "베르베르");
		printState(obj);
		obj.checkOut("이수경", "20161012");
		printState(obj);
	}

	static void printState(SeparateVolume obj) {
		// 인터페이스 Lendable을 구현하지 않은 클래스에서의 사용법
		// 인터페이스.필드
		if (obj.state == Lendable.STATE_NORMAL) {
			System.out.println("----------------");
			System.out.println("대출상태: 대출가능");
			System.out.println("----------------");
		}

		if (obj.state == Lendable.STATE_BORROWED) {
			System.out.println("----------------");
			System.out.println("대출상태: 대출중");
			System.out.println("대출인: " + obj.borrower);
			System.out.println("대출일: " + obj.checkOutDate);
			System.out.println("----------------");
		}
	}

}
