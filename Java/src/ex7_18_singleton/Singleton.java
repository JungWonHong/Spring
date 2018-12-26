package ex7_18_singleton;

public class Singleton {

	//private : 외부에서 생성자를 호출할 수 없도록 막습니다.
	private Singleton() {	}

	//필드 s는 외부에서 사용 못합니다.
	static private Singleton s = new Singleton();
	
	static Singleton getInstance(){
		System.out.println("여기는 getInstance입니다.");
		return s;
	}
}
