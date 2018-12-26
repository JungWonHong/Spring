//표준 출력과 표준 에러 출력을 모두 하는 프로그램
//err필드 사용하는 예
/*
 * err : 표준 에러 출력 필드 - 여러 메시지를 모니터로 보내는 출력
 * out필드는 일반 데이터 출력 용도로 err필드는 에러메시지 출력 용도로 사용
 * 두 필드를 사용해서 결과가 뒤섞여 나옵니다.
 */
package ex16_1_System_in_out_error;

public class System3_in_out_err {

	public static void main(String[] args) {
		int arr1[] = { 7, 82, 99, 100, -27, 0, 42, -35, 60, 72 };
		int arr2[] = { 7, 0, 3, 0, -1, 2, 11, 5, 0, 9 };
		for (int cnt = 0; cnt < arr1.length; cnt++) {
			try {
				int result = arr1[cnt] / arr2[cnt];
				// 나눗셈의 정상적인 결과를 out 필드를 통해 출력합니다.
				System.out.printf("%d / %d = %d %n", arr1[cnt], arr2[cnt], result);
			} catch (java.lang.ArithmeticException e) {
				// 나눗셈 중 발생한 에러에 대한 메시지를 err필드를 통해 출력합니다.
				System.err.println("잘못된 연산입니다. (index=" + cnt + ")");
			}
		}
		System.out.println("하하");
	}

}
