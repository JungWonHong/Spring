package report_0327;

import java.util.Scanner;

public class Rp_multiple {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է� �ϼ���?");
		int input = sc.nextInt();

		if ((input % 3) != 0)
			System.out.println(input + "��(��) 3�� ����� �ƴմϴ�.");
		else
			System.out.println(input + "��(��) 3�� ����Դϴ�.");
		
		sc.close();
	}

}

/*
1. �Է� ���� ���� 3�� ������� ����ϴ� ���α׷�
���� ���)
          ������ �Է� �ϼ���?10(�Է��� ��)
          10�� 3�� ����� �ƴմϴ�. 
*/