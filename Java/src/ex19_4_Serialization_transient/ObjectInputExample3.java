package ex19_4_Serialization_transient;

import java.io.*;

public class ObjectInputExample3 {

	public static void main(String[] args) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("output3.dat"));
			BBSItem obj = (BBSItem) in.readObject(); // ��ü�� ������ȭ

			System.out.println("��ü�Խù��� �� : " + obj.itemnum); // �Խù��� ��
			System.out.println("�۾��� : " + obj.writer);
			System.out.println("�н����� : " + obj.passwd); // transient�ν��Ͻ�
			System.out.println("���� : " + obj.title);
			System.out.println("���� : " + obj.content);
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
