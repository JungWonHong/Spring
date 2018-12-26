/*
 * Set 인터페이스
 * 	- HashSet (상속받는 클래스)
 * 	  TreeSet은 정렬됨
 * 1. 여러가지 자료형(기본자료형, 참조형 모두)의 Data를 모두 저장할 수 있다.
 * 	  ex) int, double, char, boolean, String etc
 * 2. 순서 없이 입, 출력 한다.
 * 3. 중복된 Data를 저장하지 못한다.
 * 	    예)로또 번호6개를 중복 되지 않게 하는 프로그램시 이용
 */
package ex15_5_HashSet;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class HashSet1_add_remove {

	public static void main(String[] args) {
		//HashSet 클래스의 객체 생성
		Set hs = new HashSet();
		//HashSet hs = new HashSet();

		//hs객체에 데이터 객체 보관
		hs.add("좋아요");	//업캐스팅 has.add(new String("좋아요")
		hs.add("즐거운 하루"); //업캐스팅(매개변수가 Object형이기 때문에)
		
		//Date d = new Date();
		//hs.add(d);
		hs.add(new Date()); //위 두문장과 같은 의미
		
		//hs 객체가 보관하고 있는 데이터 객체 출력
		System.out.println("hs의 내용 : " + hs);
		
		//"즐거운 하루" 데이터 객체를 hs객체에서 제거
		hs.remove("즐거운 하루");
		System.out.println("hs의 내용 : " + hs);
		
		System.out.println("\"좋아요\" 가 있나요? " + hs.contains("좋아요"));
	}

}
