//private �ʵ�� �޼ҵ带 �����ϴ� Ŭ������ ��
package ex10_7_private;

public class Fraction {
	private int numerator; // ����
	private int denominator; // �и�

	Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	//private�� ���� Ŭ���� �������� ��밡���ϴ�.
	private double getDouble() {
		// ���ڸ� double Ÿ������ ����ȯ
		return (double) numerator / denominator;
	}

	int getInt() {// �м����� int Ÿ������ ����
		return (int) getDouble();
	}

}
