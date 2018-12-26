package ex18_3_FileInputStream_FileOutputStream;

import java.io.*;

public class FileOutputStreamExample {

	public static void main(String[] args) {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("output1.dat");// 파일을 연다.
			byte arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
					      10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };

			// 파일을 반복해서 byte타입 데이터를 쓴다.
			for (int cnt = 0; cnt < arr.length; cnt++)
				out.write(arr[cnt]);
		} 
		catch (IOException ioe) {
			System.out.println("파일로 출력할 수 없습니다.");
		} 
		finally {
			try {
				out.close(); // 파일을 닫습니다.
				System.out.println("파일을 저장했습니다.");
			} 
			catch (Exception e) {

			}
		}

	}

}
