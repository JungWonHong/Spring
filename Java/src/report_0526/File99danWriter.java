package report_0526;

import java.io.*;

public class File99danWriter {

	public static void main(String[] args) {
		FileWriter writer = null;

		try {
			writer = new FileWriter("gugudan.txt"); // 해당 이름의 txt 파일을 연다.

			for (int dan = 2; dan <= 9; dan++) {
				writer.write("[" + dan + "단]" + "\t");
			}

			writer.write("\n");

			for (int i = 1; i <= 9; i++) {
				for (int j = 2; j <= 9; j++) {
					writer.write(j + "*" + i + "=" + (j * i) + "\t");
				}
				writer.write("\n");
			}
		} catch (IOException ioe) {
			System.out.println("파일로 출력할 수 없습니다.");
		} finally {
			try {
				writer.close(); // 파일을 닫습니다.

			} catch (Exception e) {

			}
		}

	}

}
