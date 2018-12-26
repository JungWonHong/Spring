//�Ѱ��� �޼��带 �̿��ؼ�  �ִ밪, �ּҰ� ���ϱ�
package report_0424;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Method_Test05_maxmin {

	static Map<String, Integer> max_min(int[] data) {
		Map<String, Integer> ht = new HashMap<String, Integer>();

		int result[] = { data[0], data[0] };
		for (int i = 1; i < data.length; i++) {
			if (result[0] < data[i])
				result[0] = data[i]; // max
			if (result[1] > data[i])
				result[1] = data[i]; // min
		}

		ht.put("�ִ밪", result[0]);
		ht.put("�ּҰ�", result[1]);

		return ht;
	}

	public static void main(String args[]) {
		int data[] = new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("���� 5���� �Է��ϼ���?");
		for (int i = 0; i < data.length; i++)
			data[i] = sc.nextInt();

		Map<String, Integer> m = max_min(data);
		System.out.println("�ִ밪 = " + m.get("�ִ밪"));
		System.out.println("�ּҰ� = " + m.get("�ּҰ�"));

		sc.close();
	}
}