//System.in�� �̿��� Ű����κ��� ���ڸ� �Է¹޴� ���α׷�
package ex16_1_System_in_out_error;

import java.io.*;

public class System1_in_InputStreamReader {

	public static void main(String[] args) {
		// SystemŬ������ in �ʵ带 ������ InputStreamReader ��ü�� �����մϴ�.
		InputStreamReader reader = new InputStreamReader(System.in); //System.in�� ��ȯ���� InputStream

		// Ű����κ��� �� ���ھ� �Է� �޾Ƽ� ����ϴ� ���� ��ħǥ(.)�� �Էµ� ������ �ݺ�
		try {
			while (true) {
				char ch = (char) reader.read(); // �ѱ��ھ� �Է� ����
				System.out.println("�Էµ� ����: " + ch);
				if (ch == '.')
					break;
			}
		} catch (IOException e) {
			System.out.println("Ű���� �Է� ����");
		}

	}

}
