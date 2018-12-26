package ex9_09_enum;
//의류 정보 클래스
public class ClothingInfo {
	String code;
	String name;
	String material;
	Season season;
	
	public ClothingInfo(String code, String name, 
			String material, Season season) {
		this.code = code;
		this.name = name;
		this.material = material;
		this.season = season;
		//this.season = 5; //컴파일에러발생
	}
}
