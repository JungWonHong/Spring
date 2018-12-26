//문자열 추출 메소드
/* StringExample6_1.java를 변경해 봅시다.
 * 1. 주민등록번호를 입력받습니다.
   2. "e"를 입력받으면 입력받는 반복을 끝냅니다.
   3. 입력받은 주민등록번호가 14개인지 판별하는 메서드를 작성합니다.
      14개가 아니면 "주민등록번호는 14자리입니다."라는 메시지를 출력하고
              다시 입력 받도록 합니다.
*/
package report_0414;

import java.util.Scanner;

public class InputIDNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("주민등록번호 입력(e입력시종료)>>");
			String IDNum = sc.nextLine();
			if(IDNum.equals("e"))
				break;
			
			if(!distinctIDNum(IDNum)){
				System.out.println("주민등록번호는 14자리입니다.\n다시 입력해주세요.");
				continue;
			}
			
			String s = IDNum.substring(7, 8);

			if(s.equals("1") || s.equals("3"))
				System.out.println("남자입니다.");
			else if(s.equals("2") || s.equals("4") )
				System.out.println("여자입니다.");
			else
				System.out.println("외국인입니다.");
			
		}
		
		System.out.print("끝");
		
		sc.close();

	}

	static boolean distinctIDNum(String IDNum) {
		if (IDNum.length() == 14)
			return true;
		else
			return false;
	}
}
