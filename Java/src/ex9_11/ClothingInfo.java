//����� ���� Ÿ���� Ŭ���� �ȿ� �����ؼ� ����� ��
//Ŭ���� ���ϵ��� Ȯ���� ����.
//�� Ŭ���� ������ �������ϸ� ������ ���� �ΰ��� Ŭ���� ������ ����
//ClothintInfo$Season.class, ClothingInfo.class ����
//ClothintInfo$Season.class �ǹ̴�
//ClothingInfo Ŭ���� �ȿ� �ִ� Season ���� Ÿ���� ������ ������Դϴ�.
package ex9_11;
public class ClothingInfo {
	enum Season{
		SPRING, SUMMER, FALL, WINTER
	}
	String code;
	String name;
	String material;
	Season season;	//���� Ÿ�� �ʵ�
	
	public ClothingInfo(String code, String name, 
			String material, Season season) {
		this.code = code;
		this.name = name;
		this.material = material;
		this.season = season;
		//this.season = 5; //�����Ͽ����߻�
	}
}
