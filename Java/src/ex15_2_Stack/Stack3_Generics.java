/*
 * Generic ���
 * java.lang.Object
 * 	 java.util.AbstractCollection<E>
 * 		java.util.AbstractList<E>
 * 			java.util.Vector<E>
 * 				java.util.Stack<E>
 * 
 * ����(Stack) Ŭ����
 * 	1. LIFO(Last Input First output) ����
 * 	     ���������� �Էµ� �ڷᰡ ���� ���� ��µǴ� ����
 *  2. �������� �ڷ����� Data�� ��� ������ �� �ִ�.
 */
package ex15_2_Stack;

import java.util.Stack;

public class Stack3_Generics {

	public static void main(String[] args) {
		// Stack ��ü ����
		Stack<String> s = new Stack<String>();
		System.out.println("�������? " + s.empty());// true - ������� �Ǵ�

		// Stack�� ���� ����
		s.push("���ƿ�");
		s.push("�ں���");

		// Stack�� ���� ���
		System.out.println("�������? " + s.empty()); // false - ������� �Ǵ�

		System.out.println("�� ������ ������ : " + s.peek());// ������ ������ ��������

		// boolean java.util.Vector.isEmpty()
		/*
		  while(!s.isEmpty()){ System.out.println("������ ��� : " + s.pop()); }
		 */

		// boolean java.util.Stack.empty()
		while (!s.empty()) {
			System.out.println("������ ��� : " + s.pop());
		}
		

		System.out.println("�������? " + s.empty()); // true - ������� �Ǵ�
	}

}
