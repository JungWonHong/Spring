package baekjoon;

import java.util.Scanner;

public class Main_cycle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 입력값
		int result; // 결과값
		int cycle = 0;
		int x, y, z; // x는 앞수식의 첫번째, y는 두번째, z는 수식의 결과

		if (N < 10) {
			N = (N * 10) + N;
		}
		
		result = N;
		
		while (true) {
			x = result / 10;
			y = result % 10;
			z = x + y;
			result = (y * 10) + (z % 10);

			cycle++;
			if (result == N)
				break;
		}

		System.out.print(cycle);
		sc.close();
	}

}
