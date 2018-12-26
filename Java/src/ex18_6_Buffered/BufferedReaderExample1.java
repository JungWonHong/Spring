//한꺼번에 여러 문자를 읽는 read 메소드 예
package ex18_6_Buffered;

import java.io.*;

public class BufferedReaderExample1 {

	public static void main(String[] args) {
		BufferedReader reader = null;
		char arr[] = new char[64]; //파일에 있는 문자를 담을 char배열
		try {
			reader = new BufferedReader(new FileReader("output.txt"));
			int num = reader.read(arr);
			System.out.println(new String(arr, 0, num));
		} catch (FileNotFoundException fe) {
			System.out.println("파일을 찾을 수 없습니다.");
			//fe.printStackTrace();
		} catch (IOException ie) {
			System.out.println("파일을 읽을 수 없습니다.");
		} catch (NullPointerException ne){
			System.out.println("NullPointerException 발생");
		}
		finally{
			try{
				reader.close();
			}
			catch(Exception e){
				
			}
		}
	}

}
