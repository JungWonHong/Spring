package report_0526;

import java.io.*;

public class File99danWriter {

	public static void main(String[] args) {
		FileWriter writer = null;

		try {
			writer = new FileWriter("gugudan.txt"); // �ش� �̸��� txt ������ ����.

			for (int dan = 2; dan <= 9; dan++) {
				writer.write("[" + dan + "��]" + "\t");
			}

			writer.write("\n");

			for (int i = 1; i <= 9; i++) {
				for (int j = 2; j <= 9; j++) {
					writer.write(j + "*" + i + "=" + (j * i) + "\t");
				}
				writer.write("\n");
			}
		} catch (IOException ioe) {
			System.out.println("���Ϸ� ����� �� �����ϴ�.");
		} finally {
			try {
				writer.close(); // ������ �ݽ��ϴ�.

			} catch (Exception e) {

			}
		}

	}

}
