package ex10_7_private;

public class Fraction2 {
	private int numerator; // ����
	private int denominator; // �и�

	Fraction2(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	double getDouble() {
		// ���ڸ� double Ÿ������ ����ȯ
		return (double) numerator / denominator;
	}

	int getInt() {// �м����� int Ÿ������ ����
		return (int) getDouble();
	}

}
