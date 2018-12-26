package ex9_3_upcasting;
//obj 변수의 타입이 Account이기 때문에
//Account에 있는 필드 사용
public class RefTypeExample7 {

	public static void main(String[] args) {
		Account obj = 
			new CheckingAccount("111-22-33333333", "홍길동", 10, "4444-5555-6666-7777");

		try {
			System.out.println("계좌번호:" + obj.accountNo);
			System.out.println("예금주 이름: " + obj.ownerName);
			System.out.println("잔액: " + obj.balance);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
