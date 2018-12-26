//사계절 열거 타입을 클래스 안에 선언해서 사용한 예
//클래스 파일들을 확인해 본다.
//이 클래스 파일을 컴파일하면 다음과 같이 두개의 클래스 파일이 생성
//ClothintInfo$Season.class, ClothingInfo.class 생성
//ClothintInfo$Season.class 의미는
//ClothingInfo 클래스 안에 있는 Season 열거 타입의 컴파일 결과물입니다.
package ex9_11;
public class ClothingInfo {
	enum Season{
		SPRING, SUMMER, FALL, WINTER
	}
	String code;
	String name;
	String material;
	Season season;	//열거 타입 필드
	
	public ClothingInfo(String code, String name, 
			String material, Season season) {
		this.code = code;
		this.name = name;
		this.material = material;
		this.season = season;
		//this.season = 5; //컴파일에러발생
	}
}
