package report_0421;

import java.util.Scanner;

public class MemberInput_method {

	public static void main(String[] args) {

		MemberInfo obj = new MemberInfo();

		input(obj);
		print(obj);

	}

	static void input(MemberInfo obj) {
		Scanner sc = new Scanner(System.in);

		System.out.println("������ �Է��ϼ���?");
		String name = sc.nextLine();

		System.out.println("���̸� �Է��ϼ���?");
		int age = Integer.parseInt(sc.nextLine());

		System.out.println("e-mail�� �Է��ϼ���?");
		String email = sc.nextLine();

		System.out.println("�ּҸ� �Է��ϼ���?");
		String address = sc.nextLine();
		
		obj.setName(name);
		obj.setAge(age);
		obj.setEmail(email);
		obj.setAddress(address);
		
		sc.close();
	}

	static void print(MemberInfo obj) {
		System.out.println("==== ����մϴ� ====");
		System.out.println("�̸� : " + obj.getName());
		System.out.println("���� : " + obj.getAge());
		System.out.println("e-mail : " + obj.getEmail());
		System.out.println("�ּ� : " + obj.getAddress());
	}

}
