/*
 * Generic 사용
 * java.lang.Object
 * 	 java.util.AbstractCollection<E>
 * 		java.util.AbstractList<E>
 * 			java.util.Vector<E>
 * 				java.util.Stack<E>
 * 
 * 스택(Stack) 클래스
 * 	1. LIFO(Last Input First output) 구조
 * 	     마지막으로 입력된 자료가 가장 먼저 출력되는 구조
 *  2. 여러가지 자료형의 Data를 모두 저장할 수 있다.
 */
package ex15_2_Stack;

import java.util.Stack;

public class Stack3_Generics {

	public static void main(String[] args) {
		// Stack 객체 생성
		Stack<String> s = new Stack<String>();
		System.out.println("비었나요? " + s.empty());// true - 비었는지 판단

		// Stack에 값을 넣음
		s.push("좋아요");
		s.push("박보검");

		// Stack의 값을 출력
		System.out.println("비었나요? " + s.empty()); // false - 비었는지 판단

		System.out.println("맨 마지막 데이터 : " + s.peek());// 마지막 데이터 가져오기

		// boolean java.util.Vector.isEmpty()
		/*
		  while(!s.isEmpty()){ System.out.println("데이터 출력 : " + s.pop()); }
		 */

		// boolean java.util.Stack.empty()
		while (!s.empty()) {
			System.out.println("데이터 출력 : " + s.pop());
		}
		

		System.out.println("비었나요? " + s.empty()); // true - 비었는지 판단
	}

}
