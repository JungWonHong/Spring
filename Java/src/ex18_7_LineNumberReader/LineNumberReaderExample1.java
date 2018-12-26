//텍스트의 각 행에 번호를 매기면서 읽는 클래스
//LineNumberWriter는 없음
package ex18_7_LineNumberReader;

import java.io.*;

public class LineNumberReaderExample1 {

	public static void main(String[] args) {
		LineNumberReader reader = null;
		try {
			// 파일을 엽니다.
			reader = new LineNumberReader(new FileReader("poem.txt"));

			// 파일로 부터 한 행씩 읽어서 행 번호와 함께 출력합니다.
			while (true) {
				String str = reader.readLine();// 파일로 부터 한 행씩 읽어온다
				if (str == null)
					break;
				// 읽은 행 번호를 리턴하는 메소드 : getLineNumber()
				int lineNo = reader.getLineNumber();
				System.out.println(lineNo + ": " + str);
			}
		} catch (FileNotFoundException fe) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException ie) {
			System.out.println("파일을 읽을 수 없습니다.");
		} finally {
			try {
				reader.close();
			} catch (Exception e) {

			}
		}

	}

}
