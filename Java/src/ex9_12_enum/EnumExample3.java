package ex9_12_enum;

public class EnumExample3 {

	public static void main(String[] args) {
		//열거형을 사용하면 초기화가 된다. 각 열거값들의 생성자 호출. 따라서 각 열거값들의 생성자가 호출되는걸 볼수있다.
		printSeason(Season.SPRING); //열거형 SPRING의 주소를 넘겨준다.
		printSeason(Season.FALL);
	}

	static void printSeason(Season season) {
		System.out.println();

		// 주어진 열거 상수와 짝을 이룬 값을 리턴
		
		System.out.println("season.value() = " + season.value());

		/*
		 * 모든 열거형의 조상인 java.lang.Enum클래스에 정의된 메서드 1. String name() - 열거형 상수의 이름을
		 * 문자열로 반환한다. 2. int ordinal() - 열거형 상수가 정의된 순서를 반환한다(0부터 시작)
		 */
		System.out.println("season.name() = " + season.name());
		
		System.out.println("season.ordinal() = " + season.ordinal());
	}

}
