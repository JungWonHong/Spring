package report_0421;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberInput_ArrayList {

	public static void main(String[] args) {

		ArrayList<MemberInfo> mL = new ArrayList<MemberInfo>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			MemberInfo obj = new MemberInfo();
			input(obj);
			mL.add(obj);

			System.out.println("계속할려면 y, 멈출려면 n을 입력?");
			String ask = sc.nextLine();

			if (ask.equals("y"))
				continue;
			else if (ask.equals("n"))
				break;
		}

		System.out.println("=== 출력 합니다. ===");
		for (int cnt = 0; cnt < mL.size(); cnt++)
			print(mL.get(cnt), cnt);
		
		sc.close();

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

	}

	static void print(MemberInfo obj, int cnt) {
		System.out.println("===get(" + cnt + ")번째 사람 명단===");
		System.out.println("이름 : " + obj.getName());
		System.out.println("나이 : " + obj.getAge());
		System.out.println("e-mail : " + obj.getEmail());
		System.out.println("주소 : " + obj.getAddress());
	}

}
