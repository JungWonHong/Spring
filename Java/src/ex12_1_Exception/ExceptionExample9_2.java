//상속 관계에 있는 두 종류의 Exception을 처리하는 try문
//ExceptionExample9_1의 catch문 변경 예 - 에러 발생
//catch문 예외 순서가 부모가 자식보다 먼저와서 에러 발생
//FileNotFoundException -> IOException
package ex12_1_Exception;

import java.io.*;

public class ExceptionExample9_2 {

	public static void main(String[] args) {

		try {
			FileReader reader = new FileReader("some.txt"); 
			reader.close();
		} catch (IOException e) { // IOException 처리
			System.err.println("입출력 에러가 발생했습니다.");
		}
		//이미 부모 IOException에서 자식 FileNotFoundException도
		//처리할 수 있기 때문에 이 부분이 필요없다.
		catch (FileNotFoundException e) { //It is already handled by the catch block for IOException
			System.err.println("파일을 찾을 수 없습니다.");
		}
	}

}
