//checked exception을 던지는 메소드
//컴파일 에러 발생 - 메소드를 호출한 곳에서 try-catch문이 있지만 에러 발생
//throw new Exception을 발생시킨 곳에서 throws 절 명시해야만 함
package ex12_1_Exception;

public class ExceptionExample3_1 {

	public static void main(String[] args) {
		try {
			int result = add(1, -2);
			System.out.println(result);
		} catch (Exception e) {
			System.err.println("에러 발생");
		}

	}

	static int add(int a, int b) {
		int result = a + b;
		if (result < 0)
			throw new Exception("에러 발생");
		return result;
	}
}
