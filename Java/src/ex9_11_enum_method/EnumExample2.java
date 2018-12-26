package ex9_11_enum_method;
/*
 * 열거 타입에 대해 valueOf 메소드를 호출하는 예
 * public static ex9_11_enum_method.Day valuesOf(java.lang.String);
 * 		==> 열거 상수의 이름을 문자열로 넘겨주면 그에 해당하는 열거 상수를 리턴하는 메소드
 */
public class EnumExample2 {

	public static void main(String[] args) {
		printDay("MONDAY");
		printDay("TUESDAY");
		printDay("FRIDAY");
		//printDay("FRIDAY2"); //열거형에 없는 상수 이기 때문에 실행오류.
	}
	
	static void printDay(String name){
		Day day = Day.valueOf(name);
		System.out.println(day);
	}

}
