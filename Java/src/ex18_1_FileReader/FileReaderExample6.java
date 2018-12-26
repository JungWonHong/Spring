package ex18_1_FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample6 {

	public static void main(String[] args) {
		FileReader reader = null;
		char arr[] = new char[64]; //���Ͽ� �ִ� ���ڸ� ���� char�迭
		
		try{
			reader = new FileReader("1.txt");
			while(true){
				//Returns : the number of characters read
				int num = reader.read(arr, 5, 10);
				//�Է� ��Ʈ������ ���� 10���� ���ڸ�ŭ �а� arr[5]���� 0���� ���ڸ� �����մϴ�.
				/*
				  public int read(char[] cbuf, int offset, int length)
				    �Է� ��Ʈ�����κ��� length���� ���ڸ�ŭ �а� cbuf[off]���� length ������ ����
				    ������ ���� ������ ���� length���� ���� ��� ���� ����ŭ �����մϴ�.
				  offset�� 0�̰� length�� �迭�� �����̸� read(char[] cbuf)�� �����մϴ�.
				*/
				if(num == -1)
					break;
				
				System.out.print(arr);
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
