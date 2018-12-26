//StringTokenizer의 기능과 유사한 String의 split메소드 사용법
package ex11_4;

import java.util.StringTokenizer;

public class StringTokenizerExample5 {

	public static void main(String[] args) {
		String post = "123-456";
		String post1 = "123-456-789-012";
		StringTokenizer str = new StringTokenizer(post, "-");
		StringTokenizer str1 = new StringTokenizer(post1, "-");

		System.out.println("***123-456 토큰 분리***");
		System.out.println("우편번호 앞자리는 " + str.nextToken());
		System.out.println("우편번호 뒷자리는 " + str.nextToken());

		System.out.println("***123-456-789-012 토큰 분리***");
		while (str1.hasMoreTokens()) {
			System.out.println(str1.nextToken());
		}

		System.out.println("***String의 split 메소드 이용 : 123-456 토큰 분리***");
		String[] st = post.split("-"); //분리된걸 배열에 저장.
		// 배열의 갯수가 가변적일때 length 속성을 이용한다.
		for (int i = 0; i < st.length; i++)
			System.out.println(st[i]);

	}

}
