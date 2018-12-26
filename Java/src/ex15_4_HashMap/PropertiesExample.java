/*
 * Properties는 HashMap의 구버전인 Hashtable을 상속 받아 구현한 것입니다.
 * Hashtable은 키와 값을 (Object, Object)의 형태로 저장하는데 비해
 * Properties는 (String, String)의 형태로 저장하는 보다 단순화된 컬렉션 클래스입니다.
 * 사용예)
 * 애플리케이션의 환경설정과 관련된 속성을 저장하는데 사용되며 데이터를 파일로 부터 읽고
 * 쓰는 편리한 기능을 제공합니다.
 */
package ex15_4_HashMap;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) {
		Properties prop = new Properties();

		// prop에 키와 값을 저장합니다.
		// setProperty메서드는 Hashtable의 put메서드를 호출합니다.
		prop.setProperty("사과", "Apple");
		prop.setProperty("딸기", "StrawBerry");
		prop.setProperty("포도", "Grapes");

		// prop에 저장된 요소들을 Enumeration을 이용해서 출력합니다.
		// Properties는 컬렉션 프레임워크 이전의 구버전이라 Enumeration을 사용합니다.
		Enumeration e = prop.propertyNames();

		while (e.hasMoreElements()) {
			String element = (String) e.nextElement();
			System.out.println(element + "=" + prop.getProperty(element));
		}

		// prop에 저장된 요소들을 출력합니다.
		System.out.println(prop);
	}

}
