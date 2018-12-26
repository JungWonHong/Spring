//삭제 시 뒤에서 부터 삭제, 삭제 후 삭제 된 멤버의 정보 출력하기
package report_0427;

import java.util.ArrayList;
import java.util.Scanner;
public class MemberInput_앞에서부터삭제시 {

	public static void main(String[] args) {
		ArrayList<MemberInfo> list = new ArrayList<MemberInfo>();
		Scanner sc = new Scanner(System.in);
		do {
			menu();

			String select = sc.nextLine();

			// 숫자인지 판단하는 메서드 호출
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
				case 3: // 수정합니다.
					update(list, sc);
					break;
				case 4 :
					delete(list, sc);
					break;
				case 5: // 출력합니다.
					printAll(list);
					break;
				case 6: // 종료합니다.
					System.out.println("종료합니다.");
					sc.close();
					return;
				default:
					System.out.println("1 , 2, 3, 4, 5, 6 중에 한 개의 숫자를 입력하세요");
				}
			}
			System.out.println();
		} while (true);

	}

	static void menu() {
		System.out.println("다음 중 선택하세요(반드시 숫자 입력)");
		System.out.println("1. 입력");
		System.out.println("2. 검색");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 출력");
		System.out.println("6. 종료");
		System.out.println("==>");
	}

	static int titlePrint(Scanner sc, int menu) {
		String[] menuname = { "검색", "수정", "삭제" };
		String[] itemname = { "성명", "나이", "E-Mail", "주소" };
		int search;
		do {
			System.out.println("=== " + menuname[menu - 2] + "할 항목을 선택하세요 ===");
			/*
			 * System.out.println("1. 성명"); System.out.println("2. 나이");
			 * System.out.println("3. E-Mail"); System.out.println("4. 주소");
			 */
			for (int i = 0; i < itemname.length; i++) {
				System.out.println((i+1) + ". " + itemname[i]);
			}
			System.out.print("==>");
			String input = sc.nextLine();
			if (isNumber(input)) { // 숫자형 문자열인 경우
				search = Integer.parseInt(input);
				if (search < 1 || search > 4) {
					System.out.println("1~4까지의 숫자를 입력하세요");
					continue; // 다시 반복합니다.
				}
				break; // 반복문 벗어납니다.
			} else // 숫자형 문자열이 아닌 경우
				System.out.println("검색할 항목을 숫자로 입력하세요");
		} while (true);
		return search;
	}

	static void search(ArrayList<MemberInfo> list, Scanner sc) {
		int selectItem = titlePrint(sc, 2);
		String[] itemname = { "성명", "나이", "E-Mail", "주소" };
		System.out.println(itemname[selectItem - 1] + "을(를) 입력하세요");

		String searchdata = sc.nextLine();
		if (selectItem == 2) { // 검색 항목이 "나이"일때
			while (!isNumber(searchdata)) {
				System.out.println("나이는 숫자로 입력하세요");
				searchdata = sc.nextLine();
			}
		}
		int count = 0, ok = 0;

		for (MemberInfo a : list) {
			ok = search_each(a, searchdata, selectItem);
			if (ok != 0) { // 검색된 데이터가 있는 경우
				count++;
				System.out.println("\n=====검색된 " + count + "째 데이터 입니다.=====");
				print(a);
			}
		} // for
		if (count == 0)
			System.out.println("*****검색된 데이터가 없습니다.*****");
	}

	static int search_each(MemberInfo a, String searchdata, int searchItem) {
		int ok = 0;
		String membergetdata = "";
		switch (searchItem) {
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

		if (membergetdata.equals(searchdata)) {
			ok++;
		}
		return ok;
	}

	static void update(ArrayList<MemberInfo> list, Scanner sc) {
		int selectItem = titlePrint(sc, 3);
		String[] itemname = { "성명", "나이", "E-Mail", "주소" };
		int count = 0;
		System.out.println("수정 전 " + itemname[selectItem - 1] + "을(를) 입력하세요");
		String before = sc.nextLine();
		if (selectItem == 2) {
			while (!isNumber(before)) {
				System.out.println("나이는 숫자로 입력하세요");
				before = sc.nextLine();
			}
		}
		for (int i = 0; i < list.size(); i++) {
			MemberInfo a = list.get(i);

			int ok=search_each(a, before, selectItem);

			if (ok !=0 ) {
				System.out.println("수정 후 " + itemname[selectItem - 1] + "을(를) 입력하세요");
				String after = sc.nextLine();
				if (selectItem == 2) {
					while (!isNumber(after)) {
						System.out.println("나이는 숫자로 입력하세요");
						after = sc.nextLine();
					}
				}
				switch (selectItem) {
				case 1:
					a.setName(after);
					break;
				case 2:
					a.setAge(Integer.parseInt(after));
					break;
				case 3:
					a.setEmail(after);
					break;
				case 4:
					a.setAddress(after);
				}
                count++;
				System.out.println("***성공적으로 수정되었습니다.***");
				print(a);
			}
		} // for
		if (count == 0)
			System.out.println("***수정할  데이터가 없습니다.***");
	}// update

	static boolean isNumber(String input) {
		if(input==null || input.equals("")) 
			return false;
		
	    for(int i=0; i< input.length();i++) 
	     { 
	    	char ch = input.charAt(i);
	        if(ch < '0' || ch > '9') 
	         { return false; } 
	     } // for end
	    return true;
	}

	static void input(ArrayList<MemberInfo> list, Scanner sc) {
		do {
			System.out.println("성명을 입력하세요? ");
			String name = sc.nextLine();
			int age;
			do {
				System.out.println("나이를 입력하세요? ");
				// 나이를 숫자로 구성된 문자열이 아닌 경우 에러를 발생하는 parseInt()메서드를 이용해서
				// 숫자인지를 판별합니다.
				try {
					age = Integer.parseInt(sc.nextLine());
					break; // 1번 반복문 벗어납니다.
				} catch (NumberFormatException e) {
					System.out.println("나이는 숫자를 입력하셔야 합니다.");
				}
			} while (true); // 1

			System.out.println("E-Mail을 입력하세요? ");
			String email = sc.nextLine();

			System.out.println("주소를 입력하세요? ");
			String address = sc.nextLine();

			MemberInfo m = new MemberInfo();
			m.setName(name);
			m.setAge(age);
			m.setEmail(email);
			m.setAddress(address);

			list.add(m);

			do {
				System.out.println("계속할려면 y, 멈출려면 n을 입력?");
				String yn = sc.nextLine();
				if (yn.equals("y")) {
					break; // 1번 반복문 벗어납니다.
				} else if (yn.equals("n")) {
					return;// input()메서드 끝냅니다.
				}
			} while (true); // 1
		} while (true); // 2

	}

	static void delete(ArrayList<MemberInfo> list, Scanner sc ){
		int selectItem = titlePrint(sc, 2);
		String[] itemname = { "성명", "나이", "E-Mail", "주소" };
		System.out.println(itemname[selectItem - 1] + "을(를) 입력하세요");
		String searchdata = sc.nextLine();
		if (selectItem == 2) { // 검색 항목이 "나이"일때
			while (!isNumber(searchdata)) {
				System.out.println("나이는 숫자로 입력하세요");
				searchdata = sc.nextLine();
			}
		}
		int count=0;
		for(int i=0;i<list.size();i++){  //앞에서부터 삭제시 항목들이 앞으로 땡겨지면서 조건체크를 하지 못하는 경우가 발생.
			MemberInfo a = list.get(i);
			int ok = search_each(a, searchdata, selectItem);
			if(ok != 0){
				list.remove(i);
				System.out.println("***성공적으로 삭제 했습니다.***");
				i--; // i번째 검사한걸 한번더 검사하기 위해서 다시 앞으로 땡겨준다.
				print(a);
				count++;
			}
	}//for
		if(count==0)
			System.out.println("***삭제할 데이터가 없습니다.***");
	}//delete
	public static void printAll(ArrayList<MemberInfo> list) {
		MemberInfo mm;
		if (list.size() == 0) {
			System.out.println("===== 출력할 데이터가 없습니다. =====");
		} else {
			System.out.println("===== 출력 합니다. =====");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("===get(" + i + ")번째 사람 명단" + "===");
				mm = list.get(i);
				/*System.out.println("성명:" + mm.getName());
				System.out.println("나이:" + mm.getAge());
				System.out.println("E-Mail:" + mm.getEmail());
				System.out.println("주소:" + mm.getAddress());*/
				print(mm);
			}
		}
	}

	public static void print(MemberInfo m) {
		System.out.println("성명:" + m.getName());
		System.out.println("나이:" + m.getAge());
		System.out.println("E-Mail:" + m.getEmail());
		System.out.println("주소:" + m.getAddress());
	}
}
