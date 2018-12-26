/*
 * Properties�� HashMap�� �������� Hashtable�� ��� �޾� ������ ���Դϴ�.
 * Hashtable�� Ű�� ���� (Object, Object)�� ���·� �����ϴµ� ����
 * Properties�� (String, String)�� ���·� �����ϴ� ���� �ܼ�ȭ�� �÷��� Ŭ�����Դϴ�.
 * ��뿹)
 * ���ø����̼��� ȯ�漳���� ���õ� �Ӽ��� �����ϴµ� ���Ǹ� �����͸� ���Ϸ� ���� �а�
 * ���� ���� ����� �����մϴ�.
 */
package ex15_4_HashMap;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) {
		Properties prop = new Properties();

		// prop�� Ű�� ���� �����մϴ�.
		// setProperty�޼���� Hashtable�� put�޼��带 ȣ���մϴ�.
		prop.setProperty("���", "Apple");
		prop.setProperty("����", "StrawBerry");
		prop.setProperty("����", "Grapes");

		// prop�� ����� ��ҵ��� Enumeration�� �̿��ؼ� ����մϴ�.
		// Properties�� �÷��� �����ӿ�ũ ������ �������̶� Enumeration�� ����մϴ�.
		Enumeration e = prop.propertyNames();

		while (e.hasMoreElements()) {
			String element = (String) e.nextElement();
			System.out.println(element + "=" + prop.getProperty(element));
		}

		// prop�� ����� ��ҵ��� ����մϴ�.
		System.out.println(prop);
	}

}
