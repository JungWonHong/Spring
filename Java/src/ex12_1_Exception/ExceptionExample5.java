//getMessage 메소드의 사용 예를 보여주는 프로그램
package ex12_1_Exception;

public class ExceptionExample5 {

	public static void main(String[] args) {
		int num1 = 2, num2 = 0;
		try {
			int result = num1 / num2;
			System.out.println(result);
		} catch (ArithmeticException e) {
			// ArithmeticException객체에 있는 에러 메시지를 가져옵니다.
			String str = e.getMessage();
			System.err.println(str);
		}

	}
}
