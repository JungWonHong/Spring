//Generic 없이 사용
/*
 * Vector 클래스 - List와 거의 비슷, 둘 중에서 List를 더 많이 사용
 *  1.여러가지 자료형의 Data를 모두 저장할 수 있습니다.
 *  	ex) int, double, char, boolean, String etc
 *  2.순서있는 입, 출력 처리(index번호 순으로 저장됨)
 *  3.중복된 Data를 저장 할 수 있습니다.
 *  4.입출력 방법 다양합니다.(열거형으로 출력 가능)
 *  5.무조건 동기화를 하기 때문에 단일 스레드 처리에서는
 *    ArrayList나 LinkedList보다 성능이 떨어집니다.
 *    참고)동기화란 스레드에서 공유자원에 작업을 마치기 전 까지는
 *        다른 스레드에서 공유자원에 접근 하지 못하게 약속하는 것
 */
package ex15_1_Vector;

import java.util.Vector;

public class Vector2_Generics {

	public static void main(String[] args) {
		// Generic 사용 안하기 때문에 모든 자료형 입력 가능
		Vector<String> vec = new Vector<String>();
		vec.add("Apple");
		vec.add("banana");
		vec.add("oRANGE");

		// 출력 방법 1.get() 사용
		System.out.println("=== get() ===");
		String temp;
		for (int cnt = 0; cnt < vec.size(); cnt++) {
			//temp = (String) vec.get(cnt); // Generic을 사용하지 않을 경우에는 변환형을 명시적으로 선언해야 합니다.
			temp = vec.get(cnt); //get(i)이 반환형이 Object형이지만 Generic으로 선언했기 때문에 (String)을 생략 할 수 있습니다.
			System.out.println(temp.toUpperCase()); // 대문자로 변환
		}

	}

}
