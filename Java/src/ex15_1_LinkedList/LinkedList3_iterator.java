//LinkedList에 데이터를 삽입/수정/삭제의 예
package ex15_1_LinkedList;

import java.util.LinkedList;

public class LinkedList3_iterator {

	public static void main(String[] args) {
		// LinkedList 객체를 생성
		LinkedList<String> list = new LinkedList<String>();
		list.add("포도");
		list.add("딸기");
		list.add("복숭아");
		list.add(2, "키위");
		
		list.set(0, "오렌지");

		list.remove(1);
		list.remove("키위");
		
		int num = list.size();
		
		//get메소드는 데이터를 읽을 때 첫번째 데이터부터 링크를 따라가면서 순서대로 찾는다
		//예) get(2)의 경우 index 0부터 1,2의 경로를 거친다.
		//예) get(4)의 경우 index 0부터 1,2,3,4의 경로를 거친다.
		//앞서 찾은 데이터의 위치를 기억하고 있다가 다음번에 바로 그 다음 데이터를 읽는 방법은 없을까?
		//iterator메소드 이용하면 된다. LinkedExample3.java 참고
		for (int cnt = 0; cnt < num; cnt++) {
			String str = list.get(cnt);
			System.out.println(str);
		}

	}

}
