//텍스트 파일을 읽는 프로그램
//reader = new FileReader("poem.txt"); 을 주석 처리 해보기
//NullPointerException 예외 발생
package ex18_1_FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample3 {

	public static void main(String[] args) {
		//reader 변수를 33라인에서 사용하기 위해서 try문 전에 선언
		FileReader reader = null;
		try {
			reader = new FileReader("poem.txt");
			//reader = new FileReader("E:\\홍정원\\workspace\\java\\src\\ex18_1_FileReader\\poem.txt");
			//reader = new FileReader("E:/홍정원/workspace/Java/src/ex18_1_FileReader/poem.txt");
			while (true) {
				int data = reader.read(); // 파일에 있는 문자 하나를 읽어서 리턴한다.
				// 4바이트 공간에 2바이트씩 읽어온다.
				if (data == -1) // 더 이상 읽을 데이터가 없는 경우
					break;
				char ch = (char) data;
				System.out.print(ch);
			}
		} 
		catch (FileNotFoundException fe) {
			System.out.println("파일을 찾을 수 없습니다.");
			// fe.printStackTrace();
		} 
		catch (IOException ie) {
			System.out.println("파일을 읽을 수 없습니다.");
		} 
		catch (NullPointerException ne) {// Exception - RuntimeException
			System.out.println("NullPointerException 예외 발생");
		} 
		finally { // 파일을 닫는 명령문을 에러와 상관없이 처리하기 위해 finally 블록에
			try {
				reader.close(); // 파일을 닫는 명령문
			} 
			catch (Exception e) { //close메소드가 발생하는 예외 처리
								  //IOException과 NullPointerException
			}
		}
	}

}
