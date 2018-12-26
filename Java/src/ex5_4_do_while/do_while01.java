package ex5_4_do_while;

public class do_while01 {

	public static void main(String[] args) {
		// 1~10까지 1씩 증가
		System.out.println("==1씩증가==");
		int i = 1;
		do {
			System.out.println(i);
			i = i + 1; // i++;
		} while (i <= 10);

		// 홀수출력
		System.out.println("==홀수출력==");
		i = 1;
		do {
			System.out.println(i);
			i += 2;
		} while (i <= 10);

		// 짝수출력
		System.out.println("==짝수출력==");
		i = 2;
		do {
			System.out.println(i);
			i += 2;
		} while (i <= 10);

		// 1~10까지의 합
		System.out.println("==1~10까지의 합==");
		int sum1 = 0;
		i = 1;
		do {
			sum1 += i;
			i++;
		} while (i <= 10);

		System.out.println("1~10까지의 합 = " + sum1);

		// 홀수 합 구하기
		System.out.println("==홀수 합 구하기==");
		int sum2 = 0;
		i = 1;
		do {
			sum2 += i;
			i += 2;
		} while (i <= 10);

		System.out.println("1~10까지의 홀수의 합 = " + sum2);

		// 짝수 합 구하기
		System.out.println("==짝수 합 구하기==");
		int sum3 = 0;
		/*
		 * i = 1; while (i <= 10) { if (i % 2 == 0) sum3 += i; i++; }
		 */

		i = 2;
		do {
			sum3 += i;
			i += 2;
		} while (i <= 10);

		System.out.println("1~10까지의 짝수의 합 = " + sum3);

	}

}
