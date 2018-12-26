package ex18_2_FileWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample2_1 {

	public static void main(String[] args) {
		try {
			// 1. ������ ����
			//FileReader reader = new FileReader("poem.txt");
			// ����� ���� - E:/ȫ����/workspace/Java/poem.txt �ǹ�
			FileReader reader = new FileReader("output.txt");
			
			// ������ ����
			// FileReader reader =
			//   new FileReader("E:/ȫ����/workspace/Java/src/ex18_1_FileReader/poem.txt");
			
			// 2. ������ �о ó���ϴ� �κ�
			while (true) {
				int data = reader.read(); // ���Ͽ� �ִ� ���� �ϳ��� �о �����Ѵ�.
				//4����Ʈ ������ 2����Ʈ�� �о�´�.
				if (data == -1) // �� �̻� ���� �����Ͱ� ���� ���
					break;
				char ch = (char) data;
				System.out.print(ch);
			}

			// 3. ������ �ݴ´�.
			reader.close();
		} catch (FileNotFoundException fe) {
			System.out.println("������ ã�� �� �����ϴ�.");
			//fe.printStackTrace();
		} catch (IOException ie) {
			System.out.println("������ ���� �� �����ϴ�.");
		}
	}

}
