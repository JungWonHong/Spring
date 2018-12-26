package ex9_02_null;

//레퍼런스 변수를 null 참조값과 비교해서 처리하는 프로그램
public class RefTypeExample5 {

	public static void main(String[] args) {
		Point obj = null;
		if (obj == null) { // null 값과 비교시
			System.out.println("obj 변수가 가리키는 객체가 없습니다.");
			return;
		} else {
			System.out.println("obj 변수가 가리키는 객체가 있습니다.");
		}

	}

}
