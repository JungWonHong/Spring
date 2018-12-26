//FileWriter Ŭ������ �̿��ؼ� ���� �����͸� ���Ͽ� ���� ���α׷�
//�Ű����� �� ���� FileWriter ������ ��� ��
//���� 2�� �����ϱ�
//writer.write("\n"); ������ �ּ� �ް� 3�� �����ϱ�
//��� Ȯ���� FileReaderExampl2.java �� Ȯ��
package ex18_2_FileWriter;

import java.io.*;

public class FileWriterExample2 {

	public static void main(String[] args) {
		FileWriter writer = null;
		try{
			//true : ���� �ִ� ���� ������ �����϶�� �����ϴ� �Ķ����
			//		-���� �ִ� ���� ���� �ڿ� �߰��� ����.
			writer = new FileWriter("output.txt", true);
			
			//public FileWriter(String fileName) throws IOException
			//FileWriter �����ڴ� IOException������ �߻��ϱ� ������
			//IOException ó������ �־�� �մϴ�.
			
			char arr[] = {'��','��',' ','��','��','��'};
			
			//���Ͽ� �ݺ��ؼ� ���ڵ��� ���ϴ�.
			for(int cnt = 0;cnt<arr.length;cnt++)
				writer.write(arr[cnt]);
			//�� �� ����� ���� �ǹ�
			//writer.write(arr);
			//writer.write("\n");
		}
		catch(IOException ioe){
			System.out.println("���Ϸ� ����� �� �����ϴ�.");
		}
		finally {
			try{
				writer.close(); //������ �ݽ��ϴ�.
			}
			catch(Exception e){
				
			}
		}

	}

}
