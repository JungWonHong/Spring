package ex7_07_field;

public class FieldExample1 {

	public static void main(String[] args) {
		Circle obj = new Circle(0.0);
		obj.radius = 5.0;
		double area = obj.getArea();
		double area2 = obj.getArea2(obj.radius);
		double area3 = obj.getArea3(obj);
		System.out.println("원의 반지름 = " + obj.radius);
		System.out.println("원의 넓이 = " + area);
		System.out.println("원의 넓이2 = " + area2);
		System.out.println("원의 넓이3" + " = " + area3);
	}

}
