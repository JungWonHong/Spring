package ex7_0_object;

public class Saram5 {
	//멤버녀수(필드)
	String name;
	double w;
	double ki;
	int age;

	// 생성자 - 반드시 클래스 이름과 똑같고 리턴 타입이 없어야 한다.
	Saram5(String name2, double w2) {
		this.name = name2;   //같은 클래스내의 변수사용시 this사용.
		this.w = w2;
	}
	
	Saram5(double w2, String name2){ //생성자 오버로딩.(위와 매개변수 순서가 바뀜)
		this.name = name2;
		this.w=w2;
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
