//�ؽ�Ʈ ������ �д� ���α׷�
//reader = new FileReader("poem.txt"); �� �ּ� ó�� �غ���
//NullPointerException ���� �߻�
package ex18_1_FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample3 {

	public static void main(String[] args) {
		//reader ������ 33���ο��� ����ϱ� ���ؼ� try�� ���� ����
		FileReader reader = null;
		try {
			reader = new FileReader("poem.txt");
			//reader = new FileReader("E:\\ȫ����\\workspace\\java\\src\\ex18_1_FileReader\\poem.txt");
			//reader = new FileReader("E:/ȫ����/workspace/Java/src/ex18_1_FileReader/poem.txt");
			while (true) {
				int data = reader.read(); // ���Ͽ� �ִ� ���� �ϳ��� �о �����Ѵ�.
				// 4����Ʈ ������ 2����Ʈ�� �о�´�.
				if (data == -1) // �� �̻� ���� �����Ͱ� ���� ���
					break;
				char ch = (char) data;
				System.out.print(ch);
			}
		} 
		catch (FileNotFoundException fe) {
			System.out.println("������ ã�� �� �����ϴ�.");
			// fe.printStackTrace();
		} 
		catch (IOException ie) {
			System.out.println("������ ���� �� �����ϴ�.");
		} 
		catch (NullPointerException ne) {// Exception - RuntimeException
			System.out.println("NullPointerException ���� �߻�");
		} 
		finally { // ������ �ݴ� ��ɹ��� ������ ������� ó���ϱ� ���� finally ��Ͽ�
			try {
				reader.close(); // ������ �ݴ� ��ɹ�
			} 
			catch (Exception e) { //close�޼ҵ尡 �߻��ϴ� ���� ó��
								  //IOException�� NullPointerException
			}
		}
	}

}
