package report_0410;

import java.util.Scanner;

public class Problem_no2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[30];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println("�Է°�\t��°�");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "\t" + (arr[i]-1) / 10);
		}

		sc.close();

	}

}
