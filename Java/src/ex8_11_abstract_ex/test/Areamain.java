package ex8_11_abstract_ex.test;

public class Areamain {

	public static void main(String[] args) {
		Circle obj1 = new Circle(6.5);
		System.out.println("원의 넓이 : " + obj1.getArea());
		
		Square obj2 = new Square(5, 4);
		System.out.println("사각형의 넓이 : " + obj2.getArea());
		
		Trapezoid obj3 = new Trapezoid(3, 4, 5);
		System.out.println("사다리꼴의 넓이 : " + obj3.getArea());
	}

}
