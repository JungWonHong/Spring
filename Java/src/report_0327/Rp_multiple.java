package report_0327;

import java.util.Scanner;

public class Rp_multiple {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력 하세요?");
		int input = sc.nextInt();

		if ((input % 3) != 0)
			System.out.println(input + "은(는) 3의 배수가 아닙니다.");
		else
			System.out.println(input + "은(는) 3의 배수입니다.");
		
		sc.close();
	}

}

/*
1. 입력 받은 수가 3의 배수인지 출력하는 프로그램
실행 결과)
          정수를 입력 하세요?10(입력한 수)
          10은 3은 배수가 아닙니다. 
*/