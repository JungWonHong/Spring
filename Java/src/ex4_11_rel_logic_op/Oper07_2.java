package ex4_11_rel_logic_op;

import java.util.Scanner;

public class Oper07_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("나이를 입력하시오!");
		int num = sc.nextInt();
		
		if(num>=1 && num<=9)
			System.out.println("10세 미만");
		
		if(num>=10 && num<=19)
			System.out.println("10대");
		
		if(num>=20 && num<=29)
			System.out.println("20대");
		
		if(num>=30 && num<=39)
			System.out.println("30대");
		
		if(num>=40 && num<=49)
			System.out.println("40대");
		
		sc.close();
	}

}
