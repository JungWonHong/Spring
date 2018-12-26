package ex5_4_do_while;

import java.util.Scanner;

public class DoWhileExample2 {

	public static void main(String[] args) {
		String location;
		System.out.print("지역을 입력하세요~");
		System.out.println("프로그램을 종료하려면 q를 입력하세요?");
		Scanner sc = new Scanner(System.in);
		do{
			System.out.print(">");
			location = sc.next();
			System.out.println(location);
		}while(!location.equals("q"));
		
		System.out.println("끝.");
		sc.close();
	}

}
