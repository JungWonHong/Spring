package ex7_01_object;

class Data2{
	int x;
}

public class ParameterTest2 {

	public static void main(String[] args) {
		Data2 d = new Data2();
		d.x = 10;
		System.out.println("main() : x = " + d.x);

		change(d);	// 클래스의 주소를 전달해준다(매개변수가 참조형)
		System.out.println("After change(d)");
		System.out.println("main() : x = " + d.x);
	}

	static void change(Data2 d) {
		d.x = 1000;
		System.out.println("change() : x = " + d.x);
	}
}
