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

			System.out.println("����ҷ��� y, ������� n�� �Է�?");
			String ask = sc.nextLine();

			if (ask.equals("y"))
				continue;
			else if (ask.equals("n"))
				break;
		}

		System.out.println("=== ��� �մϴ�. ===");
		for (int cnt = 0; cnt < mL.size(); cnt++)
			print(mL.get(cnt), cnt);
		
		sc.close();

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

	}

	static void print(MemberInfo obj, int cnt) {
		System.out.println("===get(" + cnt + ")��° ��� ���===");
		System.out.println("�̸� : " + obj.getName());
		System.out.println("���� : " + obj.getAge());
		System.out.println("e-mail : " + obj.getEmail());
		System.out.println("�ּ� : " + obj.getAddress());
	}

}
