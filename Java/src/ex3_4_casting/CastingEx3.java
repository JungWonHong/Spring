package ex3_4_casting;

public class CastingEx3 {

	public static void main(String[] args) {
		
		//int -> char
		int i3 = 97;
		char c1 = (char)i3;
		System.out.println("i3데이타는 " + i3 + "입니다.");
		System.out.println("c1데이타는 " + c1 + "입니다.");
		
		i3 = 65;
		c1 = (char)i3;
		System.out.println("i3데이타는 " + i3 + "입니다.");
		System.out.println("c1데이타는 " + c1 + "입니다.");
		
		//아스키 코드(ASCII CODE) - 컴퓨터에서 표현하는 문자를 0~127에 대응시킨 코드
		System.out.printf("%c\n", 'A'); //문자 'A'를 문자 서식 (%c)으로 출력
		System.out.printf("아스키코드 65는 문자 %c를 의미합니다.\n", 65); //정수65를 문자 서식 (%c)으로 출력해라
		System.out.printf("문자 A의 아스키 코드는 %d입니다.\n", (int)'A'); //문자 'A'를 정수 서식 (%d)으로 출력해라
	}

}
