package ex9_3_upcasting_override;
public class RefTypeExample7 {

	public static void main(String[] args) {
		Account obj = 
			new CheckingAccount("111-22-33333333", "ȫ�浿", 10, "4444-5555-6666-7777");

		try {
			System.out.println("���¹�ȣ:" + obj.accountNo);
			System.out.println("������ �̸�: " + obj.ownerName);
			System.out.println("�ܾ�: " + obj.balance);
			obj.override(); //�������ε�
			//AccountŬ������ override() �޼ҵ尡 �ִ��� Ȯ�� �� ������ ����, ������ �ν��Ͻ��� �޼ҵ� ȣ��.
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
