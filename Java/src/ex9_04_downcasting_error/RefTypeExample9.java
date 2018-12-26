package ex9_04_downcasting_error;
//컴파일 에러는 안나지만 실행에러
public class RefTypeExample9 {

	public static void main(String[] args) {
		Account obj1 = 
			new Account("111-22-33333333", "홍길동", 100000); 

		// 컴파일러는 변수의 타입만 보고 대입 가능성을 검사하기 때문에 에러발생
		//CheckingAccount obj2 = obj1;
		CheckingAccount obj2 = (CheckingAccount)obj1; //명시적으로 해줘야한다.
								//obj1는 Account형 다운캐스팅하려면 업캐스팅이 이뤄져야하는데 그렇지않음.

		try {
			int amount = obj2.pay("5555-6666-7777-8888", 47000);
			System.out.println("인출액: " + amount);
			System.out.println("카드번호: " + obj2.cardNo);
			System.out.println("잔액: " + obj2.balance);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
