package ex7_08_private_field;
//정보의 은닉 : 객체의 구성요소를 외부로 부터 감추는 기술
public class FieldExample2 {

	public static void main(String[] args) {
		Circle obj = new Circle(0.0);
		//obj.radius = 5.0; //The field Circle.radius is not visible
		double area = obj.getArea();
		//System.out.println("원의 반지름 = " + obj.radius);
		System.out.println("원의 넓이 = " + area);

	}

}
