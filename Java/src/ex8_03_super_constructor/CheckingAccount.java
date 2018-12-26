package ex8_03_super_constructor;
//은행 계좌 클래스를 상속받는 직불 계좌 클래스
//은행 계좌클래스(Account)         - 슈퍼클래스(상속을 해주는 클래스)
//직불 계좌클래스(CheckingAccount) - 서브클래스(상속을 받는 클래스)
public class CheckingAccount extends Account {
	String cardNo; // 직불카드 번호
	
	//자바 컴파일러가 컴파일 시 서브 클래스의 생성자 첫번째 명령문이
	//슈퍼 클래스의 생성자 호출문이 아니면
	//자동으로 슈퍼클래스의 no-arg constructor(기본생성자) 호출문을 추가한다.
	//하지만 슈퍼 클래스에는 no-arg constructor가 없어서 컴파일 에러 발생.(다른생성자 선언으로 인해서 명시적으로 선언해줘야함)
	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		this.accountNo = accountNo;	//상속 받은 필드 초기
		this.ownerName = ownerName;	//상속 받은 필드 초기
		this.balance = balance;		//상속 받은 필드 초기
		this.cardNo = cardNo;		//클래스 안에 선언된 필드 초기화
	}
	
	//balance 필드와 withdraw 메소드는 Account클래스로 부터 상속 받아 사용 가능.
	//이 클래스안에 선언되어 있는 것처럼 사용하고 있습니다.
	//직불 카드 사용액을 지불한다에 해당하는 메소드
	int pay(String cardNo, int amount) throws Exception { // 에러 발생시 메소드 호출한 곳에서 해결하도록 선언.
		if (!cardNo.equals(this.cardNo) || (balance < amount))
			throw new Exception("지불이 불가능합니다.");        // 에러 발생시 메세지출력.
		return withdraw(amount);
	}

}
