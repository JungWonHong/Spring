//��� ���迡 �ִ� �� ������ Exception�� ó���ϴ� try��
//ExceptionExample9_1�� catch�� ���� �� - ���� �߻�
//catch�� ���� ������ �θ� �ڽĺ��� �����ͼ� ���� �߻�
//FileNotFoundException -> IOException
package ex12_1_Exception;

import java.io.*;

public class ExceptionExample9_3 {

	public static void main(String[] args) {

		try {
			FileReader reader = new FileReader("some.txt");
			reader.close();
		} catch (IOException e) { // ������(FileNotFoundException�� ��ĳ���õż� ó����.
			System.err.println("����� ������ �߻��߽��ϴ�.");
		}
	}

}
