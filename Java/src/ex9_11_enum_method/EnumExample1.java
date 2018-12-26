package ex9_11_enum_method;
/*
 * 열거 타입에 대해 values 메소드를 호출하는 예
 * public static ex9_11_enum_method.Day[] values();
 * 		==> 열거 타입에 속하는 모든 열거 상수들을 배열에 담아서 리턴하는 메소드
 */
public class EnumExample1 {

	public static void main(String[] args) {
		Day days[] = Day.values();

		for (int i = 0; i < days.length; i++)
			System.out.println(days[i]);
/*
		for (Day day : days)
			System.out.println(day);
*/
	}

}
