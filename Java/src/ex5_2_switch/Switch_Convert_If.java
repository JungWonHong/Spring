package ex5_2_switch;

import java.util.Scanner;

public class Switch_Convert_If {

	public static void main(String[] args) {
		int s;
		System.out.println("������ �Է��ϼ���?");

		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();

		s /= 10; // +���������Ϸ��� 5�� ������.

		switch (s) {
		case 10:
		case 9:
			System.out.println("A����");
			break;
		case 8:
			System.out.println("B����");
			break;
		case 7:
			System.out.println("C����");
			break;
		case 6:
			System.out.println("D����");
			break;
		default:
			System.out.println("F����");
			break;
		}

		sc.close();
	}

}
