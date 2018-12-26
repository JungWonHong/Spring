package ex7_08_final_field;

//final 필드를 포함하는 클래스 - 올바른 예
public class Square2 {
	final int sideLength;// 선언문에서 초기화 하지 않았지만

	Square2(int sideLength) {
		// 생성자 안에서 초기화 했음
		this.sideLength = sideLength;
	}
}
