package ex6_3_method;

public class Method_Test01 {

	// 메소드 정의

	static void sum(int n) { // n은 지역변수로 stack에 저장되어 있다.

		int sum = 0;

		for (int i = 0; i <= n; i++) {
			sum += i;
		}

		System.out.println("1 ~ " + n + "까지의 합: " + sum);

	}

	public static void main(String[] args) {

		sum(5); // 메소드 호출
		sum(10); // 메소드 호출
		sum(100); // 메소드 호출
	}

}
