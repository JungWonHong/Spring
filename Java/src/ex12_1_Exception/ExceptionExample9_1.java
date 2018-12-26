//��� ���迡 �ִ� �� ������ Exception�� ó���ϴ� try~catch��
//catch�� ���� ó�� ������ �ڽĿ��� �θ� ������ �ۼ��մϴ�.
//FileNotFoundException -> IOException
//�� �� �߻��� ������ ������ ��ġ�ϴ� �� �� ���� catch���� ����˴ϴ�.
package ex12_1_Exception;
//import.java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionExample9_1 {

	public static void main(String[] args) {

		try {
			FileReader reader = new FileReader("some.txt"); //Unhandled exception type FileNotFoundException
			reader.close(); //Unhandled exception type IOException
		} catch (FileNotFoundException e) { //FileNotFoundException ó��
			System.err.println("������ ã�� �� �����ϴ�.");
		} catch (IOException e) { //IOException ó��
			System.err.println("����� ������ �߻��߽��ϴ�.");
		}
	}

}
