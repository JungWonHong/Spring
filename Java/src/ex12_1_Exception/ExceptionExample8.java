//�ͼ��� �Ķ������ �������� �����ִ� ��
package ex12_1_Exception;

import java.io.FileReader;

public class ExceptionExample8 {

	public static void main(String[] args) {

		FileReader reader = new FileReader("some.txt");
		reader.close();
		
	}

}
