package ex4_11_rel_logic_op;

import java.util.Scanner;

public class Oper07_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���̸� �Է��Ͻÿ�!");
		int num = sc.nextInt();
		
		if(num>=1 && num<=9)
			System.out.println("10�� �̸�");
		
		if(num>=10 && num<=19)
			System.out.println("10��");
		
		if(num>=20 && num<=29)
			System.out.println("20��");
		
		if(num>=30 && num<=39)
			System.out.println("30��");
		
		if(num>=40 && num<=49)
			System.out.println("40��");
		
		sc.close();
	}

}
