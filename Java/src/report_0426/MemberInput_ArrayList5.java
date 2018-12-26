package report_0426;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import report_0421.MemberInfo;

public class MemberInput_ArrayList5 {

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

				case 2: // �˻��մϴ�.
					search(list, sc);
					break;

				case 3: // �����մϴ�.
					update(list, sc);
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
		System.out.println("2. �˻�");
		System.out.println("3. ����");
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

	static int titlePrint(String str, Scanner sc) {
		int search;
		do {
			System.out.println("=== " + str + "�� �׸��� �����ϼ��� ===");
			System.out.println("1. ����");
			System.out.println("2. ����");
			System.out.println("3. E-Mail");
			System.out.println("4. �ּ�");
			System.out.print("==>");
			String input = sc.nextLine();
			if (isNumber(input)) { // ������ ���ڿ��� ���
				search = Integer.parseInt(input);
				if (search < 1 || search > 4) {
					System.out.println("1~4������ ���ڸ� �Է��ϼ���");
					continue; // �ٽ� �ݺ��մϴ�.
				}
				break;// �ݺ��� ����ϴ�.
			} else {
				System.out.println("�˻��� �׸��� ���ڷ� �Է��ϼ���");
			}
		} while (true);
		return search;
	}

	static void search(ArrayList<MemberInfo> list, Scanner sc) {
		int selectItem = titlePrint("�˻�", sc);
		String[] itemname = { "����", "����", "E-Mail", "�ּ�" };
		System.out.println(itemname[selectItem - 1] + "��(��) �Է����ּ���.");
		String searchdata = sc.nextLine();

		if (selectItem == 2) { // �˻� �׸��� "����"�� ��
			while (!isNumber(searchdata)) {
				System.out.println("���̴� ���ڷ� �Է��ϼ���");
				searchdata = sc.nextLine();
			}
		}

		int count = 0, ok = 0;

		for (MemberInfo a : list) {
			ok = search_each(a, searchdata, selectItem);
			if (ok != 0) { // �˻��� �����Ͱ� �ִ� ���
				count++;
				System.out.println("\n=====�˻���" + count + "° ������=====");
				print(a);
			}
		}
		if (count == 0)
			System.out.println("*****�˻��� �����Ͱ� �����ϴ�.*****");
	}

	static int search_each(MemberInfo a, String searchdata, int selectItem) {
		int ok = 0;
		String membergetdata = "";
		switch (selectItem) {
		case 1:
			membergetdata = a.getName();
			break;
		case 2:
			membergetdata = Integer.toString(a.getAge());
			break;
		case 3:
			membergetdata = a.getEmail();
			break;
		case 4:
			membergetdata = a.getAddress();
			break;
		}

		if (membergetdata.equals(searchdata))
			ok++;

		return ok;
	}

	static void update(ArrayList<MemberInfo> list, Scanner sc) {
		int selectItem = titlePrint("����", sc);
		String[] itemname = { "����", "����", "E-Mail", "�ּ�" };

		System.out.println("���� �� " + itemname[selectItem - 1] + "��(��) �Է��ϼ���.");
		String searchdata = sc.nextLine();
		if (selectItem == 2) { // �˻� �׸��� "����"�� ��
			while (!isNumber(searchdata)) {
				System.out.println("���̴� ���ڷ� �Է��ϼ���");
				searchdata = sc.nextLine();
			}
		}

		int count = 0, ok = 0;
		
		for (MemberInfo a : list) {
			ok = search_each(a, searchdata, selectItem);
			if (ok != 0) { // �˻��� �����Ͱ� �ִ� ���
				System.out.println("���� �� " + itemname[selectItem - 1] + "��(��) �Է��ϼ���.");
				String updatedata = sc.nextLine();
				if (selectItem == 2) { // �˻� �׸��� "����"�� ��
					while (!isNumber(updatedata)) {
						System.out.println("�˻��� �׸��� ���ڷ� �Է��ϼ���");
						updatedata = sc.nextLine();
					}
				}
				update_each(a, updatedata, selectItem);
				count++;
				System.out.println("***���������� �����Ǿ����ϴ�.***");
				print(a);
			}
		}
		if (count == 0) {
			System.out.println("***������  �����Ͱ� �����ϴ�***");
			return;
		}
	}

	static void update_each(MemberInfo a, String updatedata, int selectItem) {
		switch (selectItem) {
		case 1:
			a.setName(updatedata);
			break;
		case 2:
			a.setAge(Integer.parseInt(updatedata));
			break;
		case 3:
			a.setEmail(updatedata);
			break;
		case 4:
			a.setAddress(updatedata);
			break;
		}
	}

	static void print(MemberInfo obj) {
		System.out.println("�̸� : " + obj.getName());
		System.out.println("���� : " + obj.getAge());
		System.out.println("e-mail : " + obj.getEmail());
		System.out.println("�ּ� : " + obj.getAddress());
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
