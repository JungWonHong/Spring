package ex12_1_Exception_Test;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age;
		System.out.println("���̸� �Է��ϼ���? ");
		// ���̸� ���ڷ� ������ ���ڿ��� �ƴ� ��� ������ �߻��ϴ� parseInt()�޼��带 �̿��ؼ�
		// ���������� �Ǻ��մϴ�.
		try {
			age = Integer.parseInt(sc.nextLine());
			System.out.println("�Է��� ���̴� = " + age);
		} catch (NumberFormatException e) {
			System.out.println("���ڸ� �Է��ϼ���");
		}
		sc.close();
	}

}
