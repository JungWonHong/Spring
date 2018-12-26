/*
 * Set �������̽�
 * 	- HashSet (��ӹ޴� Ŭ����)
 * 	  TreeSet�� ���ĵ�
 * 1. �������� �ڷ���(�⺻�ڷ���, ������ ���)�� Data�� ��� ������ �� �ִ�.
 * 	  ex) int, double, char, boolean, String etc
 * 2. ���� ���� ��, ��� �Ѵ�.
 * 3. �ߺ��� Data�� �������� ���Ѵ�.
 * 	    ��)�ζ� ��ȣ6���� �ߺ� ���� �ʰ� �ϴ� ���α׷��� �̿�
 */
package ex15_5_HashSet;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class HashSet1_add_remove {

	public static void main(String[] args) {
		//HashSet Ŭ������ ��ü ����
		Set hs = new HashSet();
		//HashSet hs = new HashSet();

		//hs��ü�� ������ ��ü ����
		hs.add("���ƿ�");	//��ĳ���� has.add(new String("���ƿ�")
		hs.add("��ſ� �Ϸ�"); //��ĳ����(�Ű������� Object���̱� ������)
		
		//Date d = new Date();
		//hs.add(d);
		hs.add(new Date()); //�� �ι���� ���� �ǹ�
		
		//hs ��ü�� �����ϰ� �ִ� ������ ��ü ���
		System.out.println("hs�� ���� : " + hs);
		
		//"��ſ� �Ϸ�" ������ ��ü�� hs��ü���� ����
		hs.remove("��ſ� �Ϸ�");
		System.out.println("hs�� ���� : " + hs);
		
		System.out.println("\"���ƿ�\" �� �ֳ���? " + hs.contains("���ƿ�"));
	}

}
