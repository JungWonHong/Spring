//ObjectOutputStream Ŭ������ �̿��Ͽ� ��ü�� ���Ͽ� �����ϴ� ��
package ex18_5_Object;
import java.io.*;
import java.util.GregorianCalendar;

public class ObjectOutputExample1 {

	public static void main(String[] args) {
		ObjectOutputStream out = null;
		try{
			//������ ���ϴ�.
			/*ObjectOutputStream Ŭ������ ��ü�� ��Ʈ������ ����
			   ����ϴ� ����� �ִ� Ŭ�����Դϴ�.
			   �� Ŭ�������� �����͸� ���Ͽ� �����ϴ� ����� ���� ������
			  FileOutputStream Ŭ������ �Բ� ����ؾ� �մϴ�.
			  FileOutputStream ��ü�� �����ؼ�
			  ObjectOutputStreamŬ������ ������ �Ķ���ͷ� �Ѱ��־�� �մϴ�.
			*/
			out = new ObjectOutputStream(new FileOutputStream("output.dat"));
			
			//��ü�� ����ȭ �ϴ� �κ� : ��ü�� ��Ʈ������ ����� �۾�
			/*
			  WriteObject �޼ҵ� : �Ķ���ͷ� �Ѱ��� ��ü�� ��Ʈ������ ���� ����ϴ� �޼ҵ�
			    �Ķ���ͷ� �Ѱ��� ��ü�� ���Ͽ� ����˴ϴ�.
			  GregorianCalendar��ü�� �����ؼ� ���Ͽ� ���ϴ�.
			*/
			
			out.writeObject(new GregorianCalendar(2017, 0, 14));
			out.writeObject(new GregorianCalendar(2017, 0, 15));
			out.writeObject(new GregorianCalendar(2017, 0, 16));
		}
		catch (IOException ie) {
			System.out.println("������ ����� �� �����ϴ�.");
		}
		finally {
			try {
				out.close(); //������ �ݽ��ϴ�.
			} catch (Exception e) {

			}
		}

	}

}
