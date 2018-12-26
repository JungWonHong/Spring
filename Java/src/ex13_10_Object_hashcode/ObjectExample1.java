/*
 * hashCode의 일반 규약은 다음과 같습니다.
 * Java 애플리케이션의 실행 중에 동일한 객체에서 두 번 이상 호출 될 때마다
 * hashCode 메소드는 객체에 대한 equals 비교에서
 * 사용 된 정보가 수정되지 않으면 동일한 정수를 일관되게 반환해야합니다.
 * 이 정수는 한 응용 프로그램 실행에서 같은 응용 프로그램의 다른 실행으로
 * 일관성을 유지할 필요가 없습니다.
 * equals(Object) 메소드에 따라 두 객체가 같으면 두 객체 각각에 대해
 * hashCode 메소드를 호출하면 같은 정수 결과를 생성해야 합니다.
 */
package ex13_10_Object_hashcode;

public class ObjectExample1 {

	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		//String 클래스는 문자열의 내용이 같으면 동일한 해시코드를 반환하도록 hashCode메서드가 오버라이딩되어 있기 때문에
		//문자열의 내용이 같은 str1과 str2에 대해 hashCode()를 호출하면 항상 동일한 해시코드값을 얻습니다.
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());

	}

}
