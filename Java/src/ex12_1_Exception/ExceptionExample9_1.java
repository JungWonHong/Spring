//상속 관계에 있는 두 종류의 Exception을 처리하는 try~catch문
//catch문 예외 처리 순서가 자식에서 부모 순으로 작성합니다.
//FileNotFoundException -> IOException
//이 중 발생한 예외의 종류와 일치하는 단 한 개의 catch블럭만 수행됩니다.
package ex12_1_Exception;
//import.java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionExample9_1 {

	public static void main(String[] args) {

		try {
			FileReader reader = new FileReader("some.txt"); //Unhandled exception type FileNotFoundException
			reader.close(); //Unhandled exception type IOException
		} catch (FileNotFoundException e) { //FileNotFoundException 처리
			System.err.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) { //IOException 처리
			System.err.println("입출력 에러가 발생했습니다.");
		}
	}

}
