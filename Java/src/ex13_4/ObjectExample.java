package ex13_4;

public class ObjectExample {

	public static void main(String[] args) {
		GoodsStock obj = new GoodsStock("57293", 100);
		String str = "��� ���� = " + obj;
		//���ڿ��� GoodsStock ��ü ������ + �����ڷ� �����ϸ�
		//�� ��ü�� toString �޼ҵ尡 �ڵ����� ȣ��� �� ���ڿ��� ����ȴ�.
		System.out.println(str);
	}

}
