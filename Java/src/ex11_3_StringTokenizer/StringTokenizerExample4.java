//StringTokenizer를 이용해서 구획문자를 토큰으로 추출하는 프로그램
package ex11_3_StringTokenizer;

import java.util.StringTokenizer;

public class StringTokenizerExample4 {

	public static void main(String[] args) {
		// true : 구획문자도 토큰으로 추출하도록 만드는 인자
		StringTokenizer stok = 
				new StringTokenizer("사과=10|초콜렛=3|샴페인=1", "=|", true);

		while (stok.hasMoreTokens()) {
			String str = stok.nextToken();
			System.out.println(str + "\t");
		}

	}

}
