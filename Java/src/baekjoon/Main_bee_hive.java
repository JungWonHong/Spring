package baekjoon;

import java.util.Scanner;

public class Main_bee_hive {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cmp = 1;
		int i = 1;
		while(N>cmp){
			cmp += 6*i;
			i++;
		}
		System.out.println(i);
		sc.close();
	}
}
