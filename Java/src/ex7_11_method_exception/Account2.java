package ex7_11_method_exception;

public class Account2 {
	String accountNo;
	String ownerName;
	int balance;

	Account2(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	void deposit(int amount) {
		balance += amount;
	}

	int withdraw(int amount) throws Exception {
		if (balance < amount)
			throw new Exception("�ܾ��� �����մϴ�."); //�Ϻη� �����߻�
		//�̰� ȣ�� �ߴ������� ó���ϵ��� ��û�ϱ� ����. ������ �߻��ϸ� �޺κ� ����X
		//�޼ҵ� ����� �޺κп� throws Exception�� ����.
		balance -= amount;
		return amount;
	}
}
