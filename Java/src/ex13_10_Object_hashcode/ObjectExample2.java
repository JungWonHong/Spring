package ex13_10_Object_hashcode;

public class ObjectExample2 {

	public static void main(String[] args) {
		Circle c1 = new Circle(5);
		Circle c2 = new Circle(5);
		
		//int java.lang.Object.hashCod()
		//서로 다른 객체는 결코 같은 해시코드를 가질 수 없습니다.
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
	}

}
