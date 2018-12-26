//DataInputStream Ŭ���� ��� ��
//DataOutputStream Ŭ������ �̿��Ͽ� ���Ͽ� �����ߴ� �����͸� ���α׷�����
//�ٽ� �о���� ���ؼ��� DataInputStream Ŭ������ �̿��ؾ� �մϴ�.
//������ �� Ŭ������ ���Ͽ� �����͸� �д� ����� ���� ������
//FileInputStream Ŭ������ �Բ� ����ؾ� �մϴ�.
package ex18_4_Data;
import java.io.*;
public class DataInputExample1 {

	public static void main(String[] args) {
		DataInputStream in = null;
		try{
			in = new DataInputStream(new FileInputStream("output.dat"));
			//public DataInputSTream(InputStream in)
			
			//���Ϸκ��� ������ �о ����Ѵ�.
			while(true){
				//�����͸� �дٰ� ���� ���� ������ EOFException �߻�
				int data = in.readInt();
				System.out.print(data + " ");
			}
			
		}
		catch(FileNotFoundException fe){
			fe.printStackTrace();
		}
		catch(EOFException eofe){ //readInt()�޼ҵ忡 ���� ���Ͽ� ���� �����ϸ� �̰����� �̵�
			System.out.println("��");
		}
		catch(IOException ie){
			ie.printStackTrace();
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
