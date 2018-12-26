//String 변수에 두 수를 입력 받은 후 정수로 변환하여 최대값과 최소값을 구하는
//프로그램 완성하기
package ex14_1_Wrapper;

import java.util.Scanner;

public class T1 {

	public static void main(String[] args) {
		String a, b;
		int max, min;
		Scanner sc = new Scanner(System.in);

		System.out.println("두 수를 입력하세요 ? ");
		a = sc.next();
		b = sc.next();

		// 아래 두 문장을 완성하시오.
		max = max(Integer.parseInt(a), Integer.valueOf(b));
		min = min(Integer.valueOf(a), Integer.valueOf(b));

		System.out.println("최대값은 = " + max);
		System.out.println("최소값은 = " + min);

		sc.close();
	}

	public static int max(int a, int b) {
		int max;
		if (a > b) {
			max = a;
		} else {
			max = b;
		}

		return max;
	}

	public static int min(int a, int b) {
		int min;
		if (a < b) {
			min = a;
		} else {
			min = b;
		}

		return min;
	}

}
