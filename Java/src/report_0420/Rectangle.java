package report_0420;
/*   

1. ����ó���� ���ǿ� ������ ���ؼ� �����Ͻÿ�.
  ���ܶ� ���α׷� �ڵ忡 ���ؼ� ������ �� �ִ� �ټ� �̾��� ������ ���Ѵ�. 
  ����ó���� ���α׷� ����� �߻��� �� �ִ� ������ �߻��� ����� �ڵ带 �ۼ��ϴ� ������ ���α׷��� ������ ���Ḧ ���� �������� ������¸� �����ϱ� �����̴�.
2. ������ ���൵�� ���ܰ� �߻��Ͽ� ȭ�鿡 ��µ� �����Դϴ�.
 	������ �غ�����. 
	java.lang.Exception: getTotal() : ��� �ִ� �迭�Դϴ�.
		at ex12_1_Exception.ExceptionExample7.getTotal(ExceptionExample7.java:27)
		at ex12_1_Exception.ExceptionExample7.main(ExceptionExample7.java:8)
		
		==>���ܰ� �߻����� ��, ��� 2���� �޼ҵ�(main, getTotal)�� ȣ�⽺�ÿ� ������,
			���ܰ� �߻��Ѱ��� ���� ���ٿ� getTotal�̰� main�޼��尡 getTotal�޼ҵ带 ȣ�� �ߴٴ� ���� �˼��ִ�.
			getTotal�޼ҵ� ������ "getTotal() : ��� �ִ� �迭�Դϴ�."�� ������ָ� ���ܸ� ó���� �ش�.
 
*/
//3.
public class Rectangle {
	int width, height;

	Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Rectangle)
			return (width == ((Rectangle)obj).width) && (height == ((Rectangle)obj).height);
		else
			return false;
	}

	public String toString() {
		return "���δ� " + width + ", ���δ� " + height;
	}
}