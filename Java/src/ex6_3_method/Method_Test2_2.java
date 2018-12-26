package ex6_3_method;

import java.util.Scanner;

public class Method_Test2_2 {

	// 메소드 정의
	static void sum(int n) { // n은 지역변수로 stack에 저장되어 있다.

		int sum = 0;

		if (n > 0) {
			for (int i = 0; i <= n; i++)
				sum += i;
			System.out.println("1 ~ " + n + "까지의 합: " + sum);
		}

		else
			System.out.println("1보다 큰 자연수만 입력 가능합니다.");

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input_n;

		System.out.print("몇 까지의 합을 구할까요?> ");
		input_n = sc.nextInt();

		sum(input_n); // 메소드 호출

		System.out.println("끝.");

		sc.close();
	}

}
