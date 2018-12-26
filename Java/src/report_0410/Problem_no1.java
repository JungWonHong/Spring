package report_0410;

import java.util.Scanner;

public class Problem_no1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[30];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println("입력값\t출력값");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "\t" + arr[i] / 10);
		}

		sc.close();
	}

}
