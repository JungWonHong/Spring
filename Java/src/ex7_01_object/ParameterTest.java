package ex7_01_object;

class Data {
	int x;
}

public class ParameterTest {

	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x = " + d.x);

		change(d.x);  // 값을 전달해준다.(매개변수가 기본형)
		System.out.println("After change(d)");
		System.out.println("main() : x = " + d.x); 
		//값만 전달했기 때문에 Data클래스 내의 x값은 변하지 않는다.
	}

	static void change(int x) {
		x = 1000;
		System.out.println("change() : x = " + x);
	}
}
