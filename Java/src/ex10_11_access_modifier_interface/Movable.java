/*
 * 인터페이스의 메소드는 구성요소에 public 키워드를 붙이지 않아도
 * 컴파일할 때 자동으로 추가된다.
 * 따라서 인터페이스로부터 상속받은 메소드를 구현할 때는 항상
 * public 키워드를 붙여야한다.
 */
package ex10_11_access_modifier_interface;

public interface Movable {
	void moveTo(int x, int y);	//public abstract 생략
}
