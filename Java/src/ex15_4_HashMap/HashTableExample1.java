/*
 * Hashtable - 동기화 관련 솔루션으로 사용(잘 사용 안함)
 * null값을 Key값으로 허용하지 않습니다.
 * 업캐스팅한 방법으로 Map을 생성하면 상속해준 메소드만 사용할 수 있어
 * 참조 가능한 영역이 축소됩니다.
 * ht.keys()에 접근을 못합니다.
 */
package ex15_4_HashMap;

import java.util.*;

public class HashTableExample1 {

	public static void main(String[] args) {
		// Map ht = new Hashtable(); //업캐스팅(부모에게 상속된 메소드만 사용할 수 있습니다.)
		// 업캐스팅으로 생성하면 자식(Hashtable)에 있는 keys()메소드를 사용할 수 없어
		// 에러 발생합니다.

		Hashtable ht = new Hashtable();

		// 해쉬 테이블에 키/데이터를 입력합니다.
		ht.put("딸기", "StrawBerry");
		ht.put("사과", "Apple");
		ht.put("포도", "Grapes");
		ht.put("메론", 10);
		// ht.put(null, 10); //해시테이블 키값에는 null이 쓰일수 없다.

		// 해쉬 테이블의 값을 키를 이용하여 얻습니다.
		Object obj = ht.get("포도"); // 해당 키를 아는 경우 get메소드로 구해옵니다.
									// 반환형은 Object형입니다.
									// 하지만 String형으로 많이 사용합니다.
									// 키를 알 경우 사용하는 방법

		System.out.println("포도의 값-> " + obj);
		System.out.println("포도의 값-> " + obj.toString());

		String Val = (String) ht.get("포도"); // 다운캐스팅
		// String Val = (String)ht.get("메론"); //에러 : 정수형을 문자형으로 바꿀수 없음

		if (Val != null) {
			System.out.println("포도-> " + Val);
		}

		Enumeration Enum = ht.keys();
		// 업캐스팅으로 생성하면 자식(Hashtable)에 있는 keys()메소드를 사용할 수 없어
		// 에러 발생합니다.
		// 해결법 : Hashtable ht = new Hashtable();로 객체 생성
		// 모든 키를 열거형으로 가져오는 메소드입니다.

		// 키에 어떤 것이 있는지 모를 때, 갯수를 모를 때 사용법
		while (Enum.hasMoreElements()) {
			Object k = Enum.nextElement(); // 키를 구해온다.
			Object v = ht.get(k); // 키에 해당하는 값을 가져온다.
			System.out.println(k + " : " + v);
		}
	}

}
