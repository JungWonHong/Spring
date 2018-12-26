/*
 * HashMap Generic ������� ���� ��
 *  Map �������̽�
 *   - HashMap, HashTable (��ӹ޴� Ŭ����)
 *   	1. �������� �ڷ����� Data�� ��� ������ �� �ֽ��ϴ�.
 *   		ex) int, double, char, boolean, String etc
 *   	2. Data�� ������ ��  Key, Value �� ���ÿ� �����մϴ�.
 *   	   Key���� �ߺ����� �ʽ��ϴ�.
 *   	3. �� �ϳ��� null key, �������� null �� ���
 */
//Key�� null�� ���
package ex15_4_HashMap;

import java.util.HashMap;

public class HashMap2_Key_null {

	public static void main(String[] args) {
		// HashMap ��ü ���� ��� �� ����
		// Map hm = new HashMap(); //���1. ��ĳ����
		HashMap hm = new HashMap();// ���2. ���� Ŭ������ ���� ��ü ����

		// Key�� Value ���� ����
		// Map�� �޼ҵ�� put�� �̿���(Key, Value) ������ �ڷ� �����Ѵ�.
		hm.put("name", "������");
		hm.put("blood", "A");
		hm.put("age", new Integer(10));// hm.put("age", 10);
		hm.put("city", "seoul");

		// Key���� �ߺ��� ��� (���� ���� ���) ������ �����Ͱ� ����ȴ�.
		hm.put(null, "��ǳ");
		hm.put(null, "����");
		hm.put(null, "�ְ�");
		hm.put("city", null);

		// HashMap�� �ִ� ��ü���� ���
		// ��¹��1. �ش� ��ü������ ���
		System.out.println(hm);

		// ��� ���2. Key ���� ���
		System.out.println(hm.keySet());
		
		// ��¹��3. Value ���� ���
		System.out.println(hm.values());

		// ��¹��4.
		// get(Key) : Key�� �ش��ϴ� Value�� ��� - ���� ���� ���
		System.out.println(hm.get("woman"));
		System.out.println(hm.get("city"));
	}

}
