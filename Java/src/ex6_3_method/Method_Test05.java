package ex6_3_method;

import java.util.Scanner;

public class Method_Test05 {

	static int max(int[] num) {

		int max = num[0];

		for (int i = 1; i < num.length; i++) {
			if (max < num[i])
				max = num[i];
		}

		return max;
	}

	static int min(int[] num) {

		int min = num[0];

		for (int i = 1; i < num.length; i++) {
			if (min > num[i])
				min = num[i];
		}

		return min;
	}

	public static void main(String[] args) {

		int[] data = new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 5개를 입력하세요?");
		for (int i = 0; i < data.length; i++)
			data[i] = sc.nextInt();

		System.out.println("최대값 = " + max(data));
		System.out.println("최소값 = " + min(data));

		sc.close();
	}

}
