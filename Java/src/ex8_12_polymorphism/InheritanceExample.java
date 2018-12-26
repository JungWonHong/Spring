package ex8_12_polymorphism;
//다형성 예제
public class InheritanceExample {

	public static void main(String[] args) {
		Account obj1 = new Account("111-22-333333", "임꺽정", 
									10000);
		CheckingAccount obj2 = new CheckingAccount(
				"444-55-666666", "홍길동", 20000, 
				"5555-6666-7777-8888");
		CreditLineAccount obj3 = new CreditLineAccount(
				"777-88-999999", "김선달", 30000, 20000000);
		BonusPointAccount obj4 = new BonusPointAccount(
				"000-00-000000", "김미영", 0, 0);
		
		//다양한 타입의 객체를 가지고 같은 메소드를 호출합니다.
		printAccountInfo(obj1);
		printAccountInfo(obj2);
		printAccountInfo(obj3);
		printAccountInfo(obj4);
	}

	//다양한 타입의 객체를 한 타입의 파라미터로 받습니다(다형성) - 조상의 객체형태로
	static void printAccountInfo(Account obj) {
		System.out.println("계좌번호:" + obj.accountNo);
		System.out.println("예금주 이름:" + obj.ownerName);
		System.out.println("잔액:" + obj.balance);
		System.out.println();
	}
}
