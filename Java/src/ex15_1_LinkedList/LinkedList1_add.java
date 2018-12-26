//LinkedList »ç¿ë ¿¹
package ex15_1_LinkedList;

import java.util.LinkedList;

public class LinkedList1_add {

	public static void main(String[] args) {
		// LinkedList °´Ã¼¸¦ »ý¼º
		LinkedList<String> list = new LinkedList<String>();
		list.add("Æ÷µµ");
		list.add("µþ±â");
		list.add("º¹¼þ¾Æ");

		int num = list.size();
		for (int cnt = 0; cnt < num; cnt++) {
			String str = list.get(cnt);
			System.out.println(str);
		}

	}

}
