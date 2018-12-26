//System.in을 이용한 키보드로부터 문자를 입력받는 프로그램
package ex16_1_System_in_out_error;

import java.io.*;

public class System1_in_InputStreamReader {

	public static void main(String[] args) {
		// System클래스의 in 필드를 가지고 InputStreamReader 객체를 생성합니다.
		InputStreamReader reader = new InputStreamReader(System.in); //System.in은 반환형이 InputStream

		// 키보드로부터 한 글자씩 입력 받아서 출력하는 일을 마침표(.)가 입력될 때까지 반복
		try {
			while (true) {
				char ch = (char) reader.read(); // 한글자씩 입력 받음
				System.out.println("입력된 문자: " + ch);
				if (ch == '.')
					break;
			}
		} catch (IOException e) {
			System.out.println("키보드 입력 에러");
		}

	}

}
