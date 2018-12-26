//System.in을 이용한 키보드로부터 문자를 입력받는 프로그램
package ex16_1_System_in_out_error;

import java.io.*;

public class System2_in_BufferedReader {

	public static void main(String[] args) {
		// System클래스의 in 필드를 가지고 InputStreamReader 객체를 생성합니다.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// String java.io.BufferedReader.readLine() throws IOException
		try {
			String str = reader.readLine();// 키보드로부터 한 줄을 입력받음
			System.out.println("입력된 문자열: " + str);
		} catch (IOException e) {
			System.out.println("키보드 입력 에러");
		}
	}

}
