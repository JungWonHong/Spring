package ex15_2_Stack;

import java.util.Date;
import java.util.Stack;

public class Stack2 {

	public static void main(String[] args) {
		// Stack 객체 생성
		Stack s = new Stack();
		System.out.println("비었나요? " + s.empty()); // true - 비었음

		// Stack에 값을 넣음
		s.push("좋아요");
		Date d = new Date(); //시스템의 날짜 구하는 객체
		s.push(d);
		s.push(new Integer(10));
		s.push("수지");

		// Stack의 값을 출력
		System.out.println("비었나요? " + s.empty()); //false - 비었는지 판단

		// peek() : 출구쪽(맨 마지막에 저장된)에 있는 자료를 제거하지 않고 구해오는 메소드
		System.out.println("맨 마지막 데이터 : " + s.peek()); //값이뭔지만확인 꺼내오는건아님.

		// pop() : Stack의 맨 위에 저장된 객체를 꺼내는 메소드
		System.out.println("데이터 출력 : " + s.pop());// 수지 - 자료 출력
		System.out.println("데이터 출력 : " + s.pop());// 10 - 자료 출력
		System.out.println("데이터 출력 : " + s.pop());// 날짜 출력
		System.out.println("데이터 출력 : " + s.pop());// 좋아요 - 자료 출력

		System.out.println("비었나요? " + s.empty()); //true - 비었는지 판단

	}

}
