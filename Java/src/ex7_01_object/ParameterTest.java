package ex7_01_object;

class Data {
	int x;
}

public class ParameterTest {

	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x = " + d.x);

		change(d.x);  // ���� �������ش�.(�Ű������� �⺻��)
		System.out.println("After change(d)");
		System.out.println("main() : x = " + d.x); 
		//���� �����߱� ������ DataŬ���� ���� x���� ������ �ʴ´�.
	}

	static void change(int x) {
		x = 1000;
		System.out.println("change() : x = " + x);
	}
}
