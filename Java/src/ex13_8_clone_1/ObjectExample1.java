//clone()�޼ҵ�� ��ü�� �����ϴ� ����� �մϴ�.
//��, �Ȱ��� ���� ���� ��ü�� �� �� �� ����ϴ�.
//Cloneable �������̽��� ������ GregorianCalendar Ŭ������ ���ؼ�
//clone()�޼ҵ带 ȣ���ϴ� ����
package ex13_8_clone_1;

import java.util.GregorianCalendar;

public class ObjectExample1 {

	public static void main(String[] args) {
		//��ü�� �����մϴ�.
		GregorianCalendar obj1 = new GregorianCalendar(2007, 0, 1);
		
		//clone�޼���� ��ü�� �����մϴ�.
		GregorianCalendar obj2 = (GregorianCalendar)obj1.clone();
		
		//Type mismatch: cannot convert from Object to GregorianCalendar
		//GregorianCalendar obj3 = obj1.clone(); 
		
		//%tF : ���� ���ڴ� ��¥�� YYYY-MM-DD �������� �����ϴ� ������ �Ѵ�.
		System.out.printf("%tF %n", obj1);
		System.out.printf("%tF %n", obj2);

	}

}
