package ex3_1_literal;

public class First3 {
	public static void main(String args[]){
		//System.out.println() : ��ȣ���� ������ ����� �� �� ���� ���ϴ�.
		//System.out.print()   : ��ȣ���� ������ ����� �� �� ���� ���� �ʰ� �����մϴ�.
		//System.out.printf()  : ������ �����ؼ� ����մϴ�.
		
		//���ͷ�(literal) - �� ��ü�� ���� �ǹ� �ϴ� ��
		System.out.println("��¼���!!");
		System.out.println(30);
		System.out.println(3.14);
		System.out.println('A');
		System.out.println(true);
		System.out.println(false);
		System.out.print("���ڿ� ���");
		
		System.out.print("======���� �ȹٲ�!!====");
		System.out.print("test");
		
		System.out.printf("%s", "�ڹ����");
		System.out.printf("%f", 42.195); //�⺻ �Ҽ������� 6�ڸ�
		System.out.println(); //�ٹٲ�
		System.out.printf("%.2f", 42.195); //�Ǽ� 42.195�� �Ǽ� ���� �Ҽ��� ���� 2�ڸ��� ���
		System.out.printf("%d", 42);
		System.out.printf("%c", 'A');
		System.out.println();
		
		System.out.println("========================");
		System.out.printf("%s\n", "�ڹ����"); //\n �ٹٲ�
		System.out.printf("%f\n", 42.195); //�⺻ �Ҽ������� 6�ڸ�
		System.out.printf("%.2f\n", 42.195); //�Ǽ� 42.195�� �Ǽ� ���� �Ҽ��� ���� 2�ڸ��� ���
		System.out.printf("%d\n", 42);
		System.out.printf("%c\n", 'A');
		
		System.out.println("========================");
		System.out.printf("%s\n%f\n%.2f\n%d\n%c\n", "�ڹ����", 42.195, 42.195, 42, 'A');
		
	}

}
