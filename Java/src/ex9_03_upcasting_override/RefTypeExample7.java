package ex9_03_upcasting_override;
public class RefTypeExample7 {

	public static void main(String[] args) {
		Account obj = 
			new CheckingAccount("111-22-33333333", "홍길동", 10, "4444-5555-6666-7777");

		try {
			System.out.println("계좌번호:" + obj.accountNo);
			System.out.println("예금주 이름: " + obj.ownerName);
			System.out.println("잔액: " + obj.balance);
			obj.override(); //동적바인딩
			//Account클래스에 override() 메소드가 있는지 확인 후 없으면 에러, 있으면 인스턴스의 메소드 호출.
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
