//��� ���迡 �ִ� �� ������ Exception�� ó���ϴ� try��
//ExceptionExample9_1�� catch�� ���� �� - ���� �߻�
//catch�� ���� ������ �θ� �ڽĺ��� �����ͼ� ���� �߻�
//FileNotFoundException -> IOException
package ex12_1_Exception;

import java.io.*;

public class ExceptionExample9_2 {

	public static void main(String[] args) {

		try {
			FileReader reader = new FileReader("some.txt"); 
			reader.close();
		} catch (IOException e) { // IOException ó��
			System.err.println("����� ������ �߻��߽��ϴ�.");
		}
		//�̹� �θ� IOException���� �ڽ� FileNotFoundException��
		//ó���� �� �ֱ� ������ �� �κ��� �ʿ����.
		catch (FileNotFoundException e) { //It is already handled by the catch block for IOException
			System.err.println("������ ã�� �� �����ϴ�.");
		}
	}

}
