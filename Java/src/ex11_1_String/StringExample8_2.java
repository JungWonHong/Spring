package ex11_1_String;

public class StringExample8_2 {

	public static void main(String[] args) {
		String message = "Java program creates many objects.";

		// ������ ���ڰ� �������� ��ġ�� �ε����� ���մϴ�.
		// �������� �ʴ� ��� -1�� �����մϴ�.
		// ���ڿ��� �������� �˻��մϴ�.
		int index1 = message.lastIndexOf('a');
		System.out.println("a�� ��ġ�� " + index1);

		// �ƽ�Ű�ڵ� 97�� �ҹ��� 'a'
		int index2 = message.lastIndexOf(97);
		System.out.println("a�� ��ġ�� " + index2);

		// �ƽ�Ű�ڵ� 65�� �빮�� 'A'
		int index23 = message.lastIndexOf(65);
		// 'A'�� ���� ���� index ���� -1�� ��ȯ�Ѵ�.
		System.out.println("A�� ��ġ�� " + index23);

		// index��ȣ 10���� �������� 'a'�� ã���ϴ�.
		int index3 = message.lastIndexOf('a', 10);
		System.out.println("10�� ���� a�� ��ġ�� " + index3);
		
		int index33 = message.lastIndexOf('a', 13);
		System.out.println("13�� ���� a�� ��ġ�� " + index33);

		// "av"�� ���� index�� ã���ϴ�.
		int index4 = message.lastIndexOf("av");
		System.out.println("av�� �����ϴ� index�� " + index4);
	}

}
