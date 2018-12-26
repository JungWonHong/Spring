package ex4_11_rel_logic_op;

import java.util.Scanner;

public class Oper07_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.println("수를 입력하세요~");
		num = sc.nextInt();
		
		if(num>=1 && num<=10)
			System.out.println("1~10 사이의 수 입니다.");
		else
			System.out.println("1~10 사이의 수가 아닙니다.");
		
		sc.close();		
	}

}