package ex8_19_interface_Multiple_inheritance;

//외형 변경 인터페이스 선언
public interface Changeable extends Resizable, Colorable {
	void setFont(String font);
}
