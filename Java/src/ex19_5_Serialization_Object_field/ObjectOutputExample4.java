package ex19_5_Serialization_Object_field;

import java.io.*;

public class ObjectOutputExample4 {

	public static void main(String[] args) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("output4.dat"));
			BBSItem obj = new BBSItem("�̼���", "moonlight", "�ڷ� �����Դϴ�.", "÷�� ������ �����Ͻʽÿ�.");
			obj.addAttachment(new Object());
			
			System.out.println("��ü�Խù��� �� : " + obj.itemnum); // �Խù��� ��
			System.out.println("�۾��� : " + obj.writer);
			System.out.println("�н����� : " + obj.passwd); // transient�ν��Ͻ�
			System.out.println("���� : " + obj.title);
			System.out.println("���� : " + obj.content);
			System.out.println("÷�� : " + obj.attachment);
			
			out.writeObject(obj); // writeObject �޼ҵ尡 IOException �߻�
			//����ȭ ��� �ʵ� �߿� �ϳ��� ����ȭ �� �� ���� Ÿ���� �ʵ尡 ������ �ͼ��� �߻��ؼ�
			//��ü ��ü�� ����ȭ ���� �ʰ� �˴ϴ�.
		} catch (IOException ie) {
			System.out.println("���Ϸ� ����� �� �����ϴ�.");
			ie.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e) {
			}
		}

	}

}
