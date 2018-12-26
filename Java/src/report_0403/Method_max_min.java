package report_0403;

import java.util.Scanner;

public class Method_max_min {

	static int[] max_min(int data[]) {

		/*int test[] = new int[2];
		test[0] = data[0];
		test[1] = data[0];*/
		
		int test[] = { data[0], data[1] };

		for (int i = 1; i < data.length; i++) {
			if (test[0] < data[i])
				test[0] = data[i];

			if (test[1] > data[i])
				test[1] = data[i];
		}

		return test;
	}

	public static void main(String[] args) {
		int data[] = new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 5개를 입력하세요?");

		for (int i = 0; i < data.length; i++)
			data[i] = sc.nextInt();
		
		int[] output = max_min(data);
		
		System.out.println("최대값 = " + output[0]);
		System.out.println("최소값 = " + output[1]);
		
		sc.close();

	}

}
