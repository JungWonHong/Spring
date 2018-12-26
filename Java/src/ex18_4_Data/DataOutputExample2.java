//DataOutputStream Ŭ���� ��� �� - ���ڿ� ����
// String Ÿ���� �����͸� ���� �޼ҵ� : writeUTF()
// String Ÿ�� ���� �ٸ� ��ü�� ���� ����� ����.
// �ٸ� Ÿ���� ��ü�� ������ ObjectOutputStream Ŭ������ ����ؾ� �Ѵ�.
package ex18_4_Data;

import java.io.*;

public class DataOutputExample2 {

	public static void main(String[] args) {
		DataOutputStream out = null;
		try{
			//1.open
			out = new DataOutputStream(new FileOutputStream("output.dat"));
			//java.io.DataOutputStream.DataOutputStream(OutputStream arg0)	
			//���� �ٸ��� ������ ������Ʈ�� ����ؾ��Ѵ� (����Ʈ������ �о�������� ���°� ��Ʈ�������� ���⶧��)
			
			//2.write : ���Ͽ� int Ÿ�� �����͸� ���ϴ�.
			out.writeUTF("��ſ� �ݿ��� �Դϴ�.~");
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
