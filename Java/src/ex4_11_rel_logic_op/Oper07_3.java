package ex4_11_rel_logic_op;

import java.util.Scanner;

public class Oper07_3 {
	// 입력 받은 수가 1이거나 11이면 "1"이라고 출력
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;

		System.out.println("수를 입력하세요~");
		num = sc.nextInt();

		if (num == 1 || num == 11)
			System.out.println("1");

		sc.close();
	}

}
