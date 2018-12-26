package ex18_1_FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample6 {

	public static void main(String[] args) {
		FileReader reader = null;
		char arr[] = new char[64]; //파일에 있는 문자를 담을 char배열
		
		try{
			reader = new FileReader("1.txt");
			while(true){
				//Returns : the number of characters read
				int num = reader.read(arr, 5, 10);
				//입력 스트림으로 부터 10개의 문자만큼 읽고 arr[5]부터 0개의 문자를 저장합니다.
				/*
				  public int read(char[] cbuf, int offset, int length)
				    입력 스트림으로부터 length개의 문자만큼 읽고 cbuf[off]부터 length 개까지 저장
				    실제로 읽은 문자의 수가 length보다 작을 경우 읽은 수만큼 리턴합니다.
				  offset이 0이고 length가 배열의 길이이면 read(char[] cbuf)와 동일합니다.
				*/
				if(num == -1)
					break;
				
				System.out.print(arr);
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
