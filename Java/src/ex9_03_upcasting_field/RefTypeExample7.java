package ex9_03_upcasting_field;
public class RefTypeExample7 {

	public static void main(String[] args) {
		Account obj = 
			new CheckingAccount("111-22-33333333", "홍길동", 10, "4444-5555-6666-7777");

		try {
			System.out.println("계좌번호:" + obj.accountNo);
			System.out.println("예금주 이름: " + obj.ownerName);
			System.out.println("잔액: " + obj.balance);
			//필드의 경우 obj의 타입인 Account에 있는 name값이 출력됩니다(정적바인딩)
			System.out.println("name = " + obj.name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
