package report_0328;

import java.util.Scanner;

/*
 2. 두 개의 수와 연산자(+, -, *, /)를 입력받아 처리하는 프로그램
    조건:
    1)switch~case문 사용하세요
    2)연산자는 스트링(String)으로 처리하시고
      Scanner의 next()메서드를 이용하세요
 */
public class Calc_switch {

	public static void main(String[] args) {
		int num1, num2, result = 0;
		String op, ask;

		Scanner sc = new Scanner(System.in);

		do {
			result = 0;
			System.out.println("두 수와 사칙연산 연산자를 입력하세요? ");
			System.out.print("수1>");
			num1 = sc.nextInt();
			System.out.print("수2>");
			num2 = sc.nextInt();
			System.out.print("연산자>");
			op = sc.next();
			
			switch (op) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				result = num1 / num2;
				break;
			default:
				System.out.println("연산자가 잘못 입력되었습니다.");
				break;
			}
			System.out.println(num1 + op + num2 + "=" + result);
			System.out.println("계속 입력하시겠습니까?(N(n)이면 종료 그외는 계속 입력 가능)");
			System.out.print("계속입력>");
			ask = sc.next();
		} while (!(ask.equals("N") || ask.equals("n")));
		//while (!ask.equals("N") && !ask.equals("n"));
		//while (!ask.equalsIgnoreCase("n")); 
		//equalsIgnoreCase(String str) : 비교 문자가 같거나, 대문자와 같은경우, 소문자와 같은 경우 true
		
		System.out.println("끝.");
		sc.close();
	}

}
