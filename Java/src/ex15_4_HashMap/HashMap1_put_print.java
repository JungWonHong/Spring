/*
 * HashMap Generic 사용하지 않은 예
 *  Map 인터페이스
 *   - HashMap, HashTable (상속받는 클래스)
 *   	1. 여러가지 자료형의 Data를 모두 저장할 수 있습니다.
 *   		ex) int, double, char, boolean, String etc
 *   	2. Data를 저장할 때  Key, Value 를 동시에 저장합니다.
 *   	   Key값은 중복되지 않습니다.
 *   	3. 단 하나의 null key, 여러개의 null 값 허용
 *   
 *   HashMap과 HashSet 등에 사용되는 hashing에 대한 설명
 *   - 해싱이란 해시함수를 이용해서 데이터를 해시 테이블에 저장하고 검색하는 기법을 말합니다.
 *   - 해시 테이블이란 여러 개의 통(bucket)을 만들어 두고 키 값을 이용하여
 *     데이터를 넣을 통 번호를 계산하는 데이터 구조입니다.
 *   
 *   - 해시 함수는 키 값을 받아 해쉬 테이블의 인덱스 키 값을 구하는 함수입니다.
 *   - 해시 함수는 데이터가 저장되어 있는 곳을 알려 주기 때문에 다량의 데이터 중에서도
 *     원하는 데이터를 빠르게 찾을 수 있습니다.
 *   
 *   - 해싱을 구현한 컬렉션 클래스로는 HashSet, HashMap, Hashtable 등이 있습니다.
 *   - Object 클래스에 정의된 hashCode()를 해시함수로 사용합니다.
 *   
 *   - HashMap에 저장된 데이터를 찾는 과정
 *   	1. 검색하고자 하는 값의 키로 해시함수를 호출합니다.
 *   	2. 해시함수의 계산결과인 해시코드를 이용해서 해당 값이 저장되어 있는 linked list를 찾습니다.
 *   	3. linked list에서 검색한 키와 일치하는 데이터를 찾습니다.
 */
package ex15_4_HashMap;

import java.util.HashMap;

public class HashMap1_put_print {

	public static void main(String[] args) {
		// HashMap 객체 생성 방법 두 가지
		// Map hm = new HashMap(); //방법1. 업캐스팅
		HashMap hm = new HashMap();// 방법2. 구현 클래스를 통한 객체 생성

		// Key와 Value 쌍을 삽입
		// Map의 메소드는 put을 이용해(Key, Value) 쌍으로 자료 저장한다.
		hm.put("woman", "재미있니");
		hm.put("man", "좋은 하루");
		hm.put("age", new Integer(10));// hm.put("age", 10);
		hm.put("city", "seoul");

		// HashMap에 있는 객체들을 출력
		// 출력방법1. 해당 객체명으로 출력
		System.out.println(hm);
		// {woman=재미있니, city=seoul, man=좋은하루, age=10}

		// 출력 방법2. Key 값만 출력
		System.out.println(hm.keySet());// [woman, city, man, age]

		// 출력방법3. Value 값만 출력
		System.out.println(hm.values());// [재미있니, seoul, 좋은하루, 10]

		// 출력방법4.
		// get(Key) : Key에 해당하는 Value를 출력 - 가장 많이 사용
		System.out.println(hm.get("woman"));// 재미있니
		System.out.println(hm.get("city"));// seoul
	}

}
