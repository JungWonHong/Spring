//��Ű�� ex18_2�� FileWriterExample1.java�� �����Ͽ�
//PrintWriter Ŭ���� �̿��� ���α׷����� ������ ����
//PrintWriter Ŭ������ �����͸� �����ؼ� ���Ϸ� ����ϴ� ����� �ִ� Ŭ�����Դϴ�.
package ex18_8_PrintWriter;
import java.io.*;
public class PrintWriterExample1 {

	public static void main(String[] args) {
		PrintWriter writer = null;
		try{
			writer = new PrintWriter("print.txt"); //������ ���ϴ�.
			
			//String ó��
			String s = "������ �� ���� �ƴ� ���� ���� ��";
			writer.println(s);
			
			//char �迭 ó��
			char arr[] = {'��','��','��',' ','��',' ','��','��',' ','��','��',' ','��','��',' ','��','��',' ','��'};
			writer.println(arr);
		}
		catch(IOException ie){
			System.out.println("���� �߻�");
		}
		finally{
			try{
				System.out.println("����Ϸ�");
				writer.close();
			}
			catch(Exception e){
				
			}
		}

	}

}
