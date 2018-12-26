package baekjoon;

import java.util.Scanner;

public class Main_mississipi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int len = input.length();
		String s = input.toLowerCase();
		
		int cnt, max = 0, cmp = 0;
		for (int i = 0; i < len; i++) {
			cnt = 0;
			char c = s.charAt(i);
			for (int j = i; j < len; j++) {
				if (c == s.charAt(j))
					cnt++;
			}
			if (cmp < cnt) {
				max = i;
				cmp = cnt;
				continue;
			} else if (cmp == cnt) {
				System.out.println("?");
				sc.close();
				return;
			}
		}

		System.out.println(input.charAt(max));
		sc.close();
	}
}
