package ex5_2_switch;

import java.util.Scanner;

public class Switch_Convert_If {

	public static void main(String[] args) {
		int s;
		System.out.println("점수를 입력하세요?");

		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();

		s /= 10; // +학점까지하려면 5로 나눠서.

		switch (s) {
		case 10:
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		case 6:
			System.out.println("D학점");
			break;
		default:
			System.out.println("F학점");
			break;
		}

		sc.close();
	}

}
