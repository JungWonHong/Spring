package ex17_11_syn_format2;

public class SharedArea {
	Account account1; // �̸����� ����
	Account account2; // �������� ����

	//����ȭ �޼ҵ�
	synchronized void transfer() { // ���� ��ü�� �Ѵ�
			account1.withdraw(1000000);

			account2.deposit(1000000);
	}
	
	//����ȭ �޼ҵ�
	synchronized int getTotal() {// �ܾ� �հ踦 ���Ѵ�
			return account1.balance + account2.balance;
	}
}
