package ex6_3_method;

public class Method_Test01 {

	// �޼ҵ� ����

	static void sum(int n) { // n�� ���������� stack�� ����Ǿ� �ִ�.

		int sum = 0;

		for (int i = 0; i <= n; i++) {
			sum += i;
		}

		System.out.println("1 ~ " + n + "������ ��: " + sum);

	}

	public static void main(String[] args) {

		sum(5); // �޼ҵ� ȣ��
		sum(10); // �޼ҵ� ȣ��
		sum(100); // �޼ҵ� ȣ��
	}

}
