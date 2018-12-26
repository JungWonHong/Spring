//LinkedList�� �����͸� ����/����/������ ��
package ex15_1_LinkedList;

import java.util.LinkedList;

public class LinkedList3_iterator {

	public static void main(String[] args) {
		// LinkedList ��ü�� ����
		LinkedList<String> list = new LinkedList<String>();
		list.add("����");
		list.add("����");
		list.add("������");
		list.add(2, "Ű��");
		
		list.set(0, "������");

		list.remove(1);
		list.remove("Ű��");
		
		int num = list.size();
		
		//get�޼ҵ�� �����͸� ���� �� ù��° �����ͺ��� ��ũ�� ���󰡸鼭 ������� ã�´�
		//��) get(2)�� ��� index 0���� 1,2�� ��θ� ��ģ��.
		//��) get(4)�� ��� index 0���� 1,2,3,4�� ��θ� ��ģ��.
		//�ռ� ã�� �������� ��ġ�� ����ϰ� �ִٰ� �������� �ٷ� �� ���� �����͸� �д� ����� ������?
		//iterator�޼ҵ� �̿��ϸ� �ȴ�. LinkedExample3.java ����
		for (int cnt = 0; cnt < num; cnt++) {
			String str = list.get(cnt);
			System.out.println(str);
		}

	}

}
