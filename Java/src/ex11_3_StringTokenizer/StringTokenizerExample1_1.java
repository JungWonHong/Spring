//StringTokenizer를 이용해서 문자열로부터 토큰을 분리하는 프로그램
//공백 문자를 기준으로 토큰을 구분합니다.
package ex11_3_StringTokenizer;

import java.util.StringTokenizer; //java.util은 java.lang처럼 기본패키지가 아니므로 import해줘야합니다.

public class StringTokenizerExample1_1 {

	public static void main(String[] args) {
		StringTokenizer stok = new StringTokenizer("사과 배 복숭아");

		String s1 = stok.nextToken();
		System.out.println(s1);

		String s2 = stok.nextToken();
		System.out.println(s2);

		String s3 = stok.nextToken();
		System.out.println(s3);

		// 런타임 에러 발생 - 추출할 토큰이 더 이상 없음
		String s4 = stok.nextToken();
		System.out.println(s4);
		System.out.println("=============================");
	}

}
