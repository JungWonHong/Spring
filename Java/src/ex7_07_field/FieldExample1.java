package ex7_07_field;

public class FieldExample1 {

	public static void main(String[] args) {
		Circle obj = new Circle(0.0);
		obj.radius = 5.0;
		double area = obj.getArea();
		double area2 = obj.getArea2(obj.radius);
		double area3 = obj.getArea3(obj);
		System.out.println("���� ������ = " + obj.radius);
		System.out.println("���� ���� = " + area);
		System.out.println("���� ����2 = " + area2);
		System.out.println("���� ����3" + " = " + area3);
	}

}
