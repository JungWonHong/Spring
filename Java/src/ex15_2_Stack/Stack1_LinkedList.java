//LinkedList Ŭ������ �������� ����ϴ� ��
package ex15_2_Stack;

import java.util.LinkedList;

public class Stack1_LinkedList {

	public static void main(String[] args) {
		// LinkedList ��ü�� ����
		LinkedList<Integer> stack = new LinkedList<Integer>();

		// ���ÿ� 3���� ������ �߰�
		stack.addLast(new Integer(12));
		stack.addLast(new Integer(59));
		stack.addLast(new Integer(7));
		System.out.println("stack.size()=" + stack.size());

		System.out.println("stack.getLast()=" + stack.getLast());

		// isEmpty():LinkedList��ü �ȿ� �����Ͱ� ���� �� true, ������ false
		while (!stack.isEmpty()) {
			// removeLast():������ ������ ���� ���� �����ϴ� �޼ҵ�
			Integer num = stack.removeLast();
			System.out.print(num + "\t"); // auto unboxing
			System.out.println(num.intValue()); // unboxing
		}

		// true - ������� �Ǵ�
		System.out.println("�������? " + stack.isEmpty());
	}

}
