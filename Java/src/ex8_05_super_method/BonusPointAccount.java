package ex8_05_super_method;
//����Ʈ ���� ���� Ŭ����
public class BonusPointAccount extends Account {
	int bonusPoint; // ���� ����Ʈ �ʵ�

	BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		//���� Ŭ������ ������ ȣ���մϴ�.
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}

	//�����Ѵ� ����� �ٽ� ����(�޼ҵ� �������̵�)
	//��� ���� �޼ҵ��� ������ �ܼ��� Ȯ��
	//super�� �ڽ� Ŭ�������� �θ� Ŭ������ ��� ���� �ʵ�� �޼��带 �����ϴµ� ����մϴ�.
	void deposit(int amount) {
		balance += amount;	//super.balance += amount;
		bonusPoint += (int) (amount * 0.001);
	}

}
