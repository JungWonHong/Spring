package ex8_01_inheritance;
//���� ���� Ŭ������ ��ӹ޴� ���� ���� Ŭ����
//���� ����Ŭ����(Account)         - ����Ŭ����(����� ���ִ� Ŭ����)
//���� ����Ŭ����(CheckingAccount) - ����Ŭ����(����� �޴� Ŭ����)
public class CheckingAccount extends Account {
	String cardNo; // ����ī�� ��ȣ

	//balance �ʵ�� withdraw �޼ҵ�� AccountŬ������ ���� ��� �޾� ��� ����.
	//�� Ŭ�����ȿ� ����Ǿ� �ִ� ��ó�� ����ϰ� �ֽ��ϴ�.
	//���� ī�� ������ �����Ѵٿ� �ش��ϴ� �޼ҵ�
	int pay(String cardNo, int amount) throws Exception { // ���� �߻��� �޼ҵ� ȣ���� ������ �ذ��ϵ��� ����.
		if (!cardNo.equals(this.cardNo) || (balance < amount))
			throw new Exception("������ �Ұ����մϴ�.");        // ���� �߻��� �޼������.
		return withdraw(amount);
	}

}
