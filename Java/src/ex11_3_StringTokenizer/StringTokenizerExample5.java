//StringTokenizer�� �̿��ؼ� ��ȹ���ڸ� ��ū���� �����ϴ� ���α׷�
package ex11_3_StringTokenizer;

import java.util.StringTokenizer;

public class StringTokenizerExample5 {

	public static void main(String[] args) {
		// true : ��ȹ���ڵ� ��ū���� �����ϵ��� ����� ����
		StringTokenizer stok = 
				new StringTokenizer("���=10|���ݷ�=3|������=1", "=|", true);

		System.out.println("��ǰ�̸�\t��ǰ��");

		while (stok.hasMoreTokens()) {
			String str = stok.nextToken();
			if (str.equals("="))
				System.out.print("\t");
			else if (str.equals("|"))
				System.out.println();
			else
				System.out.print(str);
		}

	}

}
