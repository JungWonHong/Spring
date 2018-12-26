//DataOutputStream Ŭ���� ��� ��
//DataOutputStream Ŭ������ �⺻�� �����͸� ����Ʈ ��Ʈ������ ���� ����ϴ� ����� Ŭ�����Դϴ�.
//�� Ŭ������ ���Ͽ� �����͸� ���� ����� ���� ������ FileOutputStream Ŭ������
//�Բ� ����ؾ� �⺻�� �����͸� ���Ͽ� �� �� �ֽ��ϴ�.
//������ ���� FileOutputStream ��ü�� ������ �� �� ��ü�� ������ �Ķ���ͷ� �Ѱܾ� �մϴ�.
package ex18_4_Data;

import java.io.*;

public class DataOutputExample1 {

	public static void main(String[] args) {
		DataOutputStream out = null;
		try{
			//1.open
			out = new DataOutputStream(new FileOutputStream("output.dat"));
			//java.io.DataOutputStream.DataOutputStream(OutputStream arg0)	
			//���� �ٸ��� ������ ������Ʈ�� ����ؾ��Ѵ� (����Ʈ������ �о�������� ���°� ��Ʈ������ ���⶧��)
			
			int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
			//2.write : ���Ͽ� int Ÿ�� �����͸� ���ϴ�.
			for(int cnt =0;cnt<arr.length;cnt++)
				out.writeInt(arr[cnt]); //���Ͽ� int Ÿ�� �����͸� ���ϴ�.
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
