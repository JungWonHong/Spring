package ex6_3_method;

import java.util.Scanner;

public class Method_Test2_1 {

	// �޼ҵ� ����
	static void sum(int n) { // n�� ���������� stack�� ����Ǿ� �ִ�.

		int sum = 0;

		for (int i = 0; i <= n; i++) {
			sum += i;
		}

		System.out.println("1 ~ " + n + "������ ��: " + sum);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input_n;
		String input_a;

		do{
		
		System.out.print("�� ������ ���� ���ұ��?> ");
		input_n = sc.nextInt();

		sum(input_n); // �޼ҵ� ȣ��
		
		System.out.print("����Ͻðڽ��ϱ�( n(N) �Է½� ����. )> ");
		input_a = sc.next();
		
		}while(!input_a.equalsIgnoreCase("n"));

		System.out.println("��.");
		
		sc.close();
	}

}
