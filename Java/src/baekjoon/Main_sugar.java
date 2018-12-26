package baekjoon;

import java.util.Scanner;

public class Main_sugar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // �Էµ� ������ ����
		int bag = 0; // �ּ� ������ ��

		if (N >= 3 && N <= 5000) {
			if (N % 5 == 0) { // 5�� ���
				bag = N / 5;
				System.out.println(bag);
			} else if (N % 5 != 0 && N % 3 == 0) { //
				int i = 1;
				while (((N - 3 * i) % 5 != 0)) {
					i++;
				}
				bag = i + ((N - 3 * i) / 5);
				System.out.println(bag);
			} else if (N % 5 != 0 && N % 3 != 0) {

				for (int i = 1; i < (N / 3); i++) {
					if ((N - 3 * i) % 5 == 0) {
						bag += i;
						break;
					}
				}
				if (bag != 0) { // 8�� ����� ���
					bag = bag + ((N - 3 * bag) / 5);
					System.out.println(bag);
				} else if (bag == 0)
					System.out.println(-1);
			}

		}

		else
			System.out.println("������ ���� �ʽ��ϴ�.");
		
		sc.close();

	}

}