/*
 * hashCode�� �Ϲ� �Ծ��� ������ �����ϴ�.
 * Java ���ø����̼��� ���� �߿� ������ ��ü���� �� �� �̻� ȣ�� �� ������
 * hashCode �޼ҵ�� ��ü�� ���� equals �񱳿���
 * ��� �� ������ �������� ������ ������ ������ �ϰ��ǰ� ��ȯ�ؾ��մϴ�.
 * �� ������ �� ���� ���α׷� ���࿡�� ���� ���� ���α׷��� �ٸ� ��������
 * �ϰ����� ������ �ʿ䰡 �����ϴ�.
 * equals(Object) �޼ҵ忡 ���� �� ��ü�� ������ �� ��ü ������ ����
 * hashCode �޼ҵ带 ȣ���ϸ� ���� ���� ����� �����ؾ� �մϴ�.
 */
package ex13_10_Object_hashcode;

public class ObjectExample1 {

	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		//String Ŭ������ ���ڿ��� ������ ������ ������ �ؽ��ڵ带 ��ȯ�ϵ��� hashCode�޼��尡 �������̵��Ǿ� �ֱ� ������
		//���ڿ��� ������ ���� str1�� str2�� ���� hashCode()�� ȣ���ϸ� �׻� ������ �ؽ��ڵ尪�� ����ϴ�.
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());

	}

}
