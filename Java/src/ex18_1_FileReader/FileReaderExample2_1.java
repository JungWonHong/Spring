package ex18_1_FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample2_1 {

	public static void main(String[] args) {
		try {
			// 1. 파일을 연다
			FileReader reader = new FileReader("poem.txt");
			// 상대경로 지정 - E:/홍정원/workspace/Java/poem.txt 의미
			
			// 절대경로 지정
			// FileReader reader =
			//   new FileReader("E:/홍정원/workspace/Java/src/ex18_1_FileReader/poem.txt");
			
			// 2. 파일을 읽어서 처리하는 부분
			while (true) {
				int data = reader.read(); // 파일에 있는 문자 하나를 읽어서 리턴한다.
				//4바이트 공간에 2바이트씩 읽어온다.
				if (data == -1) // 더 이상 읽을 데이터가 없는 경우
					break;
				char ch = (char) data;
				System.out.print(ch);
			}

			// 3. 파일을 닫는다.
			reader.close();
		} catch (FileNotFoundException fe) {
			System.out.println("파일을 찾을 수 없습니다.");
			//fe.printStackTrace();
		} catch (IOException ie) {
			System.out.println("파일을 읽을 수 없습니다.");
		}
	}

}
