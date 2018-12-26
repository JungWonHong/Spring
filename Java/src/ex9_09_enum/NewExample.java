package ex9_09_enum;

public class NewExample {

	public static void main(String[] args) {
		ClothingInfo obj = new ClothingInfo("32919", 
				"반팔 티셔츠", "면100%", Season.SUMMER);
		//Season.SUMMER에서 Season은 열거 타입 이름,
		//SUMMER는 열거 상수 이름이다.
		
		System.out.println("상품코드: " + obj.code);
		System.out.println("상품명: " + obj.name);
		System.out.println("소재: " + obj.material);
		
		//열거 상수의 이름이 출력
		System.out.println("계절구분: " + obj.season);
	}

}
