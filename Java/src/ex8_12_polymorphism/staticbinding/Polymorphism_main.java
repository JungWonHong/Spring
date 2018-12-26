package ex8_12_polymorphism.staticbinding;

public class Polymorphism_main {

	public static void main(String[] args) {
		Child c = new Child();
		System.out.println("-----Child c = new Child();-----");
		c.parentPrn();
		c.childPrn();

		Parent p;
		p = c;	// Parent p = new Child(); // 다형성, 업캐스팅
		
		System.out.println("-----Parent p = new Child(); 업캐팅 후-----");
		
		//정적 바인딩 적용 - 객체의 타입이 컴파일러에 의해 컴파일 되는 시점에 결정되는 것을 말하며
		//private, final, static 메서드, 인스턴스 변수 등이 해당합니다.
		p.parentPrn();	

		//p.childPrn();	//The method childPrn() is undefined for the type Parent
		//컴파일 에러가 발생하게 됩니다.
		//참조 변수의 자료형 Parent클래스에는 childPrn()메소드가 없기 때문
		
		//다형성 적용 후 필드는 부모의 필드값을 출력
		//정적 바인딩 적용 - 객체의 타입이 컴파일러에 의해 컴파일 되는 시점에 결정되는 것을 말하며
		//private, final, static 메서드, 인스턴스 변수 등이 해당합니다.
		//부모 클래스의 필드에 주석을 달면 에러 발생
		System.out.println("p.message = " + p.message);
	}

}
