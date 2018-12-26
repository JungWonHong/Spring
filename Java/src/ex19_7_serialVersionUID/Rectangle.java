//직렬화 가능 클래스에 버전 번호 붙이기
//붙여진 버전 번호는 클래스에 구성요소를 추가하거나 삭제해도 바뀌지 않습니다.
package ex19_7_serialVersionUID;

public class Rectangle implements java.io.Serializable{
	static final long serialVersionUID = 100; //버전번호
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
