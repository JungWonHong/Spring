package ex9_03_upcasting_field;
public class RefTypeExample7 {

	public static void main(String[] args) {
		Account obj = 
			new CheckingAccount("111-22-33333333", "ȫ�浿", 10, "4444-5555-6666-7777");

		try {
			System.out.println("���¹�ȣ:" + obj.accountNo);
			System.out.println("������ �̸�: " + obj.ownerName);
			System.out.println("�ܾ�: " + obj.balance);
			//�ʵ��� ��� obj�� Ÿ���� Account�� �ִ� name���� ��µ˴ϴ�(�������ε�)
			System.out.println("name = " + obj.name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
