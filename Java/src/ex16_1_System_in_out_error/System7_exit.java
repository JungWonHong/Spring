//exit 메소드의 사용 예
//exit(0) : 정상 종료
//exit(0이외의 값) : 비정상 종료
//다른 프로그램에 의해 자바 프로그램이 호출되었을 경우 그 프로그램에 의해 사용될 수 있기 때문에
//프로그램이 정상 종료하면 인자값을 0으로 넘기고
//프로그램이 비정상으로 종료하면 인자값을 1로 넘긴다.
package ex16_1_System_in_out_error;

public class System7_exit {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("정수 두 개를 입력하세요");
			System.exit(1);
		}
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			int sum = num1 + num2;
			System.out.println("sum = " + sum);
			System.exit(0);
		} catch (NumberFormatException e) {
			System.err.println("잘못된 숫자입니다.");
			System.exit(-1);
		}
	}

}
