package report_0421;

import java.util.Scanner;

public class MemberInput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
/*		
		System.out.println("������ �Է��ϼ���?");
		String name = sc.next();
		
		System.out.println("���̸� �Է��ϼ���?");
		int age = sc.nextInt();
		
		System.out.println("e-mail�� �Է��ϼ���?");
		String email = sc.next();
		sc.nextLine();
		
		System.out.println("�ּҸ� �Է��ϼ���?");
		String address = sc.nextLine();
*/
		System.out.println("������ �Է��ϼ���?");
		String name = sc.nextLine();
		
		System.out.println("���̸� �Է��ϼ���?");
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.println("e-mail�� �Է��ϼ���?");
		String email = sc.nextLine();
		
		System.out.println("�ּҸ� �Է��ϼ���?");
		String address = sc.nextLine();
		
		MemberInfo obj = new MemberInfo();
		obj.setName(name);
		obj.setAge(age);
		obj.setEmail(email);
		obj.setAddress(address);
		
		System.out.println();
		
		printInformation(obj);
		
		sc.close();
	}
	
	static void printInformation(MemberInfo obj){
		System.out.println("==== ����մϴ� ====");
		System.out.println("�̸� : "+obj.getName());
		System.out.println("���� : " + obj.getAge());
		System.out.println("e-mail : " + obj.getEmail());
		System.out.println("�ּ� : " + obj.getAddress());
	}

}
