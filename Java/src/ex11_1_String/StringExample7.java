package ex11_1_String;

public class StringExample7 {

	public static void main(String[] args) {
		String str1 = "    Let it be.  ";
		String str2 = str1.trim(); //앞뒤 공백 제거
		System.out.println("=========trim()==============");
		System.out.println(str1);
		System.out.println(str2 + "\n");

		System.out.println("=========concat()=============="); //문자열 합치기
		System.out.println(str2.concat(" Speaking words of wisdom"));
		System.out.println(str2 + "\n");

		System.out.println("=========toUpperCase()=============="); //대문자로
		System.out.println(str2.toUpperCase());
		System.out.println(str2 + "\n");

		System.out.println("=========toLowerCase()=============="); //소문자로
		System.out.println(str2.toLowerCase());
		System.out.println(str2 + "\n");

		System.out.println("=========replace()=============="); //문자열교체
		System.out.println(str2.replace('e', 'a'));
		System.out.println(str2 + "\n");
	}

}
