package report_0327;

import java.util.Scanner;

public class Rp_max_min {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2, num3, max, min;

		System.out.print("3���� ������ �Է� �ϼ���?");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		/*
	    max = num1 > num2 ? num1 : num2; 
	    max = max > num3 ? max : num3;
		  
	    min = num1 < num2 ? num1 : num2; 
	    min = min < num3 ? min : num3;
		 */

		max = (num1 > num2) ? ((num1 > num3) ? num1 : num3) : ((num2 > num3) ? num2 : num3);
		min = (num1 < num2) ? ((num1 < num3) ? num1 : num3) : ((num2 < num3) ? num2 : num3);

		System.out.println(num1 + "," + num2 + "," + num3 + " �� ū ����" + max + "�Դϴ�.");
		System.out.println(num1 + "," + num2 + "," + num3 + " �� ���� ���� ����" + min + "�Դϴ�.");

		sc.close();
	}

}

/*
2. �� ���� ���� �Է� �޾� �ִ밪�� �ּҰ��� ���ϴ� ���α׷�
         ��, ���� �����ڸ� �̿��ϼ���.  

         ����ȭ��)
         3���� ������ �Է� �ϼ���?10 20 30
         10,20,30 �� ū ���� 30�Դϴ�.
         10,20,30 �� ���� �������� 10�Դϴ�.
*/