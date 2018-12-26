package ex10_7_private;

public class Fraction2 {
	private int numerator; // 분자
	private int denominator; // 분모

	Fraction2(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	double getDouble() {
		// 분자를 double 타입으로 형변환
		return (double) numerator / denominator;
	}

	int getInt() {// 분수값을 int 타입으로 리턴
		return (int) getDouble();
	}

}
