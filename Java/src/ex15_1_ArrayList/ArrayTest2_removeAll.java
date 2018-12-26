package ex15_1_ArrayList;

import java.util.ArrayList;

public class ArrayTest2_removeAll {

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>(10);
		list1.add("봄");
		list1.add("여름");
		
		ArrayList<String> list2 = new ArrayList<String>(10);
		list2.add("봄");
		list2.add("가을");
		list2.add("겨울");
		
		list2.retainAll(list1); //list2에서 list1과 같은 데이터만 남겨라
		
		System.out.println(list1);
		System.out.println(list2);
	}

}
