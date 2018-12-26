package ex19_3_Serializable_interface;

import java.io.*;

public class ObjectInputExample2 {

	public static void main(String[] args) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("output2.dat"));
			while (true) {
				GoodsStock gstock = (GoodsStock) in.readObject();
				String code = gstock.code;
				int num = gstock.num;
				System.out.println("��ǰ�ڵ�:" + code + "\t��ǰ����" + num);
			}
		} catch (FileNotFoundException fe) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		} catch (EOFException eofe) { // ���Ϸκ��� ���̻� ���� ��ü�� ���� �� �߻��ϴ� ���� ó��
			System.out.println("��");
		} catch (IOException ie) {
			System.out.println();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("�ش� Ŭ������ �������� �ʽ��ϴ�.");
		} finally {
			try {
				in.close();
			} catch (Exception e) {

			}
		}
	}

}
