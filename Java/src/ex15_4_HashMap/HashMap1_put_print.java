/*
 * HashMap Generic ������� ���� ��
 *  Map �������̽�
 *   - HashMap, HashTable (��ӹ޴� Ŭ����)
 *   	1. �������� �ڷ����� Data�� ��� ������ �� �ֽ��ϴ�.
 *   		ex) int, double, char, boolean, String etc
 *   	2. Data�� ������ ��  Key, Value �� ���ÿ� �����մϴ�.
 *   	   Key���� �ߺ����� �ʽ��ϴ�.
 *   	3. �� �ϳ��� null key, �������� null �� ���
 *   
 *   HashMap�� HashSet � ���Ǵ� hashing�� ���� ����
 *   - �ؽ��̶� �ؽ��Լ��� �̿��ؼ� �����͸� �ؽ� ���̺��� �����ϰ� �˻��ϴ� ����� ���մϴ�.
 *   - �ؽ� ���̺��̶� ���� ���� ��(bucket)�� ����� �ΰ� Ű ���� �̿��Ͽ�
 *     �����͸� ���� �� ��ȣ�� ����ϴ� ������ �����Դϴ�.
 *   
 *   - �ؽ� �Լ��� Ű ���� �޾� �ؽ� ���̺��� �ε��� Ű ���� ���ϴ� �Լ��Դϴ�.
 *   - �ؽ� �Լ��� �����Ͱ� ����Ǿ� �ִ� ���� �˷� �ֱ� ������ �ٷ��� ������ �߿�����
 *     ���ϴ� �����͸� ������ ã�� �� �ֽ��ϴ�.
 *   
 *   - �ؽ��� ������ �÷��� Ŭ�����δ� HashSet, HashMap, Hashtable ���� �ֽ��ϴ�.
 *   - Object Ŭ������ ���ǵ� hashCode()�� �ؽ��Լ��� ����մϴ�.
 *   
 *   - HashMap�� ����� �����͸� ã�� ����
 *   	1. �˻��ϰ��� �ϴ� ���� Ű�� �ؽ��Լ��� ȣ���մϴ�.
 *   	2. �ؽ��Լ��� ������� �ؽ��ڵ带 �̿��ؼ� �ش� ���� ����Ǿ� �ִ� linked list�� ã���ϴ�.
 *   	3. linked list���� �˻��� Ű�� ��ġ�ϴ� �����͸� ã���ϴ�.
 */
package ex15_4_HashMap;

import java.util.HashMap;

public class HashMap1_put_print {

	public static void main(String[] args) {
		// HashMap ��ü ���� ��� �� ����
		// Map hm = new HashMap(); //���1. ��ĳ����
		HashMap hm = new HashMap();// ���2. ���� Ŭ������ ���� ��ü ����

		// Key�� Value ���� ����
		// Map�� �޼ҵ�� put�� �̿���(Key, Value) ������ �ڷ� �����Ѵ�.
		hm.put("woman", "����ִ�");
		hm.put("man", "���� �Ϸ�");
		hm.put("age", new Integer(10));// hm.put("age", 10);
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