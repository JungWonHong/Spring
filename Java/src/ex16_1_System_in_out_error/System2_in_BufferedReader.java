//System.in�� �̿��� Ű����κ��� ���ڸ� �Է¹޴� ���α׷�
package ex16_1_System_in_out_error;

import java.io.*;

public class System2_in_BufferedReader {

	public static void main(String[] args) {
		// SystemŬ������ in �ʵ带 ������ InputStreamReader ��ü�� �����մϴ�.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// String java.io.BufferedReader.readLine() throws IOException
		try {
			String str = reader.readLine();// Ű����κ��� �� ���� �Է¹���
			System.out.println("�Էµ� ���ڿ�: " + str);
		} catch (IOException e) {
			System.out.println("Ű���� �Է� ����");
		}
	}

}
