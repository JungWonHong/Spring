package ex6_3_method;

import java.util.Scanner;

public class Method_Test03_change {

	// �޼ҵ� ����
	static int sum(int num1, int num2) {// num1, num2�� ���������� stack�� ����ȴ�.

		int sum = 0;
		int temp = 0;

		if (num1 > num2) {

			temp = num1;
			num1 = num2;
			num2 = temp;

		}
		
		for (int i = num1; i <= num2; i++)
			sum += i;

		return sum;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int from, to;

		System.out.println("���� ���� ������ �Է��ϼ���? ");

		System.out.print("from> ");
		from = sc.nextInt();
		System.out.print("to> ");
		to = sc.nextInt();

		int result = sum(from, to);
		System.out.println(from + " ~ " + to + "������ �� : " + result);

		sc.close();
	}

}
