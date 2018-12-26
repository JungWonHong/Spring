package report_0327;

import java.util.Scanner;

public class Rp_max_min {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2, num3, max, min;

		System.out.print("3개의 정수를 입력 하세요?");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		/*
	    max = num1 > num2 ? num1 : num2; 
	    max = max > num3 ? max : num3;
		  
	    min = num1 < num2 ? num1 : num2; 
	    min = min < num3 ? min : num3;
		 */

		max = (num1 > num2) ? ((num1 > num3) ? num1 : num3) : ((num2 > num3) ? num2 : num3);
		min = (num1 < num2) ? ((num1 < num3) ? num1 : num3) : ((num2 < num3) ? num2 : num3);

		System.out.println(num1 + "," + num2 + "," + num3 + " 중 큰 수는" + max + "입니다.");
		System.out.println(num1 + "," + num2 + "," + num3 + " 중 가장 작은 수는" + min + "입니다.");

		sc.close();
	}

}

/*
2. 세 개의 값을 입력 받아 최대값과 최소값을 구하는 프로그램
         단, 조건 연산자를 이용하세요.  

         실행화면)
         3개의 정수를 입력 하세요?10 20 30
         10,20,30 중 큰 수는 30입니다.
         10,20,30 중 가장 작은수는 10입니다.
*/