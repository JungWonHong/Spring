package ex8_07_final_method;
//마이너스 통장 클래스
// 상속 받은 withdraw메소드를 다시 구현(메소드 오버라이딩)하는 클래스
public class CreditLineAccount extends Account {
	int creditLine; // 마이너스 한도 필요

	CreditLineAccount(String accountNo, String ownerName, 
						int balance, int creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}

	//메소드 오버라이딩 - 인출한다 기능 다시 구현.
	//Cannot override the final method from Account
	//메소드에 final이 붙으면 오버라이딩 안된다.
	int withdraw(int amount) throws Exception {
		if ((balance + creditLine) < amount)
			throw new Exception("인출이 불가능합니다.");
		balance -= amount;
		return amount;
	}

}
