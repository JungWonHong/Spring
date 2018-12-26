package ex18_1_FileReader;

import java.io.FileReader;

public class FileReaderExample1 {

	public static void main(String[] args) {

		// 1. ������ ����
		FileReader reader = new FileReader("poem.txt");
		// ����� ���� - E:/ȫ����/workspace/Java/poem.txt �ǹ�

		// ������ ����
		// FileReader reader =
		// new
		// FileReader("E:/ȫ����/workspace/Java/src/ex18_1_FileReader/poem.txt");

		// 2. ������ �о ó���ϴ� �κ�
		while (true) {
			int data = reader.read(); // ���Ͽ� �ִ� ���� �ϳ��� �о �����Ѵ�.
			// 4����Ʈ ������ 2����Ʈ�� �о�´�.
			if (data == -1) // �� �̻� ���� �����Ͱ� ���� ���
				break;
			char ch = (char) data;
			System.out.print(ch);
		}

		// 3. ������ �ݴ´�.
		reader.close();
	}

}
