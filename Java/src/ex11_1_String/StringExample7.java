package ex11_1_String;

public class StringExample7 {

	public static void main(String[] args) {
		String str1 = "    Let it be.  ";
		String str2 = str1.trim(); //�յ� ���� ����
		System.out.println("=========trim()==============");
		System.out.println(str1);
		System.out.println(str2 + "\n");

		System.out.println("=========concat()=============="); //���ڿ� ��ġ��
		System.out.println(str2.concat(" Speaking words of wisdom"));
		System.out.println(str2 + "\n");

		System.out.println("=========toUpperCase()=============="); //�빮�ڷ�
		System.out.println(str2.toUpperCase());
		System.out.println(str2 + "\n");

		System.out.println("=========toLowerCase()=============="); //�ҹ��ڷ�
		System.out.println(str2.toLowerCase());
		System.out.println(str2 + "\n");

		System.out.println("=========replace()=============="); //���ڿ���ü
		System.out.println(str2.replace('e', 'a'));
		System.out.println(str2 + "\n");
	}

}
