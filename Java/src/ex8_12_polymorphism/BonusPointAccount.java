package ex8_12_polymorphism;

public class BonusPointAccount extends Account {
	int bonusPoint; // 누적 포인트 필드

	BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		//부코 클래스의 생성자 호출합니다.
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}

	void deposit(int amount) {
		balance += amount;	//super.balance += amount;
		bonusPoint += (int) (amount * 0.001);
	}

}
