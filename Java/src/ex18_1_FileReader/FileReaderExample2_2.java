package ex18_1_FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample2_2 {

	public static void main(String[] args) {
		// 1. ������ ����
		try {
			FileReader reader = new FileReader("poem.txt");
			// poem.txt�� ��δ� E:/ȫ����/workspace/Java/poem.txt
			// FileReader reader
			// new
			// FileReader("E:\\ȫ����\\workspace\\Java\\src\\ex18_1_FileReader\\poem.txt");

			 /*
	          * ���� '\'�� �ٸ� ���ڿ� �������� Ư���� ����� �����ϴ� ���ڷ� �ڱ� �ڽ��� ��Ÿ������
	          * �� ���� �ΰ��� ����ؾ��Ѵ�.
	          * �ϳ��� ����ϸ� ������ �߻��Ѵ�.
	          * \n'�� �ΰ��� ���ڷ� �̷���� ������ �ϳ��� ���ڷ� ��޵ȴ�.
	          * '\n'�� Ŀ���� ���� �� �� ������ �Ű��ִ� ������ �ϴ� �����̴�.
	          * �̿� ���� ���ڵ��� Escape ���ڶ�� �Ѵ�.
	          * 
	          
	          ===== Escape ���� ====
	          \n -> ���� ����
	          \t -> tabŰ�� ���� �� ó�� ����ĭ ���
	          \\ -> '\'�� ��Ÿ����.
	          \" -> ū����ǥ(")�� ��Ÿ����.
	          
	          */
			while (true) {
				// int java.io.InputStreamReader.read() throws IOException
				// read �޼ҵ� IOException �߻�
				// ���� ó�� ���־�� �մϴ�.
				int data = reader.read(); // ���Ͽ� �ִ� ���� �ϳ��� �о �����ϴ� �޼ҵ�
				if (data == -1) // �� �̻� ���� �����Ͱ� ���� ���
					break;
				char ch = (char) data;
				System.out.print(ch);

			}

			// void java.io.InputStreamReader.close() throws IOException

			reader.close();
			// 3. ������ �ݴ´�.
		} catch (FileNotFoundException fnfe) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		} catch (IOException ioe) {
			System.out.println("������ ���� �� �����ϴ�.");
		}

	}

}
