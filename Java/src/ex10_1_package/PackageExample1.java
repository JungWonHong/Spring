package ex10_1_package; // 패키지 선언문

//같은 패키지의 클래스를 사용하는 프로그램
public class PackageExample1 {

	public static void main(String[] args) {
		Circle obj = new Circle(5);
		System.out.println("반지름 = " + obj.radius);
		System.out.println("면적 = " + obj.getArea());
	}

}
