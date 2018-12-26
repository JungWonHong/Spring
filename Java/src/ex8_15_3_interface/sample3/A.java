package ex8_15_3_interface.sample3;

public class A {
	A() {
	}
	
	public void methodA() {
		//인스턴스를 직접 생성하지 않고 getInstance()메서드를 통해 제공받습니다.
		//이렇게 하면 나중에 다른 클래스의 인스턴스로 변경되어도 A 클래스의 변경없이
		//getInstance()메서드만 변경하면 된다는 장점이 생깁니다.
		I i = InstanceManager.getInstance(); //제3의 클래스의 메서드를 통해서 인터페이스 I를 구현한 클래스의 인스턴스를 얻어옵니다.
	  //I i = new B();						 //JDBC의 DriverManager클래스가 이런방식으로 되어 있습니다.
											 //DB의 경우 오라클,MySql등 다양한데 소스전체를 안바꾸고 이부분만 바꿔주는방식.
		i.methodB();
		
		//인터페이스 I타입의 참조변수 i로도 Object클래스에 정의된 메서드들을 호출할 수 있습니다.
		//i에 toString이 정의되어 있지 않지만 모든 객체는 Object클래스에 정의된 메서드의 사용을
		//허용하는 것입니다.
		System.out.println(i.toString());
	}
}
