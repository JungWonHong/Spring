//getMessage 메소드의 사용 예를 보여주는 프로그램
package ex12_1_Exception;

public class ExceptionExample6 {

	public static void main(String[] args) {
		int num1 = 2, num2 = 3;
		try {
			int result = num1 - num2;
			// Exception 객체를 생성합니다.
			if (result < 0)
				throw new Exception("잘못된 결과입니다.");
			System.out.println(result);
		} catch (Exception e) {
			// Exception 객체에 있는 에러 메시지를 가져옵니다.
			String str = e.getMessage();
			System.err.println(str);
		}
	}
}
