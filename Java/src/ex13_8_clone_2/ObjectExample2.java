package ex13_8_clone_2;

public class ObjectExample2 {

	public static void main(String[] args) {
		// ��ü �����մϴ�.
		Rectangle obj1 = new Rectangle(10, 20);

		// clone �޼���� ��ü�� �����մϴ�.
		Rectangle obj2 = obj1.clone();

		// ���� ��ü�� ���� ��ü�� ���� ����մϴ�.
		System.out.println("obj1 = " + obj1.width + "x" + obj1.height);
		System.out.println("obj2 = " + obj2.width + "x" + obj2.height);

		obj2.width = 100;
		obj2.height = 200;
		System.out.println("obj1 = " + obj1.width + "x" + obj1.height);
		System.out.println("obj2 = " + obj2.width + "x" + obj2.height);

	}

}
