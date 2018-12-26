/*
 * java.lang.Object
 * 		java.io.OutputStream
 * 			java.io.FilterOutputStream
 * 				java.io.BufferedOutputStream
 * 
 * ���۸� �̿��Ͽ� ����Ʈ ��� ��Ʈ���� ������ ����Ű�� Ŭ������ ������ ���� �����ڸ� ���� �ֽ��ϴ�.
 * 
 * 1. BufferedOutputStream(OutputStream out)
 *    size�� ���� ��� 8192����Ʈ ũ���� ���۸� �����ϴ�.
 * 
 * 2. BufferedOutputStream(OutputStream out, int size)
 */
package ex18_6_Buffered;

import java.io.*;

public class BufferedOutputStreamExample1 {

	public static void main(String[] args) {
		BufferedOutputStream out = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream("output.txt"));// ������ ����.
			byte arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
					      10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };

			// ������ �ݺ��ؼ� byteŸ�� �����͸� ����.
			for (int cnt = 0; cnt < arr.length; cnt++)
				out.write(arr[cnt]);
		} 
		catch (IOException ioe) {
			System.out.println("���Ϸ� ����� �� �����ϴ�.");
		} 
		finally {
			try {
				out.close(); // ������ �ݽ��ϴ�.
				System.out.println("������ �����߽��ϴ�.");
			} 
			catch (Exception e) {

			}
		}

	}

}
