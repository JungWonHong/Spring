package ex19_7_serialVersionUID;

import java.io.*;

public class ObjectInputExample2 {

	public static void main(String[] args) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("output10.dat"));
			Rectangle obj = (Rectangle) in.readObject();

			System.out.println("���� : " + obj.width);
			System.out.println("���� : " + obj.height);
		} catch (FileNotFoundException fe) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		} catch (EOFException eofe) {
			System.out.println("��");
		} catch (IOException ie) {
			System.out.println("������ ���� �� �����ϴ�.");
		} catch (ClassNotFoundException e) {
			System.out.println("�ش� Ŭ������ �������� �ʽ��ϴ�.");
		} finally {
			try {
				in.close();
			} catch (Exception e) {
			}
		}

	}

}
