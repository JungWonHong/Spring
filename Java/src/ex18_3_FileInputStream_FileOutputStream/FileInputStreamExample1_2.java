package ex18_3_FileInputStream_FileOutputStream;

import java.io.*;

public class FileInputStreamExample1_2 {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("���ϸ��� Arguments�ǿ� output1.dat �Է��� �ּ���.");
			return;
		}

		FileInputStream in = null;
		try {
			in = new FileInputStream(args[0]); //������ ��
			byte arr[] = new byte[20]; // byte ������ �����͸� �б� ������ byte �� ���
			while (true) {
				int num = in.read(arr); // ���Ϸκ��� 20����Ʈ �д´�.
				// int java.io.FileInputStream.read(byte[] b) throws IOException
				if (num < 0)
					break;

				// �о���� ����Ʈ �����͸� 16������ ����Ѵ�.
				for (int cnt = 0; cnt < num; cnt++)
					System.out.printf("%02X ", arr[cnt]);
				// %02X : 2�ڸ� 16����(%X)�� ����ϵ�,
				// �빮��(X�� �빮����)�� ����ϸ鼭 ���ڰ� �� �ڸ��̸� ���ڸ��� 0���� ä���
				// %02x : 2�ڸ� 16����(%x)�� ����ϵ�,
				// �ҹ���(x�� �ҹ�����)�� ����ϸ鼭 ���ڰ� �� �ڸ��̸� ���ڸ��� 0���� ä���

				System.out.println();

				for (int cnt = 0; cnt < num; cnt++)
					System.out.printf("%d ", arr[cnt]);
			}
		} catch (FileNotFoundException fe) {
			System.out.println(args[0] + " ������ ã�� �� �����ϴ�.");
		} catch (IOException ie) {
			System.out.println(args[0] + " ������ ���� �� �����ϴ�.");
		} finally {
			try {
				in.close(); // ������ �ݽ��ϴ�.
			} catch (Exception e) {
			}
		}
	}
}
