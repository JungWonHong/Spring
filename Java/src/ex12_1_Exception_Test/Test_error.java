package ex12_1_Exception_Test;

import java.util.Scanner;

public class Test_error {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age;
		System.out.println("���̸� �Է��ϼ���? ");
		//���̸� ���ڷ� ������ ���ڿ��� �ƴ� ��� ������ �߻��ϴ� parseInt()�޼��带 �̿��ؼ�
		//���������� �Ǻ��մϴ�.
		age = Integer.parseInt(sc.nextLine());
		System.out.println("�Է��� ���̴� = " + age);
		sc.close();
	}

}
