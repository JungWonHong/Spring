package ex4_11_rel_logic_op;

public class EqualityExample2 {

	public static void main(String[] args) {
		// 참조형 - s1, s2는 메모리 주소, new는 연산자,
		// new String("자바"); 에서 String()은 생성자
		// String은 라이브러리로 제공되는 클래스로 JRE에 있습니다.
		String s1 = "자바";
		String s2 = new String("자바");
		System.out.println("s1=" + s1 + " s2=" + s2);
		// 출력문에 참조형이 쓰이면 주소값이 아닌 내용물이 출력이 된다.

		// 주소값 같은지 비교
		if (s1 == s2) {
			System.out.println("같은 주소");
		} else {
			System.out.println("다른 주소");
		}

		// 내용값 같은지 비교
		if (s1.equals(s2)) {
			System.out.println("같은 값");
		} else {
			System.out.println("다른 값");
		}

	}

}
