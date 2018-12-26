package baekjoon;

import java.util.Scanner;

public class Main_groupcheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] alph = new String[N];
		int distinct[] = new int[N];

		for (int i = 0; i < N; i++)
			alph[i] = sc.next();

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < alph[i].length() - 1; j++) {
				if (alph[i].charAt(j) == alph[i].charAt(j + 1)) {
					continue;
				} else {
					for (int k = j + 1; k < alph[i].length(); k++) {
						if (alph[i].charAt(j) == alph[i].charAt(k)) {
							distinct[i] = -1;
							break;
						}
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (distinct[i] == 0)
				cnt++;
		}

		System.out.println(cnt);

		sc.close();
	}
}
