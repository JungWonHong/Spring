package ex18_6_Buffered;

import java.io.*;

public class BufferedWriterExample1 {

	public static void main(String[] args) {
		BufferedWriter writer = null;
		try{
			//�������� �Ű������� ��(open) ������ �̸��� �ǹ��մϴ�.
			//output.txt������ ���� ���� ���� ���� �� ������ �����ϴ�.
			//���� �̸��� �ִ� ��� ���� ������ ������ �������ϴ�.
			
			writer = new BufferedWriter(new FileWriter("output.txt"));
			
			//public FileWriter(String fileName) throws IOException
			//FileWriter �����ڴ� IOException������ �߻��ϱ� ������
			//IOException ó������ �־�� �մϴ�.
			
			char arr[] = {'��','��','��',' ','��',' ','��','��',' ','��','��',' ','��','��',' ','��','��',' ','��'};
			
			//���Ͽ� �ݺ��ؼ� ���ڵ��� ���ϴ�.
			for(int cnt = 0;cnt<arr.length;cnt++)
				writer.write(arr[cnt]);
			//�� �� ����� ���� �ǹ�
			//writer.write(arr);
		}
		catch(IOException ioe){
			System.out.println("���Ϸ� ����� �� �����ϴ�.");
		}
		finally {
			try{
				System.out.println("����Ϸ�");
				writer.close(); //������ �ݽ��ϴ�.
			}
			catch(Exception e){
				
			}
		}

	}

}
