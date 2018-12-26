/*
 * java.lang.Object
 * 		java.io.OutputStream
 * 			java.io.FilterOutputStream
 * 				java.io.BufferedOutputStream
 * 
 * 버퍼를 이용하여 바이트 출력 스트림의 성능을 향상시키는 클래스로 다음과 같은 생성자를 갖고 있습니다.
 * 
 * 1. BufferedOutputStream(OutputStream out)
 *    size가 없는 경우 8192바이트 크기의 버퍼를 갖습니다.
 * 
 * 2. BufferedOutputStream(OutputStream out, int size)
 */
package ex18_6_Buffered;

import java.io.*;

public class BufferedOutputStreamExample1 {

	public static void main(String[] args) {
		BufferedOutputStream out = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream("output.txt"));// 파일을 연다.
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
