package ex6_3_method;

import java.util.Scanner;

public class Method_Test03_return {

	// �޼ҵ� ����
	static void sum(int num1, int num2) {// num1, num2�� ���������� stack�� ����ȴ�.

		int sum = 0;

		for (int i = num1; i <= num2; i++)
			sum += i;

		System.out.print(num1 + " ~ " + num2 + "������ �� : " + sum);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int from, to;

		System.out.println("���� ���� ������ �Է��ϼ���? ");

		System.out.print("from> ");
		from = sc.nextInt();
		System.out.print("to> ");
		to = sc.nextInt();

		sum(from, to);

		sc.close();

	}

}
