package ex6_3_method;

import java.util.Scanner;

public class Method_Test2_2 {

	// �޼ҵ� ����
	static void sum(int n) { // n�� ���������� stack�� ����Ǿ� �ִ�.

		int sum = 0;

		if (n > 0) {
			for (int i = 0; i <= n; i++)
				sum += i;
			System.out.println("1 ~ " + n + "������ ��: " + sum);
		}

		else
			System.out.println("1���� ū �ڿ����� �Է� �����մϴ�.");

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input_n;

		System.out.print("�� ������ ���� ���ұ��?> ");
		input_n = sc.nextInt();

		sum(input_n); // �޼ҵ� ȣ��

		System.out.println("��.");

		sc.close();
	}

}
