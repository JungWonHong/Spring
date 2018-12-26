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

		System.out.println("성명을 입력하세요?");
		String name = sc.nextLine();

		System.out.println("나이를 입력하세요?");
		int age = Integer.parseInt(sc.nextLine());

		System.out.println("e-mail을 입력하세요?");
		String email = sc.nextLine();

		System.out.println("주소를 입력하세요?");
		String address = sc.nextLine();
		
		obj.setName(name);
		obj.setAge(age);
		obj.setEmail(email);
		obj.setAddress(address);
		
		sc.close();
	}

	static void print(MemberInfo obj) {
		System.out.println("==== 출력합니다 ====");
		System.out.println("이름 : " + obj.getName());
		System.out.println("나이 : " + obj.getAge());
		System.out.println("e-mail : " + obj.getEmail());
		System.out.println("주소 : " + obj.getAddress());
	}

}
