//���ڿ� ���� �޼ҵ�
/*
 * �ֹι�ȣ 123456-41234567�� �̿��Ͽ� ����,����,�ܱ����� ����ϱ�
 * ���ڸ� ù���ڰ� 1�Ǵ�3�̸� ����, 2�Ǵ�4�̸� ����, �� �ܴ� �ܱ���
 */
package ex11_1_String;

public class StringExample6_2 {
	public static void main(String[] args) {
		String str = "123456-41234567";

		String s = str.substring(7, 8);
		System.out.print("������ ���ڴ� " + s + "�̰� ");

		switch (s) {
		case "1":
		case "3":
			System.out.println("�����Դϴ�.");
			break;
		case "2":
		case "4":
			System.out.println("�����Դϴ�.");
			break;
		default:
			System.out.println("�ܱ����Դϴ�.");
		}
	}
}
