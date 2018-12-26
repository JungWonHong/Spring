//상속 관계에 있는 두 종류의 Exception을 처리하는 try문
//ExceptionExample9_1의 catch문 변경 예 - 에러 발생
//catch문 예외 순서가 부모가 자식보다 먼저와서 에러 발생
//FileNotFoundException -> IOException
package ex12_1_Exception;

import java.io.*;

public class ExceptionExample9_3 {

	public static void main(String[] args) {

		try {
			FileReader reader = new FileReader("some.txt");
			reader.close();
		} catch (IOException e) { // 다형성(FileNotFoundException이 업캐스팅돼서 처리됨.
			System.err.println("입출력 에러가 발생했습니다.");
		}
	}

}
