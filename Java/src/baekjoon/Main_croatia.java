package baekjoon;

import java.util.Scanner;

public class Main_croatia {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String alph = sc.next();
		int cnt = 1;
		for (int i = 0; i < alph.length()-1; i++) {

			if (alph.charAt(i) == 'c') {
				if (alph.charAt(i + 1) == '=' || alph.charAt(i + 1) == '-')
					continue;
			} else if (alph.charAt(i) == 'd') {
				if (alph.charAt(i + 1) == 'z' && alph.charAt(i + 2) == '=' && i<alph.length()-2) {
					continue;
				} else if (alph.charAt(i + 1) == '-')
					continue;
			} else if (alph.charAt(i) == 'l' || alph.charAt(i) == 'n') {
				if (alph.charAt(i + 1) == 'j')
					continue;
			} else if (alph.charAt(i) == 's' || alph.charAt(i) == 'z') {
				if (alph.charAt(i + 1) == '=')
					continue;
			}
			cnt++;
		}

		System.out.println(cnt);

		sc.close();
	}
}
