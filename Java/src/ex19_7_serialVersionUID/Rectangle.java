//����ȭ ���� Ŭ������ ���� ��ȣ ���̱�
//�ٿ��� ���� ��ȣ�� Ŭ������ ������Ҹ� �߰��ϰų� �����ص� �ٲ��� �ʽ��ϴ�.
package ex19_7_serialVersionUID;

public class Rectangle implements java.io.Serializable{
	static final long serialVersionUID = 100; //������ȣ
	int width, height;
	Rectangle(int width, int height){
		this.width = width;
		this.height = height;
	}
	/*
	int getArea(){
		return width * height;
	}
	 */
}
