package ex8_03_super_constructor;
//���� ���� Ŭ������ ��ӹ޴� ���� ���� Ŭ����
//���� ����Ŭ����(Account)         - ����Ŭ����(����� ���ִ� Ŭ����)
//���� ����Ŭ����(CheckingAccount) - ����Ŭ����(����� �޴� Ŭ����)
public class CheckingAccount extends Account {
	String cardNo; // ����ī�� ��ȣ
	
	//�ڹ� �����Ϸ��� ������ �� ���� Ŭ������ ������ ù��° ��ɹ���
	//���� Ŭ������ ������ ȣ�⹮�� �ƴϸ�
	//�ڵ����� ����Ŭ������ no-arg constructor(�⺻������) ȣ�⹮�� �߰��Ѵ�.
	//������ ���� Ŭ�������� no-arg constructor�� ��� ������ ���� �߻�.(�ٸ������� �������� ���ؼ� ��������� �����������)
	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		this.accountNo = accountNo;	//��� ���� �ʵ� �ʱ�
		this.ownerName = ownerName;	//��� ���� �ʵ� �ʱ�
		this.balance = balance;		//��� ���� �ʵ� �ʱ�
		this.cardNo = cardNo;		//Ŭ���� �ȿ� ����� �ʵ� �ʱ�ȭ
	}
	
	//balance �ʵ�� withdraw �޼ҵ�� AccountŬ������ ���� ��� �޾� ��� ����.
	//�� Ŭ�����ȿ� ����Ǿ� �ִ� ��ó�� ����ϰ� �ֽ��ϴ�.
	//���� ī�� ������ �����Ѵٿ� �ش��ϴ� �޼ҵ�
	int pay(String cardNo, int amount) throws Exception { // ���� �߻��� �޼ҵ� ȣ���� ������ �ذ��ϵ��� ����.
		if (!cardNo.equals(this.cardNo) || (balance < amount))
			throw new Exception("������ �Ұ����մϴ�.");        // ���� �߻��� �޼������.
		return withdraw(amount);
	}

}
