package ex8_11_abstract_ex.test;

public class Areamain {

	public static void main(String[] args) {
		Circle obj1 = new Circle(6.5);
		System.out.println("���� ���� : " + obj1.getArea());
		
		Square obj2 = new Square(5, 4);
		System.out.println("�簢���� ���� : " + obj2.getArea());
		
		Trapezoid obj3 = new Trapezoid(3, 4, 5);
		System.out.println("��ٸ����� ���� : " + obj3.getArea());
	}

}
