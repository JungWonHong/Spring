//StringTokenizer�� ��ɰ� ������ String�� split�޼ҵ� ����
package ex11_4;

import java.util.StringTokenizer;

public class StringTokenizerExample5 {

	public static void main(String[] args) {
		String post = "123-456";
		String post1 = "123-456-789-012";
		StringTokenizer str = new StringTokenizer(post, "-");
		StringTokenizer str1 = new StringTokenizer(post1, "-");

		System.out.println("***123-456 ��ū �и�***");
		System.out.println("�����ȣ ���ڸ��� " + str.nextToken());
		System.out.println("�����ȣ ���ڸ��� " + str.nextToken());

		System.out.println("***123-456-789-012 ��ū �и�***");
		while (str1.hasMoreTokens()) {
			System.out.println(str1.nextToken());
		}

		System.out.println("***String�� split �޼ҵ� �̿� : 123-456 ��ū �и�***");
		String[] st = post.split("-"); //�и��Ȱ� �迭�� ����.
		// �迭�� ������ �������϶� length �Ӽ��� �̿��Ѵ�.
		for (int i = 0; i < st.length; i++)
			System.out.println(st[i]);

	}

}
