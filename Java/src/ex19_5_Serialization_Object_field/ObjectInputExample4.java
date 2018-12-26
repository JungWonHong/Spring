package ex19_5_Serialization_Object_field;

import java.io.*;

public class ObjectInputExample4 {

	public static void main(String[] args) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("output4.dat"));
			BBSItem obj = (BBSItem) in.readObject(); // ��ü�� ������ȭ

			System.out.println("��ü�Խù��� �� : " + obj.itemnum); // �Խù��� ��
			System.out.println("�۾��� : " + obj.writer);
			System.out.println("�н����� : " + obj.passwd); // transient�ν��Ͻ�
			System.out.println("���� : " + obj.title);
			System.out.println("���� : " + obj.content);
			System.out.println("÷�� : " + obj.attachment);
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
