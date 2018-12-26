package ex6_3_method;

import java.util.Scanner;

public class Method_Test03_return {

	// 메소드 정의
	static void sum(int num1, int num2) {// num1, num2는 지역변수로 stack에 저장된다.

		int sum = 0;

		for (int i = num1; i <= num2; i++)
			sum += i;

		System.out.print(num1 + " ~ " + num2 + "까지의 합 : " + sum);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int from, to;

		System.out.println("합을 구할 범위를 입력하세요? ");

		System.out.print("from> ");
		from = sc.nextInt();
		System.out.print("to> ");
		to = sc.nextInt();

		sum(from, to);

		sc.close();

	}

}
