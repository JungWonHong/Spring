package ex4_08_arithmetic_op;

import java.util.Scanner;

public class Oper03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1, num2, result;
		
		System.out.print("����1�� �Է� �ϼ���?");
		num1 = sc.nextInt();
		
		System.out.print("����2�� �Է� �ϼ���?");
		num2 = sc.nextInt();
		
		result = num1 + num2;
		System.out.println(num1 + "+" + num2 + "=" + result);
		result = num1 - num2;
		System.out.println(num1 + "-" + num2 + "=" + result);
		result = num1 * num2;
		System.out.println(num1 + "*" + num2 + "=" + result);
		result = num1 / num2;
		System.out.println(num1 + "/" + num2 + "=" + result);
		
		sc.close();
		
	}

}
