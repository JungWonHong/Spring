package ex13_10_Object_hashcode;

public class ObjectExample2 {

	public static void main(String[] args) {
		Circle c1 = new Circle(5);
		Circle c2 = new Circle(5);
		
		//int java.lang.Object.hashCod()
		//���� �ٸ� ��ü�� ���� ���� �ؽ��ڵ带 ���� �� �����ϴ�.
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
	}

}
