//LinkedList 클래스를 스택으로 사용하는 예
package ex15_2_Stack;

import java.util.LinkedList;

public class Stack1_LinkedList {

	public static void main(String[] args) {
		// LinkedList 객체를 생성
		LinkedList<Integer> stack = new LinkedList<Integer>();

		// 스택에 3개의 데이터 추가
		stack.addLast(new Integer(12));
		stack.addLast(new Integer(59));
		stack.addLast(new Integer(7));
		System.out.println("stack.size()=" + stack.size());

		System.out.println("stack.getLast()=" + stack.getLast());

		// isEmpty():LinkedList객체 안에 데이터가 없을 때 true, 있으면 false
		while (!stack.isEmpty()) {
			// removeLast():마지막 데이터 꺼내 오고 제거하는 메소드
			Integer num = stack.removeLast();
			System.out.print(num + "\t"); // auto unboxing
			System.out.println(num.intValue()); // unboxing
		}

		// true - 비었는지 판단
		System.out.println("비었나요? " + stack.isEmpty());
	}

}
