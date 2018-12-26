//한꺼번에 여러 문자를 읽는 read 메소드 예
//int java.io.Reader.read(char[] cbuf) throws IOException 형식의 read메소드 사용
package ex18_1_FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample5_2 {

	public static void main(String[] args) {
		FileReader reader = null;
		char arr[]=new char[64]; //파일에 있는 문자를 담을 char배열
		try{
			reader = new FileReader("거위의 꿈.txt");
			while (true) {
				int num = reader.read(arr);

				if (num == -1) //더 이상 읽을 문자가 없을 경우 -1을 리턴합니다.
					break;
				// 출력방법 1. arr의 0부터 num개 만큼 스트링으로 만든 후 출력
				System.out.print(new String(arr, 0, num));

				// 출력방법 2.
				/*for(int i=0;i<num;i++) 
					System.out.print(arr[i]);*/
			}
		}
		catch(FileNotFoundException fe){
			System.out.println("파일이 존재하지 않습니다.");
		}
		catch(IOException ie){
			System.out.println("파일을 읽을 수 없습니다.");
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
