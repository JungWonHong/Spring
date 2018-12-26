package ex7_0_object;

public class Saram4 {
	//멤버녀수(필드)
	String name;
	double w;
	double ki;
	int age;

	// 생성자 - 반드시 클래스 이름과 똑같고 리턴 타입이 없어야 한다.
	Saram4(String name2, double w2) {
		name = name2;
		w = w2;
	}

	public void eat() {
		System.out.println(name + "이(가) 밥을 먹는다.");
	}

	public void walk() {
		System.out.println("걷기전 몸무게는 " + w + "입니다.");
	}

	public void sesu() {
		System.out.println(name + "이(가) 세수한다.");
	}

}
