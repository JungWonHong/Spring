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

import java.util.Vector;

public class Vector2_Generics {

	public static void main(String[] args) {
		// Generic ��� ���ϱ� ������ ��� �ڷ��� �Է� ����
		Vector<String> vec = new Vector<String>();
		vec.add("Apple");
		vec.add("banana");
		vec.add("oRANGE");

		// ��� ��� 1.get() ���
		System.out.println("=== get() ===");
		String temp;
		for (int cnt = 0; cnt < vec.size(); cnt++) {
			//temp = (String) vec.get(cnt); // Generic�� ������� ���� ��쿡�� ��ȯ���� ��������� �����ؾ� �մϴ�.
			temp = vec.get(cnt); //get(i)�� ��ȯ���� Object�������� Generic���� �����߱� ������ (String)�� ���� �� �� �ֽ��ϴ�.
			System.out.println(temp.toUpperCase()); // �빮�ڷ� ��ȯ
		}

	}

}
