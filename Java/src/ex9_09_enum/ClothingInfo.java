package ex9_09_enum;
//�Ƿ� ���� Ŭ����
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
		//this.season = 5; //�����Ͽ����߻�
	}
}
