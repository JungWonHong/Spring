package ex8_18_interface_extends;

//위치 이동 인터페이스 선언
public interface Movable {
	void moveTo(int x, int y); // 절대 위치로 이동한다

	void moveBy(int xOffset, int yOffset); // 상대 위치만큼 이동한다
}
