package ex4_11_rel_logic_op;

public class EqualityExample2 {

	public static void main(String[] args) {
		// ������ - s1, s2�� �޸� �ּ�, new�� ������,
		// new String("�ڹ�"); ���� String()�� ������
		// String�� ���̺귯���� �����Ǵ� Ŭ������ JRE�� �ֽ��ϴ�.
		String s1 = "�ڹ�";
		String s2 = new String("�ڹ�");
		System.out.println("s1=" + s1 + " s2=" + s2);
		// ��¹��� �������� ���̸� �ּҰ��� �ƴ� ���빰�� ����� �ȴ�.

		// �ּҰ� ������ ��
		if (s1 == s2) {
			System.out.println("���� �ּ�");
		} else {
			System.out.println("�ٸ� �ּ�");
		}

		// ���밪 ������ ��
		if (s1.equals(s2)) {
			System.out.println("���� ��");
		} else {
			System.out.println("�ٸ� ��");
		}

	}

}
