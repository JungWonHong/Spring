package ex7_14_static_final;
//상수 필드 선언을 포함하는 클래스
public class LimitedValue {
	final static int UPPER_LIMIT = 100000; // 상수 필드의 선언
	// static final int UPPER_LIMIT = 100000;
	int value;

	void setValue(int value) {
		if (value < UPPER_LIMIT)
			this.value = value;
		else
			this.value = UPPER_LIMIT; // 상수 필드의 사용
	}
}
