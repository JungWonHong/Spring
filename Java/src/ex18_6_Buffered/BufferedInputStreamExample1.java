package ex18_6_Buffered;

import java.io.*;

public class BufferedInputStreamExample1 {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("���ϸ��� Arguments�ǿ� output1.dat �Է��� �ּ���.");
			return;
		}

		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(args[0])); //������ ��
			byte arr[] = new byte[16]; // byte ������ �����͸� �б� ������ byte �� ���
			while (true) {
				//��Ŀũ�⸸ŭ �����͸� �Ѳ����� �о� �� �� 16����Ʈ ����
				int num = in.read(arr); 
				
				if (num < 0)
					break;

				// �о���� ����Ʈ �����͸� 16������ ����Ѵ�.
				for (int cnt = 0; cnt < num; cnt++)
					System.out.printf("%02X ", arr[cnt]);
				// %02X : 2�ڸ� 16����(%X)�� ����ϵ�,
				// �빮��(X�� �빮����)�� ����ϸ鼭 ���ڰ� �� �ڸ��̸� ���ڸ��� 0���� ä���
				// %02x : 2�ڸ� 16����(%x)�� ����ϵ�,
				// �ҹ���(x�� �ҹ�����)�� ����ϸ鼭 ���ڰ� �� �ڸ��̸� ���ڸ��� 0���� ä���

				//System.out.println();

				//for (int cnt = 0; cnt < num; cnt++)
				//	System.out.printf("%d ", arr[cnt]);
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
