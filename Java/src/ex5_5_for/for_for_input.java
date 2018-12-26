package ex5_5_for;

import java.util.Scanner;

public class for_for_input {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int input;

		System.out.println("원하는 단을 입력하세요?");
		input = sc.nextInt();

		System.out.println("[" + input + "단]");
		for (int i = 1; i <= 9; i++) {
			System.out.println(input + " * " + i + " = " + (input * i));
		}

		sc.close();
	}

}
