package ex5_4_do_while;

import java.util.Scanner;

public class DoWhileExample2 {

	public static void main(String[] args) {
		String location;
		System.out.print("������ �Է��ϼ���~");
		System.out.println("���α׷��� �����Ϸ��� q�� �Է��ϼ���?");
		Scanner sc = new Scanner(System.in);
		do{
			System.out.print(">");
			location = sc.next();
			System.out.println(location);
		}while(!location.equals("q"));
		
		System.out.println("��.");
		sc.close();
	}

}
