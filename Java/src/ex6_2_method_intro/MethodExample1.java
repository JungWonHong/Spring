package ex6_2_method_intro;

public class MethodExample1 {

	public static void main(String[] args) {
		//메서드 호출 방법1. 클래스명.정적메서드
		MethodExample1.printCharacter('*', 30);//메서드 호출
		
		//메서드 호출방법2. 정적메서드-정적메서드를 호출하는 경우 클래스명 생략 가능
		printCharacter('-', 30);
		System.out.println("Hello, Java");
		printCharacter('-', 30);
		printCharacter('*', 30);
		return; //반환형이 void인 경우 생략가능.
	}

	// 메서드 정의 : static - 정적메서드
	public static void printCharacter(char ch, int num) {
		for (int cnt = 0; cnt < num; cnt++) {
			System.out.print(ch);
		}
		System.out.println();
		return; //반환형이 void인 경우 생략가능합니다.
	}

}
