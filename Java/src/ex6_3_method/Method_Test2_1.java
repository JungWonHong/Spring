package ex6_3_method;

import java.util.Scanner;

public class Method_Test2_1 {

	// 메소드 정의
	static void sum(int n) { // n은 지역변수로 stack에 저장되어 있다.

		int sum = 0;

		for (int i = 0; i <= n; i++) {
			sum += i;
		}

		System.out.println("1 ~ " + n + "까지의 합: " + sum);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input_n;
		String input_a;

		do{
		
		System.out.print("몇 까지의 합을 구할까요?> ");
		input_n = sc.nextInt();

		sum(input_n); // 메소드 호출
		
		System.out.print("계속하시겠습니까( n(N) 입력시 종료. )> ");
		input_a = sc.next();
		
		}while(!input_a.equalsIgnoreCase("n"));

		System.out.println("끝.");
		
		sc.close();
	}

}
