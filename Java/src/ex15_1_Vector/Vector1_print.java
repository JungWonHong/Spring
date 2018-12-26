//Generic ���� ���
/*
 * Vector Ŭ���� - List�� ���� ���, �� �߿��� List�� �� ���� ���
 *  1.�������� �ڷ����� Data�� ��� ������ �� �ֽ��ϴ�.
 *  	ex) int, double, char, boolean, String etc
 *  2.�����ִ� ��, ��� ó��(index��ȣ ������ �����)
 *  3.�ߺ��� Data�� ���� �� �� �ֽ��ϴ�.
 *  4.����� ��� �پ��մϴ�.(���������� ��� ����)
 *  5.������ ����ȭ�� �ϱ� ������ ���� ������ ó��������
 *    ArrayList�� LinkedList���� ������ �������ϴ�.
 *    ����)����ȭ�� �����忡�� �����ڿ��� �۾��� ��ġ�� �� ������
 *        �ٸ� �����忡�� �����ڿ��� ���� ���� ���ϰ� ����ϴ� ��
 */
package ex15_1_Vector;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Vector1_print {

	public static void main(String[] args) {
		// Generic ��� ���ϱ� ������ ��� �ڷ��� �Է� ����
		Vector vec = new Vector();
		vec.add("Apple");
		vec.add("banana");
		vec.add("oRANGE");

		// ��� ��� 1.get() ���
		System.out.println("=== get() ===");
		String temp;
		for (int cnt = 0; cnt < vec.size(); cnt++) {
			temp = (String) vec.get(cnt); // �ٿ� ĳ����(����� ����ȯ)
			// temp = vec.get(i); //(String)�����ϸ� ���� �߻�
			System.out.println(vec.get(cnt));
			System.out.println(temp.toUpperCase()); // �빮�ڷ� ��ȯ
		}

		// Vector�� ����
		// ��� ��� 2. Enumeration ���
		System.out.println("=== Enumeration ===");
		Enumeration enu = vec.elements();
		while (enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}

		// ��¹�� 3. Iterator ���
		System.out.println("=== Iterator ===");
		Iterator iterator = vec.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
