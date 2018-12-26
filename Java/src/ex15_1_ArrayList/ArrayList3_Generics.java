/*
 * -���ʸ���(Generics) jdk 1.5���� ó�� ����
 *  �پ��� Ÿ���� ��ü���� �ٷ�� �޼ҵ峪 �÷��� Ŭ������ ������ ���� Ÿ��üũ�� ���ִ� ����Դϴ�.
 * -Ŭ���� ���� ����(<>)��ȣ�� �̿��ؼ� ����ϴ�.
 * -<>�ȿ� Ư�� �ڷ���(Wrapper Ŭ����, String, ����� ���� Ŭ������)�� �־��ָ� �˴ϴ�.
 * -��� ��)
 * 		List<String>		list = new ArrayList<String>();
 * 		ArrayList<String>	list = new ArrayList<String>();
 * 		ArrayList<Integer>	list = new ArrayList<Integer>();
 * 		ArrayList<Double>	list = new ArrayList<Double>();
 * 		ArrayList<MemberInput> list = new ArrayList<MemberInput>();
 */
package ex15_1_ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayList3_Generics {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		// ArrayList list = new ArrayList();

		// �ڷ��߰�
		list.add("�ϳ�");
		list.add(2); 		// ���� �߻� - String �� �ƴ�
		list.add(false); 	// ���� �߻� - String �� �ƴ�
		list.add(3.42); 	// ���� �߻� - String �� �ƴ�
		list.add("��"); 		// ���� �߻� - String �� �ƴ�
		list.add("five");	// ���� �߻� - String �� �ƴ�
		list.add('A'); 		// ���� �߻� - String �� �ƴ�

		// ��¹�� 1. - �ش� ��ü������ ����ϴ� ���
		System.out.println("===��ü������ ����ϱ�===");
		System.out.println(list);

		// ��¹�� 2. - get()�޼ҵ� �̿��
		System.out.println("===get()�޼ҵ� �̿��==");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " ��° ��� = " + list.get(i));
		}
		System.out.println("=================");

		for (int i = 0; i < list.size(); i++) {
			Object s = list.get(i); // get()�޼ҵ��� ��ȯ���� Object��
			System.out.println(s);
		}

		// ��¹�� 3. - Iterator �������̽� ��� : �ݺ��� 
		System.out.println("===Iterator �������̽� ���===");
		Iterator elements = list.iterator();
		while (elements.hasNext()) {// hasNext() : �о�� ��Ұ� �ִ� �� Ȯ��
			System.out.println(elements.next());
			// next() �޼ҵ带 �̿��ؼ� ���ʴ�� �Ѱ��� ������ �����ɴϴ�.
		}

		// ��¹�� 4. - for�� ���
		System.out.println("====���� for�� ���=====");
		for (Object a : list)
			System.out.println(a);

		System.out.println("======");
		for (int i = 0; i < list.size(); i++) {
			// �ε������� ���� ����Ǿ��ִ� �ڷ����� �ٸ��� ������ �����߻��Ѵ�.
			String s1 = (String) (list.get(i)); // java.lang.Integer cannot be
												// cast to java.lang.String
			System.out.println(s1);
		}
	}

}