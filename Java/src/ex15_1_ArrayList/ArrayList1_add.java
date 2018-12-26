/*
 * List �������̽� -ArrayList (��ӹ޴� Ŭ����)
 *  1. �������� �ڷ����� Data�� ��� ������ �� �ֽ��ϴ�.
 *  	ex) int, double, char, boolean, String etc
 *  2. �Է��� ������� ��µ˴ϴ�.(index��ȣ ������ �����)
 *  3. �ߺ��� Data�� ���� �� �� �ֽ��ϴ�.
 *  4. �迭�� ������ �迭���� ����� �� ���� ���� ����� �� �ֽ��ϴ�.
 *  5. ������ ���� ������ �̿��� �� �ֽ��ϴ�.
 */
package ex15_1_ArrayList;

import java.util.*;

public class ArrayList1_add {

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

		System.out.println(list); // list�� ��� ������ ���

		// size() : �������� ���� ���ϴ� �޼ҵ�
		System.out.println("�������� ���� = " + list.size());

		// get(index) : �ش� �ε����� ������ �������� �޼ҵ�
		// get(3) : 0���� ����, index=3�� ������ ����ض�
		System.out.println("list.get(3)= " + list.get(3));
	}

}
