package ex9_8_enum_need;
//������� ǥ���ϴ� �ڵ� ���� ����� �����ؼ� ����ϴ� ��
//�Ƿ� ���� Ŭ����
public class ClothingInfo {
	String code;
	String name;
	String material;
	int season;
	
	//������� ǥ���ϴ� ��� �ʵ�
	static final int SPRING = 1;
	static final int SUMMER = 2;
	static final int FALL = 3;
	static final int WINTER = 4;
	
	public ClothingInfo(String code, String name, String material, int season) {
		this.code = code;
		this.name = name;
		this.material = material;
		this.season = season;
		//this.season = 5;
	}
}