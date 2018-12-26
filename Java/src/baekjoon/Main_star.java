package baekjoon;

import java.util.Scanner;

public class Main_star {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		printStar(N);

		sc.close();
	}

	static void printStar(int N) {
		if (N == 1)
			System.out.println("  *  ");
		else if (N == 2) {
			printStar(N - 1);
			System.out.println(" * * ");
		} else {
			printStar(N - 1);
			System.out.println("*****");
		}

	}

}
