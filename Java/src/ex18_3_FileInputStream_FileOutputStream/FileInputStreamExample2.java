package ex18_3_FileInputStream_FileOutputStream;
import java.io.*;
public class FileInputStreamExample2 {

	public static void main(String[] args) {
		if(args.length<1){
			System.out.println("���ϸ��� Arguments�ǿ� output1.dat �Է��� �ּ���.");
			return;
		}
		FileInputStream in = null;
		try{
			in = new FileInputStream(args[0]); //������ ����.
			//Run -> Run Configurations���� �Ű����� ������ output1.dat �Է�
			
			while(true){
				int data = in.read();
				
				if(data < 0) //�о�� �����Ͱ� -1�̸� �ݺ��� �ߴ�
					break;
				
				System.out.print(data + " ");
			}
		}
		catch(FileNotFoundException fe){
			System.out.println(args[0] + " ������ �������� �ʽ��ϴ�.");
		}
		catch(IOException ie){
			System.out.println(args[0] + " ������ ���� �� �����ϴ�.");
		}
		finally{
			try{
				in.close(); //������ �ݽ��ϴ�.
			}
			catch(Exception e){
			}
		}

	}

}
