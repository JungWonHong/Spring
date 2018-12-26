/* equals메소드 사용 예 - 똑같은 값을 갖는 두 개의 객체를 생성
 * Object 클래스의 equals()메소드
 * 매개변수로 객체의 참조변수를 받아서 비교하여 그 결과를 boolean값으로 알려 주는 역할을 합니다.
 * 다음은 equals메소드의 실제 내용입니다.
 * 
 * public boolean equals(Object arg0){
 * 		return this == arg0;
 * }
 * 
 * 두 객체의 같고 다름을 참조변수의 값으로 판단하고 있습니다.
 * 서로 다른 두 객체를 equals 메소드로 비교하면 항상 false 결과를 얻게 됩니다.
 */
package ex13_6_Object_equals;

import java.util.GregorianCalendar;

public class ObjectExample {

	public static void main(String[] args) {
		GregorianCalendar obj1 = new GregorianCalendar(2007, 0, 1);
		GregorianCalendar obj2 = new GregorianCalendar(2007, 0, 1);
		System.out.println(obj1);
		System.out.println(obj2);
		
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		
		if(obj1.equals(obj2))
			System.out.println("obj1.equals(obj2) : 같음");
		else
			System.out.println("obj1.equals(obj2) : 다름");
		
		if(obj1==obj2)
			System.out.println("obj1==obj2 : 같음");
		else
			System.out.println("obj1==obj2 : 다름");
		
	}

}
