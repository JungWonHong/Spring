package ex8_06_final_class;
//final class Account를 상속 받아 에러 발생

public class BonusPointAccount {
	int bonusPoint;
	public BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		super(accountNo, ownerName, balance);
		//The constructor Object(String, String, int) is undefined
		this.bonusPoint = bonusPoint;
	}

	void deposit(int amount) {
		balance += amount;	//super.balance += amount;
		bonusPoint += (int) (amount * 0.001);
	}
}
