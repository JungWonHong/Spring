package ex4_11_rel_logic_op;

import java.util.Scanner;

public class Oper07_3 {
	// �Է� ���� ���� 1�̰ų� 11�̸� "1"�̶�� ���
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;

		System.out.println("���� �Է��ϼ���~");
		num = sc.nextInt();

		if (num == 1 || num == 11)
			System.out.println("1");

		sc.close();
	}

}
