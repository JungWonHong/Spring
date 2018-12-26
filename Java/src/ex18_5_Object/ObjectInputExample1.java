//ObjectInputStream Ŭ������ �̿��Ͽ� ��ü�� ���Ϸ� ���� �д� ��
//GregorianCalendar�� ����ȭ ������ Ŭ���� :
//	java.io.Serializeble �������̽��� �����ϴ��� ����
package ex18_5_Object;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class ObjectInputExample1 {

	public static void main(String[] args) {
		ObjectInputStream in = null;
		try{
			//������ ���ϴ�.
			//ObjectInputStream Ŭ������ ��Ʈ�� ���·� �о���� ��ü�� ���α׷�����
			//����� �� �ִ� ��ü�� ����� ����� Ŭ�����Դϴ�.
			//�� Ŭ������ FileInputStream Ŭ������ �Բ� ����ϸ� ���Ͽ� ����� ��ü��
			//���α׷����� �ٽ� �о ����� �� �ֽ��ϴ�.
			//FileInputStream ��ü�� �����ؼ� ObjectInputStream ������ �Ķ���ͷ�
			//�Ѱ��־�� �մϴ�.
			in = new ObjectInputStream(new FileInputStream("output.dat"));
			while(true){
				//��ü�� ������ȭ�ϴ� �κ� : ��Ʈ���� ��ü�� ����� �۾�
				//readObject �޼ҵ� : �Էµ� ��Ʈ�����κ��� ��ü�� ���� �����ϴ� �޼ҵ�
				//���� Ÿ�� Object�� ������ Ŭ���� Ÿ������ ����ϱ� ���� ĳ��Ʈ ������ �ؾ��մϴ�.
				//readObject()�� Object���̹Ƿ� GregorianCalendar Ÿ������ �� ��ȯ �մϴ�.
				GregorianCalendar calendar = (GregorianCalendar)in.readObject();
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH) + 1;
				int date = calendar.get(Calendar.DATE);
				System.out.println(year + " / " + month + " / " + date);
			}
		}
		catch(FileNotFoundException fe){
			System.out.println("������ �������� �ʽ��ϴ�.");
		}
		catch(EOFException eofe){ //���Ϸκ��� ���̻� ���� ��ü�� ���� �� �߻��ϴ� ���� ó��
			System.out.println("��");
		}
		catch(IOException ie){
			System.out.println();
		}
		catch(ClassNotFoundException cnfe){
			System.out.println("�ش� Ŭ������ �������� �ʽ��ϴ�.");
		}
		finally{
			try{
				in.close();
			}
			catch(Exception e){
				
			}
		}
	}

}
