//HashMap Generic ��� ��
package ex15_4_HashMap;

import java.util.HashMap;

public class HashMap3_Generics {

	public static void main(String[] args) {
		// HashMap ��ü ���� ��� �� ����
		// Map hm = new HashMap(); //���1. ��ĳ����
		HashMap<String, String> hm = new HashMap<String, String>();// ���2. ����
																	// Ŭ������ ����
																	// ��ü ����

		// Key�� Value ���� ����
		// Map�� �޼ҵ�� put�� �̿���(Key, Value) ������ �ڷ� �����Ѵ�.
		hm.put("woman", "����ִ�");
		hm.put("man", "���� �Ϸ�");
		hm.put("age", new String("10"));// hm.put("age", 10);
		hm.put("city", "seoul");

		// HashMap�� �ִ� ��ü���� ���
		// ��¹��1. �ش� ��ü������ ���
		System.out.println(hm);
		// {woman=����ִ�, city=seoul, man=�����Ϸ�, age=10}

		// ��� ���2. Key ���� ���
		System.out.println(hm.keySet());// [woman, city, man, age]

		// ��¹��3. Value ���� ���
		System.out.println(hm.values());// [����ִ�, seoul, �����Ϸ�, 10]

		// ��¹��4.
		// get(Key) : Key�� �ش��ϴ� Value�� ��� - ���� ���� ���
		System.out.println(hm.get("woman"));// ����ִ�
		System.out.println(hm.get("city"));// seoul
	}

}
