package ex7_14_static_final;
//��� �ʵ� ������ �����ϴ� Ŭ����
public class LimitedValue {
	final static int UPPER_LIMIT = 100000; // ��� �ʵ��� ����
	// static final int UPPER_LIMIT = 100000;
	int value;

	void setValue(int value) {
		if (value < UPPER_LIMIT)
			this.value = value;
		else
			this.value = UPPER_LIMIT; // ��� �ʵ��� ���
	}
}
