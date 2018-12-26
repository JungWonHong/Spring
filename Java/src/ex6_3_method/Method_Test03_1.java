package ex6_3_method;

import java.util.Scanner;

public class Method_Test03_1 {

	// 메소드 정의
	static int sum(int num1, int num2) {// num1, num2는 지역변수로 stack에 저장된다.

		int sum = 0;

		for (int i = num1; i <= num2; i++)
			sum += i;

		return sum;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int from, to;

		System.out.println("합을 구할 범위를 입력하세요? ");

		System.out.print("from> ");
		from = sc.nextInt();
		System.out.print("to> ");
		to = sc.nextInt();

		int result = sum(from, to);
		System.out.println(from + " ~ " + to + "까지의 합 : " + result);

		sc.close();
	}

}
