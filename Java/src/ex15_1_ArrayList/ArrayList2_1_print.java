package ex15_1_ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayList2_1_print {

	public static void main(String[] args) {
		List list = new ArrayList(); // ��ĳ����(������� �޼ҵ常 ��밡��)

		// ArrayList list = new ArrayList();

		// �ڷ� �߰�
		list.add("�ϳ�");
		list.add(2);
		list.add(false);
		list.add(3.42);
		list.add("��");
		list.add("five");
		list.add('A');
		
		//��¹�� 1. - �ش� ��ü������ ����ϴ� ���
		System.out.println("===��ü������ ����ϱ�===");
		System.out.println(list);
		
		//��¹�� 2. - get()�޼ҵ� �̿��
		System.out.println("===get()�޼ҵ� �̿��==");
		for(int i=0;i<list.size();i++){
			System.out.println(i + " ��° ��� = " + list.get(i));
		}
		System.out.println("=================");
		
		for(int i=0;i<list.size();i++){
			Object s = list.get(i); // get()�޼ҵ��� ��ȯ���� Object��
			System.out.println(s);
		}
		
		//��¹�� 3. - Iterator �������̽� ��� : �ݺ���
		System.out.println("===Iterator �������̽� ���===");
		Iterator elements = list.iterator();
		while(elements.hasNext()){//hasNext() : �о�� ��Ұ� �ִ� �� Ȯ��
			System.out.println(elements.next());
			//next() �޼ҵ带 �̿��ؼ� ���ʴ�� �Ѱ��� ������ �����ɴϴ�.
		}
		
		//��¹�� 4. - for�� ���
		System.out.println("====���� for�� ���=====");
		for(Object a : list)
			System.out.println(a);
	}

}
