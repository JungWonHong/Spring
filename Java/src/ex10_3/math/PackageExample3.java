//다른 패키지(ex10_3.geometry.polygon)에 있는 Rectangle 클래스 사용하기
package ex10_3.math;	//패키지 선언문

public class PackageExample3 {

	public static void main(String[] args) {
		ex10_3.geometry.polygon.Rectangle obj = 
				new ex10_3.geometry.polygon.Rectangle(2, 3); 
		System.out.println("넓이 = " + obj.width);
		System.out.println("높이 = " + obj.height);
		System.out.println("면적 = " + obj.getArea());

	}

}
