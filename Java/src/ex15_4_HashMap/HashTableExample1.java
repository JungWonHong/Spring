/*
 * Hashtable - ����ȭ ���� �ַ������ ���(�� ��� ����)
 * null���� Key������ ������� �ʽ��ϴ�.
 * ��ĳ������ ������� Map�� �����ϸ� ������� �޼ҵ常 ����� �� �־�
 * ���� ������ ������ ��ҵ˴ϴ�.
 * ht.keys()�� ������ ���մϴ�.
 */
package ex15_4_HashMap;

import java.util.*;

public class HashTableExample1 {

	public static void main(String[] args) {
		// Map ht = new Hashtable(); //��ĳ����(�θ𿡰� ��ӵ� �޼ҵ常 ����� �� �ֽ��ϴ�.)
		// ��ĳ�������� �����ϸ� �ڽ�(Hashtable)�� �ִ� keys()�޼ҵ带 ����� �� ����
		// ���� �߻��մϴ�.

		Hashtable ht = new Hashtable();

		// �ؽ� ���̺��� Ű/�����͸� �Է��մϴ�.
		ht.put("����", "StrawBerry");
		ht.put("���", "Apple");
		ht.put("����", "Grapes");
		ht.put("�޷�", 10);
		// ht.put(null, 10); //�ؽ����̺� Ű������ null�� ���ϼ� ����.

		// �ؽ� ���̺��� ���� Ű�� �̿��Ͽ� ����ϴ�.
		Object obj = ht.get("����"); // �ش� Ű�� �ƴ� ��� get�޼ҵ�� ���ؿɴϴ�.
									// ��ȯ���� Object���Դϴ�.
									// ������ String������ ���� ����մϴ�.
									// Ű�� �� ��� ����ϴ� ���

		System.out.println("������ ��-> " + obj);
		System.out.println("������ ��-> " + obj.toString());

		String Val = (String) ht.get("����"); // �ٿ�ĳ����
		// String Val = (String)ht.get("�޷�"); //���� : �������� ���������� �ٲܼ� ����

		if (Val != null) {
			System.out.println("����-> " + Val);
		}

		Enumeration Enum = ht.keys();
		// ��ĳ�������� �����ϸ� �ڽ�(Hashtable)�� �ִ� keys()�޼ҵ带 ����� �� ����
		// ���� �߻��մϴ�.
		// �ذ�� : Hashtable ht = new Hashtable();�� ��ü ����
		// ��� Ű�� ���������� �������� �޼ҵ��Դϴ�.

		// Ű�� � ���� �ִ��� �� ��, ������ �� �� ����
		while (Enum.hasMoreElements()) {
			Object k = Enum.nextElement(); // Ű�� ���ؿ´�.
			Object v = ht.get(k); // Ű�� �ش��ϴ� ���� �����´�.
			System.out.println(k + " : " + v);
		}
	}

}