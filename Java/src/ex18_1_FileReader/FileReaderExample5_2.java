//�Ѳ����� ���� ���ڸ� �д� read �޼ҵ� ��
//int java.io.Reader.read(char[] cbuf) throws IOException ������ read�޼ҵ� ���
package ex18_1_FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample5_2 {

	public static void main(String[] args) {
		FileReader reader = null;
		char arr[]=new char[64]; //���Ͽ� �ִ� ���ڸ� ���� char�迭
		try{
			reader = new FileReader("������ ��.txt");
			while (true) {
				int num = reader.read(arr);

				if (num == -1) //�� �̻� ���� ���ڰ� ���� ��� -1�� �����մϴ�.
					break;
				// ��¹�� 1. arr�� 0���� num�� ��ŭ ��Ʈ������ ���� �� ���
				System.out.print(new String(arr, 0, num));

				// ��¹�� 2.
				/*for(int i=0;i<num;i++) 
					System.out.print(arr[i]);*/
			}
		}
		catch(FileNotFoundException fe){
			System.out.println("������ �������� �ʽ��ϴ�.");
		}
		catch(IOException ie){
			System.out.println("������ ���� �� �����ϴ�.");
		}
		finally{
			try{
				reader.close();
			}
			catch(Exception e){
				
			}
		}
	}

}
