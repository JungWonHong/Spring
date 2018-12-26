//문자열 추출 메소드
/*
 * 주민번호 123456-41234567를 이용하여 남자,여자,외국인을 출력하기
 * 뒷자리 첫글자가 1또는3이면 남자, 2또는4이면 여자, 그 외는 외국인
 */
package ex11_1_String;

public class StringExample6_2 {
	public static void main(String[] args) {
		String str = "123456-41234567";

		String s = str.substring(7, 8);
		System.out.print("추출한 숫자는 " + s + "이고 ");

		switch (s) {
		case "1":
		case "3":
			System.out.println("남자입니다.");
			break;
		case "2":
		case "4":
			System.out.println("여자입니다.");
			break;
		default:
			System.out.println("외국인입니다.");
		}
	}
}
