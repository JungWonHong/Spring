package report_0329;

import java.util.Scanner;

public class Expression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year;
		String yes_or_no;
		
		while (true) {
			System.out.print("년도를 입력하세요?");
			year = sc.nextInt();
			// 방법 1
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
				System.out.println(year + "년은 윤년입니다.");
			else
				System.out.println(year + "년은 평년입니다.");

			System.out.print("계속 하시겠습니까?(y or n)");
			yes_or_no = sc.next();
			// 방법 2
			/*
			String pandan = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? "윤년" : "평년";
			System.out.println(year + "년은 " + pandan + "입니다.");
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
 * 2. char ch; ch!=' '||ch!='\t' <- 틀림. 정담 -> !(ch == ' '|| ch == '\t') 
 * 3. ch >= '0' && ch<='9' 
 * 4. ch>='a'&&ch<='z' 
 * 5. ch>='A'&&ch<='Z' 
 * 6. String name; name.equals("honggildong"); //"honggildong".equals(name); 
 * 7. int year; year%400==0 || (year%4==0 && year%100!=0)
 */