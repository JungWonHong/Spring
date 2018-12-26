package ex5_1_if;

import java.util.Scanner;
import java.io.InputStream;

public class If04 {

	public static void main(String[] args) {

		int score;

		InputStream is = System.in;
		Scanner sc = new Scanner(is);

		System.out.println("점수를 입력하세요?");
		score = sc.nextInt();

		if (score >= 90) {
			if (score >= 95)
				System.out.println("A+학점");
			else
				System.out.println("A학점");
		} else if (score >= 80) {
			if (score >= 85)
				System.out.println("B+학점");
			else
				System.out.println("B학점");
		} else if (score >= 70) {
			if (score >= 75)
				System.out.println("C+학점");
			else
				System.out.println("C학점");
		} else if (score >= 60) {
			if (score >= 65)
				System.out.println("D+학점");
			else
				System.out.println("D학점");
		} else {
			System.out.println("F학점");
		}

		sc.close();
	}

}
