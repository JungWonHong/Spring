//private 필드와 메소드를 포함하는 클래스의 예
package ex10_7_private;

public class Fraction {
	private int numerator; // 분자
	private int denominator; // 분모

	Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	//private은 동일 클래스 내에서만 사용가능하다.
	private double getDouble() {
		// 분자를 double 타입으로 형변환
		return (double) numerator / denominator;
	}

	int getInt() {// 분수값을 int 타입으로 리턴
		return (int) getDouble();
	}

}
