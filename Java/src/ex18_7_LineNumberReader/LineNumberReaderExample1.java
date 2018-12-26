//�ؽ�Ʈ�� �� �࿡ ��ȣ�� �ű�鼭 �д� Ŭ����
//LineNumberWriter�� ����
package ex18_7_LineNumberReader;

import java.io.*;

public class LineNumberReaderExample1 {

	public static void main(String[] args) {
		LineNumberReader reader = null;
		try {
			// ������ ���ϴ�.
			reader = new LineNumberReader(new FileReader("poem.txt"));

			// ���Ϸ� ���� �� �྿ �о �� ��ȣ�� �Բ� ����մϴ�.
			while (true) {
				String str = reader.readLine();// ���Ϸ� ���� �� �྿ �о�´�
				if (str == null)
					break;
				// ���� �� ��ȣ�� �����ϴ� �޼ҵ� : getLineNumber()
				int lineNo = reader.getLineNumber();
				System.out.println(lineNo + ": " + str);
			}
		} catch (FileNotFoundException fe) {
			System.out.println("������ ã�� �� �����ϴ�.");
		} catch (IOException ie) {
			System.out.println("������ ���� �� �����ϴ�.");
		} finally {
			try {
				reader.close();
			} catch (Exception e) {

			}
		}

	}

}
