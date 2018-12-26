package report_0424;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberInput_ArrayList2 {

	public static void main(String[] args) {
		ArrayList<MemberInfo> list = new ArrayList<MemberInfo>();
		Scanner sc = new Scanner(System.in);
		do {
			menu(); // �޴� ����ϴ� �޼��� ȣ��

			// �������� �Ǵ��ϴ� �޼��� ȣ��
			String select = sc.nextLine();

			// ���ڰ� �ƴϸ� �ٽ� �޴� ȣ���մϴ�.
			if (!isNumber(select)) {
				System.out.println("�ݵ�� ���� �Է��ϼ���.");
			} else {
				int selector = Integer.parseInt(select);
				switch (selector) {
				case 1: // �Է��մϴ�.
					input(list, sc);
					break;

				case 5: // ����մϴ�.
					printAll(list);
					break;

				case 6: // �����մϴ�.
					System.out.println("�����մϴ�.");
					sc.close();
					return;
				default:
					System.out.println("1 �Ǵ� 5 �Ǵ� 6�� ���ڸ� �Է��ϼ���");
				}
			}
			System.out.println();
		} while (true);
	}

	static void menu() {
		System.out.println("���� �� �����ϼ���(�ݵ�� ���� �Է�)");
		System.out.println("1. �Է�");
		System.out.println("5. ���");
		System.out.println("6. ����");
		System.out.print("==>");
	}

	static boolean isNumber(String str) {
		if (str == null || str.equals(""))
			return false;

		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) < '0' || str.charAt(i) > '9')
				return false;

		return true;
	}

	static void input(ArrayList<MemberInfo> mL, Scanner sc) {

		while (true) {
			MemberInfo obj = new MemberInfo();

			System.out.println("������ �Է��ϼ���?");
			String name = sc.nextLine();
			obj.setName(name);

			while (true) {
				try {
					System.out.println("���̸� �Է��ϼ���?");
					int age = Integer.parseInt(sc.nextLine());
					obj.setAge(age);
					break;
				} catch (NumberFormatException e) {
					System.out.println("���̴� ���ڸ� �Է��ϼž� �մϴ�.");
					continue;
				}
			}

			System.out.println("e-mail�� �Է��ϼ���?");
			String email = sc.nextLine();
			obj.setEmail(email);

			System.out.println("�ּҸ� �Է��ϼ���?");
			String address = sc.nextLine();
			obj.setAddress(address);

			mL.add(obj);

			while (true) {
				System.out.println("����ҷ��� y, ������� n�� �Է�?");
				String ask = sc.nextLine();

				if (ask.equals("y"))
					break;
				else if (ask.equals("n"))
					return;
			}
		}

	}

	static void printAll(ArrayList<MemberInfo> mL) {
		if (mL.size() == 0) {
			System.out.println("===== ����� �����Ͱ� �����ϴ�. =====");
		} else {
			MemberInfo obj;
			System.out.println("=== ��� �մϴ�. ===");
			for (int i = 0; i < mL.size(); i++) {
				obj = mL.get(i);
				System.out.println("===get(" + i + ")��° ��� ���===");
				System.out.println("�̸� : " + obj.getName());
				System.out.println("���� : " + obj.getAge());
				System.out.println("e-mail : " + obj.getEmail());
				System.out.println("�ּ� : " + obj.getAddress());
				System.out.println();
			}
		}
	}

}
