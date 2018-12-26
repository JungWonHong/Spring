package ex9_11;
//클래스 안에 열거 타입을 선언한 예
//접근 방법 : 열거타입이 속하는 클래스 이름.열거 타입이름.열거 상수 이름
//예) ClothingInfo.Season.SUMMER
public class NewExample2 {

	public static void main(String[] args) {
		ClothingInfo obj = new ClothingInfo("32919", 
				"반팔 티셔츠", "면100%", ClothingInfo.Season.SUMMER);
									//클래스명.열거타입.상수
		System.out.println("상품코드: " + obj.code);
		System.out.println("상품명: " + obj.name);
		System.out.println("소재: " + obj.material);
		System.out.println("계절구분: " + obj.season);
	}

}
