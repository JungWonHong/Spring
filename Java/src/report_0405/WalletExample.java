package report_0405;

public class WalletExample {

	public static void main(String[] args) {
		Wallet.money = 10000;
		Wallet DH = new Wallet("������");
		Wallet MK = new Wallet("�α���");

		System.out.println(DH.name + "�� �������� 1000���� �������ϴ�.");
		DH.getMoney(1000);
		System.out.println(MK.name + "�� �������� 1000���� �������ϴ�.");
		MK.getMoney(1000);

		System.out.println("������ ���� �ִ� ���� " + Wallet.money + "�� �Դϴ�.");

	}

}
