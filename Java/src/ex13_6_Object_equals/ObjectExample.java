/* equals�޼ҵ� ��� �� - �Ȱ��� ���� ���� �� ���� ��ü�� ����
 * Object Ŭ������ equals()�޼ҵ�
 * �Ű������� ��ü�� ���������� �޾Ƽ� ���Ͽ� �� ����� boolean������ �˷� �ִ� ������ �մϴ�.
 * ������ equals�޼ҵ��� ���� �����Դϴ�.
 * 
 * public boolean equals(Object arg0){
 * 		return this == arg0;
 * }
 * 
 * �� ��ü�� ���� �ٸ��� ���������� ������ �Ǵ��ϰ� �ֽ��ϴ�.
 * ���� �ٸ� �� ��ü�� equals �޼ҵ�� ���ϸ� �׻� false ����� ��� �˴ϴ�.
 */
package ex13_6_Object_equals;

import java.util.GregorianCalendar;

public class ObjectExample {

	public static void main(String[] args) {
		GregorianCalendar obj1 = new GregorianCalendar(2007, 0, 1);
		GregorianCalendar obj2 = new GregorianCalendar(2007, 0, 1);
		System.out.println(obj1);
		System.out.println(obj2);
		
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		
		if(obj1.equals(obj2))
			System.out.println("obj1.equals(obj2) : ����");
		else
			System.out.println("obj1.equals(obj2) : �ٸ�");
		
		if(obj1==obj2)
			System.out.println("obj1==obj2 : ����");
		else
			System.out.println("obj1==obj2 : �ٸ�");
		
	}

}
