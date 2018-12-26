//Wrapper 클래스의 생성자를 대신하는 정적 메소드 - valueOf
package ex14_1_Wrapper;

public class Wrapper4_valueOf {

	public static void main(String[] args) {
		//Wrapper 클래스의 생성자를 대신하는 정적 메소드
		//박싱 - 기본형 타입의 값을 객체화
		//int -> Integer
		Integer obj1 = Integer.valueOf(10);
		Integer obj2 = Integer.valueOf(10);
		
		//똑같은 기본값을 가지고 valueOf메소드를 여러 번 호출하면
		//같은 객체에 대한 참조값이 리턴됩니다.
		if(obj1 == obj2)
			System.out.println("obj1 == obj2");
		
		//String과 마찬가지고 equals메소드는 주소값이 아닌
		//내용을 비교하도록 오버라이딩되어 있습니다.
		if(obj1.equals(obj2))
			System.out.println("obj1.eqauls(obj2)");

	}

}
