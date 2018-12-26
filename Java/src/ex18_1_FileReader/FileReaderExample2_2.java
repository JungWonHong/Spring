package ex18_1_FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample2_2 {

	public static void main(String[] args) {
		// 1. 파일을 연다
		try {
			FileReader reader = new FileReader("poem.txt");
			// poem.txt의 경로는 E:/홍정원/workspace/Java/poem.txt
			// FileReader reader
			// new
			// FileReader("E:\\홍정원\\workspace\\Java\\src\\ex18_1_FileReader\\poem.txt");

			 /*
	          * 문자 '\'는 다른 문자와 더해져서 특수한 기능을 수행하는 문자로 자기 자신을 나타내고자
	          * 할 때는 두개를 사용해야한다.
	          * 하나만 사용하면 에러가 발생한다.
	          * \n'은 두개의 문자로 이루어져 있지만 하나의 문자로 취급된다.
	          * '\n'은 커서를 다음 줄 맨 앞으로 옮겨주는 역할을 하는 문자이다.
	          * 이와 같은 문자들을 Escape 문자라고 한다.
	          * 
	          
	          ===== Escape 문자 ====
	          \n -> 개행 문자
	          \t -> tab키를 누른 것 처음 여러칸 띄움
	          \\ -> '\'를 나타낸다.
	          \" -> 큰따옴표(")를 나타낸다.
	          
	          */
			while (true) {
				// int java.io.InputStreamReader.read() throws IOException
				// read 메소드 IOException 발생
				// 예외 처리 해주어야 합니다.
				int data = reader.read(); // 파일에 있는 문자 하나를 읽어서 리턴하는 메소드
				if (data == -1) // 더 이상 읽을 데이터가 없는 경우
					break;
				char ch = (char) data;
				System.out.print(ch);

			}

			// void java.io.InputStreamReader.close() throws IOException

			reader.close();
			// 3. 파일을 닫는다.
		} catch (FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException ioe) {
			System.out.println("파일을 읽을 수 없습니다.");
		}

	}

}
