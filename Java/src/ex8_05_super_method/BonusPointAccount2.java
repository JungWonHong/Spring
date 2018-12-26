package ex8_05_super_method;
//포인트 적립 계좌 클래스
public class BonusPointAccount2 extends Account {
	int bonusPoint; // 누적 포인트 필드

	BonusPointAccount2(String accountNo, String ownerName, int balance, int bonusPoint) {
		//부코 클래스의 생성자 호출합니다.
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}

	//예금한다 기능을 다시 구현(메소드 오버라이딩)
	//상속 받은 메소드의 로직을 단순히 확장
	//super는 자식 클래스에서 부모 클래스로 상속 받은 필드와 메서드를 참조하는데 사용합니다.
	void deposit(int amount) {
		super.deposit(amount);
		//balance += amount;	//super.balance += amount;
		bonusPoint += (int) (amount * 0.001);
	}

}
