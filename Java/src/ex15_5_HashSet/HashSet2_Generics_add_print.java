package ex15_5_HashSet;
import java.util.*;
public class HashSet2_Generics_add_print {

	public static void main(String[] args) {
		//HashSet ��ü ����
		HashSet<String> set = new HashSet<String>();
		
		//������ ����
		set.add("�ڹ�");
		set.add("īǪġ��");
		set.add("����������");
		set.add("�ڹ�");
		System.out.println("����� �������� �� = " + set.size());
		
		//set ��ü�� �����ϰ� �ִ� ������ ��ü ���
		System.out.println(set);
		
		//iterator(): set�ȿ� �ִ� �����͸� ��� �����ɴϴ�.
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			String str = iterator.next();
			System.out.println(str);
		}
	}
}