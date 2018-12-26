package ex8_12_polymorphism;

public class BonusPointAccount extends Account {
	int bonusPoint; // ���� ����Ʈ �ʵ�

	BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		//���� Ŭ������ ������ ȣ���մϴ�.
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}

	void deposit(int amount) {
		balance += amount;	//super.balance += amount;
		bonusPoint += (int) (amount * 0.001);
	}

}
