package report_0328;

import java.util.Scanner;

/*
 2. �� ���� ���� ������(+, -, *, /)�� �Է¹޾� ó���ϴ� ���α׷�
    ����:
    1)switch~case�� ����ϼ���
    2)�����ڴ� ��Ʈ��(String)���� ó���Ͻð�
      Scanner�� next()�޼��带 �̿��ϼ���
 */
public class Calc_switch {

	public static void main(String[] args) {
		int num1, num2, result = 0;
		String op, ask;

		Scanner sc = new Scanner(System.in);

		do {
			result = 0;
			System.out.println("�� ���� ��Ģ���� �����ڸ� �Է��ϼ���? ");
			System.out.print("��1>");
			num1 = sc.nextInt();
			System.out.print("��2>");
			num2 = sc.nextInt();
			System.out.print("������>");
			op = sc.next();
			
			switch (op) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				result = num1 / num2;
				break;
			default:
				System.out.println("�����ڰ� �߸� �ԷµǾ����ϴ�.");
				break;
			}
			System.out.println(num1 + op + num2 + "=" + result);
			System.out.println("��� �Է��Ͻðڽ��ϱ�?(N(n)�̸� ���� �׿ܴ� ��� �Է� ����)");
			System.out.print("����Է�>");
			ask = sc.next();
		} while (!(ask.equals("N") || ask.equals("n")));
		//while (!ask.equals("N") && !ask.equals("n"));
		//while (!ask.equalsIgnoreCase("n")); 
		//equalsIgnoreCase(String str) : �� ���ڰ� ���ų�, �빮�ڿ� �������, �ҹ��ڿ� ���� ��� true
		
		System.out.println("��.");
		sc.close();
	}

}