package ex15_1_ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayList2_2_print_error {

	public static void main(String[] args) {
		List list = new ArrayList(); // 업캐스팅(상속해준 메소드만 사용가능)

		// ArrayList list = new ArrayList();

		// 자료 추가
		list.add("하나");
		list.add(2);
		list.add(false);
		list.add(3.42);
		list.add("넷");
		list.add("five");
		list.add('A');
		
		//출력방법 1. - 해당 객체명으로 출력하는 방법
		System.out.println("===객체명으로 출력하기===");
		System.out.println(list);
		
		//출력방법 2. - get()메소드 이용법
		System.out.println("===get()메소드 이용법==");
		for(int i=0;i<list.size();i++){
			System.out.println(i + " 번째 요소 = " + list.get(i));
		}
		System.out.println("=================");
		
		for(int i=0;i<list.size();i++){
			Object s = list.get(i); // get()메소드의 반환형은 Object형
			System.out.println(s);
		}
		
		//출력방법 3. - Iterator 인터페이스 사용 : 반복자
		System.out.println("===Iterator 인터페이스 사용===");
		Iterator elements = list.iterator();
		while(elements.hasNext()){//hasNext() : 읽어올 요소가 있는 지 확인
			System.out.println(elements.next());
			//next() 메소드를 이용해서 차례대로 한개씩 데이터 가져옵니다.
		}
		
		//출력방법 4. - for문 사용
		System.out.println("====향상된 for문 사용=====");
		for(Object a : list)
			System.out.println(a);
		
		System.out.println("======");
		for(int i=0;i<list.size();i++){
			//인덱스값에 따라 저장되어있는 자료형이 다르기 때문에 에러발생한다.
			String s1 = (String)(list.get(i)); //java.lang.Integer cannot be cast to java.lang.String
			System.out.println(s1);
		}
	}

}
