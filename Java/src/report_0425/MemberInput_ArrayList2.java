package report_0425;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MemberInput_ArrayList2 {

	public static void main(String[] args) {
		ArrayList<MemberInfo> list = new ArrayList<MemberInfo>();
		Scanner sc = new Scanner(System.in);
		do {
			menu(); // 메뉴 출력하는 메서드 호출

			// 숫자인지 판단하는 메서드 호출
			String select = sc.nextLine();

			// 숫자가 아니면 다시 메뉴 호출합니다.
			if (!isNumber(select)) {
				System.out.println("반드시 숫자 입력하세요.");
			} else {
				int selector = Integer.parseInt(select);
				switch (selector) {
				case 1: // 입력합니다.
					input(list, sc);
					break;

				case 2: // 검색합니다.
					search(list, sc);
					break;

				case 5: // 출력합니다.
					printAll(list);
					break;

				case 6: // 종료합니다.
					System.out.println("종료합니다.");
					sc.close();
					return;
				default:
					System.out.println("1 또는 5 또는 6의 숫자를 입력하세요");
				}
			}
			System.out.println();
		} while (true);
	}

	static void menu() {
		System.out.println("다음 중 선택하세요(반드시 숫자 입력)");
		System.out.println("1. 입력");
		System.out.println("2. 검색");
		System.out.println("5. 출력");
		System.out.println("6. 종료");
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

			System.out.println("성명을 입력하세요?");
			String name = sc.nextLine();
			obj.setName(name);

			while (true) {
				try {
					System.out.println("나이를 입력하세요?");
					int age = Integer.parseInt(sc.nextLine());
					obj.setAge(age);
					break;
				} catch (NumberFormatException e) {
					System.out.println("나이는 숫자를 입력하셔야 합니다.");
					continue;
				}
			}

			System.out.println("e-mail을 입력하세요?");
			String email = sc.nextLine();
			obj.setEmail(email);

			System.out.println("주소를 입력하세요?");
			String address = sc.nextLine();
			obj.setAddress(address);

			mL.add(obj);

			while (true) {
				System.out.println("계속할려면 y, 멈출려면 n을 입력?");
				String ask = sc.nextLine();

				if (ask.equals("y"))
					break;
				else if (ask.equals("n"))
					return;
			}
		}

	}

	static void search(ArrayList<MemberInfo> mL, Scanner sc) {
		while (true) {
			System.out.println("=== 검색할 항목을 선택하세요 ===");
			System.out.println("1. 성명");
			System.out.println("2. 나이");
			System.out.println("3. E-Mail");
			System.out.println("4. 주소");
			System.out.print("==>");

			String choice = sc.nextLine();
			if (!isNumber(choice)) {
				System.out.println("검색할 항목을 숫자로 입력하세요");
			} else {
				Iterator<MemberInfo> iterator = mL.iterator();
				String search;
				if (choice.equals("1")) {
					System.out.println("성명을(를) 입력해 주세요");
					search = sc.nextLine();
					int i = 1;
					while (iterator.hasNext()) {
						MemberInfo obj = iterator.next();
						if (obj.getName().equals(search)) {
							System.out.println("검색된 " + (i++) + "째 데이터 입니다.");
							System.out.println("성명 : " + obj.getName());
							System.out.println("나이 : " + obj.getAge());
							System.out.println("E-Mail : " + obj.getEmail());
							System.out.println("주소 : " + obj.getAddress());
							System.out.println();
						}
					}
					if (i == 1)
						System.out.println("*****검색된 데이터가 없습니다.*****");
				} else if (choice.equals("2")) {

					while (true) {
						System.out.println("나이을(를) 입력해 주세요");
						search = sc.nextLine();
						int i = 1;
						try {
							while (iterator.hasNext()) {
								MemberInfo obj = iterator.next();
								if (obj.getAge() == Integer.parseInt(search)) {
									System.out.println("검색된 " + (i++) + "째 데이터 입니다.");
									System.out.println("성명 : " + obj.getName());
									System.out.println("나이 : " + obj.getAge());
									System.out.println("E-Mail : " + obj.getEmail());
									System.out.println("주소 : " + obj.getAddress());
									System.out.println();
								}
							}
							if (i == 1)
								System.out.println("*****검색된 데이터가 없습니다.*****");
							break;
						} catch (NumberFormatException e) {
							System.out.println("숫자를 입력해 주세요");
							continue;
						}
					}

				} else if (choice.equals("3")) {
					System.out.println("E-Mail을(를) 입력해 주세요");
					search = sc.nextLine();
					int i = 1;
					while (iterator.hasNext()) {
						MemberInfo obj = iterator.next();
						if (obj.getEmail().equals(search)) {
							System.out.println("검색된 " + (i++) + "째 데이터 입니다.");
							System.out.println("성명 : " + obj.getName());
							System.out.println("나이 : " + obj.getAge());
							System.out.println("E-Mail : " + obj.getEmail());
							System.out.println("주소 : " + obj.getAddress());
							System.out.println();
						}
					}
					if (i == 1)
						System.out.println("*****검색된 데이터가 없습니다.*****");
				} else if (choice.equals("4")) {
					System.out.println("주소을(를) 입력해 주세요");
					search = sc.nextLine();
					int i = 1;
					while (iterator.hasNext()) {
						MemberInfo obj = iterator.next();
						if (obj.getAddress().equals(search)) {
							System.out.println("검색된 " + (i++) + "째 데이터 입니다.");
							System.out.println("성명 : " + obj.getName());
							System.out.println("나이 : " + obj.getAge());
							System.out.println("E-Mail : " + obj.getEmail());
							System.out.println("주소 : " + obj.getAddress());
							System.out.println();
						}
					}
					if (i == 1)
						System.out.println("*****검색된 데이터가 없습니다.*****");
				} else {
					System.out.println("1 ~ 4 중에서 입력해 주세요");
					continue;
				}

				return;
			}
		}

	}

	static void printAll(ArrayList<MemberInfo> mL) {
		if (mL.size() == 0) {
			System.out.println("===== 출력할 데이터가 없습니다. =====");
		} else {
			MemberInfo obj;
			System.out.println("=== 출력 합니다. ===");
			for (int i = 0; i < mL.size(); i++) {
				obj = mL.get(i);
				System.out.println("===get(" + i + ")번째 사람 명단===");
				System.out.println("이름 : " + obj.getName());
				System.out.println("나이 : " + obj.getAge());
				System.out.println("e-mail : " + obj.getEmail());
				System.out.println("주소 : " + obj.getAddress());
				System.out.println();
			}
		}
	}

}
