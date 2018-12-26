package ex9_14_InnerClass;

public class InnerEx1 {
	//인스턴스 클래스(instance class)
	class InstanceInner {
		int iv = 100;
		//static int cv = 100; //에러! static변수를 선언할 수 없습니다.
		final static int CONST = 100; // final static은 상수이므로 허용
	}
	
	//static class
	static class StaticInner{
		int iv = 200;
		static int cv = 200; //static클래스만 static멤버를 정의할 수 있습니다.
	}
	
	void myMethod(){
		//지역 클래스(local class)
		class LocalInner{
			int iv = 300;
			//static int cv = 300;	//에러! static변수를 선언할 수 없습니다.
			final static int CONST = 300; // final static은 상수이므로 허용
		}
	}
	
	public static void main(String args[]){
		System.out.println(InstanceInner.CONST);
		System.out.println(StaticInner.cv);
	}
}
