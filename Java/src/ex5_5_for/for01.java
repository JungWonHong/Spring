package ex5_5_for;

public class for01 {

	public static void main(String[] args) {
		// 1~10���� Ȧ�� ����ϱ�
		System.out.println("\n1~10������ Ȧ��");

		for (int i = 1; i < 10; i += 2)
			System.out.println(i);

		// 1~10���� ¦�� ����ϱ�
		System.out.println("\n1~10������ ¦��");

		for (int i = 2; i <= 10; i += 2)
			System.out.println(i);

		// 1~10������ �� ���ϱ�
		int sum = 0;

		System.out.print("\n1~10������ �� : ");

		for (int i = 1; i <= 10; i++)
			sum += i;

		System.out.print(sum);

		// 1~10������ Ȧ���� �� ���ϱ�
		sum = 0;

		System.out.print("\n1~10���� Ȧ���� �� : ");

		for (int i = 1; i < 10; i += 2)
			sum += i;

		System.out.print(sum);

		// 1~10������ ¦���� �� ���ϱ�
		sum = 0;

		System.out.print("\n1~10���� ¦���� �� : ");

		for (int i = 2; i <= 10; i += 2)
			sum += i;

		System.out.print(sum);

	}

}
