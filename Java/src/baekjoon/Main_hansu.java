package baekjoon;

import java.util.Scanner;

public class Main_hansu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		System.out.print(hansu(N));
		sc.close();
	}

	static int hansu(int N) {
		int cnt = 0;
		int n1, n2, n3, n4;

		for (int i = 1; i <= N; i++) {
			if (i >= 1000) {
				n1 = i / 1000;
				n2 = (i % 1000) / 100;
				n3 = ((i % 1000) % 100) / 10;
				n4 = ((i % 1000) % 100) % 10;
				int cmp1, cmp2, cmp3;
				cmp1 = n1 - n2;
				cmp2 = n2 - n3;
				cmp3 = n3 - n4;
				if (cmp1 == cmp2 && cmp2 == cmp3)
					cnt++;

			} else if (i >= 100 && i < 1000) {
				n1 = i / 100;
				n2 = (i % 100) / 10;
				n3 = (i % 100) % 10;
				if ((n1 - n2) == (n2 - n3))
					cnt++;
			} else
				cnt++;

		}
		return cnt;
	}

}
