package ex5_1_if;

import java.util.Scanner;
import java.io.InputStream;

public class If04 {

	public static void main(String[] args) {

		int score;

		InputStream is = System.in;
		Scanner sc = new Scanner(is);

		System.out.println("������ �Է��ϼ���?");
		score = sc.nextInt();

		if (score >= 90) {
			if (score >= 95)
				System.out.println("A+����");
			else
				System.out.println("A����");
		} else if (score >= 80) {
			if (score >= 85)
				System.out.println("B+����");
			else
				System.out.println("B����");
		} else if (score >= 70) {
			if (score >= 75)
				System.out.println("C+����");
			else
				System.out.println("C����");
		} else if (score >= 60) {
			if (score >= 65)
				System.out.println("D+����");
			else
				System.out.println("D����");
		} else {
			System.out.println("F����");
		}

		sc.close();
	}

}
