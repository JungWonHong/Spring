//LinkedList�� iterator() �޼ҵ� ���
package ex15_1_LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedList2_set_remove {

	public static void main(String[] args) {
		// LinkedList ��ü�� ����
		LinkedList<String> list = new LinkedList<String>();
		list.add("����");
		list.add("���ξ���");
		list.add("�ٳ���");
		
		//iterator()�޼ҵ带 ȣ���Ͽ� Iterator ��ü�� ����ϴ�.
		Iterator<String> iterator = list.iterator();
		
		//Iterator ��ü�� �̿��Ͽ� list�� �ִ� �����͸� ������� �����ͼ� ���
		while(iterator.hasNext()){ //���� ��ġ���� ���� �����Ͱ� �ִ��� Ȯ��
			String str = iterator.next(); //���� �����͸� �������� �޼ҵ�
			System.out.println(str);
		}
		
		
	}

}
