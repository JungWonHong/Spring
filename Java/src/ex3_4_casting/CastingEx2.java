package ex3_4_casting;

public class CastingEx2 {

	public static void main(String[] args) {
		int i1 = 10;
		
		double d1 = i1; //������ ����ȯ
		
		System.out.println("d1 ����Ÿ�� " + d1 + "�Դϴ�.");
		
		/*
		double d2 = 10.0;
		int i2 = d2; //�����߻� : cannot convert from double to int
		System.out.println("i2 ����Ÿ�� " + i2 + "�Դϴ�.");
		*/
		
		//���� ���� - double -> int
		double d2 = 10.1234;
		int i2 = (int)d2; //������ ����ȯ
		System.out.println("i2 �����ʹ� " + i2 + "�Դϴ�.");
		
	}

}