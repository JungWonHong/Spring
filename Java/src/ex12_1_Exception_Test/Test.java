package ex12_1_Exception_Test;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age;
		System.out.println("나이를 입력하세요? ");
		// 나이를 숫자로 구성된 문자열이 아닌 경우 에러를 발생하는 parseInt()메서드를 이용해서
		// 숫자인지를 판별합니다.
		try {
			age = Integer.parseInt(sc.nextLine());
			System.out.println("입력한 나이는 = " + age);
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력하세요");
		}
		sc.close();
	}

}
