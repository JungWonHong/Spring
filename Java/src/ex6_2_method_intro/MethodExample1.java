package ex6_2_method_intro;

public class MethodExample1 {

	public static void main(String[] args) {
		//�޼��� ȣ�� ���1. Ŭ������.�����޼���
		MethodExample1.printCharacter('*', 30);//�޼��� ȣ��
		
		//�޼��� ȣ����2. �����޼���-�����޼��带 ȣ���ϴ� ��� Ŭ������ ���� ����
		printCharacter('-', 30);
		System.out.println("Hello, Java");
		printCharacter('-', 30);
		printCharacter('*', 30);
		return; //��ȯ���� void�� ��� ��������.
	}

	// �޼��� ���� : static - �����޼���
	public static void printCharacter(char ch, int num) {
		for (int cnt = 0; cnt < num; cnt++) {
			System.out.print(ch);
		}
		System.out.println();
		return; //��ȯ���� void�� ��� ���������մϴ�.
	}

}
