//clone()메소드는 객체를 복제하는 기능을 합니다.
//즉, 똑같은 값을 갖는 객체를 한 개 더 만듭니다.
//Cloneable 인터페이스를 구현한 GregorianCalendar 클래스에 대해서
//clone()메소드를 호출하는 예제
package ex13_8_clone_1;

import java.util.GregorianCalendar;

public class ObjectExample1 {

	public static void main(String[] args) {
		//객체를 생성합니다.
		GregorianCalendar obj1 = new GregorianCalendar(2007, 0, 1);
		
		//clone메서드로 객체를 복제합니다.
		GregorianCalendar obj2 = (GregorianCalendar)obj1.clone();
		
		//Type mismatch: cannot convert from Object to GregorianCalendar
		//GregorianCalendar obj3 = obj1.clone(); 
		
		//%tF : 포맷 명세자는 날짜를 YYYY-MM-DD 형식으로 포맷하는 역할을 한다.
		System.out.printf("%tF %n", obj1);
		System.out.printf("%tF %n", obj2);

	}

}
