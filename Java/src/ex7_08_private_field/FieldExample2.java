package ex7_08_private_field;
//������ ���� : ��ü�� ������Ҹ� �ܺη� ���� ���ߴ� ���
public class FieldExample2 {

	public static void main(String[] args) {
		Circle obj = new Circle(0.0);
		//obj.radius = 5.0; //The field Circle.radius is not visible
		double area = obj.getArea();
		//System.out.println("���� ������ = " + obj.radius);
		System.out.println("���� ���� = " + area);

	}

}
