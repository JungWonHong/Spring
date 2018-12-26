package ex5_5_for;

public class for01 {

	public static void main(String[] args) {
		// 1~10까지 홀수 출력하기
		System.out.println("\n1~10까지의 홀수");

		for (int i = 1; i < 10; i += 2)
			System.out.println(i);

		// 1~10까지 짝수 출력하기
		System.out.println("\n1~10까지의 짝수");

		for (int i = 2; i <= 10; i += 2)
			System.out.println(i);

		// 1~10까지의 합 구하기
		int sum = 0;

		System.out.print("\n1~10까지의 합 : ");

		for (int i = 1; i <= 10; i++)
			sum += i;

		System.out.print(sum);

		// 1~10까지의 홀수의 합 구하기
		sum = 0;

		System.out.print("\n1~10까지 홀수의 합 : ");

		for (int i = 1; i < 10; i += 2)
			sum += i;

		System.out.print(sum);

		// 1~10까지의 짝수의 합 구하기
		sum = 0;

		System.out.print("\n1~10까지 짝수의 합 : ");

		for (int i = 2; i <= 10; i += 2)
			sum += i;

		System.out.print(sum);

	}

}
