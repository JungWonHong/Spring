package ex8_03_super_constructor;
//���� Ŭ������ �����ڸ� ȣ���ϴ� ���� ���� Ŭ����
public class CheckingAccount2 extends Account {
	String cardNo; // ����ī�� ��ȣ
	
	//�����ذ�:
	//�����Ϸ��� ������ �ȿ� ���� Ŭ������ ������ ȣ�⹮�� ������
	//no-arg constructorȣ�⹮�� �߰����� �ʱ� ������
	//���� Ŭ������ ������ ȣ�⹮�� �߰��մϴ�.
	//���� Ŭ������ ������ ȣ�� Ű����� super (this�� �ڱ��ڽ�)
	//���� Ŭ������ ������ ȣ�⹮�� �������� ù ��° ��ɹ��� ���ƾ��Ѵ�.
	public CheckingAccount2(String accountNo, String ownerName, int balance, String cardNo) {
		//�Ķ���� 3���� ���� Ŭ���� ������ ȣ�⹮ 
		super(accountNo, ownerName, balance);  //CheckingAccount.java�� ��.
		this.cardNo = cardNo;		
	}
	
	int pay(String cardNo, int amount) throws Exception { 
		if (!cardNo.equals(this.cardNo) || (balance < amount))
			throw new Exception("������ �Ұ����մϴ�.");       
		return withdraw(amount);
	}

}
