//String ������ �� ���� �Է� ���� �� ������ ��ȯ�Ͽ� �ִ밪�� �ּҰ��� ���ϴ�
//���α׷� �ϼ��ϱ�
package ex14_1_Wrapper;

import java.util.Scanner;

public class T1 {

	public static void main(String[] args) {
		String a, b;
		int max, min;
		Scanner sc = new Scanner(System.in);

		System.out.println("�� ���� �Է��ϼ��� ? ");
		a = sc.next();
		b = sc.next();

		// �Ʒ� �� ������ �ϼ��Ͻÿ�.
		max = max(Integer.parseInt(a), Integer.valueOf(b));
		min = min(Integer.valueOf(a), Integer.valueOf(b));

		System.out.println("�ִ밪�� = " + max);
		System.out.println("�ּҰ��� = " + min);

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