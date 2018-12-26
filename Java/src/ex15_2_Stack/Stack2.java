package ex15_2_Stack;

import java.util.Date;
import java.util.Stack;

public class Stack2 {

	public static void main(String[] args) {
		// Stack ��ü ����
		Stack s = new Stack();
		System.out.println("�������? " + s.empty()); // true - �����

		// Stack�� ���� ����
		s.push("���ƿ�");
		Date d = new Date(); //�ý����� ��¥ ���ϴ� ��ü
		s.push(d);
		s.push(new Integer(10));
		s.push("����");

		// Stack�� ���� ���
		System.out.println("�������? " + s.empty()); //false - ������� �Ǵ�

		// peek() : �ⱸ��(�� �������� �����)�� �ִ� �ڷḦ �������� �ʰ� ���ؿ��� �޼ҵ�
		System.out.println("�� ������ ������ : " + s.peek()); //���̹�����Ȯ�� �������°Ǿƴ�.

		// pop() : Stack�� �� ���� ����� ��ü�� ������ �޼ҵ�
		System.out.println("������ ��� : " + s.pop());// ���� - �ڷ� ���
		System.out.println("������ ��� : " + s.pop());// 10 - �ڷ� ���
		System.out.println("������ ��� : " + s.pop());// ��¥ ���
		System.out.println("������ ��� : " + s.pop());// ���ƿ� - �ڷ� ���

		System.out.println("�������? " + s.empty()); //true - ������� �Ǵ�

	}

}
