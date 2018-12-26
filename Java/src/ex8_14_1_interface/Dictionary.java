package ex8_14_1_interface;
//상속 받은 추상 메소드를 구현하라는 에러 발생
//The type Dictionary must implement the inherited abstract method
public class Dictionary implements Lendable {
	String title;

	Dictionary(String title) {
		this.title = title;
	}

}
