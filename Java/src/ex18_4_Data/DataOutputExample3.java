//DataOutputStream Ŭ���� ��� �� - ���ڿ� ����
// String Ÿ���� �����͸� ���� �޼ҵ� : writeUTF()
// String Ÿ�� ���� �ٸ� ��ü�� ���� ����� ����.
// �ٸ� Ÿ���� ��ü�� ������ ObjectOutputStream Ŭ������ ����ؾ� �Ѵ�.
package ex18_4_Data;

import java.io.*;

public class DataOutputExample3 {

	public static void main(String[] args) {
		DataOutputStream out = null;
		try{
			//1.open
			out = new DataOutputStream(new FileOutputStream("output.dat"));
			
			//2.write : ���Ͽ� int Ÿ�� �����͸� ���ϴ�.
			//��� ������ String -> int -> Double �̶��
			//�Է� ������ String -> int -> Double �̾�� �մϴ�.
			out.writeUTF("��ſ� �ݿ��� �Դϴ�.~\n");
			out.writeInt(5);
			out.writeDouble(3.14);
		}
		catch(IOException ie){
			System.out.println("���Ϸ� ����� �� �����ϴ�.");
		}
		finally{
			try{
				//3.close : ������ �ݽ��ϴ�.
				out.close();
			}
			catch(Exception e){
				
			}
		}
	}

}
