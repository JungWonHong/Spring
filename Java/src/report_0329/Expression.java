package report_0329;

import java.util.Scanner;

public class Expression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year;
		String yes_or_no;
		
		while (true) {
			System.out.print("�⵵�� �Է��ϼ���?");
			year = sc.nextInt();
			// ��� 1
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
				System.out.println(year + "���� �����Դϴ�.");
			else
				System.out.println(year + "���� ����Դϴ�.");

			System.out.print("��� �Ͻðڽ��ϱ�?(y or n)");
			yes_or_no = sc.next();
			// ��� 2
			/*
			String pandan = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? "����" : "���";
			System.out.println(year + "���� " + pandan + "�Դϴ�.");
			*/
			if (yes_or_no.equals("n"))
				break;
		}

		System.out.println("Done.");

		sc.close();
	}

}
/*
 * 1. int x; x>10 && x<20 
 * 2. char ch; ch!=' '||ch!='\t' <- Ʋ��. ���� -> !(ch == ' '|| ch == '\t') 
 * 3. ch >= '0' && ch<='9' 
 * 4. ch>='a'&&ch<='z' 
 * 5. ch>='A'&&ch<='Z' 
 * 6. String name; name.equals("honggildong"); //"honggildong".equals(name); 
 * 7. int year; year%400==0 || (year%4==0 && year%100!=0)
 */